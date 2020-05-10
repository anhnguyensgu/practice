package designPattern.strategy.card;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Deck {
  private List<Card> cards;
  private CardShuffler cardShuffler;
  private Iterator<Card> cardPointer;

  public Deck() {
    cards = new ArrayList<>();
    cardPointer = cards.iterator();
  }

  public void shuffle() {

  }

  public Card getSingleCard() {
    return cardPointer.next();
  }
}
