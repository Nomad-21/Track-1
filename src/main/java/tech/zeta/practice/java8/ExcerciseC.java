package tech.zeta.practice.java8;

public class ExcerciseC {

    public  static void one(){
        interface Calculator {
            int add(int a, int b);
            int subtract(int a, int b);

            default int multiply(int a, int b) {
                return a * b;
            }
        }

        class MyCalculator implements Calculator {
            @Override
            public int add(int a, int b) {
                return a + b;
            }

            @Override
            public int subtract(int a, int b) {
                return a - b;
            }
        }

        Calculator calc = new MyCalculator();
        System.out.println(calc.add(5, 3));      // 8
        System.out.println(calc.subtract(5, 3)); // 2
        System.out.println(calc.multiply(5, 3)); // 15 (default method used!)
    }

    public static void two(){
        interface Flyable {
            default void move() {
                System.out.println("Flying in the sky");
            }
        }

        interface Swimmable {
            default void move() {
                System.out.println("Swimming in the water");
            }
        }

        class Duck implements Flyable, Swimmable {

            // Must override move() to resolve conflict
            @Override
            public void move() {
                System.out.println("Duck is flying and swimming");
            }
        }

        Duck duck = new Duck();
        duck.move();
    }

    public static void main(String[] args) {
        //one();
        two();
    }
}
