package br.uece.android.olamundouece;

import android.widget.TextView;

public class EqualHandler implements Handler{

    @Override
    public void handleIt(Object ... parameters) {

        CalcActivity activity = (CalcActivity) parameters[0];
        //declare Textviews from textViews pass from Calculator
        TextView inputTxt = (TextView) parameters[1];
        TextView solutionTxt = (TextView) parameters[2];

        solutionTxt.setText(inputTxt.getText().toString());
        inputTxt.setText("");
    }
}