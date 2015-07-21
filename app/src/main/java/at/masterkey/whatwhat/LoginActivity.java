package at.masterkey.whatwhat;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Pattern;

/**
 * Created by Masterkey on 19.07.2015.
 */
public class LoginActivity extends AppCompatActivity {
    TextInputLayout mUsernameLayout;
    EditText mUsernameText;

    TextInputLayout mPasswordLayout;
    EditText mPasswordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsernameLayout = (TextInputLayout) findViewById(R.id.activity_login_username_layout);
        mUsernameText = (EditText) findViewById(R.id.activity_login_username_edittext);

        mPasswordLayout = (TextInputLayout) findViewById(R.id.activity_login_password_layout);
        mPasswordText = (EditText) findViewById(R.id.activity_login_password_edittext);

        findViewById(R.id.activity_login_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
    }

    private void validate() {
        // Username
        String username = mUsernameText.getText().toString();
        if (Pattern.matches("[a-zA-Z]+", username)) {
            mUsernameLayout.setErrorEnabled(false);
        } else {
            mUsernameLayout.setErrorEnabled(true);
            mUsernameLayout.setError("Username Error");
        }

        // Password
        String password = mPasswordText.getText().toString();
        if (Pattern.matches("[0-9]+", password)) {
            mPasswordLayout.setErrorEnabled(false);
        } else {
            mPasswordLayout.setErrorEnabled(true);
            mPasswordLayout.setError("Password Error");
        }
    }
}
