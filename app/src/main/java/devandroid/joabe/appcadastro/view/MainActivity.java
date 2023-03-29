package devandroid.joabe.appcadastro.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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
    EditText editFirstName;
    EditText editSecondName;
    EditText editCourse;
    EditText editContact;
    Button buttonClean;
    Button buttonSave;
    Button buttonFinish;
    Spinner spinnerGender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main_spinner);

        customerController = new CustomerController(MainActivity.this);

        editFirstName = findViewById(R.id.editName);




        buttonClean = findViewById(R.id.buttonClean);
        buttonSave = findViewById(R.id.buttonSave);
        buttonFinish = findViewById(R.id.buttonFinish);


        editSecondName.setText(customer.getNameCompany());




        buttonClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editFirstName.setText("");
                editSecondName.setText("");
                editCourse.setText("");
                editContact.setText("");
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                customer.setName(editFirstName.getText().toString());
                customer.setNumberContact(editContact.getText().toString());


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