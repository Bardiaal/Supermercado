package com.example.carritocompra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalizarCompra extends AppCompatActivity {

    TextView textView1, textView2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalizar_compra);

        textView1 = findViewById(R.id.textView8);
        textView2 = findViewById(R.id.textView9);

        textView1.setText(getResources().getString(R.string.tvFinal) + "\n" + MainActivity.listaFinal);
        textView2.setText(getResources().getString(R.string.total) + " " + String.valueOf(MainActivity.precioTotal) + getResources().getString(R.string.euro));

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.precioTotal = 0;
                MainActivity.listaFinal = "";
                Intent intent = new Intent(FinalizarCompra.this, FinalSplash.class);
                startActivity(intent);
            }
        });
    }
}
