/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class TicketMachine {

    private int price;
    private int balance;
    private int total;
    
    //EXERCISE 2.44
    public TicketMachine(int price){
        this.price = price;
        this.balance = 0;
        this.total = 0;
    }

    public TicketMachine(){
        this.price = 99;
        this.balance = 0;
        this.total = 0;
    }

    //EXERCISE 2.45
    //This method does not need any parameters. It is a mutator method as it changes the value of the total variable.  
    public void empty(){
        total = 0;
    }

    //EXERCISE 2.58
    //The problem with the new method is that it never stores the amount that should be refunded, and simply resets the balance to 0 and returns this resetted balance. 
    //Thus, 0 will always be the refunded amount.  
    /*
        This can be tested by:  
            1. inserting money using insertMoney(100) method
            2. printing the return value of getBalance()
            3. printing the return value of refundBalance()

        This will show that 0 is refunded with the new method. If this test is conducted on the original method, 100 will be refunded. 
    */

    //Testing the refund methods
    public static void main(String[] args){
        TicketMachine machine = new TicketMachine();
        machine.insertMoney(100);
        System.out.println("Current balance " + machine.getBalance());
        System.out.println("You are refunded: " + machine.refundBalance());        //0 is refunded

        machine.insertMoney(100);
        System.out.println("Current balance " + machine.getBalance());
        System.out.println("You are refunded: " + machine.refundBalanceOld());        //100 is refunded
    }


    //Original method
     public int refundBalanceOld() {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }  

    //New method
    public int refundBalance() {
        balance = 0;
        return balance;
    } 
      
    //EXERCISE 2.59
    /*
    public int refundBalance() {
       return balance;
       balance = 0;
    }

    The program will encounter an error and not compile because line 67 is an unreachable statement. It is unreachable because a method stops executing after a return statement. Thus, the return statement must always be last in the method.   

    */

    //EXERCISE 2.60
   /* public TicketMachine(int cost) {
        int price = cost;
        balance = 0;
        total = 0; */

    /*Yes, the program compiles. However, when creating a TicketMachine object, the price will always be 0. This is because of the int variable declaration 
    which creates a local price variable that is different to the price variable used everywhere else in the program.
    Therefore, the real price variable is never changed, which is the reason why it is 0.    
    */

    //EXERCISE 2.61
    public int emptyMachine(){
        
        int tempTotal; 
        tempTotal = total;
        total = 0;
        return tempTotal;
    }

    //Other methods not used for exercises
     public int getPrice()  {
        return price;
    }

    public int getBalance()    {
        return balance;
    }

    public void insertMoney(int amount)
    {
        if(amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Use a positive amount rather than: " +
                               amount);
        }
    }

    public void printTicket()
    {
        if(balance >= price) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the price.
            balance = balance - price;
        }
        else {
            System.out.println("You must insert at least: " +
                               (price - balance) + " more cents.");
                    
        }
    }
}
