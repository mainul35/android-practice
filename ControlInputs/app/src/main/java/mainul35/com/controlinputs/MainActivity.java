package mainul35.com.controlinputs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> languages = new ArrayList<>();

    private RadioGroup radioGroup;

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.rgGender);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = findViewById(i);
                Log.e("Showing gender", "onCheckedChanged: "+radioButton.getText().toString() );
            }
        });

        String cities[] = getResources().getStringArray(R.array.cityArray);

        ArrayAdapter<String> citiesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, cities);

        spinner = findViewById(R.id.spinner);
        spinner.setAdapter(citiesAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i>0) {
                    String city = adapterView.getItemAtPosition(i).toString();
                    Log.e("Selected city", "onItemSelected: " + city);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void selectLanguage(View view) {
        CheckBox checkBox = (CheckBox) view;
        String selectedLanguage = checkBox.getText().toString();
        if(checkBox.isChecked()){
            languages.add(selectedLanguage);
        } else {
            languages.remove(selectedLanguage);
        }
//        System.out.println();
        Toast.makeText(MainActivity.this, Integer.toString(languages.size()), Toast.LENGTH_SHORT);
        Log.e("Showing size", "selectLanguage: " + Integer.toString(languages.size()));
    }
}
