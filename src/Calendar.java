public class Calendar {

    public static final int[] MAX_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static final int[] LEAP_MAX_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int maxDaysOfMonth(int year, int month) {
        if ((year % 4 ==0 && year % 100 != 0) || year % 400 == 0) {
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

        int weekday = getWeekday(year, month);

        for (int i=0; i<weekday; i++) {
            System.out.print("\t");
        }

        for (int j=1; j<=7-weekday; j++) {
            System.out.printf("\t%d",j);
        }
        System.out.println();

        int maxDays = maxDaysOfMonth(year, month);
        int cnt = 7 - weekday;
        if (weekday == 0) {
            cnt = 0;
        }

        for (int k=8-weekday; k<=maxDays; k++) {
            System.out.printf("\t%d",k);

            if (k % 7 == cnt) {
                System.out.println();
            }
        }
        System.out.println();
    }


    public int getWeekday(int year, int month) {

        int yearSum = 1; // 1년 1월 1일은 월요일 기준
        for (int i=1; i<year; i++) {
            for (int j=1; j<=12; j++) {
                yearSum += maxDaysOfMonth(i,j);
            }
        }
        int monthSum = 0;
        for (int k=1; k<month; k++) {
            monthSum += maxDaysOfMonth(year,k);
        }

        return (yearSum + monthSum) % 7;
    }

}