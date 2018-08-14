
package mainul35.com.employeedetailsapplicaiton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import mainul35.com.employeedetailsapplicaiton.model.Address;
import mainul35.com.employeedetailsapplicaiton.model.DataStore;
import mainul35.com.employeedetailsapplicaiton.model.Employee;

public class AddEmployeeForm3 extends AppCompatActivity {

    private EditText etHouse, etStreet, etCity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee_form3);

        etHouse = findViewById(R.id.etHouse);
        etStreet = findViewById(R.id.etStreet);
        etCity = findViewById(R.id.etCity);
    }

    public void save(View view) {
        if (etHouse.getText().toString().isEmpty() || etStreet.getText().toString().isEmpty() || etCity.getText().toString().isEmpty()) return;
        Address address = new Address(etHouse.getText().toString(), etStreet.getText().toString(), etCity.getText().toString());
        Employee employee = (Employee) getIntent().getSerializableExtra("employee");
        employee.setAddress(address);
        DataStore.employees.add(employee);

    }
}
