package br.usjt.deswebmob.calculadoramvp.agendacomsqlitefatecipinoite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ContatoDAO dao;
    private ListView contatosListView;
    private List <Contato> contatos;
    private ArrayAdapter<Contato> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contatosListView = (ListView) findViewById(R.id.contatosListView);
        contatos = new LinkedList <Contato> ();
        adapter = new ContatoAdapter(this, contatos);
        contatosListView.setAdapter(adapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(v -> {
            Intent intent = new Intent (this, AdicionaContatoActivity.class);
            startActivity(intent);
        });
        dao = new ContatoDAO(this);
    }

    class ContatoAdapter extends ArrayAdapter <Contato>{
        private List <Contato> contatos;
        ContatoAdapter (Context context, List <Contato> contatos){
            super (context, android.R.layout.simple_list_item_1, contatos);
            this.contatos = contatos;
        }
        @Override
        public int getCount() {
            return contatos.size();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        contatos.clear();
        List <Contato> contatos = dao.listar();
        this.contatos.addAll(contatos);
        adapter.notifyDataSetChanged();
    }
}
