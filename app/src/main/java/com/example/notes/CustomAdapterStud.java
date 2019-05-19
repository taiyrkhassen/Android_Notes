package com.example.notes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomAdapterStud extends ArrayAdapter<Student>{
    ArrayList<Student> student;
    public CustomAdapterStud(Context context, ArrayList<Student> student) {
        super(context, R.layout.list_item);
        this.student = student;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        @SuppressLint("ViewHolder") View custom_view = inflater.inflate(R.layout.list_item, parent, false);
        TextView name = custom_view.findViewById(R.id.textView);
        TextView gpa = custom_view.findViewById(R.id.gpa);

        name.setText(student.get(position).getName());

        return custom_view;
    }

    @Override
    public int getCount() {
        return student.size();
    }
}
