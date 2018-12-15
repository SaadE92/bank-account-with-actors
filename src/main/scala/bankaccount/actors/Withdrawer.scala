package com.novencia.bankaccount.actors

import akka.actor.{Actor, Props}
import com.novencia.bankaccount.actors.AccountOwner.Operation
import com.novencia.bankaccount.services.OperationService

object Withdrawer {
  def props(operationService: OperationService): Props = Props(new Withdrawer(operationService))
}

class Withdrawer(operationService: OperationService) extends Actor{

  override def receive = {
      case Operation(operationAmount,  date) => {
        println("Operation received (from " + sender() + "): " + Operation + " ( "+ operationService.bankAccount.balance_ +" )")
        operationService.withraw(Operation(operationAmount,  date), operationService.bankAccount)
        println("Operation finished (from " + sender() + "): " + Operation.toString + " ( "+ operationService.bankAccount.balance_ +" )")
      }
  }
}

