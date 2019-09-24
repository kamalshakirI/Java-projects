
/**
 * An alarm for the clock, if it is On or Off, displayed in 12 hour clock
 *
 * @author (Kamaluddin Shakiri)
 * @version 2019.09.20
 */
public class Alarm
{
    private ClockDisplay12 alarm;
    private boolean alarmFlag;

    /**
     * Constructor for objects of class Alarm
     */
    public Alarm()
    {
        alarm = new ClockDisplay12(12, 0, "am");
        alarmFlag = false;
        
    }

    /**
     * Setting the alarm time.  If invalid it is changed to a valid value: hours to 12, minutes to 0,
     * amPm to "a.m.". 
     * @param hours The alarm time hours (1-12)
     * @param minutes The alarm time minutes (0-59)
     * @param amPm "a.m." or "p.m."
     */
    public Alarm(int hour, int minute, String amPM, boolean alarmSet)
    {
        alarm = new ClockDisplay12(hour, minute, amPM);
        alarmFlag = alarmSet;
    }
    
    public void setTime( int hour, int minute, String amPM){
        alarm.setTime(hour, minute, amPM);
        //this.alarmTime = new ClockDisplay12();
    }
    
    /**
     * Turns the alarm on.  (does nothing if alarm is on from before.)
     */
    public void turnOn()
    {
        alarmFlag = true;
    }
    /**
     * Turns the alarm off.  (Does nothing if alarm is off from before.)
     */
    public void turnOff()
    {
        alarmFlag = false;
    }
    /**
     * Returns a String representation of the time, for example: "12:01a.m."
     */
    public String getTime()
    {
        return alarm.getTime();
    }
    /**
     * Returns true if the alarm is set, otherwise return false.
     */
    public boolean isSet()
    {
        return alarmFlag;
    }
    
}
