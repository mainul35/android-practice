package mainul35.com.gkeepui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import mainul35.com.model.NoteItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list_view = findViewById(R.id.list_view);
        List<NoteItem> noteItems = new ArrayList<>();
        noteItems.add(new NoteItem("Note 1", "New Note 1"));
        noteItems.add(new NoteItem("Note 2", "New Note 2"));
        noteItems.add(new NoteItem("Note 3", "New Note 3"));
        noteItems.add(new NoteItem("Note 4", "New Note 4"));
        noteItems.add(new NoteItem("Note 5", "New Note 5"));
        GKeepListItemAdapter gKeepListItemAdapter = new GKeepListItemAdapter(this, R.layout.activity_main, noteItems);
        list_view.setAdapter(gKeepListItemAdapter);
    }

    public void addNewItem(View view) {
    }
}

class GKeepListItemAdapter extends ArrayAdapter<NoteItem>{

    private Context context;
    private List<NoteItem> noteItems;
    public GKeepListItemAdapter(@NonNull Context context, int resource, List<NoteItem> items) {
        super(context, resource, items);
        this.context = context;
        this.noteItems = items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView =inflater.inflate(R.layout.custom_checkbox_container, parent, false);
        CheckBox cbSelectItem = convertView.findViewById(R.id.cbSelectItem);
        cbSelectItem.setText(noteItems.get(position).getItemTitle());

        return convertView;
    }
}