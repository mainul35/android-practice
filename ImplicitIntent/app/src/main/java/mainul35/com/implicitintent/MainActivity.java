package mainul35.com.implicitintent;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dialNumber(View view) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+8801634440004"));
        if (isComponentAvailable(callIntent))
            startActivity(callIntent);
        else
            Toast.makeText(this, R.string.no_component_err_msg, Toast.LENGTH_SHORT);
    }

    private boolean isComponentAvailable(Intent intent) {
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return activities.size() > 0;
    }

    public void callNumber(View view) {
        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:+8801634440004"));
        if (isComponentAvailable(callIntent)) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 111);
                return;
            }
            startActivity(callIntent);
        }else {
            Toast.makeText(this, R.string.no_component_err_msg, Toast.LENGTH_SHORT);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode==111 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:+8801634440004"));
            if (isComponentAvailable(callIntent)) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 111);
                    return;
                }
                startActivity(callIntent);
            }else {
                Toast.makeText(this, R.string.no_component_err_msg, Toast.LENGTH_SHORT);
            }
        }
    }

    public void viewMap(View view) {
        Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        startActivity(mapIntent);
    }

    public void viewWebPage(View view) {
        Uri webpage = Uri.parse("http://www.android.com");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);
    }

    public void sendMail(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
// The intent does not have a URI, so declare the "text/plain" MIME type
        emailIntent.setType("plain/text");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"mainuls18@gmail.com"}); // recipients
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "A photo");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message text");
        emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));
// You can also attach multiple items by passing an ArrayList of Uris
        startActivity(emailIntent);
    }

    public void viewCalendar(View view) {
        Intent calendarIntent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
        Calendar beginTime = Calendar.getInstance();
        beginTime.set(2018, 7, 9, 7, 30);
        Calendar endTime = Calendar.getInstance();
        endTime.set(2018, 7, 11, 10, 30);
        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
        calendarIntent.putExtra(CalendarContract.Events.TITLE, "Break Time");
        calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "BITM");
        startActivity(calendarIntent);
    }

    public void selectDate(View view) {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        button = findViewById(R.id.datePickerButton);
        int year, month, dayOfMonth;
        year = calendar.get(calendar.YEAR);
        month = calendar.get(calendar.MONTH);
        dayOfMonth = calendar.get(calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
                button.setText(i2+"/"+(i1+i2)+"/"+i);
            }
        }, year, month, dayOfMonth);
        datePickerDialog.show();
    }
}
