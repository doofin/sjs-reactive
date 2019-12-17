import sbt.Keys._
import sbt._
import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._

object depsAndOptions {

  scalaVersion := "2.12.8"
  scalacOptions ++= Seq("-Xcheckinit")

  val akkaV = "2.5.17"
  val akkaHttpV = "10.1.5"
  val circeVersion = "0.9.3"

  val jvmDeps = Seq(
    "org.scalatest" %% "scalatest" % "3.0.5",
    "com.twitter" %% "chill-akka" % "0.9.2",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.7.2",
    "ch.qos.logback" % "logback-classic" % "1.2.3",
    "org.slf4j" % "slf4j-nop" % "1.6.4",
    "org.platanios" %% "tensorflow" % "0.2.4" classifier "linux-cpu-x86_64",
    "com.softwaremill.quicklens" % "quicklens_2.12" % "1.4.11",
    "net.ruippeixotog" %% "scala-scraper" % "2.1.0"
  )
  
  val jvmAkkaDeps: Seq[ModuleID] = Seq(
    "com.typesafe.akka" %% "akka-actor-typed" % akkaV,
    "com.typesafe.akka" %% "akka-cluster-typed" % akkaV,
    "com.typesafe.akka" %% "akka-stream-typed" % akkaV,
    "com.typesafe.akka" %% "akka-cluster-sharding-typed" % akkaV,
    "com.typesafe.akka" %% "akka-persistence-typed" % akkaV,
    //
    "com.typesafe.akka" %% "akka-stream" % akkaV,
    "com.typesafe.akka" %% "akka-slf4j" % akkaV,
    "com.typesafe.akka" %% "akka-actor" % akkaV,
    "com.typesafe.akka" %% "akka-stream" % akkaV,
    "com.typesafe.akka" %% "akka-cluster" % akkaV,
    "com.typesafe.akka" %% "akka-cluster-tools" % akkaV,
    "com.typesafe.akka" %% "akka-http" % akkaHttpV,
    "com.typesafe.akka" %% "akka-http-caching" % akkaHttpV
  )

  //webpackConfigFile := Some(baseDirectory.value / "saved" / "config.js")

  val catsV = "1.4.0"
  val typesAndcatsDeps = Seq(
    "org.typelevel" %% "cats-core" % catsV,
    "org.typelevel" %% "cats-free" % catsV,
    "com.chuusai" %% "shapeless" % "2.3.3",
    "org.atnos" %% "eff" % "5.3.0"
  )
  val janusV = "0.3.2" //"0.4.0"
  /*
    Apache Cassandra 2.2.10, 3.0.14, 3.11.0
    Apache HBase 1.2.6, 1.3.1, 1.4.10, 2.1.5
    Google Bigtable 1.3.0, 1.4.0, 1.5.0, 1.6.0, 1.7.0, 1.8.0, 1.9.0, 1.10.0, 1.11.0
    Oracle BerkeleyJE 7.5.11
    Elasticsearch 5.6.14, 6.0.1, 6.6.0
    Apache Lucene 7.0.0
    Apache Solr 7.0.0
    Apache TinkerPop 3.4.1
    Java 1.8
*/
  val jvmPersistentDeps = Seq(
    "org.postgresql" % "postgresql" % "9.4.1208",
    "io.getquill" %% "quill-core" % "2.4.1",
    "io.getquill" %% "quill-jdbc" % "2.4.1",
    "com.typesafe.slick" %% "slick" % "3.2.3",
    "com.typesafe.slick" %% "slick-hikaricp" % "3.2.3",
    "org.janusgraph" % "janusgraph-core" % janusV,
    "org.janusgraph" % "janusgraph-cassandra" % janusV,
    "org.janusgraph" % "janusgraph-cql" % janusV,
    "org.janusgraph" % "janusgraph-es" % janusV,
    "com.michaelpollmeier" %% "gremlin-scala" % "3.3.3.4",
    "org.apache.tinkerpop" % "gremlin-driver" % "3.3.3"
  )
  val jvmDepsAll = jvmAkkaDeps ++ typesAndcatsDeps ++ jvmPersistentDeps ++ jvmDeps

  val myScalacOptions = Seq(
    "-feature",
    "-Xfuture",
    "-language:higherKinds,implicitConversions",
    "-Ywarn-inaccessible",
    "-Ywarn-infer-any",
    "-Ywarn-nullary-override",
    "-deprecation",
    "-unchecked",
    "-Ypartial-unification",
    "-language:postfixOps"
  )

}
/*
import sbtassembly.MergeStrategy
enablePlugins(mySparkSubmitPlugin)
enablePlugins(mySparkSubmitYARN)
addCommandAlias("spksubm", "sparkSubmit --deploy-mode client --class cuttingedge.Main")
addCommandAlias("assemb", ";reload;assembly")
addCommandAlias("rlr", ";reload;run")
test in assembly := {}
val stringToStrategy: String => MergeStrategy = {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case "application.conf"            => MergeStrategy.concat
  case x                             => MergeStrategy.first
}

assemblyMergeStrategy in assembly := stringToStrategy
 */
//println(libraryDependencies.map(_.toString()))
//libraryDependencies ~= { _.map(_.exclude("ch.slf4j", "slf4j-nop")) }
//addSbtPlugin("org.portable-scala" % "sbt-scala-native-crossproject" % "0.5.0")
//addSbtPlugin("org.scala-native"   % "sbt-scala-native"              % "0.3.7")

//addSbtPlugin("com.typesafe.sbt"   % "sbt-native-packager" % "1.3.4")
//enablePlugins(JavaAppPackaging)
//enablePlugins(UniversalPlugin)
//sources in doc in Compile := List()
//publishArtifact in packageDoc := false
//publishArtifact in packageSrc := false

//javaOptions+=" -Xmx60G"
//javaOptions += "-Djava.library.path=/usr/lib/python3.7/site-packages/jep"
//javaOptions += "-Djava.library.path=./so"
//javaOptions+=" -Xmx63360m"
//offline := true
//updateOptions := updateOptions.value.withCachedResolution(true)

//resolvers += "Spark Packages Repo" at "http://dl.bintray.com/spark-packages/maven"
//libraryDependencies += "neo4j-contrib" % "neo4j-spark-connector" % "2.1.0-M4"
