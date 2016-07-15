lazy val root = (project in file(".")).
  settings(
    name := "sentry",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.11.8"
  )

libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.1.7",
  "com.getsentry.raven" % "raven-logback" % "7.3.0"
)

scalacOptions += "-target:jvm-1.7"
