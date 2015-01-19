package org.usfirst.frc.team4586.robot.commands.binLifter;

import org.usfirst.frc.team4586.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveBinRailByStick extends Command {
	boolean isZero;
    public MoveBinRailByStick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	isZero=true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if((CommandBase.oi.operatorStickFront.getRawAxis(5)>0.1)||(CommandBase.oi.operatorStickFront.getRawAxis(5)<-0.1))
    	{
    		isZero=false;
    		CommandBase.binLifter.moveBinRail(CommandBase.oi.operatorStickFront.getRawAxis(5));
    	}
    	else if (!isZero)
    	{
    		isZero=true;
    		CommandBase.binLifter.moveBinRail(-0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
