package com.example.chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {
    EditText usernameRegistration;
    EditText passwordRegistration;
    EditText confirmPassword;
    Button registrationButton;
    TextView loginText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        usernameRegistration = findViewById(R.id.usernameRegistration);
        passwordRegistration = findViewById(R.id.passwordRegistration);
        confirmPassword = findViewById(R.id.confirmPassword);
        registrationButton = findViewById(R.id.registrationButton);
        loginText = findViewById(R.id.loginText);

        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameRegistration.getText().toString();
                String password = passwordRegistration.getText().toString();
                String confirmPwd = confirmPassword.getText().toString();

                if (password.equals(confirmPwd)) {
                    //  додати логіку для збереження нового користувача в базі даних

                    Toast.makeText(RegistrationActivity.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegistrationActivity.this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                startActivity(intent);

                finish();
            }
        });
    }
}
