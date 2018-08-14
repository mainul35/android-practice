package mainul35.com.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "onCreate: call");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: call");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: call");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: call");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: call");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: call");
    }
}
