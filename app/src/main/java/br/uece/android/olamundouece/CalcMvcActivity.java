package br.uece.android.olamundouece;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import calculadora.Calculadora;

public class CalcMvcActivity extends AppCompatActivity {

    private Calculadora calculadora = new Calculadora("rhino");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_mvc);
    }

//    @Override
//    public void onSaveInstanceState(Bundle outState){
//        super.onSaveInstanceState(outState);
//        outState.putSerializable("calc",calculadora);
//    }
//
//    @Override
//    public void onRestoreInstaceState(Bundle outState){
//        super.onRestoreInstanceState(outState);
//        calculadora = (Calculadora) outState.getSerializable("calc");
//    }

    public void onClick(View view) {
        TextView display = findViewById(R.id.display);
        calculadora.put(((Button) view).getText().charAt(0));
        display.setText(calculadora.getDisplay());
    }
}
