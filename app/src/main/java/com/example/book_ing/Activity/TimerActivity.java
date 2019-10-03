package com.example.book_ing.Activity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.book_ing.R;

import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;

//import android.support.v7.app.AppCompatActivity;

public class TimerActivity extends AppCompatActivity {
    public int counter;
//    Button button;
    TextView textView, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_timer);

//        button= (Button) findViewById(R.id.button);
        textView= (TextView) findViewById(R.id.textView);

//        new CountDownTimer(30000, 1000){
//            public void onTick(long millisUntilFinished){
//                textView.setText(String.valueOf(counter));
//                counter++;
//            }
//            public  void onFinish(){
//                textView.setText("FINISH!!");
//            }
//        }.start();

        new CountDownTimer(300000, 1000) {

            public void onTick(long millisUntilFinished) {
//                textView2.setText(" " + (millisUntilFinished / 1000)/60);
//                textView.setText(": " + (millisUntilFinished / 1000)%60);
                int second = (int) (millisUntilFinished / 1000)%60;
                int minutes = (int) (millisUntilFinished / 1000)/60;

                String timer = String.format(Locale.getDefault(), "%02d : %02d", minutes, second);
                textView.setText(timer);
            }

            public void onFinish() {
                textView.setText("done!");
            }

        }.start();
    }
}
