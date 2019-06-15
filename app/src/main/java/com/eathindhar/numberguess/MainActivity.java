package com.eathindhar.numberguess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;
    String msg;

    public void guessNumber(View view){
        EditText value = (EditText) findViewById(R.id.numberEditText);
        TextView text = (TextView) findViewById(R.id.guessTextView);

        int guessNumber = Integer.parseInt(value.getText().toString());

        Log.i("Values","Number Entered = "+guessNumber);
        Log.i("Values","Number Generated = "+randomNumber);

        if(guessNumber>randomNumber){
            text.setText("Guess Lower!");
            toast("Guess Lower!");
        }else if(guessNumber<randomNumber){
            text.setText("Guess Higher!");
            toast("Guess Higher!");
        }else{
            text.setText(guessNumber+" is Correct!");
            toast(guessNumber+" is Correct!");
            getRandomNumber();
            toast("New Number Generated Try Again!");
        }

    }

    public void getRandomNumber(){
        Random ran = new Random();
        randomNumber = ran.nextInt(50)+1;
    }

    public void toast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getRandomNumber();
    }
}
