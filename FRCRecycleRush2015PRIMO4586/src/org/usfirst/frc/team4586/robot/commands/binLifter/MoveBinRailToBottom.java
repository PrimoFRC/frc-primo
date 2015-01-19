package org.usfirst.frc.team4586.robot.commands.binLifter;

import org.usfirst.frc.team4586.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MoveBinRailToBottom extends Command {

    public MoveBinRailToBottom() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(!CommandBase.binLifter.isBinRailSwitch())
    	{
    		CommandBase.binLifter.moveBinRail(SmartDashboard.getNumber("Max Bin Rail Speed"));
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (CommandBase.binLifter.isBinRailSwitch());
    }

    // Called once after isFinished returns true
    protected void end() {
    	CommandBase.binLifter.moveBinRail(0);
    	CommandBase.binLifter.setIsBottom(true);
    	CommandBase.binLifter.setIsTop(false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
