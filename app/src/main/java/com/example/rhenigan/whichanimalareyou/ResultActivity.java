package com.example.rhenigan.whichanimalareyou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class ResultActivity extends AppCompatActivity {

    private static final String TAG = "ResultActivity";
    private Animal mResult;
    private ImageView mAnimalImage;
    private String mCaption;
    private TextView mCaptionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mResult = getIntent().getParcelableExtra("ANIMAL");
        mCaption = getIntent().getStringExtra("CAPTION");

        if (mCaption.equals("Add a caption here!")) {
            mCaption = "";
        }

        Log.d(TAG, mCaption);

        mAnimalImage = findViewById(R.id.animalImage);
        mCaptionView = findViewById(R.id.caption);

        mAnimalImage.setImageResource(mResult.getImageid());

        mCaptionView.setText(mCaption);


        Toast.makeText(this, "Congratulations, You are a(n) " + mResult.getName() + "!", Toast.LENGTH_LONG).show();

    }
}
