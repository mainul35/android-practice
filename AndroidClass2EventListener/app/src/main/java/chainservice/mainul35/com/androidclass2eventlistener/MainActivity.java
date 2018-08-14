package chainservice.mainul35.com.androidclass2eventlistener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button2 = findViewById(R.id.btn2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button 2 clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showNumber(View view) {
        Button btn = (Button) view;
        Toast.makeText(this, btn.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
