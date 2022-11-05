package com.example.myev;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PasswordCheckActivity extends AppCompatActivity {
    EditText password;
    Button checkButton;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwordcheck);

        password=(EditText) findViewById(R.id.password);
        checkButton=(Button) findViewById(R.id.checkButton);
        result=(TextView) findViewById(R.id.result);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String input=password.getText().toString();
                printStrongNess(input);
            }
        });


    }
    public void printStrongNess(String input)
    {    result=(TextView) findViewById(R.id.result);
        // Checking lower alphabet in string
        int n = input.length();
        boolean hasLower = false, hasUpper = false,
                hasDigit = false, specialChar = false;
        Set<Character> set = new HashSet<Character>(
                Arrays.asList('!', '@', '#', '$', '%', '^', '&',
                        '*', '(', ')', '-', '+'));
        for (char i : input.toCharArray())
        {
            if (Character.isLowerCase(i))
                hasLower = true;
            if (Character.isUpperCase(i))
                hasUpper = true;
            if (Character.isDigit(i))
                hasDigit = true;
            if (set.contains(i))
                specialChar = true;
        }

        // Strength of password
       // System.out.print("Strength of password:- ");
        if (hasDigit && hasLower && hasUpper && specialChar
                && (n >= 8)){
           // System.out.print(" Strong");

        result.setText("your password is strong enough");}
        else if ((hasLower || hasUpper || specialChar)
                && (n >= 6))
           // System.out.print(" Moderate");
        result.setText(" your password is Moderate");
        else
           // System.out.print(" Weak");
        result.setText("your password is weak");
    }

}