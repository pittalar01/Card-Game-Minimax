import java.util.ArrayList;
import java.util.Random;

public class RachithaP {
	public static Player getPlayer() { return new Rachitha(); }

	public static class Rachitha implements Player {

		

		public Card playFirstCard(ArrayList<Card> hand, ArrayList<Card> playedCards, Card trump, int tricks1, int tricks2) {
			Card firstCard=null;
			for (Card card:hand){
				firstCard=card;
				if(firstCard.value.compareTo(card.value)>0){
					firstCard=card;
				}
			}
			return firstCard;
		}

		public Card playSecondCard(ArrayList<Card> hand, ArrayList<Card> playedCards, Card trump,int tricks1, int tricks2) {
			Card card1=playedCards.get(playedCards.size()-1);
			//			first search for the suit that matches the played card and at least greater in value than that
			//			but not the highest one in the hand for that suit
			Card secondCard=null;
			for(Card card:hand){
				if(card.value.compareTo(card1.value)>0 && card.suit.equals(card1.suit)){
					try {
						if(card.value.compareTo(secondCard.value)<0){
							secondCard=card;
						}
					} catch (Exception e) {
						secondCard=card;
					}
				}
			}
			//			now search for the card with trump suit if not find the card matched with the played card
			//			but with lowest value as well to preserve highest values in future for getting more tricks
			if(secondCard==null){
				for(Card card:hand){
					if(card.suit.equals(trump.suit)){
						try {
							if(card.value.compareTo(secondCard.value)<0){
								secondCard=card;
							}
						} catch (Exception e) {
							secondCard=card;
						}
					}
				}
				//			if could not follow any of the played suit or trump suit, place a random card but with the
				//				lowest value only
				if(secondCard==null){
					for(Card card:hand){
						try {
							if(card.value.compareTo(secondCard.value)<0){
								secondCard=card;
							}
						} catch (Exception e) {
							secondCard=card;
						}
					}
				}
			}
			return secondCard;
		}
	}
}
