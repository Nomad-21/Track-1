package tech.zeta.practice.collections;

import java.util.HashMap;

public class CountryCode {
    public static void main(String[] args) {

        HashMap<String,Integer>  map = new HashMap<>();

        map.put("India",91);
        map.put("Japan",81);
        map.put("China",72);
        map.put("Russia",79);
        map.put("Korea",63);

        System.out.println(map);
    }
}
