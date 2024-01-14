package com.shengfq.designpatten.adapter.demo1;

/**
 * 方钉 SquarePegs are not compatible with RoundHoles (they were implemented by previous development
 * team). But we have to integrate them into our program.
 */
public class SquarePeg {
  private final double width;

  public SquarePeg(final double width) {
    this.width = width;
  }

  public double getWidth() {
    return this.width;
  }

  public double getSquare() {
    final double result;
    result = Math.pow(this.width, 2);
    return result;
  }
}
