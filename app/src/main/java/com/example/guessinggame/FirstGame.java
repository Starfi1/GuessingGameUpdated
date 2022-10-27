package com.example.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class FirstGame extends AppCompatActivity {

    Button confirmButton;
    EditText userGuess;
    int userguessint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_game);
        userGuess= (EditText)findViewById(R.id.Guess);
        Intent mIntent = getIntent();
        int MaxVal = mIntent.getIntExtra("maxrandom", 0);
        Random r = new Random();
        int randomNumber = r.nextInt(MaxVal);

        confirmButton = (Button)findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               userguessint= Integer.valueOf(userGuess.getText().toString());
               if(userguessint<randomNumber) {
                   Toast.makeText(FirstGame.this,"Guess higher",Toast.LENGTH_LONG).show();
               }
                if(userguessint>randomNumber) {
                    Toast.makeText(FirstGame.this,"Guess lower",Toast.LENGTH_LONG).show();
                }
                else if(userguessint==randomNumber) Toast.makeText(FirstGame.this,"Correct! good job!",Toast.LENGTH_LONG).show();

            }
        });


    }
}