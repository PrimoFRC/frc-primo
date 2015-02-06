package org.usfirst.frc.team4586.robot.subsystems;

import org.usfirst.frc.team4586.robot.RobotMap;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BoxLifter extends Subsystem {
	private boolean wasReleased;
    public static final int numOfValves=5;
    
    private boolean isMovingDown;
	// Put methods for controlling this subsystem
	// here. Call these from Commands
	private Talon lifter;
	private Talon lifter2;
    
	private DigitalInput checkContact1;
	private DigitalInput checkContact2;;

	private DigitalInput hookInPlace;
    //private Counter count;
	private int boxes;

	public BoxLifter(DigitalInput checkContact1, DigitalInput checkContact2,
			DigitalInput hookInPlace, Talon lifter, Talon lifter2) {
		super();
		this.checkContact1 = checkContact1;
		this.checkContact2 = checkContact2;
		this.lifter = lifter;
		this.lifter2=lifter2;
		this.hookInPlace = hookInPlace;
		//this.count=new Counter();
		//this.count.setUpSource(hookInPlace);
		boxes = 1;
	}

	public void setSpeed(double speed) {
		this.lifter.set(speed);
		this.lifter2.set(speed);
	}

	public double getSpeed() {
		return this.lifter.get();
	}

	public int getCounter() {
		return this.boxes;
	}
	
	public void setCounter(int level)
	{
		this.boxes = level;
	}
    public void incrementCounter()
    {
    	this.boxes++;
    	if(boxes>numOfValves)
    		boxes-=numOfValves;
    }
    public void decrementCounter()
    {
    	this.boxes--;
    	if(boxes<1)
    		boxes+=numOfValves;
    }
	public void resetCounter() {
		this.boxes = 0;
	}
	public boolean getCheckContact1() {
		return this.checkContact1.get();
	}

	public boolean getCheckContact2() {
		return this.checkContact2.get();
	}

	public boolean getHookState() {
		return this.hookInPlace.get();
	}
	
	public void count()
	{
		if(getSpeed() < 0)
		{
			isMovingDown = true;
		}
		else if(getSpeed() > 0)
		{
			isMovingDown = false;
		}
		
		if(isMovingDown)
		{
			if(getHookState())
				wasReleased = false;
			else if (!wasReleased)
			{
				decrementCounter();
				wasReleased = true;
			}
			
		}
		else
		{
		
			if(!getHookState())
				wasReleased = true;
			else if (wasReleased)
			{
				incrementCounter();
				wasReleased = false;
			}
		}
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
