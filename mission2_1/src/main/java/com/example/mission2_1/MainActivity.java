package com.example.mission2_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button confirm_button = findViewById(R.id.confirm_btn);
        confirm_button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v)
    {
       Toast toast = Toast.makeText(this,"click..ok..",Toast.LENGTH_SHORT);
       toast.show();
    }
}
