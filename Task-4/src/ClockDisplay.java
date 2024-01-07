/**
    In this class I edited/added three things to make it a 12-hour clock
        1.  hours = new NumberDisplay(13);    lines 24 and 37
        2.  setTime(12,00);                   line 26   
        3.  if(hours.getValue() == 0) {  
            hours.increment(); }        in the timeTick method.  line 52-54

    I did not edit the NumberDisplay class but added it anyways.  


 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 12:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(13);          //sets limit of clock to 13, so the maximum value is 12
        minutes = new NumberDisplay(60);
        setTime(12,0);                         //sets the clock to 12.00          
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute)
    {
        hours = new NumberDisplay(13);              //sets limit of clock to 13, so the maximum value is 12
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        if(hours.getValue() == 0) {             //if the hour becomes 0, the increment method is called to make its value 1 instead. This makes the clock only go from 1-12.  
            hours.increment();
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue();
    }
}