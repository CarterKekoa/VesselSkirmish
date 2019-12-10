package com.cartermooring.vesselskirmish;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ShipChoiceActivity extends AppCompatActivity {
    static final String TAG = "ShipChoiceTAG";
    int imageChange = -1;
    int userImageChoice = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ship_choice_activity_main);

        final ImageView playerChoice = (ImageView) findViewById(R.id.playersChoice);
        final ImageButton battleship = (ImageButton) findViewById(R.id.battleship);
        final ImageButton pirateship = (ImageButton) findViewById(R.id.pirateship);
        final ImageButton vikingship = (ImageButton) findViewById(R.id.vikingship);
        final ImageButton submarine = (ImageButton) findViewById(R.id.submarine);
        final ImageButton spaceship = (ImageButton) findViewById(R.id.spaceship);
        final ImageButton ufo = (ImageButton) findViewById(R.id.ufo);

        battleship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerChoice.setImageResource(R.drawable.battleship);
                imageChange += 1;
                userImageChoice = 1;
            }
        });
        pirateship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerChoice.setImageResource(R.drawable.pirateship);
                imageChange += 1;
                userImageChoice = 2;
            }
        });
        vikingship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerChoice.setImageResource(R.drawable.vikingship);
                imageChange += 1;
                userImageChoice = 3;
            }
        });
        submarine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerChoice.setImageResource(R.drawable.submarine);
                imageChange += 1;
                userImageChoice = 4;
            }
        });
        spaceship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerChoice.setImageResource(R.drawable.spaceship);
                imageChange += 1;
                userImageChoice = 5;
            }
        });
        ufo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerChoice.setImageResource(R.drawable.ufo);
                imageChange += 1;
                userImageChoice = 6;
            }
        });

        Button confirmButton = (Button) findViewById(R.id.confirmSelectionButton);
        Button quitButton = (Button) findViewById(R.id.quitSelectionButton);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imageChange >= 0){
                    Intent intent = new Intent(ShipChoiceActivity.this, ShipPlacementActivity.class);
                    intent.putExtra("shipChoice", userImageChoice);
                    startActivity(intent);
                } else{
                    Toast.makeText(ShipChoiceActivity.this, "Please select a ship type", Toast.LENGTH_SHORT).show();
                }
            }
        });

        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShipChoiceActivity.this.finish();
            }
        });
    }
}
