package main.java;

public class Calculations {
    public static boolean isPrimeNumber(Integer n) {
        if (n <= 1 && n >= 0) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
