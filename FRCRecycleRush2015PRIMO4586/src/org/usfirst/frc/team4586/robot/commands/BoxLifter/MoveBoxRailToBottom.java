package org.usfirst.frc.team4586.robot.commands.BoxLifter;

import org.usfirst.frc.team4586.robot.commands.CommandBase;
import org.usfirst.frc.team4586.robot.subsystems.BoxLifter;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveBoxRailToBottom extends Command {

	private BoxLifter boxLifter;
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
    		boxLifter.setSpeed(-1);//add smartDashBoard Field
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(boxLifter.getValve())
    		boxLifter.decrementCounter();
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
