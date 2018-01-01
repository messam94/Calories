package com.example.btngan.calories;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    Button vegetables, dairy, meat, seafood, nuts, beans, others;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vegetables = (Button) findViewById(R.id.vegetables);
        vegetables.setOnClickListener(this);
        meat = (Button) findViewById(R.id.meat);
        meat.setOnClickListener(this);
        dairy = (Button) findViewById(R.id.dairy);
        dairy.setOnClickListener(this);
        seafood = (Button) findViewById(R.id.seafood);
        seafood.setOnClickListener(this);
        nuts = (Button) findViewById(R.id.nuts);
        nuts.setOnClickListener(this);
        beans = (Button) findViewById(R.id.beans);
        beans.setOnClickListener(this);
        others = (Button) findViewById(R.id.others);
        others.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, Main2Activity.class);
        switch (v.getId()) {
            case R.id.vegetables:
                i.putExtra("filename","vegetables");
                startActivity(i);
                break;

            case R.id.meat:
                i.putExtra("filename","meat");
                startActivity(i);
                break;

            case R.id.dairy:
                i.putExtra("filename","dairy");
                startActivity(i);
                break;

            case R.id.seafood:
                i.putExtra("filename","seafood");
                startActivity(i);
                break;

            case R.id.nuts:
                i.putExtra("filename","nuts");
                startActivity(i);
                break;

            case R.id.others:
                i.putExtra("filename","others");
                startActivity(i);
                break;

            case R.id.beans:
                i.putExtra("filename","beans");
                startActivity(i);
                break;
        }

    }
}
