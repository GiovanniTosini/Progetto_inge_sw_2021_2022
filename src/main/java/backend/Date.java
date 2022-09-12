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
                || year < 1600)
            throw new Exception("data illegale!");
    }

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }

    public boolean equals(Date other) {
        return this.day == other.day
                && this.month == other.month
                && this.year == other.year;
    }

    public int compareTo(Date other) {
        //maggiore se this viene dopo di other
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
}
