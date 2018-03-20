package com.example.rhenigan.whichanimalareyou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


//pexels.com

public class MainActivity extends AppCompatActivity {

    private TextView mStatement;
    private Spinner mAnswer;
    private Button mSubmit;
    public static final String TAG = "MainActivity";
    private AnimalArray mAnimalArray = new AnimalArray();
    private StatementArray mStatementArray = new StatementArray();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStatement = findViewById(R.id.statement);
        mAnswer = findViewById(R.id.answer);
        mSubmit = findViewById(R.id.submit);

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
                        Log.d(TAG, "Disagree");
                        break;
                    case "Somewhat Disagree":
                        Log.d(TAG, "SW Disagree");
                        break;
                    case "No Opinion":
                        Log.d(TAG, "N/O");
                        break;
                    case "Somewhat Agree":
                        Log.d(TAG, "SW Agree");
                        break;
                    case "Agree":
                        Log.d(TAG, "Agree");
                        break;
                    default:
                        break;
                }

                if (statementCount >= 8) {
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    startActivity(intent);
                    MainActivity.this.finish();
                } else {
                    mStatement.setText(mStatementArray.statementArray.get(statementCount++));
                }
            }
        });
    }
}
