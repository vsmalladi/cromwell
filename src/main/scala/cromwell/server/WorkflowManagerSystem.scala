package cromwell.server

import akka.actor.ActorSystem
import cromwell.engine.WorkflowManagerActor

trait WorkflowManagerSystem {
  val systemName = "cromwell-system"
  val actorSystem = ActorSystem(systemName)

  actorSystem.registerOnTermination {actorSystem.log.info(s"$systemName shutting down")}

  val workflowManagerActor = actorSystem.actorOf(WorkflowManagerActor.props)
}
