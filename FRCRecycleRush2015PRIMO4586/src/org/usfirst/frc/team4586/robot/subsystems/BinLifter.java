package org.usfirst.frc.team4586.robot.subsystems;

import org.usfirst.frc.team4586.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BinLifter extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	static Talon binRail;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	binRail = RobotMap.binRail;
    }
    public void moveToBottom()
    {
    	
    }
}

