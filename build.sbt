lazy val root = project.in(file(".")).enablePlugins(PlayJava)

name := """shop"""

version := "1.0-SNAPSHOT"


fork in run := true

libraryDependencies += javaJpa