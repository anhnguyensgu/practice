package designPattern.strategy.card;

public class Main {

  public static void main(String[] args) {
    Deck deck52Cards = new Deck();
    CardGame blackJackGame = new BlackJackGame(deck52Cards);
    Player player1 = new Player("player 1");
    Player player2 = new Player("player 2");
    Player player3 = new Player("player 2");

    blackJackGame.addPlayer(player1);
    blackJackGame.addPlayer(player2);
    blackJackGame.addPlayer(player3);

    blackJackGame.initialize();

    blackJackGame.splitHand(player1);

    blackJackGame.giveCardOutToPLayer(player1);
    blackJackGame.giveCardOutToPLayer(player2);
    blackJackGame.giveCardOutToPLayer(player3);

    blackJackGame.getWinner();

    blackJackGame.reset();
  }
}
