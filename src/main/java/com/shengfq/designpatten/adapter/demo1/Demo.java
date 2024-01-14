package com.shengfq.designpatten.adapter.demo1;

/**
 * 适配器模式 测试代码 将方钉插入圆孔 Somewhere in client code...
 */
public class Demo {
  public static void main(final String[] args) {
    // Round fits round, no surprise.
    final RoundHole hole = new RoundHole(5);
    final RoundPeg rpeg = new RoundPeg(5);
    if (hole.fits(rpeg)) {
      System.out.println("Round peg r5 fits round hole r5.");
    }

    final SquarePeg smallSqPeg = new SquarePeg(2);
    final SquarePeg largeSqPeg = new SquarePeg(20);
    // hole.fits(smallSqPeg); // Won't compile.

    // Adapter solves the problem.
    final SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
    final SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);
    if (hole.fits(smallSqPegAdapter)) {
      System.out.println("Square peg w2 fits round hole r5.");
    }
    if (!hole.fits(largeSqPegAdapter)) {
      System.out.println("Square peg w20 does not fit into round hole r5.");
    }
  }
}
