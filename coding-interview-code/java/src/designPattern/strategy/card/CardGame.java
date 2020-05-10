package designPattern.strategy.card;

import java.util.List;

public interface CardGame {
  void addPlayer(Player player);
  void initialize();
  void giveCardOutToPLayer(Player player);
  void splitHand(Player player);
  List<Player> getWinner();
  void reset();
}
