package com.example.raj.rookart;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Ser extends navigation {

    public String dataJsonObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ser);
        Log.d("Oncreate", "Ser.java");
        x();
    }

    public void post(View view) {
        Intent i = new Intent(this, Post_Service.class);
        startActivity(i);
    }
    @Override
    public void onBackPressed() {

        Intent intent=getIntent();
        setResult(1, intent);
        finish();
    }

    public void x() {
        JSONArray jsonArray = null;
        new Ser.MongoAsyncTaskQues().execute();
        try {
            Thread.sleep(500);
            JSONObject jsonObject = new JSONObject(dataJsonObj);
            Log.d("JSON value", jsonObject.toString());
            jsonArray = jsonObject.getJSONArray("question_list");
            jsonObject = jsonArray.getJSONObject(0);
            Log.d("Data", jsonObject.toString());
        } catch (Exception e) {
        }
        ;
        String[] mobileArray = {"Android", "IPhone", "WindowsMobile", "Blackberry",
                "WebOS", "Ubuntu", "Windows7", "Max OS X"};
//        ArrayAdapter adapter = new ArrayAdapter<String>(this,
//                R.layout.activity_ser,jsonObject.toString() );


        ListView listView = (ListView) findViewById(R.id.listview);
        Freqquest l = new Freqquest(this, jsonArray);
        l.ser = this;

        listView.setAdapter(l);
    }
public void send(JSONObject jsonObject)
    {
        Intent i= new Intent(this,ServiceDisp.class);
        try {
            String ex = jsonObject.getString("emailid");
            i.putExtra("emailID",ex);
           String d = jsonObject.getString("Description");
            i.putExtra("Description",d);
            String n = jsonObject.getString("product");
            i.putExtra("ProductID",n);
            String num = jsonObject.getString("number");
            i.putExtra("number",num);

        }
        catch (Exception e){}

        startActivity(i);
    }



    class MongoAsyncTaskQues extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... args0) {
            try {
                try {
                    URL url1 = new URL("https://api.mongolab.com/api/1/databases/asedb/collections/service?apiKey=jhntLv8SVVc_a9DFCCw6s9S_OPSEl-ia");
                    HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setRequestProperty("Accept", "application/json");
                    if (conn.getResponseCode() != 200) {
                        throw new RuntimeException("Failed : HTTP error code : "
                                + conn.getResponseCode());
                    }
                    BufferedReader br = new BufferedReader(new InputStreamReader(
                            (conn.getInputStream())));
                    String temp_output = null;
                    String server_output = null;
                    while ((temp_output = br.readLine()) != null) {
                        server_output = temp_output;
                    }
                    String mongoarray = "{ question_list: " + server_output + "}";
                    dataJsonObj = mongoarray;
                } catch (Exception ex) {
                    return null;
                } finally {
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}

class Freqquest extends BaseAdapter {

    public Context context;
    public JSONArray data;
    public Ser ser;
    private static LayoutInflater inflater = null;

    public Freqquest(Context context, JSONArray data) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data=data;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.length();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        try {
            return data.getJSONObject(position);
        }
        catch (Exception e)
        {}
        return  "ujyfyjvkjbvkiv";
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub0
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.ansrow, null);
        final RowContent rowContent= new RowContent();
        Button headText = (Button) vi.findViewById(R.id.emailID);
        Button desc=(Button) vi.findViewById(R.id.desc);
        ImageView sam=(ImageView)vi.findViewById(R.id.img);
            rowContent.textView1=headText;
        rowContent.textView2=desc;
        rowContent.img=sam;
        rowContent.textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    rowContent.push(data.getJSONObject(position));
                }
                catch (Exception e){}
            }
        });

        rowContent.textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    rowContent.push(data.getJSONObject(position));
                }
                catch (Exception e){}
            }
        });

        sam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    rowContent.push(data.getJSONObject(position));
                }
                catch (Exception e){}
            }
        });
        try {
            JSONObject jsonObject = data.getJSONObject(position);

            headText.setText(jsonObject.getString("product"));

            desc.setText(jsonObject.getString("Description"));
        }
        catch (Exception e) {}

        return vi;
    }
    class RowContent
    {
        Button textView1;
        Button textView2;
        ImageView img;

        public void push(JSONObject jsonObject)
        {
            ser.send(jsonObject);

        }


    }




}
