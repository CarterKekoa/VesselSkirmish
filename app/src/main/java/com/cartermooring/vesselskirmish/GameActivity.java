package com.cartermooring.vesselskirmish;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GameActivity extends ShipPlacementActivity {
    static final String TAG = "GameActivtiyTAG";
    public Cell[][] AIGrid = new Cell[8][8];
    public Cell[][] playerGrid = new Cell[8][8];
    boolean whosUp; //player goes first always
    boolean whoWins = false; //default computer
    int playersShipCount = 17;
    int AIsShipCount = 17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ai_game_activity_main); //TODO set this for user then change as turn changes


        Button quitButton = (Button)findViewById(R.id.quitButton);
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameActivity.this.finish();
            }
        });

        //construct a blank array
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                playerGrid[i][j] = new Cell();
                //playerGrid[i][j].setPlayer(1);  //player is player 1
                playerGrid[i][j].setPlayer(0);
                AIGrid[i][j] = new Cell();
                AIGrid[i][j].setPlayer(0);      //AI is player 2
            }
        }

        String tagArray = getIntent().getStringExtra("tagArray");   //take array of values and put into a String
        Log.d(TAG, "tagArray: " + tagArray);
        parseTagArray(tagArray);    //place ships on player array based on tags from buttons they clicked
        AIShipPlacement();          //randomly place the AI ships on board



    }

    //main game function happens when the user clicks a button
    public void mainGameActivity(ImageButton button){
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        TextView playerTextView = (TextView)findViewById(R.id.playerTitle);
        TextView AITextView = (TextView)findViewById(R.id.AITitle);
        View playerView = findViewById(R.id.playerTitle);
        View AIView = findViewById(R.id.AITitle);

        whosUp = true;  //player 1 is going since the button was clicked
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE); //should disable screen use
        button.setClickable(false);

        if(parseTag(button)){   //parse returns if the users clicked spot is a hit, if statement reacts accordingly
            button.setImageResource(R.drawable.explosion);
            AIsShipCount -= 1;
            Log.d(TAG, "AIsShip count after hit: " + AIsShipCount);
            playerTextView.setText("You sunk a ship! AI has " + AIsShipCount + " ship(s) left!");
            playerView.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
        } else {
            button.setImageResource(R.drawable.splash);
            playerTextView.setText("You missed.. AI still has " + AIsShipCount + " ship(s) left!");
            playerView.setBackgroundColor(getResources().getColor(android.R.color.white));
        }

        if(isWinner()){ //after players turn, check if winner
            whoWins = true; //player wins
            alertDialogBuilder.setTitle("GAME OVER!")
                    .setMessage("The AI beat you :(")
                    .setNegativeButton("Return Home", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
            alertDialogBuilder.show();
            //TODO update firebase
        }

        whosUp = false; //change turn to AI

        if(AITurn()){   //AI hits one of the users ships
            playersShipCount -= 1;
            AITextView.setText("One of your ships was hit! You have " + playersShipCount + " ship(s) left!");
            AIView.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
        } else{ //AI misses
            AITextView.setText("The AI Missed! Time to capitalize! It only has " + AIsShipCount + " ship(s) left!");
            AIView.setBackgroundColor(getResources().getColor(android.R.color.white));
        }

        if(isWinner()) {    //after AI's turn, check if winner
            whoWins = false; //computer wins;
            alertDialogBuilder.setTitle("GAME OVER!")
                    .setMessage("You beat the AI!!")
                    .setNegativeButton("Return Home", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                                });
            alertDialogBuilder.show();

            //TODO update firebase
        }

        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);  //make screen touchable again
    }

    public void AIShipPlacement(){
        Coordinates coordinates = new Coordinates();
        Random random = new Random();
        int counter = 0;

        while(counter < 17) {
            int row = random.nextInt(8);
            int col = random.nextInt(8);
            if(AIGrid[row][col].getPlayer() != 2) {
                //System.out.println("row " + row + " col " + col);
                coordinates.setRow(row);
                coordinates.setCol(col);
                AIGrid[row][col].setCoordinates(coordinates);
                AIGrid[row][col].setPlayer(2);
                counter++;
            }
        }
    }

    public boolean isWinner(){
        Log.d(TAG, "PlayersShipCount at isWinner: " + playersShipCount);
        Log.d(TAG, "AIsShipCount at isWinner: " + AIsShipCount);
            if(playersShipCount <= 0){
                return true;
            } else if(AIsShipCount <= 0){
                return true;
            }
            return false;
    }

    public void sleepFast(){
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){e.printStackTrace();}
    }

    public boolean AITurn(){
        Random random = new Random();
        int row = random.nextInt(8);
        int col = random.nextInt(8);
        //TODO improve upon AIs ability
        return isHit(row, col);
    }

    public boolean isHit(int row, int col){
        Log.d(TAG, "Whos up: " + whosUp);
        Log.d(TAG, "AIsShip count: " + AIsShipCount);
        Log.d(TAG, "playersShip count: " + playersShipCount);

        if(whosUp == true){ //check players shot
            Log.d(TAG, "AIGrid.getPlayer(): " + AIGrid[row][col].getPlayer());
            if(AIGrid[row][col].getPlayer() == 2){
                return true;
            }else{
                return false;
            }
        } else if (whosUp != true){
            Log.d(TAG, "playerGrid.getPlayer(): " + playerGrid[row][col].getPlayer());
            if(playerGrid[row][col].getPlayer() == 1){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    public boolean parseTag(ImageButton button){
        String tag = button.getTag().toString();

        char ROW = tag.charAt(0);
        char COL = tag.charAt(1);
        String Row = String.valueOf(ROW);   //set row char to a String
        String Col = String.valueOf(COL);   //set col char to a String
        int row = Integer.parseInt(Row);
        int col = Integer.parseInt(Col);

        sleepFast();
        return isHit(row, col);
    }

    public void parseTagArray(String tagArray){
        Coordinates coordinates = new Coordinates();

        for(int i = 0; i < 34; i = i + 2){
            char ROW = tagArray.charAt(i);
            char COL = tagArray.charAt(i+1);
            String Row = String.valueOf(ROW);   //set row char to a String
            String Col = String.valueOf(COL);   //set col char to a String
            int row = Integer.parseInt(Row);
            int col = Integer.parseInt(Col);
            coordinates.setRow(row);
            coordinates.setRow(col);
            playerGrid[row][col].setCoordinates(coordinates);
            playerGrid[row][col].setPlayer(1);
        }
    }

    public void onClick(View view) {
        //00s
        final ImageButton button00 = (ImageButton) findViewById(R.id.t00);
        final ImageButton button01 = (ImageButton) findViewById(R.id.t01);
        final ImageButton button02 = (ImageButton) findViewById(R.id.t02);
        final ImageButton button03 = (ImageButton) findViewById(R.id.t03);
        final ImageButton button04 = (ImageButton) findViewById(R.id.t04);
        final ImageButton button05 = (ImageButton) findViewById(R.id.t05);
        final ImageButton button06 = (ImageButton) findViewById(R.id.t06);
        final ImageButton button07 = (ImageButton) findViewById(R.id.t07);
        //10s
        final ImageButton button10 = (ImageButton) findViewById(R.id.t10);
        final ImageButton button11 = (ImageButton) findViewById(R.id.t11);
        final ImageButton button12 = (ImageButton) findViewById(R.id.t12);
        final ImageButton button13 = (ImageButton) findViewById(R.id.t13);
        final ImageButton button14 = (ImageButton) findViewById(R.id.t14);
        final ImageButton button15 = (ImageButton) findViewById(R.id.t15);
        final ImageButton button16 = (ImageButton) findViewById(R.id.t16);
        final ImageButton button17 = (ImageButton) findViewById(R.id.t17);
        //20s
        final ImageButton button20 = (ImageButton) findViewById(R.id.t20);
        final ImageButton button21 = (ImageButton) findViewById(R.id.t21);
        final ImageButton button22 = (ImageButton) findViewById(R.id.t22);
        final ImageButton button23 = (ImageButton) findViewById(R.id.t23);
        final ImageButton button24 = (ImageButton) findViewById(R.id.t24);
        final ImageButton button25 = (ImageButton) findViewById(R.id.t25);
        final ImageButton button26 = (ImageButton) findViewById(R.id.t26);
        final ImageButton button27 = (ImageButton) findViewById(R.id.t27);
        //30s
        final ImageButton button30 = (ImageButton) findViewById(R.id.t30);
        final ImageButton button31 = (ImageButton) findViewById(R.id.t31);
        final ImageButton button32 = (ImageButton) findViewById(R.id.t32);
        final ImageButton button33 = (ImageButton) findViewById(R.id.t33);
        final ImageButton button34 = (ImageButton) findViewById(R.id.t34);
        final ImageButton button35 = (ImageButton) findViewById(R.id.t35);
        final ImageButton button36 = (ImageButton) findViewById(R.id.t36);
        final ImageButton button37 = (ImageButton) findViewById(R.id.t37);
        //40s
        final ImageButton button40 = (ImageButton) findViewById(R.id.t40);
        final ImageButton button41 = (ImageButton) findViewById(R.id.t41);
        final ImageButton button42 = (ImageButton) findViewById(R.id.t42);
        final ImageButton button43 = (ImageButton) findViewById(R.id.t43);
        final ImageButton button44 = (ImageButton) findViewById(R.id.t44);
        final ImageButton button45 = (ImageButton) findViewById(R.id.t45);
        final ImageButton button46 = (ImageButton) findViewById(R.id.t46);
        final ImageButton button47 = (ImageButton) findViewById(R.id.t47);
        //50s
        final ImageButton button50 = (ImageButton) findViewById(R.id.t50);
        final ImageButton button51 = (ImageButton) findViewById(R.id.t51);
        final ImageButton button52 = (ImageButton) findViewById(R.id.t52);
        final ImageButton button53 = (ImageButton) findViewById(R.id.t53);
        final ImageButton button54 = (ImageButton) findViewById(R.id.t54);
        final ImageButton button55 = (ImageButton) findViewById(R.id.t55);
        final ImageButton button56 = (ImageButton) findViewById(R.id.t56);
        final ImageButton button57 = (ImageButton) findViewById(R.id.t57);
        //60s
        final ImageButton button60 = (ImageButton) findViewById(R.id.t60);
        final ImageButton button61 = (ImageButton) findViewById(R.id.t61);
        final ImageButton button62 = (ImageButton) findViewById(R.id.t62);
        final ImageButton button63 = (ImageButton) findViewById(R.id.t63);
        final ImageButton button64 = (ImageButton) findViewById(R.id.t64);
        final ImageButton button65 = (ImageButton) findViewById(R.id.t65);
        final ImageButton button66 = (ImageButton) findViewById(R.id.t66);
        final ImageButton button67 = (ImageButton) findViewById(R.id.t67);
        //70s
        final ImageButton button70 = (ImageButton) findViewById(R.id.t70);
        final ImageButton button71 = (ImageButton) findViewById(R.id.t71);
        final ImageButton button72 = (ImageButton) findViewById(R.id.t72);
        final ImageButton button73 = (ImageButton) findViewById(R.id.t73);
        final ImageButton button74 = (ImageButton) findViewById(R.id.t74);
        final ImageButton button75 = (ImageButton) findViewById(R.id.t75);
        final ImageButton button76 = (ImageButton) findViewById(R.id.t76);
        final ImageButton button77 = (ImageButton) findViewById(R.id.t77);


            switch (view.getId()) {
                case R.id.t00:
                    mainGameActivity(button00);
                    break;
                case R.id.t01:
                    mainGameActivity(button01);
                    break;
                case R.id.t02:
                    mainGameActivity(button02);
                    break;
                case R.id.t03:
                    mainGameActivity(button03);
                    break;
                case R.id.t04:
                    mainGameActivity(button04);
                    break;
                case R.id.t05:
                    mainGameActivity(button05);
                    break;
                case R.id.t06:
                    mainGameActivity(button06);
                    break;
                case R.id.t07:
                    mainGameActivity(button07);
                    break;
                case R.id.t10:
                    mainGameActivity(button10);
                    break;
                case R.id.t11:
                    mainGameActivity(button11);
                    break;
                case R.id.t12:
                    mainGameActivity(button12);
                    break;
                case R.id.t13:
                    mainGameActivity(button13);
                    break;
                case R.id.t14:
                    mainGameActivity(button14);
                    break;
                case R.id.t15:
                    mainGameActivity(button15);
                    break;
                case R.id.t16:
                    mainGameActivity(button16);
                    break;
                case R.id.t17:
                    mainGameActivity(button17);
                    break;
                case R.id.t20:
                    mainGameActivity(button20);
                    break;
                case R.id.t21:
                    mainGameActivity(button21);
                    break;
                case R.id.t22:
                    mainGameActivity(button22);
                    break;
                case R.id.t23:
                    mainGameActivity(button23);
                    break;
                case R.id.t24:
                    mainGameActivity(button24);
                    break;
                case R.id.t25:
                    mainGameActivity(button25);
                    break;
                case R.id.t26:
                    mainGameActivity(button26);
                    break;
                case R.id.t27:
                    mainGameActivity(button27);
                    break;
                case R.id.t30:
                    mainGameActivity(button30);
                    break;
                case R.id.t31:
                    mainGameActivity(button31);
                    break;
                case R.id.t32:
                    mainGameActivity(button32);
                    break;
                case R.id.t33:
                    mainGameActivity(button33);
                    break;
                case R.id.t34:
                    mainGameActivity(button34);
                    break;
                case R.id.t35:
                    mainGameActivity(button35);
                    break;
                case R.id.t36:
                    mainGameActivity(button36);
                    break;
                case R.id.t37:
                    mainGameActivity(button37);
                    break;
                case R.id.t40:
                    mainGameActivity(button40);
                    break;
                case R.id.t41:
                    mainGameActivity(button41);
                    break;
                case R.id.t42:
                    mainGameActivity(button42);
                    break;
                case R.id.t43:
                    mainGameActivity(button43);
                    break;
                case R.id.t44:
                    mainGameActivity(button44);
                    break;
                case R.id.t45:
                    mainGameActivity(button45);
                    break;
                case R.id.t46:
                    mainGameActivity(button46);
                    break;
                case R.id.t47:
                    mainGameActivity(button47);
                    break;
                case R.id.t50:
                    mainGameActivity(button50);
                    break;
                case R.id.t51:
                    mainGameActivity(button51);
                    break;
                case R.id.t52:
                    mainGameActivity(button52);
                    break;
                case R.id.t53:
                    mainGameActivity(button53);
                    break;
                case R.id.t54:
                    mainGameActivity(button54);
                    break;
                case R.id.t55:
                    mainGameActivity(button55);
                    break;
                case R.id.t56:
                    mainGameActivity(button56);
                    break;
                case R.id.t57:
                    mainGameActivity(button57);
                    break;
                case R.id.t60:
                    mainGameActivity(button60);
                    break;
                case R.id.t61:
                    mainGameActivity(button61);
                    break;
                case R.id.t62:
                    mainGameActivity(button62);
                    break;
                case R.id.t63:
                    mainGameActivity(button63);
                    break;
                case R.id.t64:
                    mainGameActivity(button64);
                    break;
                case R.id.t65:
                    mainGameActivity(button65);
                    break;
                case R.id.t66:
                    mainGameActivity(button66);
                    break;
                case R.id.t67:
                    mainGameActivity(button67);
                    break;
                case R.id.t70:
                    mainGameActivity(button70);
                    break;
                case R.id.t71:
                    mainGameActivity(button71);
                    break;
                case R.id.t72:
                    mainGameActivity(button72);
                    break;
                case R.id.t73:
                    mainGameActivity(button73);
                    break;
                case R.id.t74:
                    mainGameActivity(button74);
                    break;
                case R.id.t75:
                    mainGameActivity(button75);
                    break;
                case R.id.t76:
                    mainGameActivity(button76);
                    break;
                case R.id.t77:
                    mainGameActivity(button77);
                    break;
                    }
            }
}
