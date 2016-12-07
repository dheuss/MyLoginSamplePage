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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by david on 26.11.2016.
 */

public class ProfilActivity extends AppCompatActivity {

    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;

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
                System.out.println(user.getUid().toString());
            }
        });
    }

    public void onRadioButtonClickedSex(View view){
        boolean checked = ((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.maleRadioButton:
                if (checked)
                    System.out.println("MALE SEX");
                break;
            case R.id.femaleRadioButton:
                if (checked)
                    System.out.println("FEMALSE SEX");
                break;
        }
    }
}
