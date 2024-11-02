package com.example.binarioparadecimal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText numBinarioTxt;
    Button buttonConverter;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        numBinarioTxt = findViewById(R.id.numBinario);
        buttonConverter = findViewById(R.id.buttonConverter);
        resultado = findViewById(R.id.resultadoId);

        buttonConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numBinarioString = numBinarioTxt.getText().toString().trim();

                // Validação para verificar se a string contém apenas 0 e 1
                if (!numBinarioString.matches("[01]+")) {
                    Toast.makeText(MainActivity.this, "Digite apenas números em zero e um", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Chama o método para converter o número binário em decimal
                int resultadoDecimal = gerarNumDecimal(numBinarioString);
                resultado.setText("Número decimal: " + resultadoDecimal);
            }
        });
    }

    private int gerarNumDecimal(String numBinarioString) {
        int resultadoDecimal = 0;

        // Converte cada caractere de binário para decimal
        for (int i = 0; i < numBinarioString.length(); i++) {
            char texto = numBinarioString.charAt(numBinarioString.length() - 1 - i);
            int numero = Character.getNumericValue(texto);
            resultadoDecimal += numero * Math.pow(2, i);
        }

        return resultadoDecimal;
    }
}
