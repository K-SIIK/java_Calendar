import java.util.Scanner;

public class calendar {
    public static void main(String[] args) {
        System.out.println("\t일\t월\t화\t수\t목\t금\t토");
        System.out.println("\t--------------------------");
        System.out.println("\t1\t2\t3\t4\t5\t6\t7");
        System.out.println("\t8\t9\t10\t11\t12\t13\t14");
        System.out.println("\t15\t16\t17\t18\t19\t20\t21");
        System.out.println("\t22\t23\t24\t25\t26\t27\t28");

        //월을 입력하면 해당 월의 최대 일수 출력
        System.out.println("월 입력 : ");
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();

        // 최대일수 별로 Array로 정리
        int[] maxDays = {31,28,31,30,31,30,31,31,30,31,30,31};

        System.out.printf("%d월은 %d일까지 있습니다.",month, maxDays[month - 1]);



    }
}