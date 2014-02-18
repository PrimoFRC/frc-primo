/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.co.primo4586.frc2014.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import il.co.primo4586.frc2014.RobotMap;


/**
 *
 * @author Gottlieb
 */
public class Collector extends Subsystem
{
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	SpeedController collectArm;

        DigitalInput collector_top;
	DigitalInput collector_bottom;

	private int level; //0, 1 or 2 (bottom, middle or top)
	private boolean isAboveMiddle;


	public Collector()
	{
		collectArm = RobotMap.collectArm;
                //להוציא מהערה
		collector_top = RobotMap.collector_top;
		//collector_middle = RobotMap.collector_middle;
		collector_bottom = RobotMap.collector_bottom;

	}


	public void moveArm(double speed)
	{
            System.out.println("&&&&&  collector should move  &&&&&");
		collectArm.set(-speed);
	}


	public boolean getTopMicro()
	{
            
            return !collector_top.get();
            //return false;
	}


	public boolean getMiddleMicro()
	{
		//return collector_middle.get();
                return false;
	
	}


	public boolean getBottomMicro()
	{
            
            return collector_bottom.get();
            //return false;
	}


	public int getLevel()
	{
		return level;
	}


	public void setLevel(int newLevel)
	{
		level = newLevel;
	}


	public boolean getAboveMiddle()
	{
		return isAboveMiddle;
	}


	public void setAboveMiddle()
	{
		isAboveMiddle = true;
	}


	public void setBelowMiddle()
	{
		isAboveMiddle = false;
	}


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
