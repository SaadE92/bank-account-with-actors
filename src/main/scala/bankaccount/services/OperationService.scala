package com.novencia.bankaccount.services

import com.novencia.bankaccount.BankAccount
import com.novencia.bankaccount.actors.AccountOwner.Operation

class OperationService(val bankAccount : BankAccount) {

  def bankAccount_ = bankAccount

  def withraw(operation:Operation, bankAccount: BankAccount):BigDecimal =
  {
    val newBalance : BigDecimal = bankAccount.balance_ - operation.operationAmount
    if(newBalance.signum == -1) {
      print("cannot withraw " + operation.operationAmount + ", not enough money for: " + Thread.currentThread + " to withdraw")
      return newBalance
    }
    bankAccount.balance_ = newBalance
    bankAccount.addOperation(Operation(operation.operationAmount, operation.date))
    bankAccount.balance
  }

  def deposit(operation: Operation, bankAccount: BankAccount):BigDecimal = null

  def getOperations(bankAccount: BankAccount) : List[Operation] = bankAccount.operations

}
