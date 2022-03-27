import java.util.Scanner;

public class Prompt {

    private final static String PROMPT = "cal> ";

    public void runPrompt() {
        Scanner scanner = new Scanner(System.in);
        calendar cal = new calendar();
        int[] maxDays = {31,28,31,30,31,30,31,31,30,31,30,31};

        while (true) {
            System.out.println("달을 입력하세요.");
            System.out.print(PROMPT);
            int month = scanner.nextInt();
            if (month == -1) {
                System.out.println("Bye");
                break;
            }
            cal.SampleCalendar(2022, month);
        }
    }

    public static void main(String[] args) {
        Prompt p = new Prompt();
        p.runPrompt();
    }
}
