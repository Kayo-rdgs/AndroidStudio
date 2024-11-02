package com.example.simulado;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView senhaTxt;
    private Button runButton;
    private String letrasMinusculas = "abcdefghijklmnopqrstuvwxyz";
    private String numeros = "0123456789";
    private String simbolos = "!@#$%&";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        runButton = findViewById(R.id.runButton);
        senhaTxt = findViewById(R.id.senhaId);

        // Configurando o listener para o botão
        runButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senhaTxt.setText(gerarSenha());
            }
        });

    }

    private String gerarSenha() {
        StringBuilder senhaBuilder = new StringBuilder();


        for (int i = 0; i < 3; i++) {
            char letra = letrasMinusculas.charAt(new Random().nextInt(letrasMinusculas.length()));
            char numero = numeros.charAt(new Random().nextInt(numeros.length()));
            char simbolo = simbolos.charAt(new Random().nextInt(simbolos.length()));


            senhaBuilder.append(letra);
            senhaBuilder.append(numero);
            senhaBuilder.append(simbolo);
        }
        return senhaBuilder.toString();
    }
}
