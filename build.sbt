name := "equation"

organization := "com.github.hshn"

lazy val fraction = (project in file("equation"))
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "2.2.6" % "test",
      "org.spire-math" %% "spire" % "0.11.0"
    )
  )
