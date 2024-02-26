package cc.vividcode.java22.statementsbeforesuper;

class Super1 {
  private int value;

  Super1(int value) {
    this.value = value;
  }
}

public class Child1 extends Super1 {
  Child1(int value) {
    if (value < 0) {
      throw new IllegalArgumentException("invalid value");
    }
    super(value);
  }
}