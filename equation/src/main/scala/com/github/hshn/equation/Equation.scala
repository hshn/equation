package com.github.hshn.equation

import spire.math._

case class Equation(values: Rational*) {
  def apply(index: Int): Rational = values(index)
  def /(value: Rational): Equation = map(_.map(_ / value))
  def *(value: Rational): Equation = map(_.map(_ * value))
  def -(other: Equation): Equation = map { values =>
    other.values.zipWithIndex.map {
      case (value, index) => values(index) - value
    }
  }
  def map(f: Seq[Rational] => Seq[Rational]): Equation = Equation(f(values):_*)

  override def toString: String = s"Equation(${values.mkString(", ")})"
}
