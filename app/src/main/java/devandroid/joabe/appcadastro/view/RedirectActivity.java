package devandroid.joabe.appcadastro.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import devandroid.joabe.appcadastro.R;

public class RedirectActivity extends AppCompatActivity {

    Button btn_cadastrar_cliente;
    Button btn_cadastrar_fornecedor;
    Button btn_cadastrar_colaborador;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.redirect_activity);

        btn_cadastrar_cliente = findViewById(R.id.btn_cadastrar_cliente);
        btn_cadastrar_fornecedor = findViewById(R.id.btn_cadastrar_fornecedor);
        btn_cadastrar_colaborador = findViewById(R.id.btn_cadastrar_colaborador);

        btn_cadastrar_cliente.setOnClickListener(v -> abrirCadastroCliente());
        btn_cadastrar_fornecedor.setOnClickListener(v -> abrirCadastroFornecedor());
        btn_cadastrar_colaborador.setOnClickListener(v -> abrirCadastroColaborador());

    }

    private void abrirCadastroCliente(){
        Intent intent = new Intent(this, cadastrar_cliente.class);
        startActivity(intent);
    }
    private void abrirCadastroFornecedor(){
        Intent intent = new Intent(this, cadastrar_fornecedor.class);
        startActivity(intent);
    }
    private void abrirCadastroColaborador(){
        Intent intent = new Intent(this, cadastrar_colaborador.class);
        startActivity(intent);
    }
}