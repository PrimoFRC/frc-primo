package org.usfirst.frc.team4586.robot.commands.BoxLifter;

import org.usfirst.frc.team4586.robot.commands.CommandBase;
import org.usfirst.frc.team4586.robot.subsystems.BoxLifter;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MoveBoxRailToBottom extends Command {

	private BoxLifter boxLifter;
	private boolean wasReleased ;
    public MoveBoxRailToBottom(boolean isFront) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	if(isFront)
    		boxLifter=CommandBase.boxLifterFront;
    	else
    		boxLifter=CommandBase.boxLifterBack;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(boxLifter.getCounter()>1)
    		boxLifter.setSpeed(-SmartDashboard.getNumber("Max speed of rails"));
    	
    	wasReleased = ! boxLifter.getHookState();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!boxLifter.getHookState())
    		wasReleased = true;
    	else if(boxLifter.getHookState() && wasReleased )
    	{
    		boxLifter.decrementCounter();
    		wasReleased = false;
    	}
    
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return boxLifter.getCounter()<=1;
    }

    // Called once after isFinished returns true
    protected void end() {
    	boxLifter.setSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
