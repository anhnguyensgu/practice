package designPattern.strategy.card;

import java.util.List;

public class BlackJackGame implements CardGame {
  private Deck deck;
  private List<Player> players;

  public BlackJackGame(Deck deck, List<Player> players) {
    this.deck = deck;
    this.players = players;
  }

  public BlackJackGame(Deck deck) {
    this.deck = deck;
  }

  @Override
  public void addPlayer(Player player) {

  }

  @Override
  public void giveCardOutToPLayer(Player player) {
    player.receiveCard(deck.getSingleCard());
  }

  @Override
  public void initialize() {
  }

  @Override
  public void splitHand(Player player) {

  }

  @Override
  public List<Player> getWinner() {
    players.forEach(Player::returnCards);
    return null;
  }

  @Override
  public void reset() {

  }
}
