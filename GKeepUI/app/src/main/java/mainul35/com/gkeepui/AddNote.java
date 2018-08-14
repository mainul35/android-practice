package mainul35.com.gkeepui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import mainul35.com.model.DataSource;
import mainul35.com.model.NoteItem;

public class AddNote extends AppCompatActivity {

    private EditText etNoteTitle, etNoteDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        etNoteTitle = findViewById(R.id.etNoteTitle);
        etNoteDescription = findViewById(R.id.etNoteDescription);
    }

    public void saveNote(View view) {
        if (!etNoteTitle.getText().toString().isEmpty() && !etNoteDescription.getText().toString().isEmpty()) {
            DataSource.noteItems.add(new NoteItem(etNoteTitle.getText().toString(), etNoteDescription.getText().toString()));
            Intent intent = new Intent(AddNote.this, MainActivity.class);
            startActivity(intent);
        }else
            Toast.makeText(this, "Field value is missing.", Toast.LENGTH_SHORT);

    }
}
