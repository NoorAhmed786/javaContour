public class SimpleCAlculator {
    public static String calculate(int num1,int num2, String operator ) {
        if (operator.equals("+")) {
            return String.valueOf(num1 + num2);

        } else if (operator.equals("-")) {
            return String.valueOf(num1 - num2);
        } else if (operator.equals("*")) {
            return String.valueOf(num1 * num2);

        } else if (operator.equals("/")) {
            return String.valueOf(num1 / num2);
        }else {
            return "Invalid operator";
        }

    }

}
