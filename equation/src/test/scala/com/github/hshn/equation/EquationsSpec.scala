package com.github.hshn.equation

import org.scalatest.FlatSpec

class EquationsSpec extends FlatSpec {
  "Equations" should "be eliminated by gauss jordan elimination" in {
    val equations = new Equations(
      Equation(-2.0d, 5.0d, 8.0d, -3.0d, 9.0d),
      Equation(1.0d, -2.0d, 3.0d, -4.0d, 5.0d),
      Equation(5.0d, 4.0d, 7.0d, 1.0d, -1.0d),
      Equation(9.0d, 7.0d, 3.0d, 5.0d, 4.0d)
    )

    println(equations)

    val eliminated = equations.eliminate()

    println(eliminated)
  }
}



