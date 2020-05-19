/*
 * Sujan Dhakal (dhakals@lafayette.edu)
 * CS 150 Project 2
 * Professor Linda Plotnick
 * April 15, 2018
 */

import java.util.TreeSet;
import java.util.Iterator;

public class SortedURL{
    private TreeSet<Website> sortedWeb;

    public SortedURL() {
        sortedWeb = new TreeSet<Website>();
    }

    public void add(Website w) {            // add matched websites
        this.sortedWeb.add(w);
    }

    public int webNumber() {            // number of matched websites
        return this.sortedWeb.size();
    }
    
    public Website getFirstWebsite() {          // getting top 1 websites   
        return this.sortedWeb.first();
    }
    
    public Website getLastWebsite() {           // getting last website
        return this.sortedWeb.last();
    }

    public void printSortedWebsite() {          // printing top 5 websites
        Iterator<Website> itr= sortedWeb.iterator();
        int k=0;
        while (itr.hasNext() && k<5) {
            Website w= itr.next();
            System.out.println(w.getUrl());
            System.out.println("      Keywords matched: " + w.getNumberofkeywordmatched()+"     Website Rating: "+ w.getRating());
            System.out.println(" ");
            k++;
        }
    }
}
