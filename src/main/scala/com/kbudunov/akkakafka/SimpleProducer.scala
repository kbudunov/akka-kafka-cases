package com.kbudunov.akkakafka

import akka.actor.ActorSystem
import akka.event.slf4j.SLF4JLogging
import akka.kafka.ProducerSettings
import akka.kafka.scaladsl.Producer
import akka.stream.scaladsl.Source
import com.kbudunov.akkakafka.utils.ProjectConfig
import com.typesafe.config.{ Config, ConfigFactory }
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer

object SimpleProducer extends SLF4JLogging {
  implicit val system: ActorSystem = ActorSystem("akka-kafka-cases")
  val projectConfig: ProjectConfig = ProjectConfig(ConfigFactory.load)
  val config: Config               = ConfigFactory.load.getConfig("akka.kafka.producer")

  def main(args: Array[String]): Unit = {
    log.info(s"App started!")
    val message          = projectConfig.someConfig.message
    val producerSettings = ProducerSettings(config, new StringSerializer, new StringSerializer)

    Source(1 to 10)
      .map(_.toString)
      .map(value => new ProducerRecord[String, String]("TEZZT", message + " " + value))
      .runWith(Producer.plainSink(producerSettings))
  }

}
