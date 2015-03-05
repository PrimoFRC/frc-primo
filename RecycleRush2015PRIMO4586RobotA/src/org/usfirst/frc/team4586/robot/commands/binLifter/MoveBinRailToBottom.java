package org.usfirst.frc.team4586.robot.commands.binLifter;

import org.usfirst.frc.team4586.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MoveBinRailToBottom extends Command {
	boolean wasReleased;

	public MoveBinRailToBottom() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		wasReleased = false;
		if (!CommandBase.binLifter.isBottom()) {
			CommandBase.binLifter.moveBinRail(1);
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (!CommandBase.binLifter.isBinRailSwitch()) {
			wasReleased = true;
			CommandBase.binLifter.setIsTop(false);

		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return ((CommandBase.binLifter.isBinRailSwitch() && wasReleased == true) || CommandBase.binLifter
				.isBottom());
	}

	// Called once after isFinished returns true
	protected void end() {
		CommandBase.binLifter.moveBinRail(0);
		CommandBase.binLifter.setIsBottom(true);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
