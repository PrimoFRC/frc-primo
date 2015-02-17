package org.usfirst.frc.team4586.robot.commands.BoxLifter;

import org.usfirst.frc.team4586.robot.RobotMap;
import org.usfirst.frc.team4586.robot.commands.CommandBase;
import org.usfirst.frc.team4586.robot.subsystems.BoxLifter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveBoxRailToTarget extends Command {

	int target;
	BoxLifter boxLifter;
    public MoveBoxRailToTarget(int target) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.target = target;
    	boxLifter = CommandBase.boxLifterFront;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(target < boxLifter.getCounter())
    		boxLifter.setSpeed(-0.9);
    	
    	else if (target > boxLifter.getCounter())
    		boxLifter.setSpeed(0.9);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	CommandBase.boxLifterFront.count();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (boxLifter.getCounter() == target && boxLifter.getHookState());
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
