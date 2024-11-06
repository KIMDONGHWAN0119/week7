import java.util.Scanner;

public class Calculator {

    double sum;
    int index = 0;
    String[] arr = new String[5];

    public static void main(String[] args) {

        //----------------------------------- 참조형 변수
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();
        //-----------------------------------

        //-----------------------------------
        Object result = 0;
        char whether;
        char operator;
        double num1;
        double num2;
        //-----------------------------------


        while(true){
            System.out.println("각 피, 연산자마다 띄워쓰기를 해주세요.");
            System.out.print("계산식 입력 (Ex : 1 + 1) : ");

            num1 = sc.nextDouble();

            if ( num1 == 0 ){ System.out.println("피 연산자 1에 0값을 넣을 수 없습니다. 프로그램을 종료합니다."); break; }

            operator = sc.next().charAt(0);

            num2 = sc.nextDouble();

            switch (operator) {
                case '+': result = calc.add(num1, num2); break;
                case '-': result = calc.sub(num1, num2); break;
                case '*': result = calc.mul(num1, num2); break;
                case '/': result = calc.div(num1, num2); break;
                default: System.out.print("Error"); break;
            }

            System.out.println(result);

            System.out.print("값을 저장하거나 기록을 보시겠습니까? (프로그램 종료 시 휘발) Y/N/기록(0)/종료(E) : ");

            whether = sc.next().charAt(0);

            calc.record(whether, result);
        }

    }

    void record( char whether, Object result){

        if(whether=='Y') {
            arr_fun(result+"");
        }else if('0' == whether ) {
            for(int i=0;i<arr.length;i++){
                if(arr[i] != null){
                    System.out.println((i+1) + " : " + arr[i]);
                }else{
                    System.out.println((i+1) + " : 비어있음");
                }
            }
            System.out.println("최대 5번까지 저장됩니다.");

        }else if(whether=='E'){
            System.exit(0);
        }
    }

    void arr_fun(String str){
        arr[index] = str;
        index++;
        if (index == 5) index = 0;
    }

    int decimaPoint(double a, double b) {
        return ( (a+b) % 1 != 0) ? 1 : 0;
    }

    Object add(double a, double b){

        if (decimaPoint(a,b) == 0){
            sum = a + b;
            return (int)sum;
        }else{
            return a + b;
        }
    }

    Object sub(double a, double b){

        if (decimaPoint(a, b) == 0){
            sum = a - b;
            return (int)sum;
        }else{
            return a - b;
        }
    }

    Object mul(double a, double b){

        if (decimaPoint(a, b) == 0){
             sum = a * b;
            return (int)sum;
        }else{
            return a * b;
        }
    }

    Object div(double a, double b){
        int result;
        result = ( (a/b) % 1 != 0) ? 1 : 0;
        if (result == 0){
            sum = a / b;
            return (int)sum;
        }else{
            return a / b;
        }
    }

}
