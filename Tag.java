package com.company;

public class Tag {
    public int position;
    public int length;
    public char nextChar;



    public Tag(int position,int length, char nextChar){
        this.position=position;
        this.length=length;
        this.nextChar=nextChar;
    }
    public Tag(){}

    public void setPosition(int position) { this.position = position; }
    public int getPosition(){
        return position;
    }
    public void setLength(int length){this.length=length;}
    public int getLength(){return length;}
    public void setNextChar(char nextChar){ this.nextChar=nextChar; }
    public char getNextChar(){
        return nextChar;
    }
    public String toString(){
        return "<" +position+ ", " +nextChar+ ">";
    }
}