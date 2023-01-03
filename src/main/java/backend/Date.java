package backend;

public class Date {
    private int day;
    private int month;
    private int year;

    private static int daysInMonth[] = {
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    private static String[] italianMonths = {
            "gennaio", "febbraio", "marzo", "aprile",
            "maggio", "giugno", "luglio", "agosto",
            "settembre", "ottobre", "novembre", "dicembre"
    };

    public Date(int day, int month, int year) throws Exception {
        this.day = day;
        this.month = month;
        this.year = year;

        if (month < 1 || month > 12
                || day < 1 || day > daysInMonth(month, year)
                || year < 1920)
            throw new Exception("data illegale!");
    }

    public Date(){

    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }

    public boolean equals(Date other) {
        return this.day == other.day
                && this.month == other.month
                && this.year == other.year;
    }

    //maggiore se this viene dopo di other

    public int compareTo(Date other) {
        int diff = year - other.year;
        if (diff != 0)
            return diff;

        diff = month - other.month;
        if (diff != 0)
            return diff;

        return day - other.day;
    }

    private static int daysInMonth(int month, int year) {
        if (month == 2 && isLeapYear(year))
            return 29;
        else
            return daysInMonth[month - 1];
    }

    private static boolean isLeapYear(int year) {
        return year % 4 == 0 &&
                (year % 100 != 0 || year % 400 == 0);
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public static int[] getDaysInMonth() {
        return daysInMonth;
    }

    public static String[] getItalianMonths() {
        return italianMonths;
    }


}
