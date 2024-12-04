import sbt._

object Dependencies {

  lazy val AkkaVersion = "2.10.0"

  lazy val akkaActor = "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion
  lazy val logback   = "ch.qos.logback"     % "logback-classic"  % "1.4.11" % Runtime
  lazy val slf4j     = "org.slf4j"          % "slf4j-api"        % "2.0.16"
  object Test {
    lazy val akkaActor = "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion
    lazy val munit     = "org.scalameta"     %% "munit"                    % "0.7.29"
  }
}
