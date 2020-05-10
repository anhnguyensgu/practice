package designPattern.strategy.card;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Player {
  private String name;
  private List<PlayerHand> playerHands;

  public Player(String name) {
    playerHands = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void receiveCard(Card card) {
    playerHands
        .stream()
        .filter(playerHand -> !playerHand.isFull())
        .findFirst()
        .orElseThrow(RuntimeException::new)
        .addCard(card);
  }

  public void addMoreHand() {
    playerHands.add(new PlayerHand());
  }

  public void returnCards() {
    playerHands.forEach(PlayerHand::returnCards);
  }
}
