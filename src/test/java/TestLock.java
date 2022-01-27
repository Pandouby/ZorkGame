import org.junit.jupiter.api.Test;
import zork.Item;
import zork.Lock;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestLock {

    @Test
    public void testLockUnlock() {
        Item key = new Item("key", "key", 1, 0, 0);
        Lock lock = new Lock(key);

        assertFalse(lock.lockUnlock(key));
    }
}
