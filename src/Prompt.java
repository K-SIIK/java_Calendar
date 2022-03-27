
import java.util.Scanner;

public class Prompt {

    public int parseDay(String week) {
        switch (week) {
            case "su":
                return 0;
            case "mo":
                return 1;
            case "tu":
                return 2;
            case "we":
                return 3;
            case "th":
                return 4;
            case "fr":
                return 5;
            case "sa":
                return 6;
            default:
                return 0;
        }
    }

//    private final static String PROMPT = "cal> ";

    public void runPrompt() {
        Scanner scanner = new Scanner(System.in);
        calendar cal = new calendar();
//        int[] maxDays = {31,28,31,30,31,30,31,31,30,31,30,31};


        while (true) {
            System.out.println("연도를 입력하세요.");
            System.out.print("YEAR> ");
            int year = scanner.nextInt();
            if (year == -1) {
                System.out.println("Bye");
                break;
            }

            System.out.println("달을 입력하세요.");
            System.out.print("MONTH> ");
            int month = scanner.nextInt();

            System.out.println("첫번째 요일을 입력하세요.");
            System.out.print("week> ");
            String str_weekday = scanner.next();
            int weekday = parseDay(str_weekday);

            if (month < 1 | month > 12) {
                System.err.println("잘못 입력하셨습니다.");
                continue;
            }
            cal.SampleCalendar(year, month, weekday);
        }
    }

    public static void main(String[] args) {
        Prompt p = new Prompt();
        p.runPrompt();
    }
}
