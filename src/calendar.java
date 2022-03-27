public class calendar {

    private static final int[] MAX_DAYS = {31,28,31,30,31,30,31,31,30,31,30,31};

    public int getMaxDaysOfMonth(int month) {
        return MAX_DAYS[month - 1];
    }

    public void SampleCalendar(int year, int month) {
        System.out.printf("\t\t<<%3d년 %3d월>>\n",year,month);
        System.out.println("\t일\t월\t화\t수\t목\t금\t토");
        System.out.println("\t--------------------------");
        int maxDay = getMaxDaysOfMonth(month);

        for (int i=1; i<= maxDay; i++) {
            System.out.printf("\t%d",i);
            if (i % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();

//        System.out.println("\t1\t2\t3\t4\t5\t6\t7");
//        System.out.println("\t8\t9\t10\t11\t12\t13\t14");
//        System.out.println("\t15\t16\t17\t18\t19\t20\t21");
//        System.out.println("\t22\t23\t24\t25\t26\t27\t28");
    }

}