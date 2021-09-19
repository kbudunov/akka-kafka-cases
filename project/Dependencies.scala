import sbt._

object Dependencies {
  val scalaCompat = "2.12"

  private object Version {
    val akka = "2.6.4"
  }

  object Akka {
    val AkkaSlf4j    = "com.typesafe.akka" %% "akka-slf4j"        % Version.akka
    val KafkaStreams = "com.typesafe.akka" %% "akka-stream-kafka" % "1.0-RC1"
    val Stream       = "com.typesafe.akka" %% "akka-stream"       % Version.akka
  }

  object Logging {
    val Slf4jApi       = "org.slf4j"                % "slf4j-api"        % "1.7.30"
    val Log4jSlf4jImpl = "org.apache.logging.log4j" % "log4j-slf4j-impl" % "2.13.0"
  }

  object Testing {
    val scalaTest         = "org.scalatest"     %% "scalatest"           % "3.1.1" % Test
    val akkaStreamTestkit = "com.typesafe.akka" %% "akka-stream-testkit" % "2.6.4" % Test
  }
}
