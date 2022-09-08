package main.java;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Programs {
    public static List checkForPrimeNumbersInFile(String path) throws IOException {

        List listOfNumbers = null;
        try {
            listOfNumbers = ReadFile.readFile(path);
        } catch (FileNotFoundException fnf){
            System.out.println("Failed to load text file");
        }


        List tempListOfNumbers = new ArrayList();
        for (Object number : listOfNumbers) {

            String str = number.toString();
            Boolean approve = false;
            for (int i = 0; i < str.length(); i++) {
                Boolean flag = Character.isDigit(str.charAt(i));
                if (flag) {
                    approve = true;
                } else {
                    approve = false;
                    break;
                }
            }

            if (approve == true) {
                String test = number.toString();
                Integer parsedNumber = Integer.parseInt(test);

                if (Calculations.isPrimeNumber(parsedNumber)) {
                    tempListOfNumbers.add(number);
                }
            }
        }
        return tempListOfNumbers;
    }
}
