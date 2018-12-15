package com.novencia.bankaccount

import com.novencia.bankaccount.actors.AccountOwner.Operation

class BankAccount(val operations:List[Operation], var balance:BigDecimal) {

  var balance_ = balance

  def addOperation(operation:Operation) = operations :: (List(operation))

}
