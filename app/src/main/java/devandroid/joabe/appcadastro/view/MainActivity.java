package devandroid.joabe.appcadastro.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import devandroid.joabe.appcadastro.R;
import devandroid.joabe.appcadastro.controller.CustomerController;
import devandroid.joabe.appcadastro.model.Customer;

public class MainActivity extends AppCompatActivity {

    CustomerController customerController;
    List<String> CoursesNames;
    Customer customer;
    EditText editName;
    EditText editNameCompany;
    EditText editGender;
    Button buttonClean;
    Button buttonSave;
    Button buttonFinish;
    Spinner spinnerGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        customerController = new CustomerController(MainActivity.this);

        editName = findViewById(R.id.editName);
        editNameCompany = findViewById(R.id.editNameCompany);
        editGender = findViewById(R.id.editGender);

        buttonClean = findViewById(R.id.buttonClean);
        buttonSave = findViewById(R.id.buttonSave);
        buttonFinish = findViewById(R.id.buttonFinish);


        buttonClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editName.setText("");
                editNameCompany.setText("");
                editGender.setText("");
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                customer.setName(editName.getText().toString());
                customer.setNameCompany(editNameCompany.getText().toString());
                customer.setGender(editGender.getText().toString());

                customerController.Save(customer);
            }
        });

        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte Sempre!", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}