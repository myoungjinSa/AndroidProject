package com.example.part2_6;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{

    TextView bellTextView;
    TextView labelTextVeiw;
    CheckBox repeatCheckView;
    CheckBox vibrateCheckView;
    Switch switchView;

    float initX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bellTextView = findViewById(R.id.bell_name);
        labelTextVeiw=findViewById(R.id.label);
        repeatCheckView=findViewById(R.id.repeatCheck);
        vibrateCheckView=findViewById(R.id.vibrate);
        switchView=findViewById(R.id.onOff);

        bellTextView.setOnClickListener(this);
        labelTextVeiw.setOnClickListener(this);

        repeatCheckView.setOnCheckedChangeListener(this);
        vibrateCheckView.setOnCheckedChangeListener(this);
        switchView.setOnCheckedChangeListener(this);
    }
    private void showToast(String message)
    {
        Toast toast=Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onClick(View v) {
        if (v == bellTextView) {
            showToast("bell text click event...");
        } else if (v == labelTextVeiw) {
            showToast("label text click event...");
        }
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView,boolean isChecked)
    {
        if(buttonView == repeatCheckView)
        {
            showToast("repeat checkbox is " + isChecked);
        }
        else if(buttonView == vibrateCheckView)
        {
            showToast("vibrate checkbox is " + isChecked);
        }
        else if(buttonView == switchView)
        {
            showToast("switch is" + isChecked);
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            initX = event.getX();
        }
        else if(event.getAction() == MotionEvent.ACTION_UP)
        {
            float diffX = initX - event.getRawX();
            if(diffX > 30)
            {
                showToast("왼쪽으로 화면을 밀었습니다");
            }
            else if(diffX <-30)
            {
                showToast("오른쪽으로 화면을 밀었습니다");
            }
        }
        return true;
    }

    long initTime;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            if(System.currentTimeMillis() - initTime > 3000) // Back Button 을 누른 지 3초가 지난 거라면...
            {
                showToast("종료하려면 한 번 더 누르세요.");
            }
            else{
                //3초 이내에 Back button 이 두 번 눌린 경우, Activity 종료
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
}
