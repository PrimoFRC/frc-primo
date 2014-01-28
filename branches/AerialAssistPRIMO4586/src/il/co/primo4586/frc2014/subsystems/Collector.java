/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.co.primo4586.frc2014.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
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

	Talon collectArm;
    DigitalInput collector_top;
	DigitalInput collector_middle;
	DigitalInput collector_bottom;

	int level; //0, 1 or 2 (bottom, middle or top)

	public Collector()
	{
		collectArm = RobotMap.collectArm;
		collector_top = RobotMap.collector_top;
		collector_middle = RobotMap.collector_middle;
		collector_bottom = RobotMap.collector_bottom;

	}


	public void moveArm(double speed)
	{
		collectArm.set(speed);
	}

	public boolean getTopMicro()
	{
		return collector_top.get();
	}

	public boolean getMiddleMicro()
	{
		return collector_middle.get();
	}

	public boolean getBottomMicro()
	{
		return collector_bottom.get();
	}







    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}