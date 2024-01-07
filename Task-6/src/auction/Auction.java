import java.util.ArrayList;

/**
 * A simple model of an auction.
 * The auction maintains a list of lots of arbitrary length.
 *
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class Auction {

    public static void main(String[] args){
        Auction myAuction = new Auction();
        myAuction.enterLot("Ferrari");
        myAuction.enterLot("Lambo");
        myAuction.enterLot("Volvo");
        Person farhan = new Person("Farhan");
        Person bob = new Person("Bob");

        myAuction.makeABid(1,bob,500);
        myAuction.makeABid(1,farhan,10000);
        myAuction.showLots();
    }

    //Exercise 4.48
    private void close(){
        for(Lot lot : lots) {
            Bid highestBidForLot = lot.getHighestBid();
            if(highestBidForLot == null){
                System.out.println("There is no bidder for the " + lot.getDescription());
            }
            else{
                System.out.println("The " + lot.getDescription() + " is now sold to " + highestBidForLot.getBidder().getName()+ " with a winning bid of " + highestBidForLot.getValue());
            }
        }
    }

    //Exercise 4.49
    public ArrayList<Lot> getUnsold(){
        ArrayList<Lot> unsoldLots = new ArrayList<>();
        for(Lot lot : lots) {
            if(lot.getHighestBid() == null){
                unsoldLots.add(lot);
            }
        }
        return unsoldLots;
    }

    //Exercise 4.50
    /* The getLot method creates a new Lot called selectedLot which stores the preceding lotNumber i.e. lotNumber - 1.
    Thus, if lots are removed, the "confidence check" may give an error as index numbers will change.
     */

    //Exercise 4.51
    public Lot getLot(int lotNumber)  {
        if((lotNumber >= 1)) {
            for(Lot lot: lots){
               if(lot.getNumber() == lotNumber){
                   return lot;
               }
            }
        }
        System.out.println("Lot number: " + lotNumber + " does not exist.");
        return null;
    }

    //Exercise 4.52
    /**
     * Remove the lot with the given lot number.
     * @param number The number of the lot to be removed.
     * @return The Lot with the given number, or null if
     * there is no such lot.
     */
    public Lot removeLot(int number){
        Lot lotToBeRemoved = getLot(number);
        if(lotToBeRemoved != null){
            lots.remove(lotToBeRemoved);
            return lotToBeRemoved;
        }
        else{
            return null;
        }
    }
    
    // The list of Lots in this auction.
    private ArrayList<Lot> lots;
    // The number that will be given to the next lot entered
    // into this auction.
    private int nextLotNumber;

    /**
     * Create a new auction.
     */
    public Auction() {
        lots = new ArrayList<>();
        nextLotNumber = 1;
    }

    /**
     * Enter a new lot into the auction.
     * @param description A description of the lot.
     */
    public void enterLot(String description) {
        lots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }

    /**
     * Show the full list of lots in this auction.
     */
    public void showLots() {
        for(Lot lot : lots) {
            System.out.println(lot.toString());
        }
    }

    /**
     * Make a bid for a lot.
     * A message is printed indicating whether the bid is
     * successful or not.
     *
     * @param lotNumber The lot being bid for.
     * @param bidder The person bidding for the lot.
     * @param value  The value of the bid.
     */
    public void makeABid(int lotNumber, Person bidder, long value) {
        Lot selectedLot = getLot(lotNumber);
        if(selectedLot != null) {
            Bid bid = new Bid(bidder, value);
            boolean successful = selectedLot.bidFor(bid);
            if(successful) {
                System.out.println("The bid for lot number " +
                        lotNumber + " was successful.");
            }
            else {
                // Report which bid is higher.
                Bid highestBid = selectedLot.getHighestBid();
                System.out.println("Lot number: " + lotNumber +
                        " already has a bid of: " +
                        highestBid.getValue());
            }
        }
    }

    /**
     * Return the lot with the given number. Return null
     * if a lot with this number does not exist.
     * @param lotNumber The number of the lot to return.
     */
    public Lot oldGetLot(int lotNumber) {
        if((lotNumber >= 1) && (lotNumber < nextLotNumber)) {
            // The number seems to be reasonable.
            Lot selectedLot = lots.get(lotNumber - 1);
            // Include a confidence check to be sure we have the
            // right lot.
            if(selectedLot.getNumber() != lotNumber) {
                System.out.println("Internal error: Lot number " +
                        selectedLot.getNumber() +
                        " was returned instead of " +
                        lotNumber);
                // Don't return an invalid lot.
                selectedLot = null;
            }
            return selectedLot;
        }
        else {
            System.out.println("Lot number: " + lotNumber +
                    " does not exist.");
            return null;
        }
    }
}
