package com.khanhlinhit.mychecklist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editName, editPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText)findViewById(R.id.editUsername);
        editPassword = (EditText)findViewById(R.id.editPassword);
    }

    public void logIn(View view){
        if (editName.getText().toString() == "admin" &&
                editPassword.getText().toString() == "Linh") {

            Toast.makeText(getApplicationContext(), "Reading List... ",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, CheckListActivity.class);
//            EditText editText = (EditText) findViewById(R.id.edit_message);
//            String message = editText.getText().toString();
//            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);

        }else{
            Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
        }


    }
}
