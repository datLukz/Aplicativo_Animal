package com.lucas.appanimal_m171;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.lucas.appanimal_m171.dao.AnimalDAO;
import com.lucas.appanimal_m171.dao.CategoriaDAO;
import com.lucas.appanimal_m171.model.Animal;
import com.lucas.appanimal_m171.model.Categoria;

import java.util.List;

/**
 * Created by android on 06/09/2018.
 */

public class FormularioActivity extends AppCompatActivity {

    private EditText etNome, etIdade;
    private Button btnSalvar;
    private Spinner spCategoria;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

        etNome = (EditText) findViewById(R.id.etNomeAnimal);
        etIdade = (EditText) findViewById(R.id.etIdade);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        spCategoria = (Spinner) findViewById(R.id.spCategoria);

        carregarCategorias();

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });

    }

    private void salvar(){
        String nome = etNome.getText().toString();

        if (nome.isEmpty() ||spCategoria.getSelectedItemPosition() == 0){
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle(getResources().getString(R.string.txtAtencao));
            alerta.setMessage(R.string.txtCamposObrigatorios);
            alerta.setIcon(android.R.drawable.ic_dialog_alert);
            alerta.setNeutralButton("OK", null);
            alerta.show();
        }else {
            String idade = etIdade.getText().toString();
            if (idade.isEmpty())
                idade = "0";
            idade = idade.replace(",",".");
            double ida = Double.valueOf(idade);

            Animal ani = new Animal();
            ani.setAnimal(nome);
            ani.setIdade(ida);
            ani.setCategoria((Categoria) spCategoria.getSelectedItem());

            AnimalDAO.inserir(this, ani);

            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_animal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if ( item.getItemId() == R.id.menu_nova_categoria ){
            cadastrarCategoria();
        }

        return super.onOptionsItemSelected(item);
    }

    private void cadastrarCategoria(){
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setTitle( getResources().getString(R.string.txtNovaCategoria) );
        alerta.setIcon( android.R.drawable.ic_menu_edit );

        final EditText etNomeCategoria = new EditText(this);
        etNomeCategoria.setHint( R.string.hintCategoria );
        etNomeCategoria.setTextColor(Color.GRAY);

        alerta.setView( etNomeCategoria );

        alerta.setNeutralButton(
                getResources().getString(R.string.txtCancelar) ,
                null );
        alerta.setPositiveButton(
                getResources().getString(R.string.txtSalvar),
                new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String nome = etNomeCategoria.getText().toString();
                        if ( ! nome.isEmpty() ){
                            Categoria cat = new Categoria();
                            cat.setNome( nome );
                            CategoriaDAO.inserir(FormularioActivity.this, cat);
                            carregarCategorias();
                        }
                    }
                });
        alerta.show();

    }

    private void carregarCategorias(){

        List<Categoria> lista = CategoriaDAO.getCategorias(this);
        Categoria fake = new Categoria();
        fake.setId( 0 );
        fake.setNome( getResources().getString(R.string.txtSelecione) );
        lista.add(0, fake);

        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, lista);
        spCategoria.setAdapter(adapter);

    }


}


