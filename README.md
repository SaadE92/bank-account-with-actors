# bank-account-with-actors
<b>Simple bank account API, using actors</b>

   This reimplements the same bank account app in https://github.com/SaadE92/bankaccount.git, 
 with scala and instead of a muti-threded launcher client, the use of actors model with akka
 library.
   
   In com.novencia.bankaccount.BankAccountLauncher we send two Operation messages to 2 actors 
   that plays the same roles of two threads accessing the same resource:
   
        firstAccountOwner ! Operation(BigDecimal(40),  new Date())

        secondAccountOwner ! Operation(BigDecimal(40),  new Date())
        
   But this time it's by sending messages asynchronously to another actor's mail box 
   com.novencia.bankaccount.actors.Withdrawer, to which we delegate the action of operating withdrawal
   on a given bankaccount resource.
