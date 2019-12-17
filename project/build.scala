import sbt._
import Keys._

import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._
import com.typesafe.sbt.packager.archetypes.JavaAppPackaging
import com.typesafe.sbt.packager.universal.UniversalPlugin
import com.typesafe.sbt.web.Import.{Assets, pipelineStages}
import com.typesafe.sbt.web.SbtWeb
import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.AutoImport.{
  emitSourceMaps,
  fastOptJS,
  fullOptJS,
  scalaJSUseMainModuleInitializer
}
import sbt.internal.io.Source
import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin
import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin.autoImport.{
  BundlingMode,
  webpackBundlingMode
}
import webscalajs.ScalaJSWeb
import webscalajs.WebScalaJS.autoImport.{scalaJSPipeline, scalaJSProjects}

object build {
  lazy val js: Project = (project in file("."))
    .enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin, ScalaJSWeb) //ScalaJSWeb is for sourcemap
    .settings(
      libraryDependencies ++= Seq(
         "com.raquo" %%% "laminar" % "0.4" //"0.3"
      ),
      webpackBundlingMode := BundlingMode.LibraryAndApplication(),
      scalaJSUseMainModuleInitializer := true,
      emitSourceMaps in fastOptJS := true,
      emitSourceMaps in fullOptJS := false
    )
}

//      watchSources += srcDir((ThisBuild / baseDirectory).value / "shared/src")
