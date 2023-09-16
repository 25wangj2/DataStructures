package calculator;
public class CalculatorModel {
    private static String num1 = "0";
    private static String op = "  ";
    private static String num2 = "";
    public static boolean num(String n) {
        if (op.isEmpty()) {
            return false;
        }
        if (op.equals("  ")) {
            num1 = n;
            op = " ";
        } else if (op.equals(" ")) {
            num1 += n;
        } else {
            num2 += n;
        }
        return true;
    }
    public static void clear() {
        num1 = "0";
        op = "  ";
        num2 = "";
    }
    public static boolean eval() {
        if (op.isBlank()) {
            op = "";
            return true;
        }
        if (num2.isEmpty() || op.equals("÷") && Integer.parseInt(num2) == 0) {
            return false;
        }
        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);
        num1 = switch (op) {
            case "+" -> Integer.toString(n1 + n2);
            case "-" -> Integer.toString(n1 - n2);
            case "×" -> Integer.toString(n1 * n2);
            case "÷" -> Integer.toString(n1 / n2);
            default -> "0";
        };
        op = "";
        num2 = "";
        return true;
    }
    public static boolean setOp(String o) {
        if (!op.isBlank()) {
            return false;
        }
        op = o;
        return true;
    }
    public static String getNum1() {
        return num1;
    }
    public static String getOp() {
        return op;
    }
    public static String getNum2() {
        return num2;
    }
}
