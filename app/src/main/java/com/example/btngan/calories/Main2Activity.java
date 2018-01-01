package com.example.btngan.calories;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.res.AssetManager;
import android.widget.Toast;
import java.io.InputStream;
import java.util.ArrayList;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {
    String filename;
    MyListAdapter myListAdapter = new MyListAdapter();
    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> calories = new ArrayList<>();
    ArrayList<String> protein = new ArrayList<>();
    ArrayList<String> carbohydrates = new ArrayList<>();
    ArrayList<String> fats = new ArrayList<>();
    ArrayList<String> fibers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        filename= getIntent().getStringExtra("filename");
        reading(filename);
        ListView myListView = (ListView)findViewById(R.id.myListView);
        myListView.setAdapter(myListAdapter);
    }

    private class MyListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            if(names!= null && names.size() != 0){
                return names.size();

            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return names.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            final ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                LayoutInflater inflater = Main2Activity.this.getLayoutInflater();
                convertView = inflater.inflate(R.layout.custom_row, null);
                holder.textView1 = (TextView) convertView.findViewById(R.id.textView1);
                holder.textView2 = (TextView) convertView.findViewById(R.id.textView2);
                holder.textView3 = (TextView) convertView.findViewById(R.id.textView3);
                holder.textView4 = (TextView) convertView.findViewById(R.id.textView4);
                holder.textView5 = (TextView) convertView.findViewById(R.id.textView5);
                holder.textView6 = (TextView) convertView.findViewById(R.id.textView6);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.ref = position;
            holder.textView1.setText(fibers.get(position));
            holder.textView2.setText(fats.get(position));
            holder.textView3.setText(carbohydrates.get(position));
            holder.textView4.setText(protein.get(position));
            holder.textView5.setText(calories.get(position));
            holder.textView6.setText(names.get(position));

            return convertView;
        }

        private class ViewHolder {
            TextView textView1,textView2,textView3,textView4,textView5,textView6;
            int ref;
        }

    }

    public void reading(String name){
        try {

            AssetManager am = getAssets();// If this line gives you ERROR then try AssetManager am=getActivity().getAssets();
            InputStream is = am.open(name+".xls");
            Workbook wb = Workbook.getWorkbook(is);
            Sheet s = wb.getSheet(0);
            int row = s.getRows();
            int col = s.getColumns();
            String xx;
            for (int i = 0; i < row; i++) {
                for (int c = 0; c < col; c++) {
                    Cell z = s.getCell(c, i);
                    xx = z.getContents();
                    if(c==0)
                        names.add(xx);
                    else if(c==1)
                        calories.add(xx);
                    else if(c==2)
                        protein.add(xx);
                    else if(c==3)
                        carbohydrates.add(xx);
                    else if(c==4)
                        fats.add(xx);
                    else if(c==5)
                        fibers.add(xx);
                }
            }

        } catch (Exception e) {
            Toast.makeText(this, "SORRY SOMETHING WRONG HAPPENED WHILE RUNNING", Toast.LENGTH_LONG).show();
        }

    }
}
