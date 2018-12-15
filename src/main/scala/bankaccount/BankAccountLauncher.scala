package com.novencia.bankaccount

import java.util.Date

import akka.actor.{ActorRef, ActorSystem}
import com.novencia.bankaccount.actors.{AccountOwner, Withdrawer}
import com.novencia.bankaccount.actors.AccountOwner.Operation
import com.novencia.bankaccount.services.OperationService

object BankAccountLauncher extends App {

  val system: ActorSystem = ActorSystem("bankAccount")

  val bankAccount : BankAccount = new BankAccount(List(), BigDecimal(200))

  val operationService : OperationService = new OperationService(bankAccount)

  val withdrawer: ActorRef = system.actorOf(Withdrawer.props(operationService), "withdrawerActor")

  val firstAccountOwner: ActorRef =
    system.actorOf(AccountOwner.props(withdrawer), "firstAccountOwnerActor")

  val secondAccountOwner: ActorRef =
    system.actorOf(AccountOwner.props(withdrawer), "secondAccountOwnerActor")

  firstAccountOwner ! Operation(BigDecimal(40),  new Date())

  secondAccountOwner ! Operation(BigDecimal(40),  new Date())
}
