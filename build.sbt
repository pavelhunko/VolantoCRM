name := """play-java-intro"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

libraryDependencies ++= Seq(
  javaCore,
    javaJdbc,
  javaEbean,
    "mysql" % "mysql-connector-java" % "5.1.18"
)     
