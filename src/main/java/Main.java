import java.time.LocalDate;
import java.util.List;
import sample.DateSorterImpl;
import sample.IDateSorter;

public class Main {
    public static void main(String[] args) {
        LocalDate firstJuly = LocalDate.of(2005, 7, 1);
        LocalDate secondJanuary = LocalDate.of(2005, 1, 2);
        LocalDate firstJanuary = LocalDate.of(2005, 1, 1);
        LocalDate thirdMay = LocalDate.of(2005, 5, 3);
        List<LocalDate> dates = List.of(firstJuly, secondJanuary, firstJanuary, thirdMay);
        System.out.println("Before sorting:" + System.lineSeparator() + dates);

        IDateSorter sorter = new DateSorterImpl();
        System.out.println("After sorting:" + System.lineSeparator() + sorter.sortDates(dates));
        System.out.println();

        LocalDate secondJuly = LocalDate.of(2005, 7, 2);
        LocalDate tenthJuly = LocalDate.of(2005, 7, 10);
        LocalDate firstOctober = LocalDate.of(2005, 10, 1);
        LocalDate fifthOctober = LocalDate.of(2005, 10, 5);
        LocalDate lessYear = LocalDate.of(2000, 10, 5);
        List<LocalDate> dates2 = List.of(firstJuly, secondJanuary, firstJanuary,
                thirdMay, secondJuly, tenthJuly, fifthOctober, firstOctober, lessYear);
        System.out.println("Before sorting:" + System.lineSeparator() + dates2);
        System.out.println("After sorting:" + System.lineSeparator() + sorter.sortDates(dates2));
    }
}
