/*
 * Sujan Dhakal (dhakals@lafayette.edu)
 * CS 150 Project 2
 * Professor Linda Plotnick
 * April 15, 2018
 */

import java.util.ArrayList;

public class WebsiteContainer {   
   private ArrayList<Website> webArray;
   
   public WebsiteContainer() {
       webArray= new ArrayList<Website>();
   }
   
   public void add(Website w) {         //adding websites
       this.webArray.add(w);
   }
   
   public int websiteNumber() {         // number of websites
       return this.webArray.size();
   }
   
   public Website getWebsite(int i) {       // retrieving each websites
       return this.webArray.get(i);
   }
}
