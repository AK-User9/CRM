package crm.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StatusTest {

    @Test
    public void testStatusEnumValues() {
        // Test all enum values exist
        assertNotNull(Status.PROPOSED);
        assertNotNull(Status.NEGOTIATED);
        assertNotNull(Status.IMPLEMENTED);
        assertNotNull(Status.DONE);
    }

    @Test
    public void testStatusEnumCount() {
        // Test that there are exactly 4 enum values
        Status[] values = Status.values();
        assertEquals(4, values.length);
    }

    @Test
    public void testStatusALLArray() {
        // Test the ALL static field
        assertNotNull(Status.ALL);
        assertEquals(4, Status.ALL.length);
        assertArrayEquals(new Status[]{Status.PROPOSED, Status.NEGOTIATED, Status.IMPLEMENTED, Status.DONE}, Status.ALL);
    }

    @Test
    public void testStatusValueOf() {
        // Test valueOf method
        assertEquals(Status.PROPOSED, Status.valueOf("PROPOSED"));
        assertEquals(Status.NEGOTIATED, Status.valueOf("NEGOTIATED"));
        assertEquals(Status.IMPLEMENTED, Status.valueOf("IMPLEMENTED"));
        assertEquals(Status.DONE, Status.valueOf("DONE"));
    }

    @Test
    public void testStatusValueOfInvalid() {
        // Test valueOf with invalid string
        assertThrows(IllegalArgumentException.class, () -> {
            Status.valueOf("INVALID");
        });
    }

    @Test
    public void testStatusValueOfNull() {
        // Test valueOf with null
        assertThrows(NullPointerException.class, () -> {
            Status.valueOf(null);
        });
    }

    @Test
    public void testStatusName() {
        // Test name() method
        assertEquals("PROPOSED", Status.PROPOSED.name());
        assertEquals("NEGOTIATED", Status.NEGOTIATED.name());
        assertEquals("IMPLEMENTED", Status.IMPLEMENTED.name());
        assertEquals("DONE", Status.DONE.name());
    }

    @Test
    public void testStatusOrdinal() {
        // Test ordinal() method
        assertEquals(0, Status.PROPOSED.ordinal());
        assertEquals(1, Status.NEGOTIATED.ordinal());
        assertEquals(2, Status.IMPLEMENTED.ordinal());
        assertEquals(3, Status.DONE.ordinal());
    }

    @Test
    public void testStatusEquality() {
        // Test enum equality
        assertEquals(Status.PROPOSED, Status.PROPOSED);
        assertNotEquals(Status.PROPOSED, Status.NEGOTIATED);
        assertTrue(Status.DONE == Status.DONE);
        assertFalse(Status.IMPLEMENTED == Status.NEGOTIATED);
    }
}
