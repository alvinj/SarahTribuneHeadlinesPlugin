package com.devdaily.sarah.plugin.chicagotribune

import com.devdaily.sarah.plugins._
import akka.actor.ActorSystem
import scala.concurrent.{ Await, Future }
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

class TribuneSportsHeadlinesPlugin extends SarahPlugin {

  val WHAT_USER_SAYS = "get tribune headlines"
  val TRIB_URL = "http://www.chicagotribune.com/sports/"
  val phrasesICanHandle = List(WHAT_USER_SAYS)
  
  var canonPluginDirectory = ""
  implicit val system = ActorSystem("TribuneActorSystem")
  
  // sarah callback
  def textPhrasesICanHandle: List[String] = {
      return phrasesICanHandle
  }

  // sarah callback
  override def setPluginDirectory(dir: String) {
      canonPluginDirectory = dir
  }

  // this method is no longer called, but is currently needed to satisfy the api
  def startPlugin = {}

  // sarah callback. handle our phrases when we get them.
  def handlePhrase(phrase: String): Boolean = {
      if (phrase.trim.equals(WHAT_USER_SAYS)) {
          val f1 = Future { brain ! PleaseSay("Stand by.") }
          val f2 = Future { brain ! PleaseSay(TribuneUtils.getTribuneHeadlines) }
          true
      } else {
          false
      }
  }

}




