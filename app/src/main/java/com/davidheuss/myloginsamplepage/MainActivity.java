package com.davidheuss.myloginsamplepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.FacebookActivity;
import com.facebook.FacebookSdk;

/**
 * Created by david on 25.11.2016.
 */

public class MainActivity extends AppCompatActivity {

    private Button btn_facebook;
    private Button btn_google;
    private Button btn_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        setContentView(R.layout.activity_main);

        btn_facebook = (Button) findViewById(R.id.btn_login_facebook);
        btn_google = (Button) findViewById(R.id.btn_login_google);
        btn_email = (Button) findViewById(R.id.btn_login_email);

        btn_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                startActivity(new Intent(MainActivity.this, FacebookLoginActivity.class));
            }
        });

        btn_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GoogleLoginActivity.class));
            }
        });

        btn_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EmailLoginActivity.class));
            }
        });
    }
}
