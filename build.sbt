name := "equation"

organization := "com.github.hshn"

lazy val equation = (project in file("."))
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "2.2.6" % "test",
      "org.spire-math" %% "spire" % "0.11.0"
    )
  )