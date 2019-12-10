package com.example.finalproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    public static int questionNum = 0;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button startGame;
    TextView highScoreStart;
    //private RadioButton q10 = findViewById(R.id.Questions10);
    //private RadioButton q20 = findViewById(R.id.Questions20);
    //private RadioButton q30 = findViewById(R.id.Questions30);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        startGame = findViewById(R.id.startButton);
        radioGroup = findViewById(R.id.numberOfQuestions);
        highScoreStart = findViewById(R.id.highScoreNum);

//        RadioButton a10 = findViewById(R.id.Questions10);
//        RadioButton b20 = findViewById(R.id.Questions20);
//        RadioButton c30 = findViewById(R.id.Questions30);
//        LinearLayout mainRadio = findViewById(R.id.mainscreen);
//        onRadioButtonClicked(mainRadio, a10, b20, c30);
        highScoreStart.setText(Integer.toString(EndGame.finalScoreNum));
        highScoreStart.setTextColor(Color.GREEN);

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int rId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(rId);
                String nums = radioButton.getText().toString();
                if (nums.equals("10")) {
                    questionNum = 10;
                } else if (nums.equals("20")) {
                    questionNum = 20;
                } else {
                    questionNum = 30;
                }
                openNextLayout();
            }
        });

    }

    public void openNextLayout() {
        Intent intent = new Intent(this, TriviaMainPage.class);
        startActivity(intent);
    }

    public void setQuestionsNum(View v) {
        int rId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(rId);
        String nums = radioButton.getText().toString();
        if (nums == "10") {
            questionNum = 10;
        } else if (nums == "20") {
            questionNum = 20;
        } else {
            questionNum = 30;
        }

    }

//    public void onRadioButtonClicked(View view, RadioButton q10, RadioButton q20, RadioButton q30) {
//        // Check which radio button was clicked
////        switch(view.getId()) {
////            case R.id.Questions10:
////                if (q10.isChecked())
////                    questionNum = 10;
////                    break;
////            case R.id.Questions20:
////                if (q20.isChecked())
////                    questionNum = 20;
////                    break;
////            case R.id.Questions30:
////                if (q30.isChecked())
////                    questionNum = 30;
////                    break;
////        }
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//
//        // Check which radio button was clicked
//        switch(view.getId()) {
//            case R.id.Questions10:
//                if (checked) {
//                    questionNum = 10;
//                    break;
//                }
//            case R.id.Questions20:
//                if (checked) {
//                    questionNum = 20;
//                    break;
//                }
//            case R.id.Questions30:
//                if (checked) {
//                    questionNum = 30;
//                    break;
//                }
//        }
////        if (q10.isChecked()) {
////            questionNum = 10;
////        } else if (q20.isChecked()) {
////            questionNum = 20;
////        } else {
////            questionNum = 30;
////        }
//    }







}
