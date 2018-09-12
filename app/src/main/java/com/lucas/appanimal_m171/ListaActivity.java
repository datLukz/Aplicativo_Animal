package com.lucas.appanimal_m171;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toolbar;

import com.lucas.appanimal_m171.dao.AnimalDAO;
import com.lucas.appanimal_m171.dao.CategoriaDAO;
import com.lucas.appanimal_m171.model.Animal;
import com.lucas.appanimal_m171.model.Categoria;

import java.util.List;

public class ListaActivity extends AppCompatActivity {

    private ListView lvAnimais;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);;

        lvAnimais = (ListView) findViewById(R.id.lvLista);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ListaActivity.this,
                        FormularioActivity.class);
                startActivity( i );

            }
        });

        carregarAnimais();
    }

    private void carregarAnimais(){
        List<Animal> lista = AnimalDAO.getAnimais(this);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista);
        lvAnimais.setAdapter(adapter);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        carregarAnimais();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_animal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}


