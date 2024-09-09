package com.example.trainingapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.trainingapp.Database.Database;
import com.example.trainingapp.R;

public class RegisterActivity extends AppCompatActivity {
    private Button button, button2;
    private EditText editText, editText2, editText3, editText4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editText.getText().toString();
                String email = editText2.getText().toString();
                String password = editText3.getText().toString();
                String confirmPassword = editText4.getText().toString();
                Database db = new Database(getApplicationContext(), "userDB");
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);

                if(username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Please enter all the details", Toast.LENGTH_SHORT).show();
                } else {
                    if(password.compareTo(confirmPassword) == 0) {
                        if(isValidPassword(password)) {
                            db.insertData(username, email, password);
                            Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                        } else {
                            Toast.makeText(RegisterActivity.this, "Password must contain at least 8 characters, having upperCase, lowerCase, special characters and numbers", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(RegisterActivity.this, "Password and confirm password does not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    public boolean isValidPassword(String password) {
        boolean cap1 = false, cap2 = false, cap3 = false, cap4 = false;
        if(password.length() < 8) {
            return false;
        } else {
            for(int i = 0; i < password.length(); i++) {
                if(Character.isUpperCase(password.charAt(i))) {
                    cap1 = true;
                }
            }
            for(int j = 0; j < password.length(); j++) {
                if(Character.isDigit(password.charAt(j))) {
                    cap2 = true;
                }
            }
            for(int k = 0; k < password.length(); k++) {
                if(Character.isLowerCase(password.charAt(k))) {
                    cap3 = true;
                }
            }
            for(int h = 0; h < password.length(); h++) {
                char c = password.charAt(h);
                if(c >= 33 && c <= 47 || c >= 58 && c <= 64 || c >= 91 && c <= 96 || c >= 123 && c <= 126) {
                    cap4 = true;
                }
            }
        }
        return cap1 && cap2 && cap3 && cap4;
    }
}