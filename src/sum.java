import java.util.Scanner;

public class sum {
    public static void main(String[] args) {
        System.out.println("두 수를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        String inputValue = sc.nextLine();
        String[] splitValue = inputValue.split(" ");
        int num1 = Integer.parseInt(splitValue[0]);
        int num2 = Integer.parseInt(splitValue[1]);
        System.out.printf("%d와 %d의 합은 %d입니다.",num1, num2, num1 + num2);

    }
}
