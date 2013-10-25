import ch.epfl.lamp.sbtscalajs._

val buildSettings = Defaults.defaultSettings ++ ScalaJSPlugin.scalaJSSettings ++ Seq(
  organization := "com.github.hexx",
  scalaVersion := "2.10.3",
  scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked", "-language:_")
)

lazy val example = project in file(".") settings(
  buildSettings: _*
) settings(
  unmanagedSources in (Compile, ScalaJSKeys.packageJS) += baseDirectory.value / "js" / "startup.js"
) dependsOn scalaz

lazy val scalazCore = ProjectRef(base = file("scalaz/source"), id = "core")

lazy val scalaz = project settings(
  buildSettings: _*
) settings(
  unmanagedSourceDirectories in Compile <+= baseDirectory(_ / "source" / "core")
) dependsOn scalazCore
