package org.example;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static class Person {
        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<Person> newList = new ArrayList<>();
        Person person1 = new Person();
        person1.setAge(11);
        Person person2 = new Person();
        person2.setAge(20);
        newList.add(person1);
        newList.add(person2);

        List<Person> oldList = new ArrayList<>();
        //深拷贝需要序列化
        Gson gson = new Gson();
        for (Person person : newList) {
            String json = gson.toJson(person);
            oldList.add(gson.fromJson(json, Person.class));
        }
        newList.get(0).setAge(18);
        newList.remove(1);
        System.out.println("newList size : " + newList.size());
        System.out.println("newPerson age : " + newList.get(0).getAge());
        System.out.println("oldList size : " + oldList.size());
        System.out.println("oldPerson age : " + oldList.get(0).getAge());

        MyLinkedList1 myLinkedList1 = new MyLinkedList1();
        myLinkedList1.addAtHead(1);
        myLinkedList1.addAtTail(3);
        myLinkedList1.addAtIndex(1, 2);
        int val = myLinkedList1.get(1);
        System.out.println("val: " + val);
        myLinkedList1.deleteAtIndex(1);
        val = myLinkedList1.get(1);
        System.out.println("val: " + val);

    }
}