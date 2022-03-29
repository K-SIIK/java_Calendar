import java.util.Scanner;

public class Prompt {

    public int parseDay(String week) {
        switch(week) {
            default : return 0;
            case "mo" : return 1;
            case "tu" : return 2;
            case "we" : return 3;
            case "th" : return 4;
            case "fr" : return 5;
            case "sa" : return 6;
        }
    }

    public void runPrompt() {
        Scanner scanner = new Scanner(System.in);
        Calendar cal = new Calendar(); // Calendar 클래스의 다른 method 도 가져다 쓸 수 있도록 하기 위함..?

        while (true) {
            System.out.println("년을 입력하세요.");
            System.out.print("year> ");
            int year = scanner.nextInt();
            if (year <= 0) {
                System.out.println("bye");
                break;
            }

            System.out.println("월을 입력하세요.");
            System.out.print("month> ");
            int month = scanner.nextInt();

            if (month <= 0 || month > 12) {
                System.out.println("잘못 입력하셨습니다.(1 - 12)");
                continue;
            }

            cal.printCalendar(year,month);
        }
    }

    public static void main(String[] args) {
        Prompt p = new Prompt();
        p.runPrompt();
    }
}