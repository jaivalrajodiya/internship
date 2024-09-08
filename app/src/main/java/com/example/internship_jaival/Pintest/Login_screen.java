package com.example.internship_jaival.Pintest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.internship_jaival.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class Login_screen extends AppCompatActivity {

    private ScrollView scrollView;
    private Handler handler = new Handler();
    private int scrollSpeed = 2; // Adjust the scroll speed as needed
    private int scrollDelay = 100;

    Button continu;

    EditText email;
    Boolean check = false;

    LinearLayout btSignIn;
    GoogleSignInClient googleSignInClient;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        scrollView = findViewById(R.id.printest_srcollview);
        email = findViewById(R.id.printest_email);
        continu = findViewById(R.id.printerst_continu);

        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                check = hasFocus;
                if (hasFocus){
                    scrollView.setVisibility(View.GONE);
                }
            }
        });
        // Start the automatic scrolling
        startAutoScroll();

        continu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_screen.this, Printesrt_MainActivity.class);
                startActivity(intent);
            }
        });


        btSignIn = findViewById(R.id.bt_sign_in);


        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("807487263506-oit2m46o8n74r0tac42trja1q5pl06lr.apps.googleusercontent.com")
                .requestEmail()
                .build();


        googleSignInClient = GoogleSignIn.getClient(Login_screen.this, googleSignInOptions);

        btSignIn.setOnClickListener(view -> {

            Intent intent = googleSignInClient.getSignInIntent();
            startActivityForResult(intent, 100);
        });


        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null) {
            startActivity(new Intent(Login_screen.this, Printesrt_MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        }
    }
    private void startAutoScroll() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Scroll the ScrollView by a small amount
                scrollView.scrollBy(0, scrollSpeed);

                // Schedule the next scroll after a delay
                handler.postDelayed(this, scrollDelay);
            }
        }, scrollDelay);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Stop the automatic scrolling when the activity is destroyed
        handler.removeCallbacksAndMessages(null);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            Task<GoogleSignInAccount> signInAccountTask = GoogleSignIn.getSignedInAccountFromIntent(data);

            if (signInAccountTask.isSuccessful()) {
                String s = "Google sign in successful";
                displayToast(s);
                try {
                    GoogleSignInAccount googleSignInAccount = signInAccountTask.getResult(ApiException.class);
                    if (googleSignInAccount != null) {
                        AuthCredential authCredential = GoogleAuthProvider.getCredential(googleSignInAccount.getIdToken(), null);
                        firebaseAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
//
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(Login_screen.this, Printesrt_MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));



                                    displayToast("Firebase authentication successful");
                                } else {
                                    // When task is unsuccessful display Toast
                                    displayToast("Authentication Failed :" + task.getException().getMessage());
                                }
                            }
                        });
                    }
                } catch (ApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private void displayToast(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        if (check){
            scrollView.setVisibility(View.VISIBLE);
            check = false;
        }else {
            super.onBackPressed();
        }

    }
}