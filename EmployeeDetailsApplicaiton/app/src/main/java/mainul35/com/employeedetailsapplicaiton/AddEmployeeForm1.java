package mainul35.com.employeedetailsapplicaiton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.UUID;

import mainul35.com.employeedetailsapplicaiton.R;
import mainul35.com.employeedetailsapplicaiton.model.Employee;

public class AddEmployeeForm1 extends AppCompatActivity {
    TextView etId, etName, etAge, etEmail, etNumber;
    RadioButton rbMale, rbFemale;
    String sexState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee_form1);

        etAge = findViewById(R.id.etAge);
        etName = findViewById(R.id.etName);
        etId = findViewById(R.id.etId);
        etEmail = findViewById(R.id.etEmail);
        etNumber = findViewById(R.id.etNumber);
        etId.setText("ID will be auto-generated");
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
    }


    public void goNext(View view) {
        if(etName.getText().toString().isEmpty() || etAge.getText().toString().isEmpty() || sexState.isEmpty() || etEmail.getText().toString().isEmpty() || etNumber.getText().toString().isEmpty()) return;
        Employee employee = new Employee(
                etName.getText().toString(),
                etAge.getText().toString(),
                UUID.randomUUID().toString(),
                sexState,
                etEmail.getText().toString(),
                etNumber.getText().toString());

        Intent intent = new Intent(AddEmployeeForm1.this, AddEmployeeForm2.class);
        intent.putExtra("employee", employee);
        startActivity(intent);
    }

    public void getSelectedRadioState(View view) {
        RadioButton radioButton = (RadioButton) view;
        sexState = radioButton.getText().toString();
    }
}
