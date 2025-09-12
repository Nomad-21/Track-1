package tech.zeta.practice.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ExcerciseD{

    static void one(){
        interface StringConverter{ String covert(String str);}

        StringConverter stringConverter = (str)->(str.toUpperCase());
        System.out.println( stringConverter.covert("Animal") );
    }

    public static List<Integer> filterList(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for (Integer i : list) {
            if (predicate.test(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public static void two(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> isOdd = n -> n % 2 != 0;
        List<Integer> oddNumbers = filterList(numbers, isOdd);
        System.out.println("Filtered List: " + oddNumbers);
    }

    public static void three(){
        interface Calculator { int calculate(int a,int b);}

        int number1 = 4, number2=2;

        Calculator add = (a,b)-> a+b ;
        System.out.println("Addition : "+add.calculate(number1,number2));

        Calculator sub = (a,b)-> a-b ;
        System.out.println("Subtraction : "+sub.calculate(number1,number2));

        Calculator product = (a,b)-> a*b ;
        System.out.println("Multiplication : "+product.calculate(number1,number2));

        Calculator division = (a,b)-> a/b ;
        System.out.println("Division : "+division.calculate(number1,number2));
    }

    static void four() {
        List<String> words = new ArrayList<>(Arrays.asList("banana", "apple", "cherry", "mango", "grape"));

        words.sort(String::compareToIgnoreCase);
        System.out.println("Sorted list: " + words);
    }


    public static void main(String[] args) {
        //one();
        //two();
        //three();
        four();
    }

}
