package com.example.raj.rookart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;






        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.View;
        import android.widget.EditText;

        import org.json.JSONException;
        import org.json.JSONObject;

public class SellHere extends AppCompatActivity {

    public EditText email, product, Description, number;
    View Image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_here);

        email = (EditText) findViewById(R.id.email);
        product = (EditText) findViewById(R.id.name);
        number = (EditText) findViewById(R.id.Phone);

        Image=findViewById(R.id.imageView);
        Description=(EditText)findViewById(R.id.Description);

//x();
    }
    public void x()
    {
        try {
            JSONObject z = new JSONObject();
            z.put("productID", "10000");
            z.put("emailID", "raghu@gmail.cpom");

        }
        catch(Exception e)
        {}

    }




    public void post(View view)throws JSONException {

        JSONObject json = new JSONObject();
        json.put("product",product.getText().toString());
        json.put("emailid", email.getText().toString());
        json.put("number", number.getText().toString());
        json.put("Description", Description.getText().toString());
        json.put("img","");
        Log.d("Values", json.toString());
        getDATA gd= new getDATA();
        gd.fun1(json.toString(),"https://api.mongolab.com/api/1/databases/asedb/collections/product?apiKey=jhntLv8SVVc_a9DFCCw6s9S_OPSEl-ia");
        Intent i=new Intent(this,Pro.class);
        startActivity(i);
    }
}
