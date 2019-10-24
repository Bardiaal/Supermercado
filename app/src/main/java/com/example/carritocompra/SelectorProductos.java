package com.example.carritocompra;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SelectorProductos extends AppCompatActivity {

    Spinner spinner;
    TextView textView;
    String categoria;

    String[] carne;
    String[] lacteo;
    String[] verdura;

    String[] paso2;

    String producto = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector_productos);

        Intent intent = getIntent();
        categoria = intent.getStringExtra("cat");

        carne = getResources().getStringArray(R.array.carne);
        lacteo = getResources().getStringArray(R.array.lacteos);
        verdura = getResources().getStringArray(R.array.verduras);

        spinner = findViewById(R.id.spinner);
        textView = findViewById(R.id.textView6);

        ArrayAdapter adapter = null;

        if (categoria.equals(getResources().getString(R.string.rb1value))) {
            adapter = new ArrayAdapter (getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, carne);
        } else if (categoria.equals(getResources().getString(R.string.rb2value))) {
            adapter = new ArrayAdapter (getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, lacteo);
        } else if (categoria.equals(getResources().getString(R.string.rb3value))) {
            adapter = new ArrayAdapter (getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, verdura);
        }

        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                producto = spinner.getSelectedItem().toString();
                textView.setText(getResources().getString(R.string.tv5) + " " + producto);
                String[] paso1 = producto.split("€");
                paso2 = paso1[0].split("\\(");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.precioTotal += Integer.parseInt(paso2[1]);
                MainActivity.listaFinal += "- " + producto + "\n";
                Log.v("precioTotal", String.valueOf(MainActivity.precioTotal));
                Log.v("listaFinal", MainActivity.listaFinal);
                Intent intent = new Intent(SelectorProductos.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

}
