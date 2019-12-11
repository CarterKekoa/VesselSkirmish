package com.cartermooring.vesselskirmish;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity {
    static final String TAG = "WelcomeActivityTAG";
    static final int SIGN_IN_REQUEST = 1;

    String username = "";
    List<User> userList;
    ArrayAdapter<User> arrayAdapter;
    ListView listView;

    FirebaseDatabase mFireBaseDataBase;
    DatabaseReference mUserDatabaseReference;
    ChildEventListener mUserChildEventListener;
    FirebaseAuth mFirebaseAuth;
    FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity_main);
        Log.d(TAG, "1");

        listView = (ListView)findViewById(R.id.listView);
        userList = new ArrayList<>();
        userList.add(new User());
        arrayAdapter = new ArrayAdapter<User>(
                this, android.R.layout.simple_list_item_1, userList
        );
        listView.setAdapter(arrayAdapter);

        setupFirebase();

    }

    private void setupFirebase() {
        // initialize the firebase references
        mFireBaseDataBase = FirebaseDatabase.getInstance();
        mUserDatabaseReference = mFireBaseDataBase.getReference().child("users");
        mUserChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.d(TAG, "onChildAdded: " + s);
                User user = dataSnapshot.getValue(User.class);
                userList.add(user);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        mFirebaseAuth = FirebaseAuth.getInstance();
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth mFirebaseAuth) {
                // we have two auth states, signed in and signed out
                // get the get current user, if there is one
                FirebaseUser user = mFirebaseAuth.getCurrentUser();
                if (user != null) {
                    // user is signed in
                    // step 4
                    setupUserSignedIn(user);
                } else {
                    // user is signed out
                    // step 5
                    // we need an intent
                    // the firebaseUI Github repo README.md
                    // we have used builders before in this class
                    // AlertDialog.Builder
                    // return instance to support chaining
                    Intent intent = AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setIsSmartLockEnabled(false)
                            .setAvailableProviders(
                                    Arrays.asList(
                                            new AuthUI.IdpConfig.EmailBuilder().build(),
                                            new AuthUI.IdpConfig.GoogleBuilder().build()
                                    )
                            ).build();
                    startActivityForResult(intent, SIGN_IN_REQUEST);
                }
            }
        };
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SIGN_IN_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "You are now signed in", Toast.LENGTH_SHORT).show();
            }
            else if (resultCode == Activity.RESULT_CANCELED) {
                // they backed out of the sign in activity
                // let's exit
                finish();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
    }

    private void setupUserSignedIn(FirebaseUser user) {
        // get the user's name
        username = user.getDisplayName();
        // listen for database changes with childeventlistener
        // wire it up!
        mUserDatabaseReference
                .addChildEventListener(mUserChildEventListener);
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
