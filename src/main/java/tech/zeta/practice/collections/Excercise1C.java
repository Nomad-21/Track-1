package tech.zeta.practice.collections;

import javax.swing.plaf.PanelUI;
import java.util.*;
import java.util.random.RandomGenerator;

public class Excercise1C {
//1. Duplicate Removal: Given a list of strings, use a HashSet to remove all duplicate strings and print the unique strings.
    public static void one(){
        List<String> arr = Arrays.asList("Anees","Srijith","Hussain","Koushik","Anees");
        System.out.println("With Duplicates: "+arr);

        HashSet<String> set = new HashSet<>(arr);
        System.out.println("Without Duplicates: "+set);

    }


//2. Sorted Names: Given a list of names, use a TreeSet to store the names in alphabetical order and print the sorted list.
    public static void two(){
        List<String> arr = Arrays.asList("Anees","Srijith","Hussain","Koushik","Anees");
        System.out.println("With Duplicates: "+arr);

        TreeSet<String> set = new TreeSet<>(arr);
        System.out.println("Without Duplicates: "+set);

    }
//3. Custom Sorting: Create a class Employee with attributes name and salary. Use a TreeSet with a custom Comparator to sort employees based on their salary in descending order.
    public static void three(){
        class Employee{
            int id;
            String name;
            Double salary;

            Employee(int id,String name,double salary) {
                this.id = id;
                this.name = name;
                this.salary = salary;
            }

            @Override
            public String toString() {
                return String.format("Id: %d ,Employee: %s ,salary:%f%n",id,name,salary);
            }
        }

        List<Employee> listOfEmployees = Arrays.asList(
                new Employee(1,"Anees",4000.00),
                new Employee(1,"Srijith",2000.00),
                new Employee(1,"Hussain",40000.00),
                new Employee(1,"Koushik",100000.00)
        );
        System.out.println("Unordered: "+listOfEmployees);

        TreeSet<Employee> set = new TreeSet<>((a,b)->b.salary.compareTo(a.salary));
        set.addAll(listOfEmployees);
        System.out.println("Ordered: "+set);

    }


//4. Performance Test: Create two large sets (one HashSet and one TreeSet) with 1 million random integers. Measure the time it takes to add, remove, and check for the existence of elements in both sets. Analyze the performance differences.
    public static void four(){
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        System.out.println("--------HashSet Performance");
        performanceTest(hashSet);

        System.out.println("--------TreeSet Performance");
        performanceTest(treeSet);
    }

    public static void  performanceTest(Set<Integer> set){

        Random random = new Random();
        long t1 = System.currentTimeMillis();
        for(int i=0; i < 1_000_000; i++){
            int rand = random.nextInt();
            set.add(rand);
        }
        System.out.println("Time Taken to add 1 million: "+(System.currentTimeMillis()-t1));

        t1 = System.currentTimeMillis();
        for(int i=0; i < 1_000_000; i++){
            int rand = random.nextInt();
            set.contains(rand);
        }
        System.out.println("Time Taken to check 1 million: "+(System.currentTimeMillis()-t1));

        t1 = System.currentTimeMillis();
        for(int i=0; i < 1_000_000; i++){
            int rand = random.nextInt();
            set.remove(rand);
        }
        System.out.println("Time Taken to remove 1 million: "+(System.currentTimeMillis()-t1));


    }

    public static void main(String[] args) {

        //one();
        //two();
        //three();
        four();
    }
}
