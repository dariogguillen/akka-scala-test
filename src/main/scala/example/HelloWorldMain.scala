package example

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.ActorSystem

object HelloWorldMain {
  final case class SayHello(name: String)

  def apply(): Behavior[SayHello] = Behaviors.setup { context =>
    val greeter = context.spawn(HelloWorld(), "greeter")

    Behaviors.receiveMessage { message =>
      val replayTo = context.spawn(HelloWorldBot(3), message.name)
      greeter ! HelloWorld.Greet(message.name, replayTo)
      Behaviors.same
    }
  }

  val test = "hello"

  def main(args: Array[String]) = {
    val system: ActorSystem[SayHello] = ActorSystem(HelloWorldMain(), "hello")

    system ! SayHello("World")
    system ! SayHello("Akka")
  }
}
