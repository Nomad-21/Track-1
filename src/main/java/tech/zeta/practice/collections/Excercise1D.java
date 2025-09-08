package tech.zeta.practice.collections;

import java.io.*;
import java.util.*;

public class Excercise1D {

    public static void one(){

        HashMap<Character,Integer> hashMap = new HashMap<>();
        try {
            BufferedReader input = new BufferedReader(new FileReader("src/main/resources/text.txt"));
            String line;
            while ((line = input.readLine())!=null){
                for(char c : line.toCharArray()){
                    if(Character.isAlphabetic(c)){
                        c = Character.toLowerCase(c);
                        hashMap.put(c,hashMap.getOrDefault(c,0)+1);
                    }
                }
            }

            System.out.println("----Word Map----");
            for(Map.Entry<Character,Integer> entry: hashMap.entrySet()){
                System.out.printf("%2s : %-2d%n",entry.getKey(),entry.getValue());
            }

        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void two(){

        TreeMap<String,String>  contactList = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);

        char c = 'a';
        while( c != 'q' ){
            System.out.printf("Press 1:Add contact%n      2:Remove contact%n      q:exit%n");
            c = scanner.next().charAt(0);
            if( c== '1'){
                System.out.print("Enter contact name: ");
                String name = scanner.next();
                System.out.print("Enter contact number: ");
                String number = scanner.next();
                contactList.put(name,number);
            } else if (c == '2') {
                System.out.println("Enter contact name to remove: ");
                String name = scanner.next();
                if(contactList.containsKey(name)){
                    contactList.remove(name);
                    System.out.println("Removed successfully");
                }else{
                    System.out.println("The above name does not exist");
                }
            }

            System.out.println(contactList);
        }
    }

    public static void three(){
        class Student{
            String name;
            Double gpa;
            Student(String name,double gpa){
                this.name = name;
                this.gpa = gpa;
            }

            @Override
            public String toString() {
                return "name='" + name + " gpa=" + gpa +" percentage";
            }
        }

        TreeMap<Student,Double> treeMap = new TreeMap<>((a,b)-> b.gpa.compareTo(a.gpa));

        treeMap.put(new Student("Alice", 3.9), 95.0);
        treeMap.put(new Student("Bob", 3.5), 78.0);
        treeMap.put(new Student("Charlie", 3.8), 92.0);
        treeMap.put(new Student("Diana", 3.2), 70.0);
        treeMap.put(new Student("Ethan", 3.7), 88.0);

        System.out.println(treeMap.toString().replace(',','\n'));
    }


    public static void four(){

        HashMap<String,Integer> hashMap = new HashMap<>();
        try {
            hashMap.put(null,2);
            System.out.println("Sucessfully added null key");
            hashMap.remove(null);
            System.out.println("Sucessfully removed null key");
            //hashMap.put(null,3);
        }catch (Exception exception){
            System.out.println("Error :" + exception.getMessage());
        }

        TreeMap<String,Integer> treeMap = new TreeMap<>();
        try {
            treeMap.put(null,2);
        }catch (Exception exception){
            System.out.println("Error :" + exception.getMessage());
        }
    }


    public static void main(String[] args) {
        //one();
        //two();
        //three();
        four();
    }
}
