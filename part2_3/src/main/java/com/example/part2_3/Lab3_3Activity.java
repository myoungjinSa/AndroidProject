package com.example.part2_3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Lab3_3Activity extends AppCompatActivity implements View.OnClickListener {

    Button trueBtn;
    TextView targetTextView;
    Button falseBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3_3);
        //View 객체 획득

        trueBtn = findViewById(R.id.btn_visible_true);
        falseBtn = findViewById(R.id.btn_visible_false);
        targetTextView = findViewById(R.id.text_visible_target);

        //Button이벤트 등록
        trueBtn.setOnClickListener(this);
        falseBtn.setOnClickListener(this);


    }

    //버튼 이벤트 콜백 함수
    @Override
    public void onClick(View v)
    {
        if(v==trueBtn)
        {
            //trueBtn이 눌리면 targetView를 visible상태로 변경
            targetTextView.setVisibility(View.VISIBLE);
        }
        else if(v == falseBtn)
        {
            targetTextView.setVisibility(View.INVISIBLE);
        }
    }
}


