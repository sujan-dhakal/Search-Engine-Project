

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UniqueWordTest {
    
    @Test
    public void testAdd() {
        UniqueWord u= new UniqueWord();
        u.add("mother");
        u.add("computer");
        u.add("money");
        assertEquals("mother", u.getUniqueWord(0));
        assertEquals("computer", u.getUniqueWord(1));
        assertEquals("money", u.getUniqueWord(2));
    }
    
    @Test
    public void testGetUniqueWordSize() {
        UniqueWord u= new UniqueWord();
        u.add("mother");
        u.add("computer");
        u.add("money");
        u.add("soil");
        u.add("happy");
        assertEquals(5, u.getUniqueWordSize());
    }
    
    @Test
    public void testGetUniqueWord() {
        UniqueWord u= new UniqueWord();
        u.add("mother");
        u.add("computer");
        u.add("money");
        u.add("soil");
        u.add("happy");
        assertEquals("mother", u.getUniqueWord(0));
        assertEquals("computer", u.getUniqueWord(1));
        assertEquals("money", u.getUniqueWord(2));
        assertEquals("soil", u.getUniqueWord(3));
        assertEquals("happy", u.getUniqueWord(4));
    }
    
    @Test
    public void testContains() {
        UniqueWord u= new UniqueWord();
        u.add("mother");
        u.add("computer");
        u.add("money");
        u.add("soil");
        u.add("happy");
        assertTrue(u.contains("money"));
        assertFalse(u.contains("machine"));
        assertTrue(u.contains("happy"));
        assertFalse(u.contains("32"));
    }
}
