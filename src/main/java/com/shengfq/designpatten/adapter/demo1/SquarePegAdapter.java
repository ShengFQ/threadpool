package com.shengfq.designpatten.adapter.demo1;

/**
 * 方钉到圆孔的适配器 Adapter allows fitting square pegs into round holes.
 */
public class SquarePegAdapter extends RoundPeg {
  private final SquarePeg peg;

  public SquarePegAdapter(final SquarePeg peg) {
    this.peg = peg;
  }

  @Override
  public double getRadius() {
    final double result;
    // Calculate a minimum circle radius, which can fit this peg.
    result = (Math.sqrt(Math.pow((this.peg.getWidth() / 2), 2) * 2));
    return result;
  }
}
