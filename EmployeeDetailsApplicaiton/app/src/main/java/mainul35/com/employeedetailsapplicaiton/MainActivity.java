package mainul35.com.employeedetailsapplicaiton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import mainul35.com.employeedetailsapplicaiton.R;

public class MainActivity extends AppCompatActivity {

    Button btnAddEmp;

    private ListView lvEmpList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddEmp = findViewById(R.id.btnAddEmp);
        lvEmpList = findViewById(R.id.lvEmpList);
    }

    public void addEmployee(View view) {
        Intent intent = new Intent(MainActivity.this, AddEmployeeForm1.class);
        startActivity(intent);
    }
}
