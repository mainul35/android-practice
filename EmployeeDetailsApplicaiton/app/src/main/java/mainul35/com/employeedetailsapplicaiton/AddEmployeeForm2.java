package mainul35.com.employeedetailsapplicaiton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import mainul35.com.employeedetailsapplicaiton.R;
import mainul35.com.employeedetailsapplicaiton.model.Employee;

public class AddEmployeeForm2 extends AppCompatActivity {

    private Spinner spEmpTypes;
    private Employee employee;
    String[] empTypes;
    Button btnNext;
    List<String> skills;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee_form2);

        employee = (Employee) getIntent().getSerializableExtra("employee");

        spEmpTypes = findViewById(R.id.spEmpTypes);
        empTypes = getResources().getStringArray(R.array.empTypes);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_dropdown_item_1line, empTypes);
        spEmpTypes.setAdapter(arrayAdapter);
        spEmpTypes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedEmpType = adapterView.getItemAtPosition(i).toString();
                employee.setEmploymentType(selectedEmpType);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Log.e("employee", "onCreate: " + employee.toString());
    }

    public void selectLanguage(View view) {
        skills = new ArrayList<>();
        CheckBox checkBox = (CheckBox) view;


        if (checkBox.isSelected()){
            skills.add(checkBox.getText().toString());
        }else{
            skills.remove(checkBox.getText().toString());
        }
    }

    public void goNext(View view) {
        employee.setSkills(skills);
        Log.e("employee", "goNext: " + employee.toString());
        Intent intent = new Intent(AddEmployeeForm2.this, AddEmployeeForm3.class);
        intent.putExtra("employee", employee);
        startActivity(intent);

    }
}
