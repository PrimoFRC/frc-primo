/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.dropper;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotTemplate;
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
            if (oi.safeButton.get() || RobotTemplate.isAutonoumus)
            {
                if (dropper.getCloseMicro())
                {
                    //opens door
                    isClosing = false;
                    dropper.moveDoor(1);
                }
                else
                {
                    //closes door
                    isClosing = true;
                    dropper.moveDoor(-1);
                }
            }
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
            
            
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
            System.out.println(dropper.getCurrentSpeed());
            if(oi.stopAll.get() || dropper.getCurrentSpeed() == 0)
            {
                return true;
            }
            else if (isClosing)
            {
		return (dropper.getCloseMicro()||(dropper.getCurrentSpeed() == 1 * SmartDashboard.getNumber("door move speed: ")));
            }
            else
            {
                return (dropper.getOpenMicro()||(dropper.getCurrentSpeed() == -1 * SmartDashboard.getNumber("door move speed: ")));
            }
            
	}

	// Called once after isFinished returns true
	protected void end()
	{
            if ((dropper.getCurrentSpeed() != 1 * SmartDashboard.getNumber("door move speed: ") && isClosing) || (dropper.getCurrentSpeed() != -1 * SmartDashboard.getNumber("door move speed: ") && !isClosing))
            {
            dropper.moveDoor(0);
            }
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
	}
}
