package br.usjt.deswebmob.calculadoramvp.agendacomsqlitefatecipinoite;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.Toast;

public class AdicionaContatoActivity extends AppCompatActivity {

    private EditText nomeEditText;
    private EditText foneEditText;
    private EditText emailEditText;
    private ContatoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adiciona_contato);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nomeEditText = (EditText) findViewById(R.id.nomeEditText);
        foneEditText = (EditText) findViewById(R.id.foneEditText);
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/

        fab.setOnClickListener(view -> {
            String nome = nomeEditText.getEditableText().toString();
            String fone = foneEditText.getEditableText().toString();
            String email = emailEditText.getEditableText().toString();
            Contato contato = new Contato (nome, fone, email);
            dao.inserir(contato);
            Toast.makeText(this, getString(R.string.insercao_ok), Toast.LENGTH_SHORT).show();
            finish();
        });
        dao = new ContatoDAO(this);
    }

}
