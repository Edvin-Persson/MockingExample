package calculator;

public class Calculator {


    public int add(String numbers) {


        String[] arrayNumbers = numbers.split("[/\n;,]");
        int addingNumbers = 0;


        for (String arrayNumber : arrayNumbers) {

            if (!arrayNumber.isEmpty()) {

                addingNumbers += Integer.parseInt(arrayNumber);

            }


        }

        return addingNumbers;
    }
}
