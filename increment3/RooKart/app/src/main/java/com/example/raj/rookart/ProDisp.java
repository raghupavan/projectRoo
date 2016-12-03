package com.example.raj.rookart;

/**
 * Created by rAj on 11/15/2016.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class ProDisp extends AppCompatActivity {
    public String dataJsonObj;
    public TextView email1, Desc1,Product1, number1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_disp);
        Intent i= getIntent();
        String email=i.getStringExtra("emailID");
        String number=i.getStringExtra("number");
        String Description=i.getStringExtra("Description");
        String productID=i.getStringExtra("ProductID");
        number1=(TextView)findViewById(R.id.Phone);
        email1=(TextView)findViewById(R.id.email);
        Desc1=(TextView)findViewById(R.id.Description);
        Product1=(TextView)findViewById(R.id.name);
        email1.setText(email);
        Desc1.setText(Description);
        Product1.setText(productID);
        number1.setText(number);


    }

    public void use(View view){
        Toast.makeText(this, "Thanks for Shopping with us!!! )",
                Toast.LENGTH_LONG).show();
        Intent i= new Intent(this, HomeActivity.class);
        startActivity(i);
    }



}