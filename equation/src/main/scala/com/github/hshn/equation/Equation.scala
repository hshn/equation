package com.github.hshn.equation

case class Equation(values: Double*) {
  def apply(index: Int): Double = values(index)
  def /(value: Double): Equation = map(_.map(_ / value))
  def *(value: Double): Equation = map(_.map(_ * value))
  def -(other: Equation): Equation = map { values =>
    other.values.zipWithIndex.map {
      case (value, index) => values(index) - value
    }
  }
  def map(f: Seq[Double] => Seq[Double]): Equation = Equation(f(values):_*)

  override def toString: String = s"Equation(${values.mkString(", ")})"
}
