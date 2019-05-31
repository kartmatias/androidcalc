package br.uece.android.olamundouece;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

//    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
//            @Override
//            public void onInit(int status) {
//
//            }
//        });
    }

    public void startTela2(View v){
        startActivity(new Intent(MainActivity.this, LinearActivity.class));
    }

    public void startCalc(View v){
        startActivity(new Intent(MainActivity.this, CalcActivity.class));
    }

//    public  void onClickHello(View view){
//        tts.speak("Hello World", TextToSpeech.QUEUE_FLUSH,null);
//    }

    public void startCalcMcv(View view) {
        startActivity(new Intent(MainActivity.this, CalcMvcActivity.class));
    }
}
