

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class WebsiteTest {
   
    @Test
    public void testIncreaseNumberofkeywordmatched() {
        Website w = new Website("www.facbook.com", "high", "fb.txt", 2);
        w.increaseNumberofkeywordmatched();
        assertEquals(3, w.getNumberofkeywordmatched());
    }
    
    @Test
    public void testGetRatingNumber() {
        Website w1 = new Website("www.facbook.com", "high", "fb.txt", 2);
        Website w2 = new Website("www.abc.com", "low", "fb.txt", 2);
        Website w3 = new Website("www.cnn.com", "medium", "fb.txt", 2);
        assertEquals(3, w1.getRatingNumber());
        assertEquals(1, w2.getRatingNumber());
        assertEquals(2, w3.getRatingNumber());
    }
}
