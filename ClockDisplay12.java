
/**
 * The ClockDisplay12 class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Kamaluddin Shakiri
 * @version 2019.09.20
 */
public class ClockDisplay12
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    public static final String am = "am";
    public static final String pm = "pm";
    private String dayNight;
    
    
    /**
     *  This constructor creates a new clock.
     */
    public ClockDisplay12()
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        dayNight = am;
        setTime(12, 00, am);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay12(int hour, int minute, String amPM)
    {
        //if (time.equals ("am")|| time.equals("pm"))
          //  amPm = time;
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        setTime(hour, minute, amPM);
        updateDisplay();
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // for roll over!
            hours.increment();
            if (hours.getValue()==0 || hours.getValue()== 12) {
                hours.setValue(12);
                
                changeAmPm();
         
            }
        }
        updateDisplay();
    }
   
    /**
     * A simple method which changes the a.m. to p.m. and vice versa
    */
    public void changeAmPm()
    {
        if (dayNight.equals(am))
        {
            dayNight = pm;
        }
        else 
        {
            dayNight = am;
        }
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute, String amPM)
    {
        if (amPM.equals(am))
        {
        hours.setValue(hour);
        minutes.setValue(minute);
        dayNight = am;
        updateDisplay();
    }
    else if (amPM.equals(pm))
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        dayNight = pm;
        updateDisplay();
    }/*
    else
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        dayNight = am;
        updateDisplay();
    }*/
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
        displayString = hours.getDisplayValue() + ":" + minutes.getDisplayValue() + " " + dayNight;
    }
}
