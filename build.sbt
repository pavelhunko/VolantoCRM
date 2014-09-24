name := """play-java-intro"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

libraryDependencies ++= Seq(
  javaCore,
    javaJdbc,
  javaEbean,
    "org.xerial" % "sqlite-jdbc" % "3.7.15-M1"
)     
