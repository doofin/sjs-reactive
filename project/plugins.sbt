resolvers ++= Seq(
  "Typesafe Releases" at "https://repo.typesafe.com/typesafe/releases/")


addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.29") //28
addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler" % "0.13.1") //"0.9.0"
addSbtPlugin("com.vmunier" % "sbt-web-scalajs" % "1.0.6")
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.3.2")
addSbtPlugin("io.spray" % "sbt-revolver" % "0.9.1")

//addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.6")
//addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.0.3")
//addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.3.4")
