package com.novencia.bankaccount

class OperationType(val operationType:String, val operationSign:String)

object OperationType extends Enumeration {
  val PUT = "PUT";
  val TAKE = "TAKE";
}