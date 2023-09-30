package poker;
import java.util.*;

public class Poker {
	Comparator<String> comp = new Comparator<String>() {
		@Override
		public int compare(String o1, String o2) {
			return o1.charAt(1) - o2.charAt(1);
		}
	};
	
	// Precondition: A hand of n cards have been sorted by card number.
	public boolean isFullHouse(String cards[], int n) {
		if (cards != null) Arrays.sort(cards, 0, n, comp);
		return !isFourOfaKind(cards, n) && isThreeOfaKind(cards, n) && isTwoPairs(cards, n);
	}

	// Precondition: A hand of n cards have been sorted by card number.
	public boolean isThreeOfaKind(String cards[], int n) {
		if (cards != null) Arrays.sort(cards, 0, n, comp);
		
		for (int i=0; i<n-2; i++) {
			if (cards[i].charAt(1) == cards[i+1].charAt(1) &&
					cards[i+1].charAt(1) == cards[i+2].charAt(1))
					return true;
		}

		return false;
	}

	// Precondition: A hand of n cards have been sorted by card number.
	public boolean isTwoPairs(String cards[], int n) {
		if (cards != null) Arrays.sort(cards, 0, n, comp);
		
		int count = 0;
		for (int i=0; i<n-1; i++) {
			if (cards[i].charAt(1) == cards[i+1].charAt(1)) {
				count++;
				i++;
			}
		}
		if (count == 2)
			return true;
		else
			return false;
	}
	
	// Precondition: A hand of n cards have been sorted by card number.
	public boolean isFourOfaKind(String cards[], int n) {
		if (cards != null) Arrays.sort(cards, 0, n, comp);
		
		for (int i=0; i<n-3; i++) {
			if (cards[i].charAt(1) == cards[i+1].charAt(1) &&
					cards[i+1].charAt(1) == cards[i+2].charAt(1) &&
							cards[i+2].charAt(1) == cards[i+3].charAt(1))
					return true;
		}

		return false;
	}
	
	public static void main(String args[]) {
		System.out.println(new Poker().isFullHouse(
			new String[] {"C2", "D2", "H2", "S3", "S4"}, 5));
	}
}
// end of Poker.java
