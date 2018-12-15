package com.novencia.bankaccount.actors

import java.util.Date

import akka.actor.{Actor, ActorRef, Props}
import com.novencia.bankaccount.actors.AccountOwner.Operation

object AccountOwner {
  def props(withdrawerActor: ActorRef): Props = Props(new AccountOwner(withdrawerActor))
  case class Operation(val operationAmount : BigDecimal, val date : Date)
}

class AccountOwner(withdrawerActor:ActorRef) extends Actor{
  override def receive = {
    case Operation(operationAmount,  date)           => withdrawerActor ! Operation(operationAmount,  date)
  }
}
