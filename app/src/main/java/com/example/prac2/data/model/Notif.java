package com.example.prac2.data.model;

public class Notif {
    private String title;
    private String text;
    private String data;

    public Notif(){
        this("SomeTitle","SomeText", "SomeDate");
    }
    public Notif(String title, String text, String date){
        this.title = title;
        this.text = text;
        this.data = date;
    }

    public String getTitle(){return title;}
    public String getText(){return text;}
    public String getData(){return data;}

}
