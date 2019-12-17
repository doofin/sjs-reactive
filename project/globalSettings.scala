import sbt.{Def, _}
import Keys._
import build._
object globalSettings extends AutoPlugin {
  override def trigger = allRequirements
//  val pjj = (project in file("jj")).settings()
//  override def extraProjects = Seq(build.shared,build.jvm,build.js)
  override def globalSettings =
    Seq(
      ("jsdev", ";project js; ~js/fastOptJS::webpack"),
      ("jvmdev", ";project jvm;~reStart"),
      ("jrun", "jvm/reStart"),
      ("jstop", "jvm/reStop"),
      ("run", "jvm/run")
    ).flatMap(x => addCommandAlias(x._1, x._2))
}
