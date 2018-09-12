package com.lucas.appanimal_m171.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lucas.appanimal_m171.model.Categoria;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 06/09/2018.
 */

public class CategoriaDAO {

        public static void inserir(Context contexto, Categoria categoria){
            conexao conn = new conexao(contexto);
            SQLiteDatabase banco = conn.getWritableDatabase();

            banco.execSQL("INSERT INTO categorias (nome) VALUES " +
                    " ( '" + categoria.getAnimal() + "' )  ");

        }

        public static List<Categoria> getCategorias(Context contexto){
            List<Categoria> listaDeCategorias = new ArrayList<>();
            conexao conn = new conexao(contexto);
            SQLiteDatabase banco = conn.getReadableDatabase();

            Cursor tabela = banco.rawQuery
                    ("SELECT * FROM categorias", null);
            if ( tabela.getCount() > 0){

                tabela.moveToFirst();

                do {
                    Categoria cat = new Categoria();
                    cat.setId( tabela.getInt(0) );
                    cat.setNome( tabela.getString(1) );

                    listaDeCategorias.add(cat);

                }while (tabela.moveToNext());
            }

            return listaDeCategorias;
        }




    }


