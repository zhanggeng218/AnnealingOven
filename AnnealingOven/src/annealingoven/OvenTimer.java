package annealingoven;

import java.util.Timer;
import java.util.TimerTask;

public abstract class OvenTimer {
    
    public double currentTemperature;
    public Timer timer;
    public TimerTask timerTask;
    public boolean softTurnOff;
	
    public OvenTimer() {
        
	timer = new Timer();
	softTurnOff = true;
    }
	
    public void turnOn() {
        currentTemperature += 2;
    }
	
    public void turnOff() {
        currentTemperature -= 1;
    }
	
    public double getCurrentTemperature() {
        return currentTemperature;
    }
	
    public abstract void Tick();
}