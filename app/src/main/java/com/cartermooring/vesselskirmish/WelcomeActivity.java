package com.cartermooring.vesselskirmish;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {
    static final String TAG = "WelcomeActivityTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity_main);
        Log.d(TAG, "1");

        Button playButton = (Button) findViewById(R.id.playButton);
        final EditText usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        Log.d(TAG, "2");
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                Log.d(TAG, "3");
                Intent intent = new Intent(WelcomeActivity.this, ShipChoiceActivity.class);
                intent.putExtra("username", username);

                if (username.length() > 0){
                    Log.d(TAG, "4");
                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(WelcomeActivity.this).toBundle());
                }else{
                    Log.d(TAG, "5");
                    Toast.makeText(WelcomeActivity.this, "Please Enter A Valid Username", Toast.LENGTH_LONG).show();
                }
        }
    });
    }
}
