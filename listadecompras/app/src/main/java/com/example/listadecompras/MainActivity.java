package com.example.listadecompras;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView listaView;
    List<Item> listaItens = new ArrayList<>();
    Button buttonReset;
    Button buttonAdd;
    EditText nomeItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonReset = findViewById(R.id.buttonResetId);
        buttonAdd = findViewById(R.id.buttonAddId);
        listaView = findViewById(R.id.listaId);
        nomeItem = findViewById(R.id.nomeItemId);

        // Criação da lista de itens inicial
        listaItens.add(new Item("Maçã", false));
        listaItens.add(new Item("Banana", false));
        listaItens.add(new Item("Leite", true));

        // Configuração do RecyclerView
        listaView.setLayoutManager(new LinearLayoutManager(this));
        final ListaComprasAdapter adapter = new ListaComprasAdapter(listaItens);
        listaView.setAdapter(adapter);

        // Adicionando novo item à lista
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemName = nomeItem.getText().toString().trim();
                if (!itemName.isEmpty()) {  // Verifica se o campo não está vazio
                    listaItens.add(new Item(itemName, false));
                    adapter.notifyDataSetChanged(); // Notifica o adapter sobre a mudança
                    nomeItem.setText(""); // Limpa o EditText
                }
            }
        });

        // Resetando a lista
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listaItens.clear(); // Limpa a lista de itens
                adapter.notifyDataSetChanged(); // Notifica o adapter sobre a mudança
            }
        });
    }
}
