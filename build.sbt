import Dependencies._
name := "base-akka-sample"

version := "0.1"

scalaVersion := s"$scalaCompat.11"

libraryDependencies ++= Seq(
  Logging.Slf4jApi,
  Logging.Log4jSlf4jImpl,
  Akka.Stream,
  Akka.KafkaStreams,
  Akka.AkkaSlf4j,
  Testing.scalaTest,
  Testing.akkaStreamTestkit
)

lazy val commonSettings = Seq(
  scalaVersion := s"$scalaCompat.11",
  scalacOptions ++= Seq(
    "-target:jvm-1.8",
    "-deprecation",
    "-encoding",
    "utf-8",
    "-Xlog-reflective-calls",
    "-Xlint",
    "-explaintypes",
    "-feature",
    "-language:_",
    "-unchecked",
    "-Xcheckinit",
    "-Xfatal-warnings",
    "-Xfuture",
    "-Xlint:adapted-args",
    "-Xlint:by-name-right-associative",
    "-Xlint:constant",
    "-Xlint:delayedinit-select",
    "-Xlint:doc-detached",
    "-Xlint:inaccessible",
    "-Xlint:infer-any",
    "-Xlint:missing-interpolator",
    "-Xlint:nullary-override",
    "-Xlint:nullary-unit",
    "-Xlint:option-implicit",
    "-Xlint:package-object-classes",
    "-Xlint:poly-implicit-overload",
    "-Xlint:private-shadow",
    "-Xlint:stars-align",
    "-Xlint:type-parameter-shadow",
    "-Xlint:unsound-match",
    "-Yno-adapted-args",
    "-Ypartial-unification",
    "-Ywarn-dead-code",
    "-Ywarn-extra-implicit",
    "-Ywarn-inaccessible",
    "-Ywarn-infer-any",
    "-Ywarn-nullary-override",
    "-Ywarn-nullary-unit",
    "-Ywarn-unused",
    "-Ywarn-unused:implicits",
    "-Ywarn-unused:imports",
    "-Ywarn-unused:locals",
    "-Ywarn-unused:params",
    "-Ywarn-unused:patvars",
    "-Ywarn-unused:privates"
  ),
  scalacOptions in (Test, console) := (scalacOptions in (Compile, console)).value
)

lazy val suppressWarnSettings = Seq(
  scalacOptions --= Seq(
    "-Ywarn-unused",
    "-Ywarn-unused:implicits",
    "-Ywarn-unused:imports",
    "-Ywarn-unused:locals",
    "-Ywarn-unused:params",
    "-Ywarn-unused:patvars",
    "-Ywarn-unused:privates",
    "-Xlint"
  )
)
