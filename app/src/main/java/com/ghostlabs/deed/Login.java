package com.ghostlabs.deed;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Hp on 09-07-2016.
 */
public class Login  extends AppCompatActivity {
    Button signIn;
    private static final int RC_SIGN_IN = 100;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()!=null){
            fireIntent();
        }
        setContentView(R.layout.activity_login);
        signIn=(Button)findViewById(R.id.btnSignIn);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth auth = FirebaseAuth.getInstance();
                if (auth.getCurrentUser() != null) {
                    fireIntent();
                } else {
                    signIn();
                }
            }
        });}
        private void fireIntent(){
            Intent intent=new Intent(this, MapsActivity.class);
            startActivity(intent);
            finish();

    }
    public void signIn() {
        startActivityForResult(
                AuthUI.getInstance().createSignInIntentBuilder()
                        .setTheme(R.style.AppTheme)

                        .setProviders(AuthUI.GOOGLE_PROVIDER,AuthUI.FACEBOOK_PROVIDER)
                        .build(),
                RC_SIGN_IN);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            handleSignInResponse(resultCode, data);
            return;
        }
        Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
    }

    @MainThread
    private void handleSignInResponse(int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            fireIntent();
            return;
        }

        if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "No Account Selected", Toast.LENGTH_SHORT).show();
            return;
        }
    }

}