package xyz.nowaha.nlib.test;

import org.junit.jupiter.api.Test;
import xyz.nowaha.nlib.utils.TimeUtils;

import java.util.Date;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TimeUtilsTests {

    @Test
    public void testTimeDifferenceToStringSimple() {
        int offset = Math.abs(new Random().nextInt());
        assertEquals("5s", TimeUtils.timeDifferenceToString(new Date(offset), new Date(offset + 5000L)));
        assertEquals("1m, 0s", TimeUtils.timeDifferenceToString(new Date(offset), new Date(offset + 60000L)));
        assertEquals("1m, 5s", TimeUtils.timeDifferenceToString(new Date(offset), new Date(offset + 65000L)));
        assertEquals("1h, 0m, 0s", TimeUtils.timeDifferenceToString(new Date(offset), new Date(offset + 3600000L)));
        assertEquals("1h, 1m, 5s", TimeUtils.timeDifferenceToString(new Date(offset), new Date(offset + 3665000L)));
        assertEquals("1d, 0h, 0m, 0s", TimeUtils.timeDifferenceToString(new Date(offset), new Date(offset + 86400000L)));
        assertEquals("1d, 0h, 0m, 1s", TimeUtils.timeDifferenceToString(new Date(offset), new Date(offset + 86401000L)));
        assertEquals("1d, 0h, 1m, 0s", TimeUtils.timeDifferenceToString(new Date(offset), new Date(offset + 86460000L)));
        assertEquals("1d, 1h, 0m, 0s", TimeUtils.timeDifferenceToString(new Date(offset), new Date(offset + 90000000L)));
        assertEquals("4d, 5h, 48m, 25s", TimeUtils.timeDifferenceToString(new Date(offset), new Date(offset + 366505800L)));
    }

    @Test
    public void testTimeDifferenceToStringRounding() {
        int offset = Math.abs(new Random().nextInt());
        assertEquals("4s", TimeUtils.timeDifferenceToString(new Date(offset), new Date(offset + 4999L)));
        assertEquals("5s", TimeUtils.timeDifferenceToString(new Date(offset), new Date(offset + 5001L)));
        assertEquals("59s", TimeUtils.timeDifferenceToString(new Date(offset), new Date(offset + 59999L)));
        assertEquals("1m, 0s", TimeUtils.timeDifferenceToString(new Date(offset), new Date(offset + 60001L)));
        assertEquals("59m, 59s", TimeUtils.timeDifferenceToString(new Date(offset), new Date(offset + 3599999L)));
        assertEquals("1h, 0m, 0s", TimeUtils.timeDifferenceToString(new Date(offset), new Date(offset + 3600001L)));
        assertEquals("23h, 59m, 59s", TimeUtils.timeDifferenceToString(new Date(offset), new Date(offset + 86399999L)));
        assertEquals("1d, 0h, 0m, 0s", TimeUtils.timeDifferenceToString(new Date(offset), new Date(offset + 86400001L)));
    }

    @Test
    public void testTimeDifferenceToStringEqual() {
        int offset = new Random().nextInt();
        assertEquals("0s", TimeUtils.timeDifferenceToString(new Date(offset), new Date(offset)));
    }

    @Test
    public void testTimeDifferenceToStringWithSecondBeforeFirst() {
        int offset = Math.abs(new Random().nextInt());
        assertThrows(IllegalArgumentException.class, () -> TimeUtils.timeDifferenceToString(new Date(1L), new Date(0L)));
        assertThrows(IllegalArgumentException.class, () -> TimeUtils.timeDifferenceToString(new Date(offset), new Date(offset - 1)));
        assertThrows(IllegalArgumentException.class, () -> TimeUtils.timeDifferenceToString(new Date(offset), new Date(offset - 1000)));
    }

}
