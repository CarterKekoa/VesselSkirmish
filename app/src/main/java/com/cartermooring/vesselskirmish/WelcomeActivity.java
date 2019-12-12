package com.cartermooring.vesselskirmish;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {
    static final String TAG = "WelcomeActivityTAG";

    String username = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity_main);
        Log.d(TAG, "1");

    }

    public void onPlayButtonClick(View view){
        Log.d(TAG, "onPlayButtonClick: ");
        EditText usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        String currText = usernameEditText.getText().toString();

        if (currText.isEmpty()) {
            Toast.makeText(this, "Please enter a username first", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(WelcomeActivity.this, ShipChoiceActivity.class);
            intent.putExtra("username", username);
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(WelcomeActivity.this).toBundle());
            //TODO, here is where they put new value in, we need to do this but after the game is finished instead
        }





//        playButton.setOnClickListener(new View.OnClickListener() {
//            @Override //TODO using these
//            public void onClick(View v) {
//                username = usernameEditText.getText().toString();
//                Log.d(TAG, "3");
//                Intent intent = new Intent(WelcomeActivity.this, ShipChoiceActivity.class);
//                intent.putExtra("username", username);
//
//                if (username.length() > 0){
//                    Log.d(TAG, "4");
//                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(WelcomeActivity.this).toBundle());
//                }else{
//                    Log.d(TAG, "5");
//                    Toast.makeText(WelcomeActivity.this, "Please Enter A Valid Username", Toast.LENGTH_LONG).show();
//                }
//            }
//        });
    }

}
