package mainul35.com.explicitintent;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import mainul35.com.explicitintent.model.Student;

public class StudentListActivity extends Activity {

//    private TextView textView;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        listView = findViewById(R.id.lv);
//        listView = getListView();
        System.out.println(AppDataFacade.students.get(0).toString());
        Log.e("logging....", " " + AppDataFacade.students.get(0).toString());
//        CustomAdapter customAdapter = new CustomAdapter();
//        listView.setAdapter(customAdapter);

        StudentAdapter studentAdapter = new StudentAdapter(this, R.layout.activity_student_list, AppDataFacade.students);
        listView.setAdapter(studentAdapter);
    }

}

class StudentAdapter extends ArrayAdapter<Student>{

    private Context context;
    private List<Student> students;

    public StudentAdapter(@NonNull Context context, int resource, List<Student> students) {
        super(context, resource, students);
        this.context = context;
        this.students = students;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.custom_layout, parent, false);

        TextView tvStdName = convertView.findViewById(R.id.tvName);
        TextView tvStdAge = convertView.findViewById(R.id.tvAge);
        TextView tvStdDept = convertView.findViewById(R.id.tvDepartment);

        tvStdName.setText(students.get(position).getStdName());
        tvStdAge.setText(Integer.toString(students.get(position).getStdAge()));
        tvStdDept.setText(students.get(position).getStdDept());
        return convertView;
    }
}
//    class CustomAdapter extends BaseAdapter{
//
//        @Override
//        public int getCount() {
//            return AppDataFacade.students.size();
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return null;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return 0;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            convertView = getLayoutInflater().inflate(R.layout.custom_layout, null);
//            TextView tvName = convertView.findViewById(R.id.tvName);
//            TextView tvAge = convertView.findViewById(R.id.tvAge);
//            TextView tvDept = convertView.findViewById(R.id.tvDepartment);
//
//            tvName.setText(AppDataFacade.students.get(position).getStdName());
//            tvAge.setText(Integer.toString(AppDataFacade.students.get(position).getStdAge()));
//            tvDept.setText(AppDataFacade.students.get(position).getStdDept());
//            return convertView;
//        }
//    }

