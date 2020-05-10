package designPattern.strategy.card;

public class Card {
  private int value;
  private Suite suite;

  public enum Suite {
    HEART(1), DIAMOND(2), CLUB(3), SPADE(4);

    private int suite;

    Suite(int value) {
      this.suite = value;
    }
  }

  public Card(int value , Suite suite) {
    this.value = value;
    this.suite = suite;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public Suite getSuite() {
    return suite;
  }

  public void setSuite(Suite suite) {
    this.suite = suite;
  }
}
