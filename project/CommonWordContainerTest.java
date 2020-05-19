

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.PriorityQueue;

public class CommonWordContainerTest {
   
    @Test
    public void testAdd() {
        CommonWordContainer c = new CommonWordContainer();
        c.add("of");
        c.add("an");
        c.add("the");
        assertEquals("an",c.getCommonWord(0));
        assertEquals("of",c.getCommonWord(1));
        assertEquals("the",c.getCommonWord(2));
    }
    
    @Test
    public void testCommonWordSize() {
        CommonWordContainer c = new CommonWordContainer();
        c.add("of");
        c.add("an");
        c.add("the");
        c.add("or");
        c.add("and");
        c.add("at");
        assertEquals(6, c.commonWordSize());
    }
    
    @Test
    public void testGetStringArray() {
        CommonWordContainer c = new CommonWordContainer();
        c.add("of");
        c.add("an");
        c.add("the");
        String[] array = {"an", "of", "the"};
        assertArrayEquals(array, c.getStringArray());
    }
    
    @Test
    public void testGetCommonWord() {
        CommonWordContainer c = new CommonWordContainer();
        c.add("home");
        c.add("a");
        c.add("the");
        assertEquals("a",c.getCommonWord(0));
        assertEquals("home",c.getCommonWord(1));
        assertEquals("the",c.getCommonWord(2));
    }
}
