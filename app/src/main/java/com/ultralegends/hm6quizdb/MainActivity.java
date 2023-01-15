package com.ultralegends.hm6quizdb;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    TextView q1, q2, q3, q4, q5, showResult, github;
    RadioGroup q1Group, q2Group, q3Group, q4Group, q5Group;
    RadioButton sample,q1o1,q1o2,q1o3,q1o4,q2o1,q2o2,q2o3,q2o4,q3o1,q3o2,q3o3,q3o4,q4o1,q4o2,q4o3,q4o4,q5o1,q5o2,q5o3,q5o4;
    Button resultbtn, resultpagebtn;
    int counter=0;

    DBHandler DB;

    String [] questions = {"Who is the king of Jungle?","What is the SI unit of distance?","What is the capital of Pakistan?","Which instrument is used to see micro-organisms?","Who is the founder of Pakistan?"};

    int noOfQuestions = questions.length;

    String [] options1 = {"Elephant","Tiger","Deer","Lion"};
    String [] options2 = {"meter","Kelvin","liter","Joule"};
    String [] options3 = {"Lahore","Karachi","Islamabad","Peshawar"};
    String [] options4 = {"Telescope","Microscope","Stathoscope","Miniscope"};
    String [] options5 = {"Muhammad Ali Jinnah","Allama Iqbal","Sir Syed Ahmed","Liaqat Ali Khan"};

    int noOfOptions = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        q1 = findViewById(R.id.q1);
        q1Group = findViewById(R.id.q1group);
        q1o1 = findViewById(R.id.q1o1);
        q1o2 = findViewById(R.id.q1o2);
        q1o3 = findViewById(R.id.q1o3);
        q1o4 = findViewById(R.id.q1o4);

        q2 = findViewById(R.id.q2);
        q2Group = findViewById(R.id.q2group);
        q2o1 = findViewById(R.id.q2o1);
        q2o2 = findViewById(R.id.q2o2);
        q2o3 = findViewById(R.id.q2o3);
        q2o4 = findViewById(R.id.q2o4);

        q3 = findViewById(R.id.q3);
        q3Group = findViewById(R.id.q3group);
        q3o1 = findViewById(R.id.q3o1);
        q3o2 = findViewById(R.id.q3o2);
        q3o3 = findViewById(R.id.q3o3);
        q3o4 = findViewById(R.id.q3o4);

        q4 = findViewById(R.id.q4);
        q4Group = findViewById(R.id.q4group);
        q4o1 = findViewById(R.id.q4o1);
        q4o2 = findViewById(R.id.q4o2);
        q4o3 = findViewById(R.id.q4o3);
        q4o4 = findViewById(R.id.q4o4);

        q5 = findViewById(R.id.q5);
        q5Group = findViewById(R.id.q5group);
        q5o1 = findViewById(R.id.q5o1);
        q5o2 = findViewById(R.id.q5o2);
        q5o3 = findViewById(R.id.q5o3);
        q5o4 = findViewById(R.id.q5o4);

        showResult = findViewById(R.id.showResult);
        resultbtn = findViewById(R.id.resultbtn);
        resultpagebtn = findViewById(R.id.resultpagebtn);
        github = findViewById(R.id.github);

        shuffleArray(questions);
        shuffleArray(options1);
        shuffleArray(options2);
        shuffleArray(options3);
        shuffleArray(options4);
        shuffleArray(options5);

        q1.setText(questions[0]);
        setOptionsOfThisQustion(q1,q1o1,q1o2,q1o3,q1o4);
        q2.setText(questions[1]);
        setOptionsOfThisQustion(q2,q2o1,q2o2,q2o3,q2o4);
        q3.setText(questions[2]);
        setOptionsOfThisQustion(q3,q3o1,q3o2,q3o3,q3o4);
        q4.setText(questions[3]);
        setOptionsOfThisQustion(q4,q4o1,q4o2,q4o3,q4o4);
        q5.setText(questions[4]);
        setOptionsOfThisQustion(q5,q5o1,q5o2,q5o3,q5o4);

        DB = new DBHandler(this);
        resultbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter=0;
                boolean flag = false;


                String []ques1Arr = CheckAnswer(q1, q1Group);
                if(ques1Arr[0].equals(ques1Arr[1]))
                {
                    flag = true;
                }
                else
                {
                    flag = false;
                }
                QuizData quiz1 = new QuizData(ques1Arr[0],ques1Arr[1],flag);
                System.out.println(quiz1);
                boolean insRes1 = DB.insertQuiz(quiz1);

                String []ques2Arr = CheckAnswer(q2, q2Group);
                if(ques2Arr[0].equals(ques2Arr[1]))
                {
                    flag = true;
                }
                else
                {
                    flag = false;
                }
                QuizData quiz2 = new QuizData(ques2Arr[0],ques2Arr[1],flag);
                boolean insRes2 = DB.insertQuiz(quiz2);

                String []ques3Arr = CheckAnswer(q3, q3Group);
                if(ques3Arr[0].equals(ques3Arr[1]))
                {
                    flag = true;
                }
                else
                {
                    flag = false;
                }
                QuizData quiz3 = new QuizData(ques3Arr[0],ques3Arr[1],flag);
                boolean insRes3 = DB.insertQuiz(quiz3);

                String []ques4Arr = CheckAnswer(q4, q4Group);
                if(ques4Arr[0].equals(ques4Arr[1]))
                {
                    flag = true;
                }
                else
                {
                    flag = false;
                }
                QuizData quiz4 = new QuizData(ques4Arr[0],ques4Arr[1],flag);
                boolean insRes4 = DB.insertQuiz(quiz4);

                String []ques5Arr = CheckAnswer(q5, q5Group);
                if(ques5Arr[0].equals(ques5Arr[1]))
                {
                    flag = true;
                }
                else
                {
                    flag = false;
                }
                QuizData quiz5 = new QuizData(ques5Arr[0],ques5Arr[1],flag);
                boolean insRes5 = DB.insertQuiz(quiz5);

                if(counter<=5)
                {
                    showResult.setText("Your result: "+counter+"/5");
                }
            }
        });

        resultpagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);

                boolean flag = false;
                QuizData quiz;

                String []ques1Arr = CheckAnswer(q1, q1Group);
                if(ques1Arr[0].equals(ques1Arr[1]))
                {
                    flag = true;
                }
                else
                {
                    flag = false;
                }

                intent.putExtra("ques1sel",ques1Arr[0]);
                intent.putExtra("ques1cor",ques1Arr[1]);
                intent.putExtra("res1",flag);

                String []ques2Arr = CheckAnswer(q2, q2Group);
                if(ques2Arr[0].equals(ques2Arr[1]))
                {
                    flag = true;
                }
                else
                {
                    flag = false;
                }

                intent.putExtra("ques2sel",ques2Arr[0]);
                intent.putExtra("ques2cor",ques2Arr[1]);
                intent.putExtra("res2",flag);

                String []ques3Arr = CheckAnswer(q3, q3Group);
                if(ques3Arr[0].equals(ques3Arr[1]))
                {
                    flag = true;
                }
                else
                {
                    flag = false;
                }

                intent.putExtra("ques3sel",ques3Arr[0]);
                intent.putExtra("ques3cor",ques3Arr[1]);
                intent.putExtra("res3",flag);

                String []ques4Arr = CheckAnswer(q4, q4Group);
                if(ques4Arr[0].equals(ques4Arr[1]))
                {
                    flag = true;
                }
                else
                {
                    flag = false;
                }

                intent.putExtra("ques4sel",ques4Arr[0]);
                intent.putExtra("ques4cor",ques4Arr[1]);
                intent.putExtra("res4",flag);

                String []ques5Arr = CheckAnswer(q5, q5Group);
                if(ques5Arr[0].equals(ques5Arr[1]))
                {
                    flag = true;
                }
                else
                {
                    flag = false;
                }

                intent.putExtra("ques5sel",ques5Arr[0]);
                intent.putExtra("ques5cor",ques5Arr[1]);
                intent.putExtra("res5",flag);

                startActivity(intent);
            }
        });

        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                try {
                    Uri uri = Uri.parse("https://www.github.com/Raza023/MobileComputing");
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(intent);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                finally {
                }
            }
        });
    }

    public void setOptionsOfThisQustion(TextView question, RadioButton o1,RadioButton o2,RadioButton o3,RadioButton o4)
    {
        if(question.getText().toString().equals("Who is the king of Jungle?"))
        {
            o1.setText(options1[0]);
            o2.setText(options1[1]);
            o3.setText(options1[2]);
            o4.setText(options1[3]);
        }
        else if(question.getText().toString().equals("What is the SI unit of distance?"))
        {
            o1.setText(options2[0]);
            o2.setText(options2[1]);
            o3.setText(options2[2]);
            o4.setText(options2[3]);
        }
        else if(question.getText().toString().equals("What is the capital of Pakistan?"))
        {
            o1.setText(options3[0]);
            o2.setText(options3[1]);
            o3.setText(options3[2]);
            o4.setText(options3[3]);
        }
        else if(question.getText().toString().equals("Which instrument is used to see micro-organisms?"))
        {
            o1.setText(options4[0]);
            o2.setText(options4[1]);
            o3.setText(options4[2]);
            o4.setText(options4[3]);
        }
        else if(question.getText().toString().equals("Who is the founder of Pakistan?"))
        {
            o1.setText(options5[0]);
            o2.setText(options5[1]);
            o3.setText(options5[2]);
            o4.setText(options5[3]);
        }
    }

    public String[] CheckAnswer(TextView question, RadioGroup qGroup)
    {
        int checkedButtenId = qGroup.getCheckedRadioButtonId();
        sample = findViewById(checkedButtenId);        //selected radio button.
        int colorCounter = 0;
        String []strarr = new String[2];

        strarr[0] = sample.getText().toString();

        if(question.getText().toString().equals("Who is the king of Jungle?"))
        {
            strarr[1] = "Lion";
            if(sample.getText().toString().equals("Lion"))
            {
                counter++;
                colorCounter++;
            }
        }
        else if(question.getText().toString().equals("What is the SI unit of distance?"))
        {
            strarr[1] = "meter";
            if(sample.getText().toString().equals("meter"))
            {
                counter++;
                colorCounter++;
            }
        }
        else if(question.getText().toString().equals("What is the capital of Pakistan?"))
        {
            strarr[1] = "Islamabad";
            if(sample.getText().toString().equals("Islamabad"))
            {
                counter++;
                colorCounter++;
            }
        }
        else if(question.getText().toString().equals("Which instrument is used to see micro-organisms?"))
        {
            strarr[1] = "Microscope";
            if(sample.getText().toString().equals("Microscope"))
            {
                counter++;
                colorCounter++;
            }
        }
        else if(question.getText().toString().equals("Who is the founder of Pakistan?"))
        {
            strarr[1] = "Muhammad Ali Jinnah";
            if(sample.getText().toString().equals("Muhammad Ali Jinnah"))
            {
                counter++;
                colorCounter++;
            }
        }
        if(colorCounter==0)
        {
            sample.setTextColor(Color.RED);
        }
        else if(colorCounter==1)
        {
            sample.setTextColor(Color.GREEN);
        }

        return strarr;
    }

    public void shuffleArray(Object[] array)
    {
        int arrLength = array.length;
        for (int i=0;i<arrLength; i++)
        {
            int s = i+ (int)(Math.random()*(arrLength-i));
            Object temp =array[s];
            array[s] = array[i];
            array[i] = temp;
        }
    }
}
