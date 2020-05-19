/*
 * Sujan Dhakal (dhakals@lafayette.edu)
 * CS 150 Project 2
 * Professor Linda Plotnick
 * April 15, 2018
 */

import java.util.Scanner;
import java.io.FileReader;

public class Controller extends Controller {
    CommonWordContainer cwc= new CommonWordContainer();
    WebsiteContainer wc = new WebsiteContainer();
    ContentContainer cc= new ContentContainer();
    SortedURL surl= new SortedURL();
    int LeftNoOfAnd = 0;     
    int RightNoOfAnd = 0;

    public static void main(String[] args) {
        String inputFileName = args[0];                 // input file name
        String inputFileCommonWord = args[1];           // file with common words
        boolean exit=false;
        Scanner ask = new Scanner(System.in);

        while (!exit) {                         // loop to restart the search if the user wants to research again
            Controller c= new Controller();
            c.website(inputFileName);
            c.commonWord(inputFileCommonWord);
            c.uniqueWord();
            //long startTime = System.nanoTime(); 
            c.search();
            //long stopTime = System.nanoTime();
            //System.out.println("Search Time: "+ (stopTime-startTime));
            c.display(); 
            System.out.println();
            System.out.println("Do you want to research? Press Y or N.");
            String key= ask.next();

            if (key.equalsIgnoreCase("y")) {
                exit=false;
            } else if (key.equalsIgnoreCase("n")) {
                exit=true;
            } else {
                System.out.println("Invalid Key. Sorry");
                exit=true;
            }
        }
    }

    public void commonWord(String inputFileCommonWord) {            // reads common word from the commonword.txt file and pass to CommonWordContainer Class 
        Scanner file=null;
        int k =0;

        try {
            file = new Scanner (new FileReader(inputFileCommonWord));
            while (file.hasNext()) {
                String line = file.nextLine();
                String[] words=line.split(" ");
                cwc.add(words[0].toLowerCase());
                k++;
            }
        }catch (Exception e) {
            System.out.println("Exception occured" + e);
        }

        finally {
            if (file!=null) {
                file.close();
            }
        }
    }

    public void website(String inputFileName) {         // reads the information of the websites from
        Scanner file=null;                              // website.txt file and creates the objects of websites

        try {
            file = new Scanner (new FileReader(inputFileName));
            while (file.hasNext()) {
                String line = file.nextLine();
                String[] words=line.split(" ");

                Website w = new Website(words[0].toLowerCase(), words[1].toLowerCase(), words[2].toLowerCase(), 0);
                wc.add(w);

            }
        }catch (Exception e) {
            System.out.println("Exception occured" + e);
        }
        finally {
            if (file!=null) {
                file.close();
            }
        }
    }

    public void uniqueWord() {                          // reads the content of the each website
        for (int m=0; m<wc.websiteNumber(); m++) {      
            Scanner file=null;

            try {
                file = new Scanner (new FileReader(wc.getWebsite(m).getFilename()));
                UniqueWord uw= new UniqueWord();
                while (file.hasNext()) {
                    String line = file.nextLine();
                    String[] words=line.split("[\\s\\p{Punct}]+");

                    for (int i=0; i<words.length; i++) {
                        int wordMatchCount=0; 
                        for (int j=0; j<cwc.commonWordSize(); j++) {
                            if ((words[i].equalsIgnoreCase(cwc.getCommonWord(j)))) {
                                wordMatchCount++;        
                            }
                        }     
                        if (wordMatchCount==0) {
                            if (uw.getUniqueWordSize()==0) {
                                uw.add(words[i].toLowerCase()); 
                            } else {
                                int duplicateCount=0;
                                for (int k=0; k<uw.getUniqueWordSize(); k++) {
                                    if (uw.getUniqueWord(k).equalsIgnoreCase(words[i])) {
                                        duplicateCount++;
                                    }
                                }
                                if (duplicateCount==0) {
                                    uw.add(words[i].toLowerCase()); 
                                }
                            }
                        }
                    }
                }
                uw.add(wc.getWebsite(m).getUrl().toLowerCase()); 
                cc.add(uw);
            }catch (Exception e) {
                System.out.println("Exception occured" + e);
            }
            finally {
                if (file!=null) {
                    file.close();
                }
            }      
        }
    }

    public void search() {                              // method for searching the matching
        Scanner reader = new Scanner(System.in);        // websites based on the input keyword
        
        try {
            System.out.print("Type your search keyword: ");
            String keyline= reader.nextLine();
            String[] keyword = keyline.split(" ");
            int orIndex = keyword.length;
            
            if (keyword.length>1) {
                for (int i=0; i<keyword.length; i++) {
                    if (keyword[i].equalsIgnoreCase("or")) {
                        orIndex=i;
                    }
                }
            }
            
            String[] keywordLeft = new String[orIndex];
            String[] keywordRight = new String[(keyword.length-keywordLeft.length)];
   
            for (int i=0; i<keywordLeft.length; i++) {
                keywordLeft[i]=keyword[i];
                if (keywordLeft[i].equalsIgnoreCase("and")) {
                    LeftNoOfAnd++;
                }
            }
            
            for (int i=0; i<keywordRight.length; i++) {
                keywordRight[i]=keyword[orIndex+i];
                if (keywordRight[i].equalsIgnoreCase("and")) {
                    RightNoOfAnd++;
                }
            }

            for (int i=0; i<cc.getContentSize(); i++) {
                for (int j=0; j<keywordLeft.length; j++) {
                    if (LeftNoOfAnd>=1) {
                        if (keywordLeft[j].startsWith("-")==false) {
                            if(cc.getContent(i).contains(keywordLeft[j].toLowerCase())==true) {
                                wc.getWebsite(i).increaseNumberofkeywordmatched();
                                if (wc.getWebsite(i).getNumberofkeywordmatched()>1) {
                                    surl.add(wc.getWebsite(i));
                                }
                            }
                        } else {
                            if (cc.getContent(i).contains(keywordLeft[j].toLowerCase().substring(1))==false) {
                                wc.getWebsite(i).increaseNumberofkeywordmatched();
                                if (wc.getWebsite(i).getNumberofkeywordmatched()>1) {
                                    surl.add(wc.getWebsite(i));
                                }
                            }
                        }
                    } else {
                        if (keywordLeft[j].startsWith("-")==false) {
                            if(cc.getContent(i).contains(keywordLeft[j].toLowerCase())==true) {
                                wc.getWebsite(i).increaseNumberofkeywordmatched();
                                if (wc.getWebsite(i).getNumberofkeywordmatched()>0) {
                                    surl.add(wc.getWebsite(i));
                                }
                            }
                        } else {
                            if (cc.getContent(i).contains(keywordLeft[j].toLowerCase().substring(1))==false) {
                                wc.getWebsite(i).increaseNumberofkeywordmatched();
                                if (wc.getWebsite(i).getNumberofkeywordmatched()>0) {
                                    surl.add(wc.getWebsite(i));
                                }
                            }
                        }
                    }
                }

                for (int j=0; j<keywordRight.length; j++) {
                    if (RightNoOfAnd>=1) {
                        if (keywordRight[j].startsWith("-")==false) {
                            if(cc.getContent(i).contains(keywordRight[j].toLowerCase())==true) {
                                wc.getWebsite(i).increaseNumberofkeywordmatched();
                                if (wc.getWebsite(i).getNumberofkeywordmatched()>1) {
                                    surl.add(wc.getWebsite(i));
                                }
                            }
                        } else {
                            if (cc.getContent(i).contains(keywordRight[j].toLowerCase().substring(1))==false) {
                                wc.getWebsite(i).increaseNumberofkeywordmatched();
                                if (wc.getWebsite(i).getNumberofkeywordmatched()>1) {
                                    surl.add(wc.getWebsite(i));
                                }
                            }
                        }
                    } else {
                        if (keywordRight[j].startsWith("-")==false) {
                            if(cc.getContent(i).contains(keywordRight[j].toLowerCase())==true) {
                                wc.getWebsite(i).increaseNumberofkeywordmatched();
                                if (wc.getWebsite(i).getNumberofkeywordmatched()>0) {
                                    surl.add(wc.getWebsite(i));
                                }
                            }
                        } else {
                            if (cc.getContent(i).contains(keywordRight[j].toLowerCase().substring(1))==false) {
                                wc.getWebsite(i).increaseNumberofkeywordmatched();
                                if (wc.getWebsite(i).getNumberofkeywordmatched()>0) {
                                    surl.add(wc.getWebsite(i));
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Exception occured " + e);
        }
    }

    public void display() {                     // method to display the output result
        if (surl.webNumber()==0) {
            System.out.println("No Matching Website Found");
        } else  {              
            surl.printSortedWebsite();
        }
    }
}

