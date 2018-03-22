package com.example.rhenigan.whichanimalareyou.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rhenigan.whichanimalareyou.Model.Animal;
import com.example.rhenigan.whichanimalareyou.Model.AnimalArray;
import com.example.rhenigan.whichanimalareyou.R;
import com.example.rhenigan.whichanimalareyou.Model.StatementArray;


//pexels.com

public class MainActivity extends AppCompatActivity {

    private TextView mStatement;
    private Spinner mAnswer;
    private Button mSubmit;
    private EditText mCaption;
    public static final String TAG = "MainActivity";
    private AnimalArray mAnimalArray = new AnimalArray();
    private StatementArray mStatementArray = new StatementArray();
    private int[] mAnswerArray = new int[] {0, 0, 0, 0, 0, 0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStatement = findViewById(R.id.statement);
        mAnswer = findViewById(R.id.answer);
        mSubmit = findViewById(R.id.submit);
        mCaption = findViewById(R.id.editCaption);

        mStatement.setText(mStatementArray.statementArray.get(0));

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.answers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mAnswer.setAdapter(adapter);

        mSubmit.setOnClickListener(new View.OnClickListener() {
            int statementCount = 1;
            @Override
            public void onClick(View view) {
                switch(mAnswer.getSelectedItem().toString()){
                    case "Disagree":
                        mAnswerArray[statementCount - 1] = -10;
                        Log.d(TAG, "Disagree");
                        break;
                    case "Somewhat Disagree":
                        mAnswerArray[statementCount - 1] = -5;
                        Log.d(TAG, "SW Disagree");
                        break;
                    case "No Opinion":
                        mAnswerArray[statementCount - 1] = 0;
                        Log.d(TAG, "N/O");
                        break;
                    case "Somewhat Agree":
                        mAnswerArray[statementCount - 1] = 5;
                        Log.d(TAG, "SW Agree");
                        break;
                    case "Agree":
                        mAnswerArray[statementCount - 1] = 10;
                        Log.d(TAG, "Agree");
                        break;
                    default:
                        break;
                }

                if (statementCount >= 8) {
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("ANIMAL", getResult());
                    intent.putExtra("CAPTION", mCaption.getText().toString());
                    Log.d(TAG, mCaption.getText().toString());
                    startActivity(intent);
                    MainActivity.this.finish();
                } else {
                    if (statementCount == 7) {
                        mCaption.setVisibility(View.VISIBLE);
                    }
                    mStatement.setText(mStatementArray.statementArray.get(statementCount++));
                    mAnswer.setSelection(0);
                }
            }
        });
    }

    private Animal getResult() {
        int TempAnimalScore = 0;
        int CurrAnimalScore = 100;
        Animal topAnimal = mAnimalArray.animalArray.get(0);
        for (Animal animal: mAnimalArray.animalArray) {
            int[] animalRating = animal.getmRating();

            for (int i = 0; i < animalRating.length; i++) {
                TempAnimalScore = TempAnimalScore + Math.abs(animalRating[i] - mAnswerArray[i]);
            }
            if (TempAnimalScore < CurrAnimalScore) {
                CurrAnimalScore = TempAnimalScore;
                topAnimal = animal;
            }
            TempAnimalScore = 0;
        }
        return topAnimal;
    }
}
