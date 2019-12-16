package com.design.pattern.singleton;


import com.design.pattern.singleton.lazy.SingleTwo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SeriableTest {
    public static void main(String[] args) {

        SingleTwo s1 = SingleTwo.getInstance();
        SingleTwo s2 = null;

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("SingleTwo.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s1);
            oos.flush();
            oos.close();


            FileInputStream fis = new FileInputStream("SingleTwo.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s2 = (SingleTwo)ois.readObject();
            ois.close();

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1 == s2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
