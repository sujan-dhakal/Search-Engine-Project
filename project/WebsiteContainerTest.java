
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WebsiteContainerTest {
    
    @Test
    public void testAdd() {
        WebsiteContainer wc= new WebsiteContainer();
        Website w1 = new Website("www.facbook.com", "high", "fb.txt", 2);
        Website w2 = new Website("www.abc.com", "low", "abc.txt", 2);
        Website w3 = new Website("www.cnn.com", "medium", "cnn.txt", 2);
        wc.add(w1);
        wc.add(w2);
        wc.add(w3);
        assertEquals(w1, wc.getWebsite(0));
        assertEquals(w2, wc.getWebsite(1));
        assertEquals(w3, wc.getWebsite(2));
    }
    
    @Test
    public void testWebsiteNumber() {
        WebsiteContainer wc= new WebsiteContainer();
        Website w1 = new Website("www.facbook.com", "high", "fb.txt", 2);
        Website w2 = new Website("www.abc.com", "low", "abc.txt", 2);
        Website w3 = new Website("www.cnn.com", "medium", "cnn.txt", 2);
        Website w4 = new Website("www.ted.com", "medium", "ted.txt", 2);
        wc.add(w1);
        wc.add(w2);
        wc.add(w3);
        wc.add(w4);
        assertEquals(4, wc.websiteNumber());
    }
    
    @Test
    public void testGetWebsite() {
        WebsiteContainer wc= new WebsiteContainer();
        Website w1 = new Website("www.facbook.com", "high", "fb.txt", 2);
        Website w2 = new Website("www.abc.com", "low", "fb.txt", 2);
        Website w3 = new Website("www.cnn.com", "medium", "fb.txt", 2);
        Website w4 = new Website("www.ted.com", "medium", "fb.txt", 2);
        wc.add(w1);
        wc.add(w2);
        wc.add(w3);
        wc.add(w4);
        assertEquals(w1, wc.getWebsite(0));
        assertEquals(w2, wc.getWebsite(1));
        assertEquals(w3, wc.getWebsite(2));
        assertEquals(w4, wc.getWebsite(3));
    }
}
