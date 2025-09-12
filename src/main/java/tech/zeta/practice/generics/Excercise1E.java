package tech.zeta.practice.generics;

import org.w3c.dom.css.Counter;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Supplier;

public class Excercise1E {

    static void one(){
        Function<String, Integer> numberParser = Integer::parseInt;
        Integer number = numberParser.apply("123");
        System.out.println("Parsed Integer: " + number);
    }

    static void two(){
        class Counter {
            private int count = 0;
            public int increment() {
                return ++count;
            }
        }

        Counter counter = new Counter();
        Supplier<Integer> incrementAction = counter::increment;
        System.out.println("Count: "+incrementAction.get());
        System.out.println("Count: "+incrementAction.get());
        System.out.println("Count: "+incrementAction.get());
    }

    static void three(){
        List<String> names = Arrays.asList("  KK  ", "  Anees  ", " srijith ");
        names.replaceAll(String::trim);
        System.out.println("Trimmed names: " + names);
    }

    static void four(){
        interface ListCreator<T> { List<T> create(Collection<T> c); }

        ListCreator<String> listCreator = ArrayList::new;
        List<String> newList = listCreator.create(Arrays.asList("one", "two", "three"));
        System.out.println("New ArrayList: " + newList);
    }

    public static void main(String[] args) {
        //one();
        //two();
        //three();
        four();
    }
}
