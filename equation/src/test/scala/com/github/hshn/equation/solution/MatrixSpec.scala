package com.github.hshn.equation.solution

import org.scalatest.{FlatSpec, Matchers}

class MatrixSpec extends FlatSpec with Matchers {
  "Matrix" should "be eliminated by gauss jordan elimination" in {
    val matrix = new Matrix(
      Row(-2.0d, 5.0d, 8.0d, -3.0d, 9.0d),
      Row(1.0d, -2.0d, 3.0d, -4.0d, 5.0d),
      Row(5.0d, 4.0d, 7.0d, 1.0d, -1.0d),
      Row(9.0d, 7.0d, 3.0d, 5.0d, 4.0d)
    )

    matrix.solve() should be (Seq(1, 3, -2, -4))
  }
}



