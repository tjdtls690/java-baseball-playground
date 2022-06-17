public class StringCalculateMain {
    private StringCalculatorUtils stringCalculatorUtils;

    public StringCalculateMain() {
        stringCalculatorUtils = new StringCalculatorUtils();
    }

    int StringCalculate(String str){
        String[] values = str.split(" ");
        int sum = Integer.parseInt(values[0]);
        for(int i = 2; i < values.length; i += 2){
            int currentNum = Integer.parseInt(values[i]);
            char symbol = values[i - 1].charAt(0);
            sum = stringCalculatorUtils.calculateAll(sum, currentNum, symbol);
        }
        return sum;
    }
}
