package tech.zeta.practice.generics;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;

public class ExcerciseA {

     public static void one(){

         class MyStack<T>{
             ArrayList<T> stack;
             public MyStack(int capacity){
                 stack = new ArrayList<>(capacity);
             }

             public void push(T element){ stack.addFirst(element);}

             public T pop(){
                 if(stack.isEmpty()) throw new RuntimeException("Stack is empty");
                 return stack.removeFirst();
             }

             public T peek(){
                 if(stack.isEmpty()) throw new RuntimeException("Stack is empty");
                 return stack.getFirst();
             }

             @Override
             public String toString(){
                 return stack.toString();
             }

         }

         MyStack<Integer> stack = new MyStack<>(5);

         System.out.println("Created stack...");
         System.out.println("Pushing elements into stack...");

         for(int element=1; element<=5 ; element++ )    stack.push(element);

         System.out.println("Stack: "+stack);

         System.out.println("Removing element from stack:");
         System.out.println("Removed: "+stack.pop());

         System.out.println("Peek : "+stack.peek());
     }


     public static void two(){
         Integer[] array = {1,2,3,4,5};
         System.out.print("Array: ");
         for(int number : array) System.out.print( number+" ");

         System.out.println("\nMax number: "+findMax(array));
     }

    public static <T extends Comparable<T>> T findMax(T[] array) {
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }

    public static void three(){
         class Cache<K,V>{
             HashMap<K,V> hashMap;

             public Cache(){
                 hashMap = new HashMap<>();
             }

             public void put(K key,V value){
                 hashMap.put(key,value);
                 System.out.println("Added (" + key + " -> " + value + ") to cache.");
             }

             public V get(K key){
                 if(!hashMap.containsKey(key))
                     throw new RuntimeException("Cache does not contains the key: "+key);
                 return hashMap.get(key);
             }

             public void remove(K key){
                if(!hashMap.containsKey(key))
                    throw new RuntimeException("Cache does not contains the key: "+key);
                System.out.println("Removed (" + key + " -> " + hashMap.remove(key) + ") from cache.");
            }

            public boolean contains(K key){ return hashMap.containsKey(key); }

             @Override
             public String toString() {
                 return hashMap.toString();
             }
         }

         Cache<Integer,String> cache = new Cache<>();

         cache.put(1,"Item1");
         cache.put(2,"Item2");
         cache.put(3,"Item3");

         cache.remove(2);

        System.out.println("Cache contains 3 ? "+cache.contains(3));

        System.out.println("Key 1 : "+cache.get(1));

    }

    public static void main(String[] args) {

        //one();
        //two();
        three();
    }

}
