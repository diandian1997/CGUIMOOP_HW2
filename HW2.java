import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/*
 * ID: TODO: B0444123
 * Name: TODO: 黃城恩
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("input N(deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that you print all cards on your screen
		deck.printDeck();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/*
	 * This method is used for checking your result, not a part of your HW2
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/*
 * Description: TODO: class Deck 是將52張牌乘n堆牌放進Arrsylist的cards陣列中
 *                    printDeck 是將cards陣列裡的東西印出來
 */
class Deck{
	private ArrayList<Card> cards;
	//TODO: Please implement the constructor
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		for(int i=0;i<nDeck;i++){
			for(int j=1;j<=4;j++){
				for(int k=1;k<=13;k++){
					Card card=new Card(j,k);
					cards.add(card);
				}
			}
		}
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end

	}	
	//TODO: Please implement the method to print all cards on screen
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//please implement and reuse printCard method in Card class
		for(Card showcard:cards){
			showcard.printCard();
		}
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/*
 * Description: TODO: class Card 是設定牌的花色跟數字
 *                    getSuit 是取得牌的花色的方法
 *                    getRank 是取得牌的數字的方法
 */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	public Card(int s,int r){
		suit=s;
		rank=r;
	}	
	//TODO: 1. Please implement the printCard method
	public void printCard(){
		System.out.print("("+getSuit()+","+(getRank()==13?getRank()+") \n":getRank()+") "));
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}