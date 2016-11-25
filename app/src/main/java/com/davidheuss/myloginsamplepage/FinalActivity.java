package com.davidheuss.myloginsamplepage;

import android.content.Intent;
import android.hardware.camera2.params.Face;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.facebook.AccessToken;
import com.facebook.FacebookActivity;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;

/**
 * Created by david on 25.11.2016.
 */

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        setContentView(R.layout.activity_final);

        if (AccessToken.getCurrentAccessToken() == null) {
            goFacebookLoginActivity();
        }
    }

    private void goFacebookLoginActivity() {
        Intent intent = new Intent(this, FacebookActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void logoutFacebook (View view){
        LoginManager.getInstance().logOut();
        goFacebookLoginActivity();
    }
}
