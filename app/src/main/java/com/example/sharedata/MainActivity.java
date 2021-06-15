package com.example.sharedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnShareData;
    TextInputLayout tilData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShareData = findViewById(R.id.btnShareData);
        tilData = findViewById(R.id.tilData);

        btnShareData.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                String data = tilData.getEditText().getText().toString();

                if (!TextUtils.isEmpty(data)) {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, data);
                    sendIntent.setType("text/plain");

                    Intent shareIntent = Intent.createChooser(sendIntent, "Send To: ");
                    startActivity(shareIntent);
                } else {
                    Toast.makeText(MainActivity.this, "Field is empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}