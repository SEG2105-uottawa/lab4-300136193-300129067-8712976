package com.melissabakker.sportsprofilelab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity {

    ImageView logo0, logo1, logo2, logo3, logo4, logo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        logo0 = (ImageView) findViewById(R.id.logo0);

        logo0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetTeamIcon(v);
            }
        });

        logo1 = (ImageView) findViewById(R.id.logo1);

        logo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetTeamIcon(v);
            }
        });

        logo2 = (ImageView) findViewById(R.id.logo2);

        logo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetTeamIcon(v);
            }
        });

        logo3 = (ImageView) findViewById(R.id.logo3);

        logo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetTeamIcon(v);
            }
        });

        logo4 = (ImageView) findViewById(R.id.logo4);

        logo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetTeamIcon(v);
            }
        });

        logo5 = (ImageView) findViewById(R.id.logo5);

        logo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetTeamIcon(v);
            }
        });

    }



    public void SetTeamIcon(View view) {
//Creating a Return intent to pass to the Main Activity
        Intent returnIntent = new Intent();
//Figuring out which image was clicked
        ImageView selectedImage = (ImageView) view;
//Adding stuff to the return intent
        returnIntent.putExtra("imageID", selectedImage.getId());
        setResult(RESULT_OK, returnIntent);
//Finishing Activity and return to main screen!
        finish();
    }
}