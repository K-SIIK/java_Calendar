import java.util.Scanner;

public class Prompt {
//    public int parseWeek(String week) {
//        switch (week) {
//            case "mo" : return 1;
//            case "tu" : return 2;
//            case "we" : return 3;
//            case "th" : return 4;
//            case "fr" : return 5;
//            case "sa" : return 6;
//            default : return 0;
//        }
//    }

    public void runPrompt() {
        Scanner scanner = new Scanner(System.in);
        Calendar cal = new Calendar();

        while (true) {
            System.out.println("년을 입력하세요.");
            System.out.print("year> ");
            int year = scanner.nextInt();
            if (year < 1) {
                System.out.println("bye");
                break;
            }

            System.out.println("월을 입력하세요.");
            System.out.print("month> ");
            int month = scanner.nextInt();

            if (month < 1 || month > 12) {
                System.out.println("다시 입력");
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