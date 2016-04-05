package com.github.hshn.equation.solution

import spire.math.Rational

private[solution] class GaussJordanElimination extends Solution {
  override def solve(rows: Seq[Row]): Seq[Rational] = {
    var resolutions = Resolution.empty

    val eliminated = rows.indices.foldLeft(rows){ (eliminating, column) =>
      val eliminator = indexOfEliminator(eliminating, column, resolutions.solved)

      resolutions = resolutions.solve(column, eliminator)

      eliminate(eliminating, column, eliminator)
    }

    resolutions(eliminated)
  }

  private def indexOfEliminator(rows: Seq[Row], column: Int, excludes: Seq[Int]): Int = {
    rows.zipWithIndex
      .filter { case (row, index) => !excludes.contains(index)}
      .maxBy { case (row, index) => row(column).abs }._2
  }

  private def eliminate(rows: Seq[Row], column: Int, eliminator: Int): Seq[Row] = {
    rows.zipWithIndex.map {
      case (row, index) => if (index == eliminator) {
        row
      } else {
        row - rows(eliminator) * row(column) / rows(eliminator)(column)
      }
    }
  }

  private case class Resolution(resolutions: Map[Int, Int]) {
    def apply(rows: Seq[Row]): Seq[Rational] = rows.indices.map(index => this(rows, index))
    def apply(rows: Seq[Row], column: Int): Rational = rows(resolutions(column)) match { case row => row.last / row(column) }
    def solve(column: Int, row: Int): Resolution = Resolution(resolutions + ((column, row)))
    def solved: Seq[Int] = resolutions.values.toSeq
  }

  private object Resolution {
    def empty: Resolution = new Resolution(Map.empty)
  }
}
