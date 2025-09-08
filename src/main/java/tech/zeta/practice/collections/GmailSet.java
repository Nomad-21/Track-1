package tech.zeta.practice.collections;

import java.util.HashSet;

public class GmailSet {
    public static void main(String[] args) {

        HashSet<String> set = new HashSet<>();

        set.add("kk@gmail.com");
        set.add("krishna@gmail.com");
        set.add("srijith@gmail.com");
        set.add("aneesh@gmail.com");
        set.add("husssain@gmail.com");
        set.add("kk@gmail.com");

        System.out.println(set);
    }
}
