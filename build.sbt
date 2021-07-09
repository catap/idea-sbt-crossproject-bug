import sbtcrossproject.CrossPlugin.autoImport.crossProject

lazy val scala211 = "2.11.12"
lazy val scala212 = "2.12.13"
lazy val scala213 = "2.13.6"
lazy val scala3 = "3.0.1"

lazy val blake3Version = "latest.integration"

lazy val scalaJVMCrossVersion = Seq(scala212, scala211, scala213, scala3)
lazy val scalaJsCrossVersion = Seq(scala212, scala211, scala213, scala3)
lazy val scalaNativeCrossVersion = Seq(scala212, scala211, scala213)

ThisBuild / organization := "com.github.catap"

ThisBuild / scalaVersion := scala213
crossScalaVersions := Seq()
ThisBuild / scalacOptions ++= Seq(
)

lazy val `ideaBug` = crossProject(JSPlatform, JVMPlatform, NativePlatform)
  .crossType(CrossType.Pure)
  .in(file("."))
  .settings(
    libraryDependencies ++= Seq(
      "ky.korins" %%% "blake3" % blake3Version
    )
  )
  .jsSettings(
    crossScalaVersions := scalaJsCrossVersion
  )
  .jvmSettings(
    crossScalaVersions := scalaJVMCrossVersion
  )
  .nativeSettings(
    crossScalaVersions := scalaNativeCrossVersion
  )
