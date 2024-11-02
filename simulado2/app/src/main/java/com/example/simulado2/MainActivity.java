package com.example.simulado2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText senhaTxt;
    private Button runButton;
    TextView positivo;
    TextView negativo;
    private String letrasMaiusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String letrasMinusculas = "abcdefghijklmnopqrstuvwxyz";
    private String numeros = "1234567890";
    private String simbolos = "!@#$%&";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        senhaTxt = findViewById(R.id.senhaId);
        runButton = findViewById(R.id.runButton);
        positivo = findViewById(R.id.resultadoPositivoId);
        negativo = findViewById(R.id.resultadoNegativoId);

        runButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String senha = senhaTxt.getText().toString(); // Pegando o texto inserido no EditText
                verificarSenha(senha);
            }
        });
    }

    private void verificarSenha(String senha) {
        // Verificar se a senha tem pelo menos 8 caracteres
        if (senha.length() < 8) {
            positivo.setVisibility(View.INVISIBLE);
            negativo.setVisibility(View.VISIBLE);
            negativo.setText("A senha deve conter 8 caracteres ou mais.");
            return;
        }

        // Variáveis de controle para os tipos de caracteres
        int contMaiusculas = 0;
        int contMinusculas = 0;
        int contNumeros = 0;
        int contSimbolos = 0;

        // Percorrer a senha e verificar os tipos de caracteres
        for (int i = 0; i < senha.length(); i++) {
            char c = senha.charAt(i);

            if (letrasMaiusculas.indexOf(c) != -1) {
                contMaiusculas++;
            } else if (letrasMinusculas.indexOf(c) != -1) {
                contMinusculas++;
            } else if (numeros.indexOf(c) != -1) {
                contNumeros++;
            } else if (simbolos.indexOf(c) != -1) {
                contSimbolos++;
            }
        }

        // Verificar se a senha contém pelo menos 2 letras maiúsculas, 2 letras minúsculas, 2 números e 2 símbolos
        if (contMaiusculas >= 2 && contMinusculas >= 2 && contNumeros >= 2 && contSimbolos >= 2) {
            positivo.setVisibility(View.VISIBLE);
            negativo.setVisibility(View.INVISIBLE);
            positivo.setText("Senha válida e forte!");
        } else {
            positivo.setVisibility(View.INVISIBLE);
            negativo.setVisibility(View.VISIBLE);
            negativo.setText("A senha deve conter pelo menos:\n- 2 letras maiúsculas\n- 2 letras minúsculas\n- 2 números\n- 2 símbolos");
        }
    }
}
