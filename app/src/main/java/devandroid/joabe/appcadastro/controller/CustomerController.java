package devandroid.joabe.appcadastro.controller;

import android.content.ContentValues;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.joabe.appcadastro.database.AppCadastroDb;
import devandroid.joabe.appcadastro.model.Customer;
import devandroid.joabe.appcadastro.view.MainActivity;

public class CustomerController extends AppCadastroDb {

    public CustomerController(MainActivity mainActivity) {
        super(mainActivity);

    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_CONTROLLER", "Controller iniciada!");

        return super.toString();
    }

    public void Save(Customer customer) {
        Log.d("MVC_CONTROLLER", "Salvo!");

        ContentValues data = new ContentValues();

        data.put("name", customer.getName());
        data.put("nameCompany", customer.getNameCompany());
        data.put("gender", customer.getGender());
        data.put("name", customer.getBirthday());
        data.put("name", customer.getCountry());
        data.put("name", customer.getState());
        data.put("name", customer.getCity());
        data.put("name", customer.getBudget());
        data.put("name", customer.getNumberContact());


        saveObject("CUSTOMER", data);
    }

    public void alterData(Customer customer) {
        ContentValues data = new ContentValues();

        data.put("id", customer.getId());
        data.put("name", customer.getName());
        data.put("nameCompany", customer.getNameCompany());
        data.put("gender", customer.getGender());
        data.put("name", customer.getBirthday());
        data.put("name", customer.getCountry());
        data.put("name", customer.getState());
        data.put("name", customer.getCity());
        data.put("name", customer.getBudget());
        data.put("name", customer.getNumberContact());
        AlterData("CUSTOMER", data);
    }

    public void delete(int id) {
        DeleteData("CUSTOMER", id);
    }
}
