package sample;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DateSorterImplTest {
    private static final LocalDate FIRST_JULY = LocalDate.of(2005, 7, 1);
    private static final LocalDate SECOND_JANUARY = LocalDate.of(2005, 1, 2);
    private static final LocalDate FIRST_JANUARY = LocalDate.of(2005, 1, 1);
    private static final LocalDate THIRD_MAY = LocalDate.of(2005, 5, 3);
    private static final LocalDate SECOND_JULY = LocalDate.of(2005, 7, 2);
    private static final LocalDate TENTH_JULY = LocalDate.of(2005, 7, 10);
    private static final LocalDate FIRST_OCTOBER = LocalDate.of(2005, 10, 1);
    private static final LocalDate FIFTH_OCTOBER = LocalDate.of(2005, 10, 5);
    private static final LocalDate LESS_YEAR = LocalDate.of(2000, 10, 5);
    private static IDateSorter sorter;

    @BeforeAll
    static void beforeAll() {
        sorter = new DateSorterImpl();
    }

    @Test
    public void sortDatesFromTaskOk() {
        Collection<LocalDate> actualDates = sorter.sortDates(getUnsortedDatesFromTask());
        Collection<LocalDate> expectedDatesFromTask = getExpectedDatesFromTask();
        Assertions.assertEquals(expectedDatesFromTask, actualDates);
    }

    @Test
    public void sortCustomDatesOk() {
        Collection<LocalDate> actualDates = sorter.sortDates(getUnsortedCustomDates());
        Collection<LocalDate> expectedCustomDates = getExpectedCustomDates();
        Assertions.assertEquals(expectedCustomDates, actualDates);
    }

    @Test
    public void sortWithNullDatesNotOk() {
        Assertions.assertThrows(RuntimeException.class, () -> sorter.sortDates(null));
    }

    private List<LocalDate> getUnsortedDatesFromTask() {
        return List.of(FIRST_JULY, SECOND_JANUARY, FIRST_JANUARY, THIRD_MAY);
    }

    private Collection<LocalDate> getExpectedDatesFromTask() {
        return List.of(FIRST_JANUARY, SECOND_JANUARY, FIRST_JULY, THIRD_MAY);
    }

    private List<LocalDate> getUnsortedCustomDates() {
        return List.of(FIRST_JULY, SECOND_JANUARY, FIRST_JANUARY,
                THIRD_MAY, SECOND_JULY, TENTH_JULY, FIFTH_OCTOBER, FIRST_OCTOBER, LESS_YEAR);
    }

    private Collection<LocalDate> getExpectedCustomDates() {
        return List.of(LESS_YEAR, FIRST_JANUARY, SECOND_JANUARY, FIRST_OCTOBER, FIFTH_OCTOBER,
                TENTH_JULY, SECOND_JULY, FIRST_JULY, THIRD_MAY);
    }
}