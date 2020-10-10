package com.melissabakker.sportsprofilelab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import static android.view.View.*;

public class MainActivity extends AppCompatActivity {

    /** Variable introduction **/
    Button mapOpen;
    ImageView teamLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapOpen = (Button) findViewById(R.id.button);


        /**Method for listening for button click **/
        mapOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnOpenInGoogleMaps(v);
            }
        });

        teamLogo = (ImageView) findViewById(R.id.teamLogo);

        teamLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnSetAvatarButton(v);
            }
        });
    }

    /** Code copied from lab guide **/

        public void OnOpenInGoogleMaps (View view){
            EditText teamLocation = (EditText) findViewById(R.id.teamLocation);
            // Create a Uri from an intent string. Use the result to create an Intent.
            Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q=" + teamLocation.getText());
            // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            // Make the Intent explicit by setting the Google Maps package
            mapIntent.setPackage("com.google.android.apps.maps");
            // Attempt to start an activity that can handle the Intent
            startActivity(mapIntent);
        }

        public void OnSetAvatarButton (View view){
//Application Context and Activity
            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
            startActivityForResult(intent, 0);
        }

    @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       super.onActivityResult(requestCode, resultCode, data);
        teamLogo = (ImageView) findViewById(R.id.teamLogo);
        if (resultCode == RESULT_CANCELED) return;

//Figuring out the correct image
        String drawableName;
        switch (data.getIntExtra("imageID", R.id.logo0)) {
            case R.id.logo1:
                drawableName = "ic_logo_01";
                break;
            case R.id.logo2:
                drawableName = "ic_logo_02";
                break;
            case R.id.logo3:
                drawableName = "ic_logo_03";
                break;
            case R.id.logo4:
                drawableName = "ic_logo_04";
                break;
            case R.id.logo5:
                drawableName = "ic_logo_05";
                break;
            default:
                drawableName = "ic_logo_00";
                break;
        }
        int resID = getResources().getIdentifier(drawableName, "drawable",
                getPackageName());
        teamLogo.setImageResource(resID);
    }


    }