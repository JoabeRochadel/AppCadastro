package devandroid.joabe.appcadastro.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import devandroid.joabe.appcadastro.model.Customer;

public class AppCadastroDb extends SQLiteOpenHelper {

    private static final String DB_NAME = "listavip.db";
    private static final int DB_VERSION = 1;
    Cursor cursor;
    SQLiteDatabase db;

    public AppCadastroDb(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SqlTableCadastro = "CREATE TABLE CUSTOMER " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "                           NAME TEXT, " +
                "                           NAME_COMPANY TEXT, " +
                "                           GENDER TEXT)";

        db.execSQL(SqlTableCadastro);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void saveObject(String table, ContentValues data) {
        db.insert(table, null, data);
    }

    public List<Customer> ListData() {
        List<Customer> listCustomer = new ArrayList<Customer>();
        Customer reg;

        String sSql = "SELECT * FROM LISTAVIP";

        cursor = db.rawQuery(sSql, null);

        if (cursor.moveToFirst()) {

            do {
                reg = new Customer();
                reg.setName(cursor.getString(0));
                reg.setNameCompany(cursor.getString(1));
                reg.setGender(cursor.getString(2));
                listCustomer.add(reg);
            }
            while (cursor.moveToNext());
        } else {
            throw new RuntimeException("Ocorreu um erro -> Não há registros na tabela Customer");
        }
        return listCustomer;
    }

    public void AlterData(String table, ContentValues data) {
        int id = data.getAsInteger("id");

        db.update(table, data, "id=?", new String[]{Integer.toString(id)});
    }

    public void DeleteData(String table, int id) {
        db.delete(table, "id=?", new String[]{Integer.toString(id)});
    }
}
