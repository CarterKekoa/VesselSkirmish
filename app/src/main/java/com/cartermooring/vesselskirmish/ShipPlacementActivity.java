package com.cartermooring.vesselskirmish;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ShipPlacementActivity extends AppCompatActivity {
    static final String TAG = "ShipPlacementTAG";
    int shipsLeft = 17;
    int userImageChoice = -1;
    int shipChoice = -1;
    String tagArray = "";
    int tagCounter = 17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

        Intent intent = getIntent();
        if (intent != null){
            userImageChoice = intent.getIntExtra("shipChoice", 0);
            Log.d(TAG, "onCreate: " + userImageChoice);
        }
        shipChoice = shipChoice(userImageChoice);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(shipsLeft <= 0){
                    Intent intent = new Intent(ShipPlacementActivity.this, GameActivity.class);
                    intent.putExtra("tagArray", tagArray);

                    if(intent != null) {
                        startActivity(intent);
                    }
                    //TODO move to next screen and gameplay
                }else{
                    Toast.makeText(ShipPlacementActivity.this, "You haven't placed all your ships yet!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void tagGet(ImageButton button){
        if(tagCounter > 0) {
            String tag = button.getTag().toString();   //grab the full tag
            tagArray = tagArray + tag;
            tagCounter--;
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


        if(shipsLeft >= 1) { //TODO make buttons not clickable after being changed
            switch (view.getId()) {
                case R.id.t00:
                    button00.setImageResource(shipChoice);
                    button00.setClickable(false);
                    tagGet(button00);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t01:
                    button01.setImageResource(shipChoice);
                    button01.setClickable(false);
                    tagGet(button01);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t02:
                    button02.setImageResource(shipChoice);
                    button02.setClickable(false);
                    tagGet(button02);
                    Log.d(TAG, "02 ");
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t03:
                    button03.setImageResource(shipChoice);
                    button03.setClickable(false);
                    tagGet(button03);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t04:
                    button04.setImageResource(shipChoice);
                    button04.setClickable(false);
                    tagGet(button04);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t05:
                    button05.setImageResource(shipChoice);
                    button05.setClickable(false);
                    tagGet(button05);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t06:
                    button06.setImageResource(shipChoice);
                    button06.setClickable(false);
                    tagGet(button06);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t07:
                    button07.setImageResource(shipChoice);
                    button07.setClickable(false);
                    tagGet(button07);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t10:
                    button10.setImageResource(shipChoice);
                    button10.setClickable(false);
                    tagGet(button10);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t11:
                    button11.setImageResource(shipChoice);
                    button11.setClickable(false);
                    tagGet(button11);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t12:
                    button12.setImageResource(shipChoice);
                    button12.setClickable(false);
                    tagGet(button12);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t13:
                    button13.setImageResource(shipChoice);
                    button13.setClickable(false);
                    tagGet(button13);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t14:
                    button14.setImageResource(shipChoice);
                    button14.setClickable(false);
                    tagGet(button14);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t15:
                    button15.setImageResource(shipChoice);
                    button15.setClickable(false);
                    tagGet(button15);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t16:
                    button16.setImageResource(shipChoice);
                    button16.setClickable(false);
                    tagGet(button16);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t17:
                    button17.setImageResource(shipChoice);
                    button17.setClickable(false);
                    tagGet(button17);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t20:
                    button20.setImageResource(shipChoice);
                    button20.setClickable(false);
                    tagGet(button20);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t21:
                    button21.setImageResource(shipChoice);
                    button21.setClickable(false);
                    tagGet(button21);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t22:
                    button22.setImageResource(shipChoice);
                    button22.setClickable(false);
                    tagGet(button22);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t23:
                    button23.setImageResource(shipChoice);
                    button23.setClickable(false);
                    tagGet(button23);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t24:
                    button24.setImageResource(shipChoice);
                    button24.setClickable(false);
                    tagGet(button24);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t25:
                    button25.setImageResource(shipChoice);
                    button25.setClickable(false);
                    tagGet(button25);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t26:
                    button26.setImageResource(shipChoice);
                    button26.setClickable(false);
                    tagGet(button26);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t27:
                    button27.setImageResource(shipChoice);
                    button27.setClickable(false);
                    tagGet(button27);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t30:
                    button30.setImageResource(shipChoice);
                    button30.setClickable(false);
                    tagGet(button30);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t31:
                    button31.setImageResource(shipChoice);
                    button31.setClickable(false);
                    tagGet(button31);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t32:
                    button32.setImageResource(shipChoice);
                    button32.setClickable(false);
                    tagGet(button32);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t33:
                    button33.setImageResource(shipChoice);
                    button33.setClickable(false);
                    tagGet(button33);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t34:
                    button34.setImageResource(shipChoice);
                    button34.setClickable(false);
                    tagGet(button34);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t35:
                    button35.setImageResource(shipChoice);
                    button35.setClickable(false);
                    tagGet(button35);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t36:
                    button36.setImageResource(shipChoice);
                    button36.setClickable(false);
                    tagGet(button36);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t37:
                    button37.setImageResource(shipChoice);
                    button37.setClickable(false);
                    tagGet(button37);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t40:
                    button40.setImageResource(shipChoice);
                    button40.setClickable(false);
                    tagGet(button40);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t41:
                    button41.setImageResource(shipChoice);
                    button41.setClickable(false);
                    tagGet(button41);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t42:
                    button42.setImageResource(shipChoice);
                    button42.setClickable(false);
                    tagGet(button42);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t43:
                    button43.setImageResource(shipChoice);
                    button43.setClickable(false);
                    tagGet(button43);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t44:
                    button44.setImageResource(shipChoice);
                    button44.setClickable(false);
                    tagGet(button44);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t45:
                    button45.setImageResource(shipChoice);
                    button45.setClickable(false);
                    tagGet(button45);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t46:
                    button46.setImageResource(shipChoice);
                    button46.setClickable(false);
                    tagGet(button46);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t47:
                    button47.setImageResource(shipChoice);
                    button47.setClickable(false);
                    tagGet(button47);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t50:
                    button50.setImageResource(shipChoice);
                    button50.setClickable(false);
                    tagGet(button50);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t51:
                    button51.setImageResource(shipChoice);
                    button51.setClickable(false);
                    tagGet(button51);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t52:
                    button52.setImageResource(shipChoice);
                    button52.setClickable(false);
                    tagGet(button52);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t53:
                    button53.setImageResource(shipChoice);
                    button53.setClickable(false);
                    tagGet(button53);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t54:
                    button54.setImageResource(shipChoice);
                    button54.setClickable(false);
                    tagGet(button54);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t55:
                    button55.setImageResource(shipChoice);
                    button55.setClickable(false);
                    tagGet(button55);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t56:
                    button56.setImageResource(shipChoice);
                    button56.setClickable(false);
                    tagGet(button56);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t57:
                    button57.setImageResource(shipChoice);
                    button57.setClickable(false);
                    tagGet(button57);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t60:
                    button60.setImageResource(shipChoice);
                    button60.setClickable(false);
                    tagGet(button60);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t61:
                    button61.setImageResource(shipChoice);
                    button61.setClickable(false);
                    tagGet(button61);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t62:
                    button62.setImageResource(shipChoice);
                    button62.setClickable(false);
                    tagGet(button62);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t63:
                    button63.setImageResource(shipChoice);
                    button63.setClickable(false);
                    tagGet(button63);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t64:
                    button64.setImageResource(shipChoice);
                    button64.setClickable(false);
                    tagGet(button64);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t65:
                    button65.setImageResource(shipChoice);
                    button65.setClickable(false);
                    tagGet(button65);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t66:
                    button66.setImageResource(shipChoice);
                    button66.setClickable(false);
                    tagGet(button66);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t67:
                    button67.setImageResource(shipChoice);
                    button67.setClickable(false);
                    tagGet(button67);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t70:
                    button70.setImageResource(shipChoice);
                    button70.setClickable(false);
                    tagGet(button70);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t71:
                    button71.setImageResource(shipChoice);
                    button71.setClickable(false);
                    tagGet(button71);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t72:
                    button72.setImageResource(shipChoice);
                    button72.setClickable(false);
                    tagGet(button72);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t73:
                    button73.setImageResource(shipChoice);
                    button73.setClickable(false);
                    tagGet(button73);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t74:
                    button74.setImageResource(shipChoice);
                    button74.setClickable(false);
                    tagGet(button74);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t75:
                    button75.setImageResource(shipChoice);
                    button75.setClickable(false);
                    tagGet(button75);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t76:
                    button76.setImageResource(shipChoice);
                    button76.setClickable(false);
                    tagGet(button76);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.t77:
                    button77.setImageResource(shipChoice);
                    button77.setClickable(false);
                    tagGet(button77);
                    shipsLeft -= 1;
                    Toast.makeText(this, "You have" + shipsLeft + " ships left!", Toast.LENGTH_SHORT).show();break;
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
