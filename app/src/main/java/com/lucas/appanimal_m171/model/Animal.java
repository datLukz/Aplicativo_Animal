package com.lucas.appanimal_m171.model;

import com.lucas.appanimal_m171.model.Categoria;

/**
 * Created by assparremberger on 28/08/2018.
 */

public class Animal {

    private int id;
    private String animal;
    private double idade;
    private Categoria categoria;

    public Animal() {

    }

    public Animal(int id, String nome, double idade, Categoria categoria) {
        this.id = id;
        this.animal = animal;
        this.idade = idade;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String nome) {
        this.animal = nome;
    }

    public double getIdade() {
        return idade;
    }

    public void setIdade(double idade) {this.idade = idade;}

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }


    @Override
    public String toString() {
        return animal;
    }
}





