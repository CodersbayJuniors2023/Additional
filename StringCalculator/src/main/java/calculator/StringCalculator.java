package calculator;

public class StringCalculator {
    public int subtract(int x, int y) {
        return x - y;
    }

    public int add(String numbers) {
        int sum = 0;
        for (int number : parseNumbers(numbers)) {
            sum += number;
        }

        return sum;
    }

    public int subtract(String numbers) {
        int sub = 0;
        for (int number : parseNumbers(numbers)) {
            sub -= number;
        }

        return sub;
    }

    public int multiply(String numbers) {
        int mul = 1;
        for (int number : parseNumbers(numbers)) {
            mul *= number;
        }

        return mul;
    }

    public boolean checkBrackets(String brackets) {
        int bracketCounter = 0;
        for (char bracket : brackets.toCharArray()) {
            switch (bracket) {
                case '{':
                    bracketCounter++;
                    break;
                case '}':
                    bracketCounter--;
                    break;
                default:
                    throw new IllegalArgumentException("Wrong parameter, only { or } is allowed");
            }
        }
        return bracketCounter == 0;
    }

    private int[] parseNumbers(String numberString) {
        // remove new lines from string
        numberString = numberString.replace("\n", ",");

        String[] numbers = numberString.split(",");

        int[] convertedNumbers = new int[numbers.length];

        for (int i = 0; i < convertedNumbers.length; i++) {
            convertedNumbers[i] = Integer.parseInt(numbers[i]);
        }

        return convertedNumbers;
    }
}
