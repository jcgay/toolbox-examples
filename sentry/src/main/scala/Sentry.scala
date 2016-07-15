import com.getsentry.raven.RavenFactory
import fr.jcgay.github.sentry.MyAppRavenFactory
import org.slf4j.{LoggerFactory, MDC}

object Sentry {

  def main(args: Array[String]) {

    RavenFactory.registerFactory(MyAppRavenFactory())

    def logger = LoggerFactory.getLogger(Sentry.this.getClass)
    logger.warn("Warning message 1")

    MDC.put("Environment", "Dev")
    logger.warn("Warning message 2")
    MDC.remove("Environment")
  }
}
