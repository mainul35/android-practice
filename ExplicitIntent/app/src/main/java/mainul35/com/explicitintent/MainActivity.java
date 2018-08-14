package mainul35.com.explicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import mainul35.com.explicitintent.model.Student;

public class MainActivity extends AppCompatActivity {

    private EditText etStdName, etStdAge, etStdDept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etStdName = findViewById(R.id.etStdName);
        etStdAge = findViewById(R.id.etStdAge);
        etStdDept = findViewById(R.id.etStdDept);
    }

    public void saveStudent(View view) {
        String name = etStdName.getText().toString();
        String age = etStdAge.getText().toString().isEmpty()?"0":etStdAge.getText().toString();
        String dept = etStdDept.getText().toString();

        Student student = new Student(name, Integer.parseInt(age), dept);
        Log.d("student", "saveStudent: "+student.toString());

        AppDataFacade.students.add(student);

        Intent intent = new Intent(MainActivity.this, StudentListActivity.class);
        startActivity(intent);
    }
}
