/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.dropper;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author user
 */
public class OpenDoorWhilePressed extends CommandBase
{
        /* opens the droper door, without microswitchs */
	public OpenDoorWhilePressed()
	{
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
             
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
          
            dropper.moveDoor(1);
           
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
            
                return (!oi.openDoor.get() || oi.stopAll.get());
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
