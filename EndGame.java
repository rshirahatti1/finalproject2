package com.example.finalproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndGame extends AppCompatActivity {

    public static int finalScoreNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        TextView finalScore = findViewById(R.id.score);
        Button tryAgain = findViewById(R.id.retryButton);
        finalScoreNum = TriviaMainPage.score;
        finalScore.setText(Integer.toString(finalScoreNum));

        tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextLayout();
            }
        });




    }

    public void openNextLayout() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
