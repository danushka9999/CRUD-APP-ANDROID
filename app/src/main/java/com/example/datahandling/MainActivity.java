package com.example.datahandling;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.datahandling.database.DBHelper;
import com.example.datahandling.database.UsersMaster;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

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
        String password = editTextTextPassword.getText().toString();
        DBHelper dbHelper = new DBHelper(this);

        if(name.isEmpty() || password.isEmpty()){
            Toast.makeText(this,"Enter values please",Toast.LENGTH_SHORT).show();
        }
        else{
            long inserted = dbHelper.addInfo(name,password);
            editTextTextPersonName.setText("");
            editTextTextPassword.setText("");
            if(inserted>0){
                Toast.makeText(this,"Data Inserted",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this,"Something went wrong",Toast.LENGTH_SHORT).show();
            }

        }
    }
    public void viewAll(View view){
        DBHelper dbHelper = new DBHelper(this);

        List info = dbHelper.readAllInfo();
        List items = new ArrayList<Integer>();

        String[] data = (String[]) info.toArray(new String[0]);

        //Toast.makeText(this, info.toString(), Toast.LENGTH_SHORT).show();

//        Snackbar snackbar = Snackbar.make(view, info.toString(),Snackbar.LENGTH_LONG);
//        snackbar.setAnimationMode(Snackbar.ANIMATION_MODE_SLIDE);
//        snackbar.show();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Users");
        builder.setItems(data, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String userName = data[i].split(":")[0];
                editTextTextPersonName.setText(userName);
                editTextTextPassword.setText("*************************");

            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public void deleteUser(View view){
        DBHelper dbHelper = new DBHelper(this);

        String userName = editTextTextPersonName.getText().toString();

        if(userName.isEmpty()){
            Toast.makeText(this, "Please select user to Delete", Toast.LENGTH_SHORT).show();
        }else{
            dbHelper.deleteInfo(userName);
            Toast.makeText(this, "User deleted!", Toast.LENGTH_SHORT).show();

            editTextTextPersonName.setText("");
            editTextTextPassword.setText("");
        }

    }

    public void updateUser(View view){
        DBHelper dbHelper = new DBHelper(this);
        String userName = editTextTextPersonName.getText().toString();
        String password = editTextTextPassword.getText().toString();

        if(userName.isEmpty()||password.isEmpty()){

        }else{
            dbHelper.updateInfo(view,userName,password);
        }

    }




}