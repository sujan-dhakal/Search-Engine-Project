

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ContentContainerTest {
    
    @Test
    public void testAdd() {
        ContentContainer cc= new ContentContainer();
        UniqueWord u1= new UniqueWord();
        UniqueWord u2= new UniqueWord();
        UniqueWord u3= new UniqueWord();
        UniqueWord u4= new UniqueWord();
        cc.add(u1);
        cc.add(u2);
        cc.add(u3);
        cc.add(u4);
        assertEquals(u1, cc.getContent(0));
        assertEquals(u2, cc.getContent(1));
        assertEquals(u3, cc.getContent(2));
        assertEquals(u4, cc.getContent(3));
    }
    
    @Test
    public void testGetContentSize() {
        ContentContainer cc= new ContentContainer();
        UniqueWord u1= new UniqueWord();
        UniqueWord u2= new UniqueWord();
        UniqueWord u3= new UniqueWord();
        UniqueWord u4= new UniqueWord();
        UniqueWord u5= new UniqueWord();
        cc.add(u1);
        cc.add(u2);
        cc.add(u3);
        cc.add(u4);
        cc.add(u5);
        assertEquals(5, cc.getContentSize());    
    }
    
    @Test
    public void testGetContent() {
        ContentContainer cc= new ContentContainer();
        UniqueWord u1= new UniqueWord();
        UniqueWord u2= new UniqueWord();
        UniqueWord u3= new UniqueWord();
        UniqueWord u4= new UniqueWord();
        UniqueWord u5= new UniqueWord();
        UniqueWord u6= new UniqueWord();
        cc.add(u1);
        cc.add(u2);
        cc.add(u3);
        cc.add(u4);
        cc.add(u5);
        cc.add(u6);
        assertEquals(u1, cc.getContent(0));
        assertEquals(u2, cc.getContent(1));
        assertEquals(u3, cc.getContent(2));
        assertEquals(u4, cc.getContent(3));
        assertEquals(u5, cc.getContent(4));
        assertEquals(u6, cc.getContent(5));
    }
}
