package sample;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DateSorterImpl implements IDateSorter {
    @Override
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        return unsortedDates.stream()
                .sorted(new DateComparator())
                .collect(Collectors.toList());
    }

    public static class DateComparator implements Comparator<LocalDate> {
        public static final String REGEX = "r";

        @Override
        public int compare(LocalDate firstDate, LocalDate secondDate) {
            if (firstDate.getYear() == secondDate.getYear()) {
                if (firstDate.getMonth().equals(secondDate.getMonth())
                        && firstDate.getMonth().name().contains(REGEX.toUpperCase())) {
                    return firstDate.getDayOfMonth() - secondDate.getDayOfMonth();
                }
                if (firstDate.getMonth().equals(secondDate.getMonth())) {
                    return secondDate.getDayOfMonth() - firstDate.getDayOfMonth();
                }
                if (firstDate.getMonth().name().contains(REGEX.toUpperCase())
                        && secondDate.getMonth().name().contains(REGEX.toUpperCase())) {
                    return firstDate.getMonth().compareTo(secondDate.getMonth());
                }
                if (!firstDate.getMonth().name().contains(REGEX.toUpperCase())
                        && !secondDate.getMonth().name().contains(REGEX.toUpperCase())) {
                    return secondDate.getMonth().compareTo(firstDate.getMonth());
                }
                if (firstDate.getMonth().name().contains(REGEX.toUpperCase())) {
                    return -1;
                }
                if (secondDate.getMonth().name().contains(REGEX.toUpperCase())) {
                    return 1;
                }
            }
            return firstDate.getYear() - secondDate.getYear();
        }

    }
}
