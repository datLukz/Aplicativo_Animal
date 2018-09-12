package com.lucas.appanimal_m171.model;

/**
 * Created by assparremberger on 27/08/2018.
 */

public class Categoria {

    private int id;
    private String animal;

    public Categoria(){

    }

    public Categoria(String animal) {this.animal = animal;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimal() {
        return animal;
    }

    public void setNome(String nome) {
        this.animal = nome;
    }


    @Override
    public String toString() {
        return animal;
    }
}
