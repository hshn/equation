package com.github.hshn.equation.solution

import spire.math.Rational

private[solution] class GaussJordanElimination extends Solution {
  override def solve(rows: Seq[Row]): Seq[Rational] = {
    var solutionMap = SolutionMap.empty

    val eliminated = rows.indices.foldLeft(rows){ (eliminating, column) =>
      val eliminator = indexOfEliminator(eliminating, column, solutionMap.rows)

      solutionMap = solutionMap.updated(column, eliminator)

      eliminate(eliminating, column, eliminator)
    }

    solutionMap.solve(eliminated)
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

  private case class SolutionMap(columnToRow: Map[Int, Int]) {
    def solve(rows: Seq[Row]): Seq[Rational] = rows.indices.map(solve(rows, _))
    def solve(rows: Seq[Row], column: Int): Rational = rows(columnToRow(column)) match { case row => row.last / row(column) }
    def updated(column: Int, row: Int): SolutionMap = SolutionMap(columnToRow + ((column, row)))
    def rows: Seq[Int] = columnToRow.values.toSeq
  }

  private object SolutionMap {
    def empty: SolutionMap = new SolutionMap(Map.empty)
  }
}
