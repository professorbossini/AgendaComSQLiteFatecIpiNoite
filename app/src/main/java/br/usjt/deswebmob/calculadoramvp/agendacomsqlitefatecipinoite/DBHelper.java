package br.usjt.deswebmob.calculadoramvp.agendacomsqlitefatecipinoite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rodrigo on 04/05/18.
 */

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper (Context context){
        super (context, "contatos.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql =
                "CREATE TABLE contato (id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR(200), fone VARCHAR(200), email VARCHAR(200));";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
