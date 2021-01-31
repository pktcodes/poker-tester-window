package main;

import java.awt.Font;
import java.util.Arrays;

/**
*
* @author PraveenKumarThipparam
*/
public class PokerTesterWindow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StdDraw.setXscale(0,34);
        StdDraw.setYscale(0,35);
        
    //int[] hand = {15, 30, 4, 26, 23}; // pair
    // int[] hand = {0, 40, 48, 22, 13}; // Two pair
     //int[] hand = {27, 35, 33, 37, 30}; // Flush
     //int[] hand = {0, 35, 48, 22, 13}; // Full house
     //int[] hand = {15, 32, 4, 26, 23}; // Nothing
     // int[] hand = {35, 1, 48, 22, 13}; // Three of a kind
     //int[] hand = {0, 4, 14, 29, 15}; // Straight
     //int[] hand = {9, 35, 48, 13, 22}; // four of a kind
      int[] hand = {35, 32, 34, 36, 33}; // four of a kind
        
        
		
        PokerTesterWindow pokerTesterWindowObj = new PokerTesterWindow();
        
        pokerTesterWindowObj.drawHand(hand);
        pokerTesterWindowObj.drawHandText(hand);
        pokerTesterWindowObj.drawIdentifiedHand(hand);
	}
	
	/**
	 * 
	 * @param hand
	 */
	private void drawHand(int[] hand) {
		
		String handText = "Hand: [ " + hand[0] + ", " + hand[1] 
				+ ", " + hand[2]+ ", " + hand[3] + ", " +hand[4] + " ]";
		
        StdDraw.setPenColor(200,100,0);
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 20));
        //Showing current Hand
        StdDraw.text(15, 34, handText);
        
        //Here draws all the cards in hand
        StdDraw.picture(4, 28, "\\CardDecks\\Paris\\"+getCardFileNameFromCardValue(hand[0])+".png", 7,10,0);
        StdDraw.picture(10.5, 28, "\\CardDecks\\Paris\\" +getCardFileNameFromCardValue(hand[1])+".png", 7,10,0);
        StdDraw.picture(17, 28,  "\\CardDecks\\Paris\\"+getCardFileNameFromCardValue(hand[2])+".png", 7,10,0);
        StdDraw.picture(23.5,28, "\\CardDecks\\Paris\\"+getCardFileNameFromCardValue(hand[3])+".png", 7,10,0);
        StdDraw.picture(30, 28, "\\CardDecks\\Paris\\"+getCardFileNameFromCardValue(hand[4])+".png", 7,10,0);

	}
	
	/**
	 * 
	 * @param hand
	 */
	private void drawHandText(int[] hand) {
		StdDraw.setPenColor(50,50,0);
        StdDraw.setFont(new Font("Arial", Font.BOLD, 13));
        //This part is "fake". Instead you have to determine which string to draw:
        String allHandCardsNames = getCardNameFromCardValue(hand[0]) + "    " +
        							getCardNameFromCardValue(hand[1]) + "   " +
        							getCardNameFromCardValue(hand[2]) + "   " +
        							getCardNameFromCardValue(hand[3]) + "    " +
        							getCardNameFromCardValue(hand[4]);
        StdDraw.text(17, 22, allHandCardsNames);

	}
	
	/**
	 * 
	 * @param hand
	 */
	private void drawIdentifiedHand(int[] hand) {
		StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 25));
        StdDraw.text(17, 15, "You have ");
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 30));
        StdDraw.text(17, 10, identifyHand(hand));
	}
	
	/**
	 * 
	 * @param hand
	 * @return
	 */
	private String identifyHand(int[] hand) {
		//Arrays.equals(arr1, arr2);
		int cardRanks[] = getRankCountsArray(hand);
		int cardSuits[] = getRankSuitsArray(hand);
		
		if (isFourOfAKind(cardRanks)) {
			return "Four of a Kind";
		} else if (isFullHouse(cardRanks)) {
			return "Full House";
		} else if (isThreeOfAKind(cardRanks)) {
			return "Three of a Kind";
		} else if (isTwoPairs(cardRanks)) {
			return "Two Pairs";
		} else if (isPair(cardRanks)) {
			return "A Pair";
		} else if (isStraightFlush(cardRanks, cardSuits)) {
			return "Straight Flush";
		} else if (isStraight(cardRanks)) {
			return "Straight";
		} else if (isFlush(cardSuits)) {
			return "Flush";
		} else {
			return "Nothing";
		}
	}
	
	
	public String getCardFileNameFromCardValue(int cardValue) {
				
		int suitValue = cardValue / 13;
		int cardRank = cardValue % 13;
		
		String suit = "", card = "";
		
		switch(suitValue) { 
			case 0: suit = "h"; break; // h = Hearts
			case 1: suit = "d"; break; // d = Diamonds
			case 2: suit = "s"; break; // s = Spades
			case 3: suit = "c"; break; // c = Clubs
			default: System.out.println("Something went wrong!"); System.exit(-1);
		}
		
		switch(cardRank) {
			case 0: card = "1"; break;
			case 1: card = "2"; break;
			case 2: card = "3"; break;
			case 3: card = "4"; break;
			case 4: card = "5"; break;
			case 5: card = "6"; break;
			case 6: card = "7"; break;
			case 7: card = "8"; break;
			case 8: card = "9"; break;
			case 9: card = "10"; break;
			case 10: card = "11"; break;
			case 11: card = "12"; break;
			case 12: card = "13"; break;
			default: System.out.println("Something went wrong!"); System.exit(-1);
		}
		return card+suit;
	}
	
	public String getCardNameFromCardValue(int cardValue) {
		
		int suitValue = cardValue / 13;
		int cardRank = cardValue % 13;
		
		String suit = "", card = "";
		
		switch(suitValue) { 
			case 0: suit = "Hearts"; break; // h = Hearts
			case 1: suit = "Diamonds"; break; // d = Diamonds
			case 2: suit = "Spades"; break; // s = Spades
			case 3: suit = "Clubs"; break; // c = Clubs
			default: System.out.println("Something went wrong!"); System.exit(-1);
		}
		
		switch(cardRank) {
			case 0: card = "A"; break;
			case 1: card = "2"; break;
			case 2: card = "3"; break;
			case 3: card = "4"; break;
			case 4: card = "5"; break;
			case 5: card = "6"; break;
			case 6: card = "7"; break;
			case 7: card = "8"; break;
			case 8: card = "9"; break;
			case 9: card = "10"; break;
			case 10: card = "J"; break;
			case 11: card = "Q"; break;
			case 12: card = "K"; break;
			default: System.out.println("Something went wrong!"); System.exit(-1);
		}
		return card+ " of " + suit;
	}
	
	public int[] getRankCountsArray(int[] hand) {
		int[] cardRanks= {0, 0, 0, 0, 0};
		
		for(int i =0; i< hand.length; i++) {
			cardRanks[i] = hand[i] % 13;
		}
		
		return cardRanks;
	}
	
	public int[] getRankSuitsArray(int[] hand) {
		int[] cardSuits= {0, 0, 0, 0, 0};
		
		for(int i =0; i< hand.length; i++) {
			cardSuits[i] = hand[i] / 13;
		}
		
		return cardSuits;
	}
	
	
	
	public boolean isPair(int[] cardRanks) {
		boolean a1, a2, a3, a4;

		Arrays.sort(cardRanks);
		
		// Check for: a a x y z     
		a1 = cardRanks[0] == cardRanks[1];
		
		// Check for: x a a y z
		a2 = cardRanks[1] == cardRanks[2];
		
		//Check for: x y a a z
		a3 = cardRanks[2] == cardRanks[3];
		
		//Check for: x y a a z
		a4 = cardRanks[3] == cardRanks[4];
				
		return( a1 || a2 || a3 || a4);
	}
	
	public boolean isTwoPairs(int[] cardRanks) {
		boolean a1, a2, a3;

		if ( cardRanks.length != 5 )
			return(false);
		
		Arrays.sort(cardRanks);
		
		// Check for: a a  b b  x      
		a1 = cardRanks[0] == cardRanks[1] &&                  
				cardRanks[2] == cardRanks[3];
		
		// Check for: a a x  b b
		a2 = cardRanks[0] == cardRanks[1] &&
				cardRanks[4] == cardRanks[3];
		
		//Check for: x a a  b b
		a3 = cardRanks[1] == cardRanks[2] &&
				cardRanks[3] == cardRanks[4];
		
		return( a1 || a2 || a3 );
	}
	
	public boolean isThreeOfAKind(int[] cardRanks) {
		boolean a1, a2, a3;

		if ( cardRanks.length != 5 )
			return(false);
		
		Arrays.sort(cardRanks);
		
		// Check for: x x x a b      
		a1 = cardRanks[0] == cardRanks[1] &&                  
				cardRanks[1] == cardRanks[2];
		
		// Check for: a x x x b
		a2 = cardRanks[1] == cardRanks[2] &&
				cardRanks[2] == cardRanks[3];
		
		//Check for: a b x x x
		a3 = cardRanks[2] == cardRanks[3] &&
				cardRanks[3] == cardRanks[4];
		
		return( a1 || a2 || a3 );
	}
	
	public boolean isFourOfAKind(int[] cardRanks) {
		boolean a1, a2;

		if ( cardRanks.length != 5 )
			return(false);

		Arrays.sort(cardRanks);         // Sort by rank first

		//Check for: 4 cards of the same rank  + higher ranked unmatched card    
		a1 = cardRanks[0] == cardRanks[1]&&
				cardRanks[1] == cardRanks[2] &&
				cardRanks[2] == cardRanks[3] ;


	      //Check for: lower ranked unmatched card + 4 cards of the same rank 
	      a2 = cardRanks[1] == cardRanks[2] &&
	    		  cardRanks[2] == cardRanks[3] &&
	    		  cardRanks[3] == cardRanks[4];

      return( a1 || a2 );
	}
	
	public boolean isStraight(int[] cardRanks) {
		int i, testRank;

	      if ( cardRanks.length != 5 )
	         return(false);

	      Arrays.sort(cardRanks);      // Sort the cards Rank of each card      

	      //Check if rank has an Ace on high limit or low limit
	      if ( cardRanks[4] == 14 || cardRanks[4] == 0 ) {
	         // Check straight using an Ace
	         boolean a = cardRanks[0] == 2 && cardRanks[1] == 3 &&
	        		 	cardRanks[2] == 4 && cardRanks[3] == 5 ;
	         boolean b = cardRanks[0] == 10 && cardRanks[1] == 11 &&        
	        		 	cardRanks[2] == 12 && cardRanks[3] == 13 ;

	         return ( a || b );
	      }
	      else {
	         // General case: check for increasing values
	         testRank = cardRanks[0] + 1;

	         for ( i = 1; i < 5; i++ ) {
	            if ( cardRanks[i] != testRank )
	               return(false);        // Straight failed...

	            testRank++;   // Next card in hand
	         }

	         return(true);        // Straight found !
	      }
	}
	
	public boolean isFlush(int[] cardSuits) {
		if ( cardSuits.length != 5 )
	         return(false);   // Make sure we have 5 cards....

		Arrays.sort(cardSuits);// Sort the cardsuit, so that lower limit & higher limit contians same

	    return( cardSuits[0] == cardSuits[4] );   // All cards has same suit
	}
	
	
	public boolean isStraightFlush(int[] cardRanks, int[] cardSuits) {
		return isFlush(cardSuits) && isStraight(cardRanks);
	}
	
	public boolean isFullHouse(int[] cardRanks) {
		boolean a1, a2;
	
		if ( cardRanks.length != 5 )
			return(false);
	
		Arrays.sort(cardRanks);      // Sort by rank first
	
		// Check for: x x x y y  
		a1 = cardRanks[0] == cardRanks[1] &&
			  cardRanks[1] == cardRanks[2] &&
			  cardRanks[3] == cardRanks[4];
		
		// Check for: x x y y y
		a2 = cardRanks[0] == cardRanks[1] &&
			  cardRanks[2] == cardRanks[3] &&
			  cardRanks[3] == cardRanks[4];
		
		return( a1 || a2 );
	}
}
