package com.example.notes;

public class Note {
    private String note_text;
    private String note_date;

    public Note(String note_text, String note_date) {
        this.note_text = note_text;
        this.note_date = note_date;
    }

    public String getNote_text() {
        return note_text;
    }

    public String getNote_date() {
        return note_date;
    }

    public void setNote_text(String note_text) {
        this.note_text = note_text;
    }

    public void setNote_date(String note_date) {
        this.note_date = note_date;
    }
}
