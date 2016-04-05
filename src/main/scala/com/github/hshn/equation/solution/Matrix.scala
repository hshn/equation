package com.github.hshn.equation.solution

import spire.math.Rational

class Matrix(rows: Row*) {
  def solve()(implicit ev: Solution): Seq[Rational] = ev.solve(rows)

  override def toString: String = s"Matrix(\n  ${rows.mkString(",\n  ")}\n)"
}
