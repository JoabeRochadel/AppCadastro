package devandroid.joabe.appcadastro.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import devandroid.joabe.appcadastro.model.Cadastro;

public class AppCadastroDb extends SQLiteOpenHelper {

    private static final String DB_NAME = "cadastro.db";
    private static final int DB_VERSION = 1;
    Cursor cursor;
    SQLiteDatabase db;

    public AppCadastroDb(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SqlTableCadastro = "CREATE TABLE CADASTRO " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "                           NOME TEXT, " +
                "                           ENDERECO TEXT, " +
                "                           SEXO TEXT, " +
                "                           EMAIL TEXT, " +
                "                           TELEFONE TEXT, " +
                "                           CATEGORIA TEXT)";

        db.execSQL(SqlTableCadastro);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void saveObject(String table, ContentValues data) {
        db.insert(table, null, data);
    }

    public List<Cadastro> ListData() {
        List<Cadastro> listCadastro = new ArrayList<Cadastro>();
        Cadastro reg;

        String sSql = "SELECT * FROM CADASTRO";

        cursor = db.rawQuery(sSql, null);

        if (cursor.moveToFirst()) {

            do {
                reg = new Cadastro();
                reg.setNome(cursor.getString(0));
                reg.setEndereco(cursor.getString(1));
                reg.setSexo(cursor.getString(2));
                reg.setEmail(cursor.getString(3));
                reg.setTelefone(cursor.getString(4));
                reg.setCategoria(cursor.getString(5));
                listCadastro.add(reg);
            }
            while (cursor.moveToNext());
        } else {
            throw new RuntimeException("Ocorreu um erro -> Não há registros na tabela CADASTRO");
        }
        return listCadastro;
    }

    public void AlterData(String table, ContentValues data) {
        int id = data.getAsInteger("id");

        db.update(table, data, "id=?", new String[]{Integer.toString(id)});
    }

    public void DeleteData(String table, int id) {
        db.delete(table, "id=?", new String[]{Integer.toString(id)});
    }
}
