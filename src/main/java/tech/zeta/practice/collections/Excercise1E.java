package tech.zeta.practice.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Excercise1E {

//1. Create a Student class with attributes like name, ID, and GPA. Implement the Comparable interface to sort students by their ID in ascending order.
    public static void one(){
        class Student implements Comparable<Student>{
            String name;
            String id;
            Double gpa;
            Student(String name,String id,double gpa){
                this.name = name;
                this.gpa = gpa;
                this.id = id;
            }

            @Override
            public String toString() {
                return  "Id: "+id+"name='" + name + " gpa=" + gpa +"\n";
            }

            @Override
            public int compareTo(Student student) {
                return this.id.compareTo(student.id);
            }
        }

        ArrayList<Student> students = new ArrayList<>();


        students.add(new Student("S001", "Alice", 3.9));
        students.add(new Student("S003", "Charlie", 3.8));
        students.add(new Student("S002", "Bob", 3.5));
        students.add(new Student("S005", "Ethan", 3.7));
        students.add(new Student("S004", "Diana", 3.2));

        System.out.println("Unorderd students: \n"+students);
        Collections.sort(students);
        System.out.println("Ordered Students: \n"+students);
    }
//2. Create a Book class with attributes like title, author, and publication year. Create a Comparator to sort books by publication year in descending order.
    public static void two(){
        class Book {
            String title;
            String author;
            int yearOfPublication;

            public Book( String title, String author,int yearOfPublication) {
                this.title = title;
                this.author = author;
                this.yearOfPublication = yearOfPublication;
            }
            @Override
            public String toString() {
                return   title + " by " + author +
                         " in year "+ yearOfPublication +"\n";
            }
        }

        List<Book> books = new LinkedList<>();

        books.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
        books.add(new Book("1984", "George Orwell", 1949));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        books.add(new Book("The Catcher in the Rye", "J.D. Salinger", 1951));
        books.add(new Book("Moby-Dick", "Herman Melville", 1851));

        System.out.println("Unsorted books:\n"+books);
        books.sort((a,b)->b.yearOfPublication- a.yearOfPublication);
        System.out.println("Sorted books:\n"+books);

    }

    public static void three(){
        class Employee{
            String name;
            String department;
            Double salary;
            Employee(String name,String department,double salary){
                this.name = name;
                this.department = department;
                this.salary = salary;
            }

            @Override
            public String toString() {
                return name + " Department:" + department + ") - $" + salary;
            }
        }

        LinkedList<Employee> employees = new LinkedList<>();

        // Add Employee objects
        employees.add(new Employee("Alice", "HR", 45000));
        employees.add(new Employee("Bob", "IT", 60000));
        employees.add(new Employee("Charlie", "Finance", 55000));
        employees.add(new Employee("Diana", "Marketing", 50000));
        employees.add(new Employee("Ethan", "IT", 70000));

        System.out.println("Before Sorting: "+employees.toString().replace(',','\n'));
        employees.sort( (a,b)->{
           int difference = a.department.compareTo(b.department);
           if(difference != 0) return difference;
           return b.salary.compareTo(a.salary);
        });
        System.out.println("After Sorting: "+employees.toString().replace(',','\n'));

    }
//3. Given a list of employees with attributes like name, department, and salary, sort the employees first by department (alphabetically) and then by salary (highest to lowest) within each department using chained comparators.
    public static void main(String[] args) {
        //one();
        //two();
        three();
    }
}
