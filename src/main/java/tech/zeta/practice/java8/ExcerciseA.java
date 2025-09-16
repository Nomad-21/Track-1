package tech.zeta.practice.java8;

import java.util.Comparator;
import java.util.List;

public class ExcerciseA {
    public static void one() {
        List<Integer> numbers = List.of(10, 11, 12, 2, 4, 5, 22, 19, 20);
        System.out.println("List: " + numbers);
        int EvenSumGreaterThan10 = numbers.stream().filter(n -> n > 10 && n % 2 == 0).mapToInt(Integer::intValue).sum();
        System.out.println("Sum: " + EvenSumGreaterThan10);
    }

    //Given a list of strings, use the Streams API to find the longest string.
    public static void two() {
        List<String> strings = List.of("apple", "banana", "cherry", "watermelon", "kiwi");
        System.out.println("List: " + strings);
        String longestString = strings.stream().max(Comparator.comparing(String::length)).orElse("");
        System.out.println("Longest String: " + longestString);
    }


    //Given a list of Person objects (with name and age properties), use the Streams API to find the average age of people whose names start with "A".
    public static void three() {
        class Person {
            String name;
            int age;

            Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public String toString() {
                return "Person{name='" + name + "', age=" + age + '}';
            }
        }

        List<Person> people = List.of(
                new Person("Alice", 30),
                new Person("Hussain", 25),
                new Person("Anees", 28),
                new Person("KK", 35)
        );

        System.out.println("People: " + people);
        double averageAge = people.stream()
                .filter(p -> p.name.startsWith("A"))
                .mapToInt(p -> p.age)
                .average()
                .orElse(0.0);

        System.out.println("Average age of people whose names start with 'A': " + averageAge);
    }


    //Using the Product class from the previous example, create a stream pipeline to find the names of all products that cost more than INR50 and belong to the "Electronics" category, sorted alphabetically.
    public static void four() {

        class Product {
            String name;
            String category;
            double price;

            Product(String name, String category, double price) {
                this.name = name;
                this.category = category;
                this.price = price;
            }

            @Override
            public String toString() {
                return "Product{name='" + name + "', category='" + category + "', price=" + price + '}';
            }
        }

        List<Product> products = List.of(
                new Product("Laptop", "Electronics", 60000),
                new Product("Smartphone", "Electronics", 30000),
                new Product("Headphones", "Electronics", 40),
                new Product("Refrigerator", "Appliances", 45000),
                new Product("Washing Machine", "Appliances", 35000),
                new Product("Television", "Electronics", 55000)
        );

        System.out.println("Products: " + products);
        List<String> result = products.stream()
                .filter(p -> p.price > 50 && p.category.equals("Electronics"))
                .map(product -> product.name)
                .sorted()
                .toList();

        System.out.println("Filtered products: " + result);

    }

    public static void main(String[] args) {
        //one();
        //two();
        //three();
        four();
    }
}