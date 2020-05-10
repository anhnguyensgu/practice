package designPattern.strategy.card;

import java.util.ArrayList;
import java.util.List;

public class PlayerHand {
  private List<Card> playingCard;

  public List<Card> getPlayingCard() {
    return playingCard;
  }

  public void addCard(Card card) {
    playingCard.add(card);
  }

  public void returnCards() {
    playingCard = new ArrayList<>();
  }

  public boolean isFull() {
    return false;
  }
}
