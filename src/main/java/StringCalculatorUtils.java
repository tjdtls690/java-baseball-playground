public class StringCalculatorUtils {
    int add(int a, int b){
        return a + b;
    }

    int subtract(int a, int b){
        return a - b;
    }

    int multiply(int a, int b){
        return a * b;
    }

    int divide(int a, int b){
        return a / b;
    }

    public int calculateAll(int sum, int currentNum, char symbol) {
        if(symbol == '+'){
            return add(sum, currentNum);
        }
        if(symbol == '-'){
            return subtract(sum, currentNum);
        }
        if(symbol == '*'){
            return multiply(sum, currentNum);
        }
        if(symbol == '/'){
            return divide(sum, currentNum);
        }
        return -1;
    }
}
