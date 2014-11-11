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

    private boolean isClosed=false;
	public ChangeDoorState()
	{
            
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
           this.isClosed=(dropper.getCloseMicro()) ;
           if(this.isClosed)
               dropper.moveDoor(0.5);//to be tested
           else
               dropper.moveDoor(-0.5);//to be tested
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
        }

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return (this.isClosed&&dropper.getOpenMicro())||(!this.isClosed&&dropper.getCloseMicro());
	}

	// Called once after isFinished returns true
	protected void end()
	{
//            dropper.moveDoor(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
	}
}
