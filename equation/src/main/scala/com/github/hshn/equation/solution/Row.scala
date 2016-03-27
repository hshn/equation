package com.github.hshn.equation.solution

import spire.math._

case class Row(values: Rational*) {
  def apply(index: Int): Rational = values(index)
  def /(value: Rational): Row = map(_.map(_ / value))
  def *(value: Rational): Row = map(_.map(_ * value))
  def -(other: Row): Row = map { values =>
    other.values.zipWithIndex.map {
      case (value, index) => values(index) - value
    }
  }
  def map(f: Seq[Rational] => Seq[Rational]): Row = Row(f(values):_*)
  def last: Rational = values.last

  override def toString: String = s"Row(${values.mkString(", ")})"
}
