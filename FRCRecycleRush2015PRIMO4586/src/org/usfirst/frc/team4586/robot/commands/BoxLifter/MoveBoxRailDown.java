package org.usfirst.frc.team4586.robot.commands.BoxLifter;

import org.usfirst.frc.team4586.robot.commands.CommandBase;
import org.usfirst.frc.team4586.robot.subsystems.BoxLifter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveBoxRailDown extends Command {
	private BoxLifter boxLifter;
	private boolean wasReleased;

	public MoveBoxRailDown(boolean isFront) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		wasReleased = false;
		if (isFront) {
			boxLifter = CommandBase.boxLifterFront;
		} else {
			boxLifter = CommandBase.boxLifterBack;
		}
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		if (boxLifter.getCounter() > 1)
			boxLifter.setSpeed(-1);// add SmartDashBoard value
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (!boxLifter.getValve())
			wasReleased = true;
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (boxLifter.getCounter() <= 0) {
			return true;
		} else if (wasReleased && boxLifter.getValve()) {
			return true;
		} else
			return false;

	}

	// Called once after isFinished returns true
	protected void end() {
		boxLifter.setSpeed(0);
		boxLifter.decrementCounter();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
