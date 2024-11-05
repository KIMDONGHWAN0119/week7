import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();
        Object result = 0;

        System.out.print("연산자 선택 (+, -, *, / ) :");
        char operator = sc.next().charAt(0);

        System.out.print("피연산자 1 입력 : ");
        double num1 = sc.nextDouble();

        System.out.print("피연산자 2 입력 : ");
        double num2 = sc.nextDouble();

        switch (operator) {
            case '+': result = calc.add(num1, num2); break;
            case '-': result = calc.sub(num1, num2); break;
            case '*': result = calc.mul(num1, num2); break;
            case '/': result = calc.div(num1, num2); break;
            default: System.out.print("Error"); break;
        }

        System.out.println(result);
    }

    int decimaPoint(double a, double b) {
        return ( (a+b) % 1 != 0) ? 1 : 0;
    }



    Object add(double a, double b){
        int result = decimaPoint(a, b);
        if (result == 0){
            double sum = a + b;
            return (int)sum;
        }else{
            return a + b;
        }
    }

    Object sub(double a, double b){
        int result = decimaPoint(a, b);
        if (result == 0){
            double sum = a - b;
            return (int)sum;
        }else{
            return a - b;
        }
    }

    Object mul(double a, double b){
        int result = decimaPoint(a, b);
        if (result == 0){
            double sum = a * b;
            return (int)sum;
        }else{
            return a * b;
        }
    }

    Object div(double a, double b){
        int result;
        result = ( (a/b) % 1 != 0) ? 1 : 0;
        if (result == 0){
            double sum = a / b;
            return (int)sum;
        }else{
            return a / b;
        }
    }

}
