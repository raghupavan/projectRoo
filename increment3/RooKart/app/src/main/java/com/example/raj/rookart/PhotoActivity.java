package com.example.raj.rookart;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

    import android.content.Intent;
    import android.database.Cursor;
    import android.graphics.Bitmap;
    import android.graphics.BitmapFactory;
    import android.graphics.drawable.BitmapDrawable;
    import android.graphics.drawable.Drawable;
    import android.location.Address;
    import android.net.Uri;
    import android.os.Bundle;
    import android.os.Handler;
    import android.os.ResultReceiver;
    import android.provider.MediaStore;
    import android.support.v7.app.AppCompatActivity;
    import android.support.v7.widget.Toolbar;
    import android.util.Log;
    import android.view.View;
    import android.widget.Button;
    import android.widget.CheckBox;
    import android.widget.ImageView;
    import android.widget.TextView;
    import android.widget.Toast;

public class PhotoActivity extends ActionBarActivity {
    int TAKE_PHOTO_CODE = 0;
    ImageView userImage ;

    /**
     * Called when the activity is first created.
//     */
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        getActionBar().setTitle("Capture image");
//        setContentView(R.layout.activity_photo);
//        Button capture = (Button) findViewById(R.id.btn_take_photo);
//        userImage = (ImageView) findViewById(R.id.view_photo);
//        //Button click eventlistener. Initializes the camera.
//        capture.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(cameraIntent, TAKE_PHOTO_CODE);
//            }
//        });
//    }
//    //If the photo is captured then set the image view to the photo captured.
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == TAKE_PHOTO_CODE && resultCode == RESULT_OK) {
//            Bitmap photo = (Bitmap) data.getExtras().get("data");
//            userImage.setImageBitmap(photo);
//            Log.d("CameraDemo", "Pic saved");
//        }
//    }
//
//    public void redirectToHome(View v) {
//        Intent redirect = new Intent(PhotoActivity.this, MainActivity.class);
//        startActivity(redirect);
//    }
//}    }
}