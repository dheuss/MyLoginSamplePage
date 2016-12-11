package com.davidheuss.myloginsamplepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by david on 26.11.2016.
 */

public class ProfilActivity extends AppCompatActivity {

    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;
    private DatabaseReference mDatabase;

    private EditText surnameText;
    private EditText lastnameText;
    private EditText emailText;
    private EditText ageText;
    private RadioGroup radioSexGroup;
    private RadioButton radioSexText;
    private Spinner smokerText;
    private EditText durationText;
    private EditText minSizeText;
    private EditText maxSizeText;

    private Button saveButton;

    private String surnameString;
    private String lastnameString;
    private String emailString;
    private String ageString;
    private String sexString;
    private String smokerString;
    private String durationString;
    private String minSizeString;
    private String maxSizeString;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        //get firebase auth instance
        auth = FirebaseAuth.getInstance();

        //get current user
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(ProfilActivity.this, EmailLoginActivity.class));
                    finish();
                }
            }
        };

        mDatabase = FirebaseDatabase.getInstance().getReference();

        surnameText = (EditText)findViewById(R.id.surnameText);
        lastnameText = (EditText)findViewById(R.id.lastnameText);
        emailText = (EditText)findViewById(R.id.emailText);
        ageText = (EditText)findViewById(R.id.ageText);
        radioSexGroup = (RadioGroup)findViewById(R.id.sexRadioGroup);
        smokerText = (Spinner)findViewById(R.id.smokerText);
        durationText = (EditText)findViewById(R.id.durationText);
        minSizeText = (EditText)findViewById(R.id.minSizeText);
        maxSizeText = (EditText)findViewById(R.id.maxSizeText);

        saveButton = (Button)findViewById(R.id.saveButton);



        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                surnameString = surnameText.getText().toString();
                lastnameString = lastnameText.getText().toString();
                emailString = emailText.getText().toString();
                ageString = ageText.getText().toString();
                smokerString = smokerText.getSelectedItem().toString();
                durationString = durationText.getText().toString();
                minSizeString = minSizeText.getText().toString();
                maxSizeString = maxSizeText.getText().toString();

                mDatabase.child(user.getUid())
                        .child("surname").setValue(surnameString);
                mDatabase.child(user.getUid())
                        .child("lastname").setValue(lastnameString);
                mDatabase.child(user.getUid())
                        .child("email").setValue(emailString);
                mDatabase.child(user.getUid())
                        .child("age").setValue(ageString);
                mDatabase.child(user.getUid())
                        .child("sex").setValue(sexString);
                mDatabase.child(user.getUid())
                        .child("smoker").setValue(smokerString);
                mDatabase.child(user.getUid())
                        .child("duration").setValue(durationString);
                mDatabase.child(user.getUid())
                        .child("minSize").setValue(minSizeString);
                mDatabase.child(user.getUid())
                        .child("maxSize").setValue(maxSizeString);
            }
        });
    }

    public void onRadioButtonClickedSex(View view){
        boolean checked = ((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.maleRadioButton:
                if (checked)
                    sexString = "male";
                break;
            case R.id.femaleRadioButton:
                if (checked)
                    sexString = "female";
                break;
        }
    }
}
