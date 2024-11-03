package com.example.listadecompras;

public class Item {
    private String name;
    private boolean checked;

    public Item(String name, boolean checked) {
        this.name = name;
        this.checked = checked;
    }

    public String getNome() {
        return name;
    }

    public boolean isComprado() {
        return checked;
    }

    public void setComprado(boolean checked) {
        this.checked = checked;
    }
}
