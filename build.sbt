ThisBuild / scalaVersion := "2.13.15"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "test-akka",
    libraryDependencies ++= Seq(
      Dependencies.akkaActor,
      Dependencies.logback,
      Dependencies.slf4j,
      Dependencies.Test.akkaActor % Test,
      Dependencies.Test.munit     % Test
    ),
    semanticdbEnabled := true,
    semanticdbVersion := scalafixSemanticdb.revision,
    Compile / scalacOptions := Seq(
      "-Wunused",
      "-feature",
      "-unchecked",
      "-deprecation",
      "-Xlint:unused"
    ),
    resolvers += "Akka library repository".at("https://repo.akka.io/maven")
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
