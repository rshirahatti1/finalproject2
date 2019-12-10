package com.example.finalproject2;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.lang.Math;

public class TriviaMainPage extends AppCompatActivity {

    private String questionBank[][] = {
            //{"question", "correct", "ans1", "ans2", "ans3"},
            {"Which US president’s nose is considered a lucky charm before exams?", "Lincoln", "Roosevelt", "Jefferson", "Washington"},
            {"What is the number of undergraduate students at UIUC?", "30,000", "20,000", "10,000", "40,000"},
            {"What is the name of the basketball stadium?", "StateFarm Center", "Coach K Court", "American Airlines Arena", "AT&T Center"},
            {"When was the last time the Men’s Fighting Illini basketball team made it to the Final Four?", "2004", "2001", "1982", "1997"},
            {"Which one of these actors is an alumni of UIUC?", "Nick Offerman", "Aziz Ansari", "John Cusack", "Robin Williams"},
            {"How many items are in the UIUC library collection?", "22 million", "10 million", "16 million", "18 million"},
            {"How expensive was tuition in 1867?", "15 dollars", "500 dollars", "1000 dollars", "3000 dollars"},
            {"How many colleges are there at UIUC?", "15", "8", "10", "12"},
            {"How many NCAA teams are there?", "21", "12", "17", "19"},
            {"How big is the alumni network at UIUC?", "450,000", "300,000", "400,000", "350,000"},
            {"How large is UIUC's campus in acres?", "6372", "1372", "2785", "4876"},
            {"Which all star NBA player is an alumni of UIUC?", "Deron Williams", "Chris Paul", "Blake Griffin", "Victor Oladipo"},
            {"How far is Champaign from Chicago?", "135 miles", "105 miles", "173 miles", "127 miles"},
            {"Who is the current chancellor of UIUC?", "Robert J. Jones", "John E. Cribbet", "Nancy Cantor", "Michael Aiken"},
            {"What is the average starting salary for computer science graduates from UIUC?", "$99,700", "$78,500", "$86,900", "$69,400"},
            {"What is the Grainger College of Engineering’s ranking in US News’s best undergraduate engineering programs?", "6", "4", "9", "12"},
            {"How much did Grainger donate to the College of Engineering", "$300 million", "$100 million", "$200 million", "$400 million"},
            {"How many faculty members are in the Department of Computer Science?", "92", "85", "72", "67"},
            {"Who is the Bardeen quadrangle named after?", "A professor at UIUC", "An alumni", "A donor", "A former chancellor"},
            {"How many buildings are there in total at UIUC?", "651",  "542", "460", "320"},
            {"When was the term Illini coined?", "1874", "1864", "1910", "1950"},
            {"When was the chief officially removed as UIUC’s mascot?", "2007", "1999", "2003", "2011"},
            {"Who is the current dean of the Grainger College of Engineering?", "James D. Anderson", "Rashid Bashir", "Jeffrey Brown", "Feng Sheng Hu"},
            {"How old is the Illini Union?", "1939", "1927", "1954", "1894"},
            {"How many national titles does the Fighting Illini football team have?", "5", "2", "0", "8"},
            {"Who is the head coach of the Fighting Illini basketball team?", "Brad Underwood", "Lovie Smith", "Mike Krzyzewski", "Bobby Knight"},
            {"What is the capacity of Foellinger Auditorium?", "1361", "3678", "2390", "867"},
            {"How many quads are there on campus?", "4", "1", "2", "3"},
            {"How many undergraduate residence halls are there on campus?", "15", "23", "11", "8"},
            {"What does SDRP stand for?", "Student dining and residential programs", "Studying and dining rooms and places", "Student dining and recreation place", "Study dine relax promote"},




    };

    public static int score = 0;
    private int ansSpot = 0;
    private int questionNumber = 0;
    private int[] qArray = new int[30];
//    private Button count10 = findViewById(R.id.Questions10);
//    private Button count20 = findViewById(R.id.Questions20);
//    private Button count30 = findViewById(R.id.Questions30);
//    private Button optionA = findViewById(R.id.button2);
//    private Button optionB = findViewById(R.id.button3);
//    private Button optionC = findViewById(R.id.button4);
//    private Button optionD = findViewById(R.id.button5);
//    private TextView question = findViewById(R.id.questionsAsked);
    //changed this to questionNumber instead cus it makes more sense so
    // basically its correct depending on which question it is
    private String correct = questionBank[questionNumber][1];

    private TextView countDown;
    private static final long COUNTDOWN_IN_MILLISECONDS = 11000;
    private ColorStateList defaultColorCounter;
    private CountDownTimer countDownTimer;
    private long timeLeft;

    private Button A;
    private Button B;
    private Button C;
    private Button D;
    private TextView Q;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia_main_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        A = findViewById(R.id.button2);
        B = findViewById(R.id.button3);
        C = findViewById(R.id.button4);
        D = findViewById(R.id.button5);
        Q = findViewById(R.id.questionsAsked);
        final TextView scoreVal = findViewById(R.id.scoreNum);
        final TextView finalScore = findViewById(R.id.score);

        countDown = findViewById(R.id.timerView);

        defaultColorCounter = countDown.getTextColors();

        randomUserArray();
        setQuestion(A, B, C, D, Q);
        /*
        if (correctAnswerCheck(A, B, C, D)) {
            //question.setText(questionBank[0][score + 1]);
            score++;
            if (questionNumber < MainActivity.questionNum) {
                questionNumber++;
            }
        }
        else {
            //was endGame changed it to this
            if (questionNumber < MainActivity.questionNum) {
                questionNumber++;
            }
        }

         */


        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //correct = questionBank[questionNumber][1];
                countDownTimer.cancel();
                if (questionNumber >= (MainActivity.questionNum - 1)) {
                    openNextLayout();
                }
                if (ansSpot == 1) {
                    setScore(scoreVal);
                    questionNumber++;
                    setQuestion(A, B, C, D, Q);
                } else {
                    questionNumber++;
                    setQuestion(A, B, C, D, Q);
                }
            }
        });

        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //correct = questionBank[questionNumber][1];
                //correct == B.getText().toString()
                countDownTimer.cancel();
                if (questionNumber >= (MainActivity.questionNum - 1)) {
                    openNextLayout();
                }
                if (ansSpot == 2) {
                    setScore(scoreVal);
                    questionNumber++;
                    setQuestion(A, B, C, D, Q);
                } else {
                    questionNumber++;
                    setQuestion(A, B, C, D, Q);
                }
            }
        });

        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //correct = questionBank[questionNumber][1];
                countDownTimer.cancel();
                if (questionNumber >= (MainActivity.questionNum - 1)) {
                    openNextLayout();
                }
                if (ansSpot == 3) {
                    setScore(scoreVal);
                    questionNumber++;
                    setQuestion(A, B, C, D, Q);
                } else {
                    questionNumber++;
                    setQuestion(A, B, C, D, Q);
                }
            }
        });

        D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correct = questionBank[questionNumber][1];
                countDownTimer.cancel();
                if (questionNumber >= (MainActivity.questionNum - 1)) {
                    openNextLayout();
                }
                if (ansSpot == 4) {
                    setScore(scoreVal);
                    questionNumber++;
                    setQuestion(A, B, C, D, Q);
                } else {
                    questionNumber++;
                    setQuestion(A, B, C, D, Q);
                }
            }
        });



        //setQuestion(A, B, C, D, Q);





    }

    public void openNextLayout() {
        Intent intent = new Intent(this, EndGame.class);
        startActivity(intent);
    }

    public void setScore(TextView scoreVal) {
        score++;
        scoreVal.setText(Integer.toString(score));

    }

    public void setQuestion(Button optionA, Button optionB, Button optionC, Button optionD,
                            TextView question) {
        ansSpot = (int) ((Math.random() * 4) + 1);
        if (ansSpot == 1) {
            question.setText(questionBank[qArray[questionNumber]][0]);
            optionA.setText(questionBank[qArray[questionNumber]][1]);
            optionB.setText(questionBank[qArray[questionNumber]][2]);
            optionC.setText(questionBank[qArray[questionNumber]][3]);
            optionD.setText(questionBank[qArray[questionNumber]][4]);
        } else if (ansSpot == 2) {
            question.setText(questionBank[qArray[questionNumber]][0]);
            optionA.setText(questionBank[qArray[questionNumber]][2]);
            optionB.setText(questionBank[qArray[questionNumber]][1]);
            optionC.setText(questionBank[qArray[questionNumber]][3]);
            optionD.setText(questionBank[qArray[questionNumber]][4]);
        } else if (ansSpot == 3) {
            question.setText(questionBank[qArray[questionNumber]][0]);
            optionA.setText(questionBank[qArray[questionNumber]][2]);
            optionB.setText(questionBank[qArray[questionNumber]][3]);
            optionC.setText(questionBank[qArray[questionNumber]][1]);
            optionD.setText(questionBank[qArray[questionNumber]][4]);
        } else if (ansSpot == 4) {
            question.setText(questionBank[qArray[questionNumber]][0]);
            optionA.setText(questionBank[qArray[questionNumber]][2]);
            optionB.setText(questionBank[qArray[questionNumber]][3]);
            optionC.setText(questionBank[qArray[questionNumber]][4]);
            optionD.setText(questionBank[qArray[questionNumber]][1]);
        }
        System.out.println(questionNumber);
        System.out.println(MainActivity.questionNum);

        timeLeft = COUNTDOWN_IN_MILLISECONDS;
        startCounter();
    }

    public void startCounter() {
        countDownTimer = new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeft = millisUntilFinished;
                setTextCounter();
            }

            @Override
            public void onFinish() {
                timeLeft = 0;
                setTextCounter();
                questionNumber++;
                setQuestion(A, B, C, D, Q);
            }
        }.start();
    }

    public void setTextCounter() {
        int seconds = (int) (timeLeft / 1000);

        String time = String.format(Locale.getDefault(), "%02d", seconds);

        countDown.setText(time);

        if (timeLeft < 5000) {
            countDown.setTextColor(Color.RED);
        } else {
            countDown.setTextColor(defaultColorCounter);
        }
    }

    /*
    public boolean correctAnswerCheck(final Button optionA, final Button optionB, final Button optionC, final Button optionD) {
        correct = questionBank[questionNumber][1];

        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (optionA.getText() == correct) {
                    check = true;
                }
            }
        });
        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (optionB.getText() == correct) {
                    check = true;
                }
            }
        });
        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (optionC.getText() == correct) {
                    check = true;
                }
            }
        });
        optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (optionD.getText() == correct) {
                    check = true;
                }
            }
        });

        return check;
    }
     */

    public void randomUserArray() {
        int[] arr = new int[30];
        for (int i = 0; i < 30; i++) {
            arr[i] = i;
        }
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            int index = rand.nextInt(arr.length);
            int t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;
        }
        qArray = arr;
        //return arr;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }


//    public static int getIntInRange(int min, int max) {
//        Random r = new Random();
//        return r.nextInt((max - min) + 1) + min;
//    }

}
