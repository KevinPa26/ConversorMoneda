package com.example.conversormoneda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int valorDolar = 1;
    private int valorEuro= 2;

    private TextView tvOneDollar;
    private EditText etDolares;
    private EditText etEuros;
    private EditText etAsignacionValor;
    private Button btnConvertir;
    private Button btnCambiarValor;
    private RadioButton rbConvertirDolares;
    private RadioButton rbConvertirEuros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.dolar){
            rbConvertirDolares.setChecked(true);
            rbConvertirEuros.setChecked(false);
            return true;
        }
        return true;
    }

    public void inicializar(){
        tvOneDollar = findViewById(R.id.tvOneDollar);
        etDolares = findViewById(R.id.etDolares);
        etEuros = findViewById(R.id.etEuros);
        etAsignacionValor = findViewById(R.id.etAsignacionValor);
        btnConvertir = findViewById(R.id.btnConvertir);
        btnCambiarValor = findViewById(R.id.btnCambiarValor);
        rbConvertirDolares = findViewById(R.id.rbConvertirDolares);
        rbConvertirEuros = findViewById(R.id.rbConvertirEuros);

        etDolares.setEnabled(false);
        etEuros.setEnabled(false);
        btnCambiarValor.setEnabled(false);
        btnConvertir.setEnabled(false);



        etAsignacionValor.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                btnCambiarValor.setEnabled(true);
                return false;
            }
        });
        btnCambiarValor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valorEuro = Integer.parseInt(etAsignacionValor.getText().toString());
            }
        });

        rbConvertirDolares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etEuros.setEnabled(true);
                btnConvertir.setEnabled(true);
                etDolares.setEnabled(false);
                etDolares.setText("");
            }
        });

        rbConvertirEuros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etDolares.setEnabled(true);
                btnConvertir.setEnabled(true);
                etEuros.setEnabled(false);
                etEuros.setText("");
            }
        });

        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rbConvertirDolares.isChecked()){
                    etDolares.setText("" + Integer.parseInt(etEuros.getText().toString()) * valorDolar);
                }
                if (rbConvertirEuros.isChecked()){
                    etEuros.setText("" + Integer.parseInt(etDolares.getText().toString()) * valorEuro);
                }
            }
        });
    }


}