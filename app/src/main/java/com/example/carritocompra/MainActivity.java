package com.example.carritocompra;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioButton rb1, rb2, rb3;
    Button button;
    TextView textView;
    static int precioTotal = 0;
    static String listaFinal = "";
    String categoria = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rb1 = findViewById(R.id.radioButton3);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton);
        button = findViewById(R.id.material_button);
        textView = findViewById(R.id.textView4);
        textView.setText(getResources().getString(R.string.total) + " " + String.valueOf(precioTotal) + getResources().getString(R.string.euro));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, FinalizarCompra.class);
                startActivity(intent1);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("CATEGORÍA", categoria);
                if (!categoria.equals("")) {
                    Intent intent = new Intent(MainActivity.this, SelectorProductos.class);
                    intent.putExtra("cat", categoria);
                    startActivity(intent);
                } else {
                    Snackbar.make(view, getResources().getString(R.string.snackbar), Snackbar.LENGTH_LONG).show();
                }
            }
        });

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoria = getResources().getString(R.string.rb1value);
            }
        });

        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoria = getResources().getString(R.string.rb2value);
            }
        });

        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoria = getResources().getString(R.string.rb3value);
            }
        });

    }
}
