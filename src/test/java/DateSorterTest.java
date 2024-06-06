import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class DateSorterTest {
    private final DateSorter dateSorter = new DateSorter();

    @Test
    public void testSortMixedDates() {
        List<LocalDate> unsortedDates = Arrays.asList(
                LocalDate.of(2002, 1, 15), // January
                LocalDate.of(2002, 5, 15), // May
                LocalDate.of(2002, 5, 13), // May
                LocalDate.of(2002, 5, 11), // May
                LocalDate.of(2002, 3, 10), // March
                LocalDate.of(2002, 3, 11), // March
                LocalDate.of(2002, 3, 12), // March
                LocalDate.of(2002, 6, 10), // June
                LocalDate.of(2002, 4, 5),  // April
                LocalDate.of(2002, 7, 5)   // July
        );

        Collection<LocalDate> result = dateSorter.sortDates(unsortedDates);
        List<LocalDate> expected = Arrays.asList(
                LocalDate.of(2002, 1, 15),
                LocalDate.of(2002, 3, 10),
                LocalDate.of(2002, 3, 11),
                LocalDate.of(2002, 3, 12),
                LocalDate.of(2002, 4, 5),
                LocalDate.of(2002, 7, 5),
                LocalDate.of(2002, 6, 10),
                LocalDate.of(2002, 5, 15),
                LocalDate.of(2002, 5, 13),
                LocalDate.of(2002, 5, 11)
        );

        assertEquals(expected, result);
    }
    @Test
    public void testSortEmptyList() {
        List<LocalDate> unsortedDates = Arrays.asList();

        Collection<LocalDate> result = dateSorter.sortDates(unsortedDates);
        List<LocalDate> expected = Arrays.asList();

        assertEquals(expected, result);
    }

}
