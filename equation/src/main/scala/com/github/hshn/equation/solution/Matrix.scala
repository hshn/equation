package com.github.hshn.equation.solution

import spire.math.Rational

class Matrix(rows: Row*) {
  def solve(): Seq[Rational] = {
    var answer = Seq.empty[Rational]
    eliminate().foreachWithIndex {
      case (row, index) => answer = answer :+ row.last / row(index)
    }
    answer
  }

  def eliminate(index: Int): Matrix = map { rows =>
    rows.zipWithIndex.map {
      case (row, i) => if (i == index) {
        row
      } else {
        row - rows(index) * row(index) / rows(index)(index)
      }
    }
  }

  def eliminate(): Matrix = {
    rows.foldLeft(this)((eliminating, row) => {
      eliminating.eliminate(rows.indexOf(row))
    })
  }

  def map(f: Seq[Row] => Seq[Row]): Matrix = new Matrix(f(rows):_*)
  def foreachWithIndex[U](f: ((Row, Int)) => U): Unit = rows.zipWithIndex.foreach(f)

  override def toString: String = s"Matrix(\n  ${rows.mkString(",\n  ")}\n)"
}
