/*
 * Sujan Dhakal (dhakals@lafayette.edu)
 * CS 150 Project 2
 * Professor Linda Plotnick
 * April 15, 2018
 */

import java.util.PriorityQueue;
import java.util.Iterator;

public class CommonWordContainer {

    private PriorityQueue<String> commonWordQueue;

    public CommonWordContainer() {
        commonWordQueue = new PriorityQueue<String>();
    }

    public void add(String s) {             // adding common word
        this.commonWordQueue.add(s);
    }

    public int commonWordSize() {               // commonword size
        return this.commonWordQueue.size();
    }

    public String[] getStringArray() {              // conversion to String array
        String[] array= new String[commonWordQueue.size()];
        int i=0;
        Iterator<String> itr= commonWordQueue.iterator();
        while(itr.hasNext()) {
            array[i]= itr.next();
            i++;
        }
        return array;
    }

    public String getCommonWord(int i) {            // retrieving each common word
        String[] array = getStringArray();
        return array[i];
    }

}
