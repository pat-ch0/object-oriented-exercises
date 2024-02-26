package exercice4;

public class Date implements Comparable<Date> {
    private final int day;
    private final int month;
    private final int year;

    public Date(int d, int m, int y) {
        if (y < 0) {
            throw new IllegalArgumentException("The year must be positive.");
        }
        if (m < 1 || m > 12) {
            throw new IllegalArgumentException("The month must be between 1 and 12.");
        }
        if (d < 1 || d > 31) {
            throw new IllegalArgumentException("The day must be between 1 and 31.");
        }
        this.year = y;
        this.month = m;
        this.day = d;
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return String.format("%02d-%02d-%04d", getDay(), getMonth(), getYear());
    }
    
    @Override
    public int compareTo(Date other) {
        if (getYear() != other.getYear()) {
            return Integer.compare(getYear(), other.getYear());
        }
        if (getMonth() != other.getMonth()) {
            return Integer.compare(getMonth(), other.getMonth());
        }
        if (getDay() != other.getDay()) {
            return Integer.compare(getDay(), other.getDay());
        }
        return 0;
    }

    public static void main(String[] args) {
        Date date1 = new Date(02, 02, 2022);
        Date date2 = new Date(1, 02, 2022);
        System.out.println(date1);
        System.out.println(date2);

        System.out.println(date1.compareTo(date2));

    }

}