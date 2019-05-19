package com.example.notes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapterNotes extends ArrayAdapter<Note>{

    ArrayList<Note> notes;
    public CustomAdapterNotes(@NonNull Context context, ArrayList<Note> notes) {
        super(context, R.layout.note_layout);
        this.notes = notes;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        @SuppressLint("ViewHolder") View custom_view = inflater.inflate(R.layout.note_layout, parent, false);
        TextView date = custom_view.findViewById(R.id.date);
        TextView note = custom_view.findViewById(R.id.main_text);

        note.setText(notes.get(position).getNote_text());
        date.setText( notes.get(position).getNote_date());

        return custom_view;
    }

    @Override
    public int getCount() {
        return notes.size();
    }


}
