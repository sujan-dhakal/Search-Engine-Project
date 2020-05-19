/*
 * Sujan Dhakal (dhakals@lafayette.edu)
 * CS 150 Project 2
 * Professor Linda Plotnick
 * April 15, 2018
 */

public class Website implements Comparable<Website> {
    private String url;
    private String rating;
    private String filename;
    private int numberofkeywordmatched;

    public Website(String url, String rating, String filename, int numberofkeywordmatched) {
        this.url=url;
        this.rating=rating;
        this.filename=filename;
        this.numberofkeywordmatched=numberofkeywordmatched;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url=url;
    }

    public String getRating() {
        return this.rating;
    }

    public void setRating(String rating) {
        this.rating=rating;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        this.filename=filename;
    }

    public int getNumberofkeywordmatched() {
        return this.numberofkeywordmatched;
    }

    public void setNumberofkeywordmatched(int numberofkeywordmatched) {
        this.numberofkeywordmatched=numberofkeywordmatched;
    }

    public void increaseNumberofkeywordmatched() {
        this.numberofkeywordmatched=this.numberofkeywordmatched+1;
    }

    public int getRatingNumber() {             // numerical value of a priority
        if (this.rating.equalsIgnoreCase("high")) {
            return 3;
        } else if (this.rating.equalsIgnoreCase("medium")) {
            return 2;
        } else {
            return 1;
        }
    }

    public int compareTo(Website w) {           //compareTo Method
        if (this.getNumberofkeywordmatched()<w.getNumberofkeywordmatched()) {
            return 1;
        } else if (this.getNumberofkeywordmatched()>w.getNumberofkeywordmatched()) {
            return -1;
        } else {
            if (this.getRatingNumber()<w.getRatingNumber()) {
                return 1;
            } else if (this.getRatingNumber()>w.getRatingNumber()) {
                return -1;
            } else {
                if (this.getUrl().compareTo(w.getUrl())>0) {
                    return 1; 
                } else if (this.getUrl().compareTo(w.getUrl())<0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }
}

