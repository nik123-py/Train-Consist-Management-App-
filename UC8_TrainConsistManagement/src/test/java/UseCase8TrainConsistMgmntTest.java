import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase8TrainConsistMgmntTest {

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = Arrays.asList(
                new UseCase8TrainConsistMgmnt.Bogie("A", 80),
                new UseCase8TrainConsistMgmnt.Bogie("B", 50)
        );

        List<UseCase8TrainConsistMgmnt.Bogie> result =
                UseCase8TrainConsistMgmnt.filterBogies(bogies, 70);

        assertEquals(1, result.size());
        assertEquals("A", result.get(0).name);
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = Arrays.asList(
                new UseCase8TrainConsistMgmnt.Bogie("A", 70)
        );

        List<UseCase8TrainConsistMgmnt.Bogie> result =
                UseCase8TrainConsistMgmnt.filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = Arrays.asList(
                new UseCase8TrainConsistMgmnt.Bogie("A", 20)
        );

        List<UseCase8TrainConsistMgmnt.Bogie> result =
                UseCase8TrainConsistMgmnt.filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = Arrays.asList(
                new UseCase8TrainConsistMgmnt.Bogie("A", 80),
                new UseCase8TrainConsistMgmnt.Bogie("B", 90)
        );

        List<UseCase8TrainConsistMgmnt.Bogie> result =
                UseCase8TrainConsistMgmnt.filterBogies(bogies, 70);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();

        List<UseCase8TrainConsistMgmnt.Bogie> result =
                UseCase8TrainConsistMgmnt.filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("A", 80));

        List<UseCase8TrainConsistMgmnt.Bogie> result =
                UseCase8TrainConsistMgmnt.filterBogies(bogies, 70);

        assertEquals(1, bogies.size());
    }
}
