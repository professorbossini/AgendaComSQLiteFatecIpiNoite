package br.usjt.deswebmob.calculadoramvp.agendacomsqlitefatecipinoite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by rodrigo on 04/05/18.
 */

public class ContatoDAO {

    private Context context;
    public ContatoDAO (Context context){
        this.context = context;
    }
    public long inserir (Contato contato){
        ContentValues cv = new ContentValues();
        cv.put("nome", contato.getNome());
        cv.put("fone", contato.getFone());
        cv.put("email", contato.getEmail());
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long id = db.insert("contato", null ,cv);
        db.close();
        dbHelper.close();
        return id;
    }

    public List<Contato> listar (){
        List <Contato> contatos = new LinkedList<>();
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query ("contato", null, null, null, null, null, null);
        while (cursor.moveToNext()){
            long id = cursor.getLong(cursor.getColumnIndexOrThrow("id"));
            String nome = cursor.getString(cursor.getColumnIndexOrThrow("nome"));
            String fone = cursor.getString(cursor.getColumnIndexOrThrow("fone"));
            String email = cursor.getString(cursor.getColumnIndexOrThrow("email"));
            Contato contato = new Contato (id, nome, fone, email);
            contatos.add(contato);
        }
        db.close();
        dbHelper.close();
        return contatos;
    }
}
