package fr.jcgay.github.sentry

import java.net.InetAddress.getLocalHost
import java.util.UUID

import com.getsentry.raven.dsn.Dsn
import com.getsentry.raven.event.EventBuilder
import com.getsentry.raven.event.helper.EventBuilderHelper
import com.getsentry.raven.event.interfaces.UserInterface
import com.getsentry.raven.{DefaultRavenFactory, Raven}

case class MyAppRavenFactory() extends DefaultRavenFactory {

  lazy val uuid: String = UUID.randomUUID.toString

  override def createRavenInstance(dsn: Dsn): Raven = {
    val raven = super.createRavenInstance(dsn)
    raven.addBuilderHelper(AddUser("jcgay", "contact@jeanchristophegay.com", uuid))
    raven
  }
}

case class AddUser(id: String, email: String, uuid: String) extends EventBuilderHelper {
  override def helpBuildingEvent(eventBuilder: EventBuilder): Unit =
    eventBuilder
      .withSentryInterface(new UserInterface(id, getLocalHost.getHostName, null, email))
      .withTag("session-uuid", uuid)
}