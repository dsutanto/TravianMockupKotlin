package com.traviatour.travianmockupkotlin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import dmax.dialog.SpotsDialog;


public class LoginActivity extends AppCompatActivity {

    EditText _LoginEmail, _LoginPassword;
    TextView _Login_ForgotPass;
    Button _Login_LoginButton, _Login_SignupButton;
    TextInputLayout _Login_EmailLayout, _Login_PasswordLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //OnFirstRun();

        _LoginEmail = (EditText) findViewById(R.id.Login_txtEmail);
        _LoginPassword = (EditText) findViewById(R.id.Login_txtPassword);
        _Login_ForgotPass = (TextView) findViewById(R.id.Login_txtForgotPass);
        _Login_LoginButton = (Button) findViewById(R.id.Login_btnLogin);
        _Login_SignupButton = (Button) findViewById(R.id.Login_btnSignup);

        _Login_EmailLayout = (TextInputLayout) findViewById(R.id.Login_EmailLayout);
        _Login_PasswordLayout = (TextInputLayout) findViewById(R.id.Login_PasswordLayout);

        _Login_SignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                overridePendingTransition( R.anim.right_in, R.anim.right_out);
                finish();
            }
        });

        _Login_ForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ForgotPassActivity.class));
                overridePendingTransition( R.anim.right_in, R.anim.right_out);
                finish();
            }
        });

        _Login_LoginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onLoginProcess();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition( R.anim.right_in, R.anim.right_out);
    }

    public void onLoginProcess() {
        //Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        _Login_LoginButton.setEnabled(false);
        new SpotsDialog(this, R.style.CustomProgressLogin).show();

        // TODO: Implement your own authentication logic here.
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess();

                        // On complete call either onLoginSuccess or onLoginFailed
                        //onLoginFailed();
                    }
                }, 3000);
    }

    public void onLoginSuccess() {
        _Login_LoginButton.setEnabled(true);
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }

    public void onLoginFailed() {
        //Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
        _Login_LoginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = _LoginEmail.getText().toString();
        String phone = _LoginPassword.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _Login_EmailLayout.setError("enter a valid email address");
            valid = false;
        } else if (phone.isEmpty() || phone.length() < 4 || phone.length() > 13) {
            _Login_PasswordLayout.setError("Invalid phone number format");
            valid = false;
        } else {
            _Login_EmailLayout.setError(null);
            _Login_PasswordLayout.setError(null);
        }

        return valid;
    }

    public void OnFirstRun(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //  Initialize SharedPreferences
                SharedPreferences getPrefs = PreferenceManager
                        .getDefaultSharedPreferences(getBaseContext());

                //  Create a new boolean and preference and set it to true
                boolean isFirstStart = getPrefs.getBoolean("FirstTime", true);

                //  If the activity has never started before...
                if (isFirstStart) {

                    finish();

                    //  Launch app intro
                    final Intent LaunchIntro = new Intent(LoginActivity.this, IntroActivity.class);

                    runOnUiThread(new Runnable() {
                        @Override public void run() {
                            startActivity(LaunchIntro);
                        }
                    });

                    //  Make a new preferences editor
                    SharedPreferences.Editor e = getPrefs.edit();

                    //  Edit preference to make it false because we don't want this to run again
                    e.putBoolean("FirstTime", false);

                    //  Apply changes
                    e.apply();
                }
            }
        });

        // Start the thread
        t.start();
    }
}
