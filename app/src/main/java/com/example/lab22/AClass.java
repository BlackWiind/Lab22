package com.example.lab22;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class AClass extends AppCompatActivity {

    public static final String ANSWER = "answer";

    RadioButton buttonB;
    RadioButton buttonC;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aclass);

        buttonB = (RadioButton) findViewById(R.id.radioB);
        buttonC = (RadioButton) findViewById(R.id.radioC);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.buttonChoice);
        button.setOnClickListener(onClickListener);


    }

    ActivityResultLauncher<Intent> startActivityForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>()
             {
                 @Override
                 public void onActivityResult(ActivityResult result) {
                     if(result.getResultCode() == Activity.RESULT_OK){
                         Intent intent = result.getData();
                         String message = intent.getStringExtra(ANSWER);
                         textView.setText(message);
                     }
                     else {
                         textView.setText("Какая-то ошибка!");
                     }
                 }
             });


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (buttonB.isChecked()){
                Intent intent = new Intent(view.getContext(),BClass.class);
                startActivityForResult.launch(intent);
            }
            if (buttonC.isChecked()){
                Intent intent = new Intent(view.getContext(),CClass.class);
                startActivityForResult.launch(intent);
            }


        }
    };
}