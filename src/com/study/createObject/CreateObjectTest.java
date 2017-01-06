package com.study.createObject;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * test the CreateObject
 *
 * @author shihuibo
 * @version 1.0
 * @since 2017/01/05 20:48.
 */
public class CreateObjectTest {

    public static void main(String... args) {

        /*
         * the first way to create object
         * by using new keyword
         */
        CreateObject co1 = new CreateObject("co1", "co1's object");
        System.out.println("first : " + co1.toString());

        /*
         * the second way to create object
         * by using Class class's newInstance() method
         */
        try {
            CreateObject co2 = (CreateObject) Class.forName("com.study.createObject.CreateObject").newInstance();
            co2.setName("co2");
            co2.setObject("co2's object");
            System.out.println("second : " + co2.toString());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println(e.getMessage());
        }

        /*
         * the third way to create object
         * by using Constructor class's newInstance() method
         */
        try {
            Constructor<CreateObject> constructor = CreateObject.class.getConstructor();
            CreateObject co3 = constructor.newInstance();
            co3.setName("co3");
            System.out.println("third : " + co3.toString());
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException |
                InstantiationException | InvocationTargetException e) {
            System.out.println(e.getMessage());
        }

        /*
         * the fourth way to create object
         * by using clone() method
         */
        try {
            CreateObject co4 = (CreateObject) co1.clone();
            co4.setName("co4");
            co4.setObject("Null");
            System.out.println("first : " + co1.toString() + " fourth : " + co4.toString());
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }

        /*
         * the fifth way to create object
         * by using Deserialization
         */
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("data.obj"));
            objectOutputStream.writeObject(new CreateObject("shihuibo", "CreateObject"));
            objectOutputStream.close();

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("data.obj"));
            CreateObject co5 = (CreateObject) objectInputStream.readObject();
            objectInputStream.close();

            System.out.println("fifth : " + co5.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
