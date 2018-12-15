import java.util.Date

import akka.actor.ActorSystem
import akka.testkit.{TestKit, TestProbe}
import com.novencia.bankaccount.BankAccount
import com.novencia.bankaccount.actors.AccountOwner.Operation
import com.novencia.bankaccount.actors.{AccountOwner, Withdrawer}
import com.novencia.bankaccount.services.OperationService
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}

import scala.concurrent.duration._


class WithdrawerSpec(_system: ActorSystem)
  extends TestKit(_system)
    with Matchers
    with WordSpecLike
    with BeforeAndAfterAll {


  def this() = this(ActorSystem("BankAccountSpec"))

  override def afterAll: Unit = {
    shutdown(system)
  }

  "A Withrawer Actor" should {
    "pass on an operation amount" in {
      val testProbe = TestProbe()
      val operation : Operation = Operation(BigDecimal(40),  new Date())
      val bankAccount : BankAccount = new BankAccount(List(), BigDecimal("100"));
      val operationService = new OperationService(bankAccount);
      val accountOwner = system.actorOf(AccountOwner.props(testProbe.ref))
      accountOwner ! operation
      testProbe.expectMsg(10000 millis, operation)
    }
  }

}