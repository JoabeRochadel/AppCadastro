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
        saveObject("CUSTOMER", data);
    }

    public void alterData(Customer customer) {
        ContentValues data = new ContentValues();

        data.put("id", customer.getId());
        data.put("name", customer.getName());
        data.put("nameCompany", customer.getNameCompany());
        data.put("gender", customer.getGender());
        AlterData("CUSTOMER", data);
    }

    public void delete(int id) {
        DeleteData("CUSTOMER", id);
    }
}
