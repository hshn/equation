package com.github.hshn.equation.solution

import com.github.hshn.equation.solution.Solution._
import org.scalatest.{FlatSpec, Matchers}
import spire.implicits._

class MatrixSpec extends FlatSpec with Matchers {

  "Matrix" should "be solved by gauss jordan elimination" in {
    val matrix = new Matrix(
      Row(-2.0d, 5.0d, 8.0d, -3.0d, 9.0d),
      Row(1.0d, -2.0d, 3.0d, -4.0d, 5.0d),
      Row(5.0d, 4.0d, 7.0d, 1.0d, -1.0d),
      Row(9.0d, 7.0d, 3.0d, 5.0d, 4.0d)
    )

    matrix.solve() should be (Seq(1, 3, -2, -4))
  }

  "Matrix" should "be solved even if there are some zero(s)" in {
    val matrix = new Matrix(
      Row(0.0d,    0.0d, 8.0d, 0.0d,  9.0d),
      Row(0.0d,   -2.0d, 0.0d, 0.0d,  5.0d),
      Row(0.0d,    0.0d, 0.0d, 1.0d, -1.0d),
      Row(9.0d,    0.0d, 0.0d, 0.0d,  4.0d)
    )

    matrix.solve() should be (Seq(r"4/9", r"5/-2", r"9/8", r"-1/1"))
  }
}
