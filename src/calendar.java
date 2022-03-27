public class calendar {

    private static final int[] MAX_DAYS = {31,28,31,30,31,30,31,31,30,31,30,31};
    private static final int[] LEAP_MAX_DAYS = {31,29,31,30,31,30,31,31,30,31,30,31};

    public boolean isLeapYear(int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return true;
        }
        else {
            return false;
        }
    }

    public int getMaxDaysOfMonth(int year, int month) {
        if (isLeapYear(year)) {
            return LEAP_MAX_DAYS[month - 1];
        }
        else
            return MAX_DAYS[month - 1];

    }

    public void SampleCalendar(int year, int month, int weekday) {
        System.out.printf("\t\t<<%3d년 %3d월>>\n",year,month);
        System.out.println("\tSU\tMO\tTU\tWE\tTH\tFR\tSA");
        System.out.println("\t--------------------------");

        int maxDay = getMaxDaysOfMonth(year, month);
        int cnt = 7 - weekday;
        if (weekday == 0) cnt = 0;


        for (int j=0; j<weekday; j++) {
            System.out.print("\t");
        }

        for (int k=1; k<=7-weekday; k++) {
            System.out.printf("\t%d", k);
        }
        System.out.println();

        for (int i = 8-weekday; i <= maxDay; i++) {
            System.out.printf("\t%d", i);
            if (i % 7 == cnt) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();

    }

}