
package devandroid.joabe.appcadastro.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import devandroid.joabe.appcadastro.R;
import devandroid.joabe.appcadastro.controller.CadastroController;
import devandroid.joabe.appcadastro.model.Cadastro;

public class CadastrarClienteActivity extends AppCompatActivity {

    public static String CATEGORIA = "Cliente";
    List<String> CoursesNames;
    CadastroController cadastroController;
    Cadastro cadastro;

    EditText edit_nome;
    EditText edit_endereco;
    EditText edit_email;
    EditText edit_telefone;
    EditText edit_sexo;
    Button btn_limpar;
    Button btn_salvar;
    Button btn_finalizar;
    Button btn_voltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_cliente);

        cadastroController = new CadastroController(CadastrarClienteActivity.this);

        cadastro = new Cadastro();

        edit_nome = findViewById(R.id.edit_nome);
        edit_endereco = findViewById(R.id.edit_endereco);
        edit_email = findViewById(R.id.edit_email);
        edit_telefone = findViewById(R.id.edit_telefone);
        edit_sexo = findViewById(R.id.edit_sexo);
        btn_limpar = findViewById(R.id.btn_limpar);
        btn_salvar = findViewById(R.id.btn_salvar);
        btn_finalizar = findViewById(R.id.btn_finalizar);
        btn_voltar = findViewById(R.id.btn_voltar);

        edit_nome.setText(cadastro.getNome());
        edit_endereco.setText(cadastro.getEndereco());
        edit_email.setText(cadastro.getEmail());
        edit_telefone.setText(cadastro.getTelefone());
        edit_sexo.setText(cadastro.getSexo());

        btn_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastroController.limparDados(edit_nome, edit_endereco, edit_email, edit_telefone, edit_sexo);
            }
        });

        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cadastro.setCategoria(CATEGORIA);
                cadastro.setNome(edit_nome.getText().toString());
                cadastro.setEndereco(edit_endereco.getText().toString());
                cadastro.setEmail(edit_email.getText().toString());
                cadastro.setTelefone(edit_telefone.getText().toString());
                cadastro.setSexo(edit_sexo.getText().toString());

                cadastroController.Save(cadastro);
                cadastroController.limparDados(edit_nome, edit_endereco, edit_email, edit_telefone, edit_sexo);
            }
        });

        btn_finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CadastrarClienteActivity.this, "Volte Sempre!", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltar = new Intent(CadastrarClienteActivity.this, RedirectActivity.class);

                startActivity(voltar);
            }
        });
    }

}