/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.dropper;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author user
 */
public class MoveDoorJoystick extends CommandBase
{
        boolean isZero;
        
	public MoveDoorJoystick()
	{
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
            isZero = true;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
            if((!dropper.getCloseMicro() && oi.operatorStick.getRawAxis(3)<-0.1) || (!dropper.getOpenMicro() && oi.operatorStick.getRawAxis(3)>0.1))
            {
                dropper.moveDoor(oi.operatorStick.getRawAxis(3));
                isZero = false;
            }
            else if (!isZero)
            {
                dropper.moveDoor(0);
                isZero = true;
            }
                
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return false;
	}

	// Called once after isFinished returns true
	protected void end()
	{
            dropper.moveDoor(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
	}
}
