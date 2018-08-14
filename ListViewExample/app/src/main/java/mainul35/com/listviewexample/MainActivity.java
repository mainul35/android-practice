package mainul35.com.listviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> countries = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        generateCountryList();
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countries);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.student_row, countries);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String selectedCountry = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, countries.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateCountryList() {
        countries.add("Australia");
        countries.add("Bangladesh");
        countries.add("Canada");
        countries.add("Denmark");
        countries.add("England");
        countries.add("Finland");
        countries.add("Germany");
        countries.add("Honduras");
        countries.add("Italy");
        countries.add("Japan");
        countries.add("Korea");
        countries.add("Latvia");
        countries.add("Mongolia");
        countries.add("Nepal");
        countries.add("Oman");
    }
}
