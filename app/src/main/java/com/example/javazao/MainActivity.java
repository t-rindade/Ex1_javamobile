package com.example.javazao;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.javazao.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    private TextView txt_resultado;
    private TextView txt_classificacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        txt_resultado = findViewById(R.id.txt_resultado);
        txt_classificacao = findViewById(R.id.txt_classificacao);


        Button botaoCalculo = findViewById(R.id.btn_calculo);
        botaoCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { calculo();

            }

            private void calculo() {
                EditText altura = findViewById(R.id.input_altura);
                EditText peso = findViewById(R.id.input_peso);

                String classificacao;


                double valorAltura = Double.parseDouble(altura.getText().toString());
                double valorPeso = Double.parseDouble(peso.getText().toString());

                double valorImc = valorPeso / (valorAltura * valorAltura);

                if (valorImc < 18.5) {
                    classificacao = "Filezinho";


                } else if (valorImc < 25) {
                    classificacao = "Diliça";


                } else if (valorImc < 30) {
                    classificacao = "Ta top";


                } else {
                    classificacao = "Oh la em casa";

                }

                txt_classificacao.setText(classificacao);
                txt_classificacao.setVisibility(View.VISIBLE);

                txt_resultado.setText(String.valueOf(valorImc));
                txt_resultado.setVisibility(View.VISIBLE);




            }
        });

    }
}