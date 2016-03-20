name := "equation"

organization := "com.github.hshn"

lazy val fraction = (project in file("equation"))
  .settings(
    libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"
  )
