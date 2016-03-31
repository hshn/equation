package com.github.hshn.equation.solution

import spire.math.Rational

class Matrix(rows: Row*) {

  def solve(): Seq[Rational] = {
    eliminate().foldLeft(Seq.empty[Rational])((answer, row, index) => answer :+ row.last / row(index))
  }

  private def eliminate(index: Int): Matrix = map { rows =>
    rows.zipWithIndex.map {
      case (row, i) => if (i == index) {
        row
      } else {
        row - rows(index) * row(index) / rows(index)(index)
      }
    }
  }

  private def eliminate(): Matrix = {
    rows.foldLeft(this)((eliminating, row) => {
      eliminating.eliminate(rows.indexOf(row))
    })
  }

  private def map(f: Seq[Row] => Seq[Row]): Matrix = new Matrix(f(rows):_*)

  private def foldLeft[A](z: A)(op: (A, Row, Int) => A) = {
    rows.zipWithIndex.foldLeft(z)((acc, tuple) => tuple match {
      case (row, index) => op(acc, row, index)
    })
  }

  override def toString: String = s"Matrix(\n  ${rows.mkString(",\n  ")}\n)"
}
