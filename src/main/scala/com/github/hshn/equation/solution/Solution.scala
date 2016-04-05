package com.github.hshn.equation.solution

import spire.math.Rational

trait Solution {
  def solve(rows: Seq[Row]): Seq[Rational]
}

object Solution {
  implicit val gaussJordanElimination: Solution = new GaussJordanElimination
}
