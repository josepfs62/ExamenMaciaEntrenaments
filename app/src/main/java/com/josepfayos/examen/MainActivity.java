package com.josepfayos.examen;

import static com.josepfayos.examen.Entrenament.entrenaments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static TextView[] textViewArray = new TextView[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int orientation = this.getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            for (int i = 0; i < entrenaments.length; i++) {
                int id = this.getResources().getIdentifier("textView" + i, "id", this.getPackageName());
                TextView textView = findViewById(id);
                textViewArray[i] = textView;
                textView.setText(entrenaments[i].getNom());
                View v1 = textViewArray[i];
                int finalI = i;
                v1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        Intent intent = new Intent(MainActivity.this, Fragments.class);
                        intent.putExtra("textPrincipal", entrenaments[finalI].getNom().toString());
                        intent.putExtra("text1", entrenaments[finalI].getDescripcio().toString());
                        startActivity(intent);
                        return false;
                    }
                });
            }
        } else {
            int id1 = this.getResources().getIdentifier("titulo", "id", this.getPackageName());
            TextView titulo = findViewById(id1);
            int id2 = this.getResources().getIdentifier("text1", "id", this.getPackageName());
            TextView text1 = findViewById(id2);
            for (int i = 0; i < entrenaments.length; i++) {
                int id = this.getResources().getIdentifier("textView" + i, "id", this.getPackageName());
                TextView textView = findViewById(id);
                textViewArray[i] = textView;
                textView.setText(entrenaments[i].getNom());
                View v1 = textViewArray[i];
                int finalI = i;
                v1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent){
                        titulo.setText(entrenaments[finalI].getNom());
                        text1.setText(entrenaments[finalI].getDescripcio());
                        return false;
                    }
                });
            }
        }
    }
}