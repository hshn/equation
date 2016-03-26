package com.github.hshn.equation

class Equations(expressions: Equation*) {
  def eliminate(index: Int): Equations = map { expressions =>
    expressions.map { expression =>
      if (expressions(index) == expression) {
        expression
      } else {
        expression - expressions(index) * expression(index) / expressions(index)(index)
      }
    }
  }

  def eliminate(): Equations = {
    expressions.foldLeft(this)((eliminating, expression) => {
      eliminating.eliminate(expressions.indexOf(expression))
    })
  }

  def map(f: Seq[Equation] => Seq[Equation]): Equations = new Equations(f(expressions):_*)

  override def toString: String = s"Equations(\n  ${expressions.mkString(",\n  ")}\n)"
}
