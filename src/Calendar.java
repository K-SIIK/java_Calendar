public class Calendar {

    private static final int[] MAX_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] LEAP_MAX_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int maxDaysOfMonth(int year, int month) {
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            return LEAP_MAX_DAYS[month];
        } else {
            return MAX_DAYS[month];
        }
    }


    public void printCalendar(int year, int month) {
        System.out.printf("\t\t<<%4d년 %3d월>>\n", year, month);
        System.out.println("\tSU\tMO\tTU\tWE\tTH\tFR\tSA");
        System.out.println("\t--------------------------");

        int maxDays = maxDaysOfMonth(year, month);

//        int yearWeekday = (year + (((year - 1) / 4) - ((year - 1) / 100) + ((year - 1) / 400))) % 7;
//
//        int monthWeekday = 0;
//        for (int i = 1; i < month; i++) {
//            monthWeekday += maxDaysOfMonth(year, i);
//        }
//        int weekday = (yearWeekday + monthWeekday) % 7;


        int weekday = getWeekday(year, month);


        int cnt = 7 - weekday;
        if (weekday == 0) {
            cnt = 0;
        }

        // get weekday automatically
        for (int k = 0; k < weekday; k++) {
            System.out.print("\t");
        }

        for (int j = 1; j <= 7 - weekday; j++) {
            System.out.printf("\t%d", j);
        }
        System.out.println();

        for (int i = 8 - weekday; i <= maxDays; i++) {
            System.out.printf("\t%d", i);
            if (i % 7 == cnt) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();
    }

    private int getWeekday(int year, int month) {
        int yearSum = 1; // 1년 1월 1일 월요일(1)

        for (int i=1; i<year; i++) {
            for (int j=1; j<13; j++) {
                yearSum += maxDaysOfMonth(i, j);
            }
        }

        int monthSum = 0;
        for (int j=1; j<month; j++) {
            monthSum += maxDaysOfMonth(year,j);
        }

        return (yearSum + monthSum) % 7;
    }
}

