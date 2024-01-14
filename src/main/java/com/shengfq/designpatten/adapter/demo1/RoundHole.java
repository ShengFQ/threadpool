package com.shengfq.designpatten.adapter.demo1;

/**
 * 圆孔 RoundHoles are compatible with RoundPegs.
 */
public class RoundHole {
  private final double radius;

  public RoundHole(final double radius) {
    this.radius = radius;
  }

  public double getRadius() {
    return this.radius;
  }

  public boolean fits(final RoundPeg peg) {
    final boolean result;
    result = (this.getRadius() >= peg.getRadius());
    return result;
  }
}
