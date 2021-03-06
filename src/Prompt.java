//Prompt

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {
    public void printMenu() {
        System.out.println("+------------------+");
        System.out.println("|   1. 일정 등록 ");
        System.out.println("|   2. 일정 검색 ");
        System.out.println("|   3. 달력 보기 ");
        System.out.println("|   h. 도움말  q. 종료 ");
        System.out.println("+------------------+");
    }

    public int parseInt(String week) {
        switch(week) {
            case "su" : return 0;
            case "mo" : return 1;
            case "tu" : return 2;
            case "we" : return 3;
            case "th" : return 4;
            case "fr" : return 5;
            case "sa" : return 6;
            default: return 0;
        }
    }

    public void runPrompt() throws ParseException {
        printMenu();

        Scanner scanner = new Scanner(System.in);
        Calendar cal = new Calendar();

        boolean isLoop = true;
        while(isLoop) {
            System.out.println("명령 (1, 2, 3, h, q)");
            String cmd = scanner.next();
            switch(cmd) {
                case "1" :
                    cmdRegister(scanner, cal);
                    break;
                case "2" :
                    cmdSearch(scanner, cal);
                    break;
                case "3" :
                    cmdCal(scanner, cal);
                case "h" :
                    printMenu();
                case "q" :
                    isLoop = false;
                    break;
            }
        }
        System.out.println("Thank you. Bye");
        scanner.close();

    }

    private void cmdCal(Scanner s, Calendar c) {

        System.out.println("년을 입력하세요.");
        System.out.print("year> ");
        int year = s.nextInt();

        System.out.println("월을 입력하세요.");
        System.out.print("month> ");
        int month = s.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("잘못 입력하셨습니다.");
            return;
        }
        c.printCalendar(year, month);
    }

    private void cmdSearch(Scanner s, Calendar c) {
        System.out.println("[일정 검색]");
        System.out.println("날짜를 입력해 주세요.(yyyy-MM-dd).");
        String date = s.next();
        String plan = "";
        try {
            plan = c.searchPlan(date);
        } catch (ParseException e) {
            e.printStackTrace();
            System.err.println("일정 검색 중 오류가 발생하였습니다.");
        }
        System.out.println(plan);
    }

    private void cmdRegister(Scanner s, Calendar c) throws ParseException {
        System.out.println("[새 일정 등록]");
        System.out.println("날짜를 입력해 주세요.(yyyy-MM-dd).");
        String date = s.next();
        String text = "";
        s.nextLine();
        System.out.println("일정을 입력해 주세요.");
        text = s.nextLine();

        c.registerPlan(date, text);
    }

    public static void main(String[] args) throws ParseException {
        Prompt p = new Prompt();
        p.runPrompt();
    }
}