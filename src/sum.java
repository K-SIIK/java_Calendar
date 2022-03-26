import java.util.Scanner;

public class sum {
    public static void main(String[] args) {
        // 입력
        System.out.println("두 수 입력 : ");
        Scanner scanner = new Scanner(System.in);
        String a, b;
        a = scanner.next();
        b = scanner.next();
        System.out.println(a + "+" + b);

        // 출력
        int num1, num2;
        num1 = Integer.parseInt(a);
        num2 = Integer.parseInt(b);
        int result = num1 + num2;
        System.out.println(result);
    }
}