/*
 * Sujan Dhakal (dhakals@lafayette.edu)
 * CS 150 Project 2
 * Professor Linda Plotnick
 * April 15, 2018
 */

import java.util.ArrayList;

public class UniqueWord {

    private ArrayList<String> uniqueWordArray;

    public UniqueWord() {
        uniqueWordArray = new ArrayList<String>();
    }

    public void add(String s) {             // adding unique word
        this.uniqueWordArray.add(s);
    }

    public int getUniqueWordSize() {            // unique word size
        return this.uniqueWordArray.size();
    }

    public String getUniqueWord(int i) {            // retrieving each unique word
        return this.uniqueWordArray.get(i);
    }
    
    public boolean contains(Object o) {             // checking if the list contains a particular word
        return this.uniqueWordArray.contains(o);
    }
}
