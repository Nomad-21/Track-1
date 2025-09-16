package tech.zeta.practice.debug;


public class ExcerciseA {

    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public void greet() {
        System.out.println("Hello!");
    }

    public void calculateSum(int a, int b) {
        int sum = a + b;
        System.out.println("Sum: " + sum);
    }

    public void displayMessage(String message) {
        System.out.println("Message: " + message);
    }

    private String secret = "initial";

    public void updateSecret(String newSecret) {
        this.secret = newSecret;
    }

    public String getSecret() {
        return secret;
    }

    public void throwException() {
        String str = null;
        System.out.println(str.length());
    }

    // ========= MAIN =========
    public static void main(String[] args) {
        ExcerciseA demo = new ExcerciseA();

        // 1. Line Breakpoint (Factorial)
        int fact = factorial(5);
        System.out.println("Factorial of 5: " + fact);

        // 2. Method Breakpoints
        demo.greet();
        demo.calculateSum(4, 6);
        demo.displayMessage("Debugging in IntelliJ!");

        // 3. Field Watchpoint
        demo.updateSecret("top-secret");
        System.out.println("Secret is: " + demo.getSecret());

        // 4. Exception Breakpoint
        demo.throwException();  // <-- Set EXCEPTION BREAKPOINT for NullPointerException
    }
}

//Excercise B is also completed here, as to navigate I used step-into,step-over and step-out opetations

