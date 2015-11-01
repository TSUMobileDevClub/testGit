package com.example.sgt_powell.superquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public Button trueButton;
    public Button falseButton;
    public TextView questionText;

    private truthClass[] questionBank= new truthClass[]{
            new truthClass(R.string.question_africa, false),
            new truthClass(R.string.question_america, true),
            new truthClass(R.string.question_mideast, false),
            new truthClass(R.string.question_oceans, true)
    };

    private void updateQuestion(){
        int currentIndex = 0;
        int question = questionBank[currentIndex].getQuestion();
        questionText.setText(question);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        questionText = (TextView)findViewById(R.id.questionTextView);

        trueButton = (Button)findViewById(R.id.trueButton);
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.incorrectToastMessage, Toast.LENGTH_SHORT).show();
            }
        });


        falseButton = (Button) findViewById(R.id.falseButton);
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, R.string.correctToastMessage, Toast.LENGTH_SHORT).show();
            }
        });

        updateQuestion();
    }
}
