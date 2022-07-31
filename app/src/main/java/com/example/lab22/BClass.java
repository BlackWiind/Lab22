package com.example.lab22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BClass extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bclass);
        editText = findViewById(R.id.editB);
    }

    public void onButtonClick(View v){
        String message = "Это сообщение из класса B:\n" + editText.getText().toString();
        sendMessage(message);
    }

    private void sendMessage(String message){
        Intent data = new Intent();
        data.putExtra(AClass.ANSWER, message);
        setResult(RESULT_OK, data);
        finish();
    }
}