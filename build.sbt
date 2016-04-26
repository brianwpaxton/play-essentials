lazy val root = project.in(file(".")).enablePlugins(PlayJava)

name := """shop"""

version := "1.0-SNAPSHOT"


fork in run := true

libraryDependencies += javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api")

libraryDependencies += "org.hibernate" % "hibernate-entitymanager" % "4.3.4.Final"

lazy val `pfe-java` = project.in(file(".")).enablePlugins(PlayJava)

fork in run := true

fork in run := true