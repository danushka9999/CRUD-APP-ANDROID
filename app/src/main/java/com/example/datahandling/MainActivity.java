package com.example.datahandling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.datahandling.database.DBHelper;

public class MainActivity extends AppCompatActivity {


    EditText editTextTextPersonName;
    EditText editTextTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);

    }

    public void saveUser(View view){
        String name = editTextTextPersonName.getText().toString();
        String password = editTextTextPersonName.getText().toString();
        DBHelper dbHelper = new DBHelper(this);

        if(name.isEmpty() || password.isEmpty()){
            Toast.makeText(this,"Enter values please",Toast.LENGTH_SHORT).show();
        }
        else{
            dbHelper.addInfo(name,password);
            Toast.makeText(this,"Data Inserted",Toast.LENGTH_SHORT).show();
        }
    }

}