package calculator;

public class Calculator {

    boolean illegalException = false;
    String negativeNumbers = "";

    public int add(String numbers) {


        String[] arrayNumbers = numbers.split("[/\n;,]");
        int addingNumbers = 0;


        for (String arrayNumber : arrayNumbers) {


            if (!arrayNumber.isEmpty() && Integer.parseInt(arrayNumber) <= 1000) {


                addingNumbers += Integer.parseInt(arrayNumber);

            }
            if (arrayNumber.contains("-")) {

                illegalException = true;

                negativeNumbers += " " + arrayNumber;


            }


        }


        if (illegalException) {
            throw new IllegalArgumentException("Negative numbers not allowed" + negativeNumbers);
        }


        return addingNumbers;
    }
}
