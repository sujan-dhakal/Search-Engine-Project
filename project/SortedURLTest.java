

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortedURLTest {
    
    @Test
    public void testAdd() {
        SortedURL surl = new SortedURL();
        Website w1 = new Website("www.facbook.com", "high", "fb.txt", 1);
        Website w2 = new Website("www.abc.com", "low", "abc.txt", 2);
        Website w3 = new Website("www.cnn.com", "medium", "fb.txt", 2);
        Website w4 = new Website("www.foxnews.com", "medium", "fb.txt", 1);
        Website w5 = new Website("www.google.com", "high", "fb.txt", 2);
        Website w6 = new Website("www.orange.com", "low", "fb.txt", 3);
        surl.add(w1);
        surl.add(w2);
        surl.add(w3);
        surl.add(w4);
        surl.add(w5);
        surl.add(w6);
        assertEquals(w6, surl.getFirstWebsite());
        assertEquals(w4, surl.getLastWebsite());
    }
    
    @Test
    public void testWebNumber() {
        SortedURL surl = new SortedURL();
        Website w1 = new Website("www.facbook.com", "high", "fb.txt", 1);
        Website w2 = new Website("www.abc.com", "low", "abc.txt", 2);
        Website w3 = new Website("www.cnn.com", "medium", "fb.txt", 2);
        Website w4 = new Website("www.foxnews.com", "medium", "fb.txt", 1);
        Website w5 = new Website("www.google.com", "high", "fb.txt", 2);
        Website w6 = new Website("www.orange.com", "low", "fb.txt", 3);
        surl.add(w1);
        surl.add(w2);
        surl.add(w3);
        surl.add(w4);
        surl.add(w5);
        surl.add(w6);
        assertEquals(6, surl.webNumber());
    }
    
    @Test
    public void testGetFirst() {
        SortedURL surl = new SortedURL();
        Website w1 = new Website("www.facbook.com", "high", "fb.txt", 4);
        Website w2 = new Website("www.abc.com", "low", "abc.txt", 2);
        Website w3 = new Website("www.cnn.com", "medium", "fb.txt", 2);
        Website w4 = new Website("www.foxnews.com", "medium", "fb.txt", 1);
        Website w5 = new Website("www.google.com", "high", "fb.txt", 5);
        Website w6 = new Website("www.orange.com", "low", "fb.txt", 3);
        surl.add(w1);
        surl.add(w2);
        surl.add(w3);
        surl.add(w4);
        surl.add(w5);
        surl.add(w6);
        assertEquals(w5, surl.getFirstWebsite());
    }
    
    @Test
    public void testGetLast() {
        SortedURL surl = new SortedURL();
        Website w1 = new Website("www.facbook.com", "high", "fb.txt", 4);
        Website w2 = new Website("www.abc.com", "low", "abc.txt", 2);
        Website w3 = new Website("www.cnn.com", "medium", "fb.txt", 2);
        Website w4 = new Website("www.foxnews.com", "medium", "fb.txt", 2);
        Website w5 = new Website("www.google.com", "high", "fb.txt", 5);
        Website w6 = new Website("www.orange.com", "low", "fb.txt", 3);
        surl.add(w1);
        surl.add(w2);
        surl.add(w3);
        surl.add(w4);
        surl.add(w5);
        surl.add(w6);
        assertEquals(w2, surl.getLastWebsite());
    }
}
