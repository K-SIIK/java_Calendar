// Calendar

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Calendar {
    public static final int[] MAX_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static final int[] LEAP_MAX_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private HashMap <Date, String> planMap;

    public Calendar() {
        planMap = new HashMap<Date, String>();
    }

    public void registerPlan(String strDate, String plan) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
        planMap.put(date, plan);
    }

    public String searchPlan(String strDate) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
        String plan = planMap.get(date);
        return plan;
    }

    public int maxDaysOfMonth(int year, int month) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return LEAP_MAX_DAYS[month];
        }

        else {
            return MAX_DAYS[month];
        }
    }

    public void printCalendar(int year, int month) {
        System.out.printf("\t\t<<%d년 %d월>>\n", year, month);
        System.out.println("\tSU\tMO\tTU\tWE\tTH\tFR\tSA");
        System.out.println("\t--------------------------");


        int maxDay = maxDaysOfMonth(year, month);
        int weekday = getWeekdays(year, month);

        for (int i=0; i<weekday; i++) {
            System.out.print("\t");
        }

        for (int j=1; j<=7-weekday; j++) {
            System.out.printf("\t%d", j);
        }
        System.out.println();

        int cnt = 7 - weekday;
        if (cnt == 7) {
            cnt = 0;
        }

        for (int k=8-weekday; k<=maxDay; k++) {
            System.out.printf("\t%d",k);
            if (k % 7 == cnt) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();
    }

    public int getWeekdays(int year, int month) {
        int initialDay = 1; // 1년 1월 1일이 월요일 기준 잡음

        // 년
        int yearSum = 0;
        for (int i=1; i<year; i++) {
            for (int j=1; j<=12; j++) {
                yearSum += maxDaysOfMonth(i,j);
            }
        }

        // 월
        int monthSum = 0;
        for (int k=1; k<month; k++) {
            monthSum += maxDaysOfMonth(year, k);
        }

        return (initialDay + yearSum + monthSum) % 7;
    }

    public static void main(String[] args) throws ParseException {
        Calendar cal = new Calendar();

        System.out.println(cal.getWeekdays(1970,1) == 4);
        System.out.println(cal.getWeekdays(1971,1) == 5);
        System.out.println(cal.getWeekdays(1972,1) == 6);
        System.out.println(cal.getWeekdays(1973,1) == 1);
        System.out.println(cal.getWeekdays(1974,1) == 2);
        cal.registerPlan("2022-04-05","Let's have a dinner");
        System.out.println(cal.searchPlan("2022-04-05").equals("Let's have a dinner"));
    }
}