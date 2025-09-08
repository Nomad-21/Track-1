package tech.zeta.practice.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Excercise1B {
    public static void oneA(){
        //      1. Create a LinkedList of strings representing a playlist of songs. Implement methods to add a song to the end of the playlist, add a song to the beginning of the playlist, and remove a song from the playlist.
        LinkedList<String> playlist = new LinkedList<>();

        playlist.addLast("Sahiba");
        playlist.addFirst("Tum Tum");

        playlist.addLast("Kathyayni");
        playlist.addFirst("salaar bgm");

        System.out.println(playlist);

        playlist.remove("Sahiba");

        System.out.println(playlist);
    }

    public static void  oneB(){

//      2. Create a LinkedList of integers. Write a method to reverse the order of the elements in the list.

        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1,2,3,4,5,6));

        System.out.println("Initial Order: "+list);

        System.out.println("Reverse Order: "+list.reversed());

    }

    public static void oneC(){
//      3. Implement a simple queue using a LinkedList. The queue should have methods to enqueue (add an element to the end), dequeue (remove an element from the beginning), and peek (view the first element without removing it).
        class Queue<T>{
            LinkedList<T> queue;
            Queue(){
                queue = new LinkedList<>();
            }

            void enqueue(T element){
                queue.addLast(element);
            }

            T dequeue(){
                return queue.removeFirst();
            }

            T peek(){
                return queue.getFirst();
            }

            @Override
            public String toString(){
                return queue.toString();
            }
        }

        Queue<Integer> qu = new Queue<>();

        qu.enqueue(1);
        qu.enqueue(2);
        qu.enqueue(3);
        qu.enqueue(4);

        System.out.println(qu);

        System.out.println(qu.dequeue());
        System.out.println(qu.peek());
    }

    public static void main(String[] args) {

        //oneA();
        //oneB();
        oneC();


    }
}
