package tech.zeta.practice.generics;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ExcerciseC {

    static void one(){
        class ListProccesor<T extends List<?>>{
            void process(List<?> list){
                System.out.println("The size of the list is : "+list.size());
            }
        }

        ListProccesor<List<Integer>> listProccesor = new ListProccesor<>();
        listProccesor.process(new ArrayList<>(Arrays.asList(1,2,3,4,5)));
        listProccesor.process(new LinkedList<>(Arrays.asList("a", "b", "c", "d")));

    }

    static void two(){
        class MultiBound<T extends Comparable<T> & Serializable>{
            void serialize(T object,String fileName){
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                    oos.writeObject(object);
                    System.out.println("Object serialized successfully to " + fileName);
                } catch (IOException e) {
                    System.out.println("Serialization failed: " + e.getMessage());
                }
            }

            T deserialize(String fileName){
                T object = null;
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
                    object = (T) ois.readObject();
                    System.out.println("Object deserialized successfully from " + object);
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("Deserialization failed: " + e.getMessage());
                }
                return object;
            }
        }

        class Person implements Comparable<Person>, Serializable {
            private static final long serialVersionUID = 1L; //

            private String name;
            private int age;

            public Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public int compareTo(Person other) {
                return Integer.compare(this.age, other.age);
            }

            @Override
            public String toString() {
                return "Person{" +
                        "name='" + name + '\'' +
                        ", age=" + age +
                        '}';
            }
        }

        Person person = new Person("Koushik",21);
        MultiBound<Person> serializer = new MultiBound<>();

        serializer.serialize(person,"src/main/java/tech/zeta/practice/generics/person.ser");
        serializer.deserialize("src/main/java/tech/zeta/practice/generics/person.ser");
    }

    public static void addInteger(List<? super Integer> list) {
        list.add(42);
    }

    static void three(){
        List<Integer> intList = new ArrayList<>();
        List<Number> numList = new ArrayList<>();
        List<Double> doubleList = new ArrayList<>(); //results in error

        addInteger(intList);
        addInteger(numList);
        //addInteger(doubleList);

        System.out.println(intList);
        System.out.println(numList);
    }


    public static void main(String[] args) {
        //one();
        //two();
        three();
    }

}
