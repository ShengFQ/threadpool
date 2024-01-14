package com.shengfq.designpatten.adapter.demo1;

/**
 * 圆钉 RoundPegs are compatible with RoundHoles.
 */
public class RoundPeg {
  private double radius;

  public RoundPeg() {}

  public RoundPeg(final double radius) {
    this.radius = radius;
  }

  public double getRadius() {
    return this.radius;
  }
}
