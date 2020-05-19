/*
 * Sujan Dhakal (dhakals@lafayette.edu)
 * CS 150 Project 2
 * Professor Linda Plotnick
 * April 15, 2018
 */


import java.util.ArrayList;

public class ContentContainer {

    private ArrayList<UniqueWord> contentArray;

    public ContentContainer() {
        contentArray= new ArrayList<UniqueWord>();
    }

    public void add(UniqueWord u) {             // adding uniqueword objects
        this.contentArray.add(u);
    }

    public int getContentSize() {               // Content size
        return this.contentArray.size();
    }

    public UniqueWord getContent(int i) {        
        return this.contentArray.get(i);    
    }
    
}
