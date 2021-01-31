package main;
import java.awt.Font;

public class FakePokerTester{

    public static void FakeDrawHand(int[] hand){
    
        StdDraw.setPenColor(200,100,0);
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 20));
        //The following part is "fake". Instead, you have to determine which string to draw
        //and which image files to use:
        StdDraw.text(15, 34, "Hand: [ 15, 30, 4, 26, 23 ]");
        StdDraw.picture(3, 28, "\\CardDecks\\Paris\\3d.png", 7,10,0);
        StdDraw.picture(10, 28, "\\CardDecks\\Paris\\5s.png", 7,10,0);
        StdDraw.picture(17, 28,  "\\CardDecks\\Paris\\5h.png", 7,10,0);
        StdDraw.picture(24,28, "\\CardDecks\\Paris\\1s.png", 7,10,0);
        StdDraw.picture(31, 28, "\\CardDecks\\Paris\\11d.png", 7,10,0);
        
    }
    
    public static void FakeDrawHandText(int[] hand){
        StdDraw.setPenColor(50,50,0);
        StdDraw.setFont(new Font("Arial", Font.BOLD, 13));
        //This part is "fake". Instead you have to determine which string to draw:
        StdDraw.text(17, 22, "3 of Diamonds      5 of Spades      5 of Hearts      A of Spades     J of Diamonds");
    }
    
    public static void FakeDrawIdentifiedHand(int[] hand){    
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 25));
        StdDraw.text(17, 15, "You have ");
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 30));
        StdDraw.text(17, 10, FakeIdentifyHand(hand));//Here you are calling a "fake" method to get a string identifying the hand
           
    }
    
    public static String FakeIdentifyHand(int[] hand){
       //This one is a "rigged" returning string.
       //In fact, actual identifying your hand is the main part of your project.
       return "a Pair of 5s";
    }

    public static void main(String[] args){
        
        StdDraw.setXscale(0,34);
        StdDraw.setYscale(0,35);
        
        int[] testHand = {15, 30, 4, 26, 23};      
        
        FakeDrawHand(testHand); //This will draw corresponding images in the window
        FakeDrawHandText(testHand);//This will draw names of each card under the images
        FakeDrawIdentifiedHand(testHand);//This will print what hand you have in the window            
    }
    
}