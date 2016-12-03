package com.example.raj.rookart;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;

public class Post_Service extends AppCompatActivity {

    public EditText email, product, Description, number;
    public static final int TAKE_PHOTO_CODE = 0;
    ImageView userImage ;
View Image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post__service);
        email = (EditText) findViewById(R.id.email);
        product = (EditText) findViewById(R.id.name);
        number = (EditText) findViewById(R.id.Phone);

        userImage=(ImageView)findViewById(R.id.imageView);
        Description=(EditText)findViewById(R.id.Description);

//x();
    }
    public void setImage(View v)
    {
        Image=findViewById(R.id.imageView);
       // picButton = (ImageButton) findViewById(R.id.profileImage);
        Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //camera.putExtra(MediaStore.EXTRA_OUTPUT, getOutputMediaFileUri());
                startActivityForResult(camera, TAKE_PHOTO_CODE);
            }
        });

    }
//    private static Uri getOutputMediaFileUri(int type){
//        return Uri.fromFile(getOutputMediaFile(type));
//    }
//    private static File getOutputMediaFile(int type){
//
//        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
//                Environment.DIRECTORY_PICTURES), "MyCameraApp");
//
//        if (! mediaStorageDir.exists()){
//            if (! mediaStorageDir.mkdirs()){
//                Log.d("MyCameraApp", "failed to create directory");
//                return null;
//            }
//        }
//        File mediaFile;
//        if (type ==TAKE_PHOTO_CODE ){
//            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
//                    "IMG_" + ".jpg");
//        } else {
//            return null;
//        }
//        return mediaFile;
//    }
//    @Override
//    protected void onActivityResult(int requestcode, int resultcode, Intent data)
//    {
//        super.onActivityResult(requestcode, resultcode, data);
//
//        if(requestcode == TAKE_PHOTO_CODE && resultcode == RESULT_OK)
//        {
//            Bitmap photo = (Bitmap) data.getExtras().get("data");
//            userImage.setImageBitmap(photo);
//            Log.d("Image successful","success");
//        }
//    }
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




public void post(View view)throws JSONException{

    JSONObject json = new JSONObject();
    json.put("product",product.getText().toString());
    json.put("emailid", email.getText().toString());
    json.put("number", number.getText().toString());
    json.put("Description", Description.getText().toString());
    json.put("img","");
    Log.d("Values", json.toString());
   getDATA gd= new getDATA();
    gd.fun1(json.toString(),"https://api.mongolab.com/api/1/databases/asedb/collections/service?apiKey=jhntLv8SVVc_a9DFCCw6s9S_OPSEl-ia");
Intent i=new Intent(this,Ser.class);
    startActivity(i);
}

}
