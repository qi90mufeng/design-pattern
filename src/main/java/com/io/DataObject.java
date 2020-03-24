package com.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DataObject implements Serializable {
    private static int i=0;
    private String word=" ";
    public void setWord(String word){
        this.word=word;
    }
    public void setI(int i){
        DataObject.i=i;
    }

    public static void main(String[] args) {
        DataObject object = new DataObject();
        object.setWord("123");
        object.setI(2);

        try{
            FileOutputStream file = new FileOutputStream("dataObject.txt") ;
            ObjectOutputStream oos = new ObjectOutputStream(file) ;
            oos.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            FileInputStream file = new FileInputStream("dataObject.txt") ;
            ObjectInputStream ois = new ObjectInputStream(file) ;
            DataObject o = (DataObject)ois.readObject();
            System.out.println(o);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
