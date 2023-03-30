package devandroid.joabe.appcadastro.controller;

import android.content.ContentValues;
import android.util.Log;
import android.widget.EditText;

import androidx.annotation.NonNull;

import devandroid.joabe.appcadastro.database.AppCadastroDb;
import devandroid.joabe.appcadastro.model.Cadastro;
import devandroid.joabe.appcadastro.view.CadastrarClienteActivity;
import devandroid.joabe.appcadastro.view.RedirectActivity;

public class CadastroController extends AppCadastroDb {

    public CadastroController(CadastrarClienteActivity activity) {
        super(activity);

    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_CONTROLLER", "Controller iniciada!");

        return super.toString();
    }

    public void Save(Cadastro cadastro) {
        Log.d("MVC_CONTROLLER", "Salvo!");

        ContentValues data = new ContentValues();

        data.put("NOME", cadastro.getNome());
        data.put("ENDERECO", cadastro.getEndereco());
        data.put("SEXO", cadastro.getSexo());
        data.put("EMAIL", cadastro.getEmail());
        data.put("TELEFONE", cadastro.getTelefone());
        data.put("CATEGORIA", String.valueOf(cadastro.getCategoria()));
        saveObject("CADASTRO", data);
    }

    public void alterData(Cadastro cadastro) {
        ContentValues data = new ContentValues();

        data.put("NOME", cadastro.getNome());
        data.put("ENDERECO", cadastro.getEndereco());
        data.put("SEXO", cadastro.getSexo());
        data.put("EMAIL", cadastro.getEmail());
        data.put("TELEFONE", cadastro.getTelefone());
        data.put("CATEGORIA", String.valueOf(cadastro.getCategoria()));
        saveObject("CADASTRO", data);

        AlterData("CADASTRO", data);
    }

    public void delete(int id) {
        DeleteData("CADASTRO", id);
    }

    public void limparDados(EditText edit_nome, EditText edit_endereco, EditText edit_email,
                             EditText edit_telefone, EditText edit_sexo){
        edit_nome.setText("");
        edit_endereco.setText("");
        edit_email.setText("");
        edit_telefone.setText("");
        edit_sexo.setText("");
    }
}
