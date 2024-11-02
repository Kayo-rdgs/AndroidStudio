package com.example.atividade;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText pesoTxt;
    private EditText distanciaTxt;
    private Button calcula;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        pesoTxt = findViewById(R.id.pesoId);
        distanciaTxt = findViewById(R.id.distanciaId);
        calcula = findViewById(R.id.buttonCalc);
        resultado = findViewById(R.id.resultadoId);

        calcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pesoString = pesoTxt.getText().toString();
                String distanciaString = distanciaTxt.getText().toString();

                if (pesoString.isEmpty() || distanciaString.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor, insira valores válidos", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    double peso = Double.parseDouble(pesoString);
                    double distancia = Double.parseDouble(distanciaString);
                    calculaFrete(peso, distancia);
                } catch (NumberFormatException e) {
                    // Exibe o erro caso o valor inserido seja inválido (não-numérico)
                    Toast.makeText(MainActivity.this, "Por favor, insira valores válidos", Toast.LENGTH_SHORT).show();
                }

                double peso = Double.parseDouble(pesoString);
                double distancia = Double.parseDouble(distanciaString);

                calculaFrete(peso, distancia);
            }
        });
    }

    private void calculaFrete(double peso, double distancia) {
        double valorKm = 0;
        double valorCobradoPeloPeso = 0;

        if (peso > 0 && peso <= 25) {
            valorCobradoPeloPeso = 2;
            valorKm = 1;
        } else if (peso > 25 && peso <= 50) {
            valorCobradoPeloPeso = 2.25;
            valorKm = 1.25;
        } else if (peso > 50 && peso <= 75) {
            valorCobradoPeloPeso = 2.5;
            valorKm = 1.5;
        } else if (peso > 75) {
            valorCobradoPeloPeso = 3;
            valorKm = 2;
        }

        double resultadoFrete = (distancia * valorKm) + (peso * valorCobradoPeloPeso);
        resultado.setText("O total do frete é: R$" + resultadoFrete);
    }
}
