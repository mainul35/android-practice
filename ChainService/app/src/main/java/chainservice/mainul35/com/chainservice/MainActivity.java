package chainservice.mainul35.com.chainservice;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView viewFullName;
    private EditText fName, lName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        fName = findViewById(R.id.etF_Name);
//        lName = findViewById(R.id.etL_Name);
//        viewFullName = findViewById(R.id.viewFullName);

    }

//    public void changeText(View view) {
//        Toast.makeText(this, "Welcome to android", Toast.LENGTH_SHORT);
//        textView1.setText(editText1.getText().toString());
//        editText1.setText("");
//    }

//    public void showFullName(View view) {
//        viewFullName.setText(fName.getText().toString()+" "+lName.getText().toString());
//        fName.setText("");
//        lName.setText("");
//    }
}
