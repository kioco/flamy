import NativePackagerHelper._

lazy val commonSettings = Seq(
  organization := "com.flaminem",
  name := "flamy",
  version := "0.7.0-SNAPSHOT",
  scalaVersion := "2.11.8"
)

lazy val macros = 
  (project in file("macros"))
  .settings(commonSettings)

lazy val root = 
  (project in file("."))
  .dependsOn(macros)
  .aggregate(macros)
  .settings(commonSettings)

scalaVersion := "2.11.8"

scalacOptions in Compile ++= Seq("-unchecked",  "-deprecation",  "-feature")

enablePlugins(JavaAppPackaging)

mappings in Universal ++= directory("conf")

mappings in Universal ++= directory("bin")

parallelExecution in Test := false

javaOptions in Test += "-XX:MaxPermSize=1G -XX:MaxMetaspaceSize=1G"

mappings in (Compile, packageDoc) := Seq()

// fork in Test := true

