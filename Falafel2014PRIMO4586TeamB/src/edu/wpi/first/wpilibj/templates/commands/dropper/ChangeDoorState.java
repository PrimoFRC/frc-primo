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
public class ChangeDoorState extends CommandBase
{
        boolean isClosing;
	public ChangeDoorState()
	{
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
            if (dropper.getCloseMicro())
            {
                //opens door
                isClosing = false;
                dropper.moveDoor(0.5);
            }
            else
            {
                //closes door
                isClosing = true;
                dropper.moveDoor(-0.5);
            }
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
            
            
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
            if (isClosing)
		return dropper.getCloseMicro();
            else
                return dropper.getOpenMicro();
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
