package com.cartermooring.vesselskirmish;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ShipPlacementActivity extends AppCompatActivity {
    static final String TAG = "ShipPlacementTAG";
    int shipsLeft = 17;
    int userImageChoice = -1;
    int shipChoice = -1;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ship_placement_activity);

        Button quitButton = (Button) findViewById(R.id.quitButton);
        Button confirmButton = (Button) findViewById(R.id.confirmButton);

        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShipPlacementActivity.this.finish();
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(shipsLeft == 0){
                    //TODO move to next screen and gameplay
                }else{
                    Toast.makeText(ShipPlacementActivity.this, "You haven't placed all your ships yet!", Toast.LENGTH_LONG).show();
                }
            }
        });

        Intent intent = getIntent();
        if (intent != null){
            userImageChoice = intent.getIntExtra("shipChoice", 0);
            Log.d(TAG, "onCreate: " + userImageChoice);
        }
        shipChoice = shipChoice(userImageChoice);
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


        if(shipsLeft >= 1) {
            switch (view.getId()) {
                case R.id.t00:
                    button00.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t01:
                    button01.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t02:
                    button02.setImageResource(shipChoice);
                    Log.d(TAG, "02 ");
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t03:
                    button03.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t04:
                    button04.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t05:
                    button05.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t06:
                    button06.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t07:
                    button07.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t10:
                    button10.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t11:
                    button11.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t12:
                    button12.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t13:
                    Log.d(TAG, "13 ");
                    button13.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t14:
                    button14.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t15:
                    button15.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t16:
                    button16.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t17:
                    button17.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t20:
                    button20.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t21:
                    button21.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t22:
                    button22.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t23:
                    button23.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t24:
                    button24.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t25:
                    button25.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t26:
                    button26.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t27:
                    Log.d(TAG, "27 ");
                    button27.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t30:
                    button30.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t31:
                    button31.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t32:
                    button32.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t33:
                    button33.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t34:
                    button34.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t35:
                    button35.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t36:
                    button36.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t37:
                    button37.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t40:
                    button40.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t41:
                    button41.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t42:
                    button42.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t43:
                    button43.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t44:
                    button44.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t45:
                    button45.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t46:
                    button46.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t47:
                    button47.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t50:
                    button50.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t51:
                    button51.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t52:
                    button52.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t53:
                    button53.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t54:
                    button54.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t55:
                    button55.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t56:
                    button56.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t57:
                    button57.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t60:
                    button60.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t61:
                    button61.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t62:
                    button62.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t63:
                    button63.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t64:
                    button64.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t65:
                    button65.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t66:
                    button66.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t67:
                    button67.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t70:
                    button70.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t71:
                    button71.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t72:
                    button72.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t73:
                    button73.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t74:
                    button74.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t75:
                    button75.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t76:
                    button76.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t77:
                    button77.setImageResource(shipChoice);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
            }
        }else{
            Toast.makeText(this, "You have placed all your ships! Click " +
                    "confirm to start playing or click quit to choose a different ship type.", Toast.LENGTH_SHORT).show();
        }
    }

    public int shipChoice(int userImageChoice){
        int shipCho;
        if(userImageChoice == 1){
            shipCho = R.drawable.battleship;
        } else if(userImageChoice == 2){
            shipCho = R.drawable.pirateship;
        } else if(userImageChoice == 3){
            shipCho = R.drawable.vikingship;
        }else if(userImageChoice == 4){
            shipCho = R.drawable.submarine;
        } else if(userImageChoice == 5){
            shipCho = R.drawable.spaceship;
        } else if(userImageChoice == 6){
            shipCho = R.drawable.ufo;
        }else{
            shipCho = R.drawable.battleship;
        }
        return shipCho;
    }
}
