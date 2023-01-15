package com.ultralegends.hm6quizdb;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView sel1, cor1, res1, sel2, cor2, res2, sel3, cor3, res3, sel4, cor4, res4, sel5, cor5, res5;
    Button whatsappBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        whatsappBtn = findViewById(R.id.whatsappBtn);

        sel1 = findViewById(R.id.sel1);
        sel1.setText(intent.getStringExtra("ques1sel"));
        cor1 = findViewById(R.id.cor1);
        cor1.setText(intent.getStringExtra("ques1cor"));
        res1 = findViewById(R.id.res1);
        res1.setText(Boolean.toString(intent.getBooleanExtra("res1",false)));

        sel2 = findViewById(R.id.sel2);
        sel2.setText(intent.getStringExtra("ques2sel"));
        cor2 = findViewById(R.id.cor2);
        cor2.setText(intent.getStringExtra("ques2cor"));
        res2 = findViewById(R.id.res2);
        res2.setText(Boolean.toString(intent.getBooleanExtra("res2",false)));

        sel3 = findViewById(R.id.sel3);
        sel3.setText(intent.getStringExtra("ques3sel"));
        cor3 = findViewById(R.id.cor3);
        cor3.setText(intent.getStringExtra("ques3cor"));
        res3 = findViewById(R.id.res3);
        res3.setText(Boolean.toString(intent.getBooleanExtra("res3",false)));

        sel4 = findViewById(R.id.sel4);
        sel4.setText(intent.getStringExtra("ques4sel"));
        cor4 = findViewById(R.id.cor4);
        cor4.setText(intent.getStringExtra("ques4cor"));
        res4 = findViewById(R.id.res4);
        res4.setText(Boolean.toString(intent.getBooleanExtra("res4",false)));

        sel5 = findViewById(R.id.sel5);
        sel5.setText(intent.getStringExtra("ques5sel"));
        cor5 = findViewById(R.id.cor5);
        cor5.setText(intent.getStringExtra("ques5cor"));
        res5 = findViewById(R.id.res5);
        res5.setText(Boolean.toString(intent.getBooleanExtra("res5",false)));

        whatsappBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try
                {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.setPackage("com.whatsapp");
                    String msg = "Selected\tCorrect\tResult\n"
                            +sel1.getText().toString()+"\t"
                            +cor1.getText().toString()+"\t"
                            +res1.getText().toString()+"\n"
                            +sel2.getText().toString()+"\t"
                            +cor2.getText().toString()+"\t"
                            +res2.getText().toString()+"\n"
                            +sel3.getText().toString()+"\t"
                            +cor3.getText().toString()+"\t"
                            +res3.getText().toString()+"\n"
                            +sel4.getText().toString()+"\t"
                            +cor4.getText().toString()+"\t"
                            +res4.getText().toString()+"\n"
                            +sel5.getText().toString()+"\t"
                            +cor5.getText().toString()+"\t"
                            +res5.getText().toString()+"\n";

                    intent.putExtra(Intent.EXTRA_TEXT,msg);
                    startActivity(intent);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {}
            }
        });
    }
}