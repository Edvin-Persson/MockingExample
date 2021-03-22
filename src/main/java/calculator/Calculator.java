package calculator;

public class Calculator {


    public int add(String numbers) {

        if (numbers.equals("")) {

            return 0;

        }


        String[] arrayNumber = numbers.split("\n|,");
        int addingNumbers = 0;


        for (int i = 0; i < arrayNumber.length; i++) {

            addingNumbers += Integer.parseInt(arrayNumber[i]);

        }

        return addingNumbers;
    }
}
