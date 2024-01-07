/**
 * Read web server data and analyse hourly access patterns.
 *
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */
public class LogAnalyzer  {

    public static void main(String[] args){
        LogAnalyzer analyzer = new LogAnalyzer();

        System.out.println(analyzer.numberOfAccesses());
        System.out.println(analyzer.busiestHour());
    }

    //Exercise 4.73 + 4.74
    /**
     * Return the number of accesses recorded in the log
     * file.
     */
    public int numberOfAccesses() {
        int total = 0;
        // Add the value in each element of hourCounts // to total.
        for (int i = 0; i < hourCounts.length ; i++) {
            total += hourCounts[i];
        }
        return total;
    }

    //Exercise 4.75
    // A for-each loop is better because we are iterating through an array
    public int busiestHour(){
        int busiestHour = 0;
        for(int hour : hourCounts){
            if(hourCounts[hour] > hourCounts[busiestHour]){
                busiestHour = hour;
            }
        }
        return busiestHour;
    }

    //Exercise 4.76
    public int quietestHour(){
        int quietestHour = 0;
        for(int hour : hourCounts) {
            if (hourCounts[hour] < hourCounts[quietestHour]) {
                quietestHour = hour;
            }
        }
        return quietestHour;
    }

    //Exercise 4.77
    //The first hour with the largest count.

    //Exercise 4.78
    public int busiestTwoHours(){
        int busiestFirstHour = 0;
        int busiestTwoHours = 0;
        int twoHourSum = 0;
        //this checks for periods from 0 to 23
        for(int hour = 0; hour < hourCounts.length -1;hour++){      //goes up to hourCounts[22]
            twoHourSum = hourCounts[hour] + hourCounts[hour + 1];   //last hour+1 index is 23
            if(twoHourSum > busiestTwoHours ){
                busiestFirstHour = hour;
                busiestTwoHours = twoHourSum;
            }
        }
        //A check for the period 23 to 0
        twoHourSum = hourCounts[23] + hourCounts[0];
        if(twoHourSum > busiestTwoHours){
            busiestFirstHour = 23;
        }

        return busiestFirstHour;
    }

    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer() {
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData() {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts() {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }

    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData() {
        reader.printData();
    }
}
