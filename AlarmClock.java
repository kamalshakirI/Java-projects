
/**
 * AlarmClock class will implement the methods that are created in the Alarm and the ClockDisplay12 classes.
 * It will be a final class which will connect all the previous classes.
 * 
 * @author Kamaluddin Shakiri
 * @version 2019.09.20
 */
public class AlarmClock
{
    private Alarm alert; // alert represents the alarm
    private ClockDisplay12 clock; // represents the clock/time

    /**
     * The following constructor sets the clock to 12 am, and the alarm off.
     */
    public AlarmClock()
    {
        alert = new Alarm(12, 0, "a.m.", false); 
        clock = new ClockDisplay12(12, 0, "a.m.");
        
    }
    /**
     * The following constructor will let the user to input the parameters such as:
     *  clockHour, clockMinute, clockAmPm, alertHour, alertMinute , and if the alarm is on or off.
     */

    public AlarmClock(int clockHour, int clockMinute, String clockAmPm, int alertHour, 
                       int alertMinute, String alertAmPm, boolean alarmSet)
    {
        clock = new ClockDisplay12(clockHour, clockMinute, clockAmPm);
        alert = new Alarm(alertHour, alertMinute, alertAmPm, alarmSet);
    }
                            
    /**
     * The following method will set the time of the clock.
     */
    public void setTime(int hour, int minute, String amPM)
    {
        clock.setTime(hour, minute, amPM);
    }
    
    /**
     * The following method will se the time of the alarm.
     */
    public void setAlarmTime(int hour, int minute, String amPM)
    {
        alert.setTime(hour, minute, amPM);
    }

    /**
     * The following method will increase the minute and check if the clock is exactly as the alarm time
     * and the alarm is ON.
     */
    public void clockTick()
    {
        clock.timeTick();
        if (clock.getTime().equals(alert.getTime()) && isAlarmSet() == true)
        {
            System.out.println("RING RING RING");
            unsetAlarm();
        }
    }
    
    /**
     * The following method will turn the alarm on.
     */
    public void setAlarm()
    {
        alert.turnOn();
    }
    /**
     * The following method will turn the alarm off.
     */
     public void unsetAlarm()
    {
        alert.turnOff();
    }
    /**
     * The follwing method will get the current clock time.
     */
    
    public String getTime()
    {
        return clock.getTime();
    }
    /** 
     * The following method will get the current alarm time of the clock.
     */
    
    public String getAlarmTime()
    {
        return alert.getTime();
    }
     /**
     * The follwing method will let the user know if the alarm is on or off.
     */
    
    public boolean isAlarmSet()
    {
        return alert.isSet();
    }
}

