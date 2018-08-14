package mainul35.com.gkeepui;

import android.content.Context;
import android.content.Intent;
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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mainul35.com.model.DataSource;
import mainul35.com.model.NoteItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvEmptyList = findViewById(R.id.tvEmptyList);
        if (DataSource.noteItems.isEmpty()){
            tvEmptyList.setText("No notes found!");
        }else{
            tvEmptyList.setText("");
        }
        ListView list_view = findViewById(R.id.list_view);

        GKeepListItemAdapter gKeepListItemAdapter = new GKeepListItemAdapter(this, R.layout.activity_main, DataSource.noteItems);
        list_view.setAdapter(gKeepListItemAdapter);
    }

    public void addNewItem(View view) {
        Intent intent = new Intent(MainActivity.this, AddNote.class);
        startActivity(intent);
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