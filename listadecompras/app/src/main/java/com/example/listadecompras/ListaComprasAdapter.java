package com.example.listadecompras;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


public class ListaComprasAdapter extends RecyclerView.Adapter<ListaComprasAdapter.ViewHolder> {

    private List<Item> listaItens;

    public ListaComprasAdapter(List<Item> listaItens) {
        this.listaItens = listaItens;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBoxItem;
        TextView textViewItemName;

        public ViewHolder(View itemView) {
            super(itemView);
            checkBoxItem = itemView.findViewById(R.id.checkBoxItem);
            textViewItemName = itemView.findViewById(R.id.textViewItemName);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = listaItens.get(position);
        holder.textViewItemName.setText(item.getNome());
        holder.checkBoxItem.setChecked(item.isComprado());

        if (item.isComprado()) {
            holder.textViewItemName.setPaintFlags(holder.textViewItemName.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            holder.textViewItemName.setPaintFlags(holder.textViewItemName.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
        }

        holder.checkBoxItem.setOnCheckedChangeListener((buttonView, isChecked) -> {
            item.setComprado(isChecked);
            // Aqui, você pode adicionar lógica extra, como atualizar a lista no banco de dados
            if (isChecked) {
                holder.textViewItemName.setPaintFlags(holder.textViewItemName.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            } else {
                holder.textViewItemName.setPaintFlags(holder.textViewItemName.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaItens.size();
    }
}
