package com.traviatour.travianmockupkotlin;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import dmax.dialog.SpotsDialog;

public class RegisterActivity extends AppCompatActivity {

    EditText _SignupEmail, _SignupPhone;
    TextView _Signup_ForgotPass;
    Button _Signup_LoginButton, _Signup_SignupButton;
    TextInputLayout _Signup_EmailLayout, _Signup_PhoneLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        _SignupEmail = (EditText) findViewById(R.id.Signup_txtEmail);
        _SignupPhone = (EditText) findViewById(R.id.Signup_txtPhone);
        _Signup_ForgotPass = (TextView) findViewById(R.id.Signup_txtForgotPass);
        _Signup_LoginButton = (Button) findViewById(R.id.Signup_btnLogin);
        _Signup_SignupButton = (Button) findViewById(R.id.Signup_btnSignup);

        _Signup_EmailLayout = (TextInputLayout) findViewById(R.id.Signup_EmailLayout);
        _Signup_PhoneLayout = (TextInputLayout) findViewById(R.id.Signup_PhoneLayout);

        _Signup_LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                overridePendingTransition( R.anim.right_in, R.anim.right_out);
                finish();
            }
        });

        _Signup_ForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, ForgotPassActivity.class));
                overridePendingTransition( R.anim.right_in, R.anim.right_out);
                finish();
            }
        });

        _Signup_SignupButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                signUpProcess();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition( R.anim.right_in, R.anim.right_out);
    }

    public void signUpProcess() {
        //Log.d(TAG, "Login");

        if (!validate()) {
            onSignUpFailed();
            return;
        }

        _Signup_SignupButton.setEnabled(false);
        new SpotsDialog(this, R.style.CustomProgressLogin).show();

        // TODO: Implement your own authentication logic here.
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onSignUpSuccess();

                        // On complete call either onLoginSuccess or onLoginFailed
                        //onLoginFailed();
                    }
                }, 3000);
    }

    public void onSignUpSuccess() {
        _Signup_SignupButton.setEnabled(true);
        finish();
    }

    public void onSignUpFailed() {
        //Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
        _Signup_SignupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = _SignupEmail.getText().toString();
        String phone = _SignupPhone.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _Signup_EmailLayout.setError("enter a valid email address");
            valid = false;
        } else if (phone.isEmpty() || phone.length() < 4 || phone.length() > 13) {
            _Signup_PhoneLayout.setError("Invalid phone number format");
            valid = false;
        } else {
            _Signup_EmailLayout.setError(null);
            _Signup_PhoneLayout.setError(null);
        }

        return valid;
    }
}
