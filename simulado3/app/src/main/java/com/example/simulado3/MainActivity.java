package com.example.simulado3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText entrada;
    Button botaoConverter;
    TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        entrada = findViewById(R.id.entradaBinario);
        botaoConverter = findViewById(R.id.buttonConverter);
        resultado = findViewById(R.id.resultado);

        botaoConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numBin = entrada.getText().toString();
                // Validação da entrada
                if (validarBinario(numBin)) {
                    int decimal = gerarDecimal(numBin);  // Aqui você obtém o valor decimal
                    resultado.setText(String.valueOf(decimal));  // Converte para String e passa para o setText
                } else {
                    Toast.makeText(MainActivity.this, "Entrada inválida! Digite apenas 0s e 1s.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Método para validar a entrada binária
    private boolean validarBinario(String numBin) {
        for (int i = 0; i < numBin.length(); i++) {
            char bit = numBin.charAt(i);
            // Se o caractere não for '0' nem '1', a entrada é inválida
            if (bit != '0' && bit != '1') {
                return false;
            }
        }
        return true;
    }

    private int gerarDecimal(String numBin) {
        int decimal = 0;
        int length = numBin.length();

        // Perceba que você agora começa do índice 0 (à direita) até o final da string
        for (int i = 0; i < length; i++) {
            // Obtemos o bit, da direita para a esquerda
            char bit = numBin.charAt(length - i - 1);

            // Se for '1', adicione o valor da potência de 2 correspondente
            decimal += (int) ((bit - '0') * Math.pow(2, i));
        }

        return decimal;
    }
}
