package com.josepfayos.examen;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Fragments extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);
        Intent secondIntent = getIntent();
        int id = this.getResources().getIdentifier("titulo", "id", this.getPackageName());
        TextView titulo = findViewById(id);
        int id1 = this.getResources().getIdentifier("text1", "id", this.getPackageName());
        TextView text1 = findViewById(id1);
        titulo.setText(secondIntent.getStringExtra("textPrincipal"));
        text1.setText(secondIntent.getStringExtra("text1"));
    }
}