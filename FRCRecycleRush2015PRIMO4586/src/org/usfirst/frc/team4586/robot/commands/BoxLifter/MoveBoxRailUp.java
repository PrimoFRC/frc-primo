package org.usfirst.frc.team4586.robot.commands.BoxLifter;

import org.usfirst.frc.team4586.robot.RobotMap;
import org.usfirst.frc.team4586.robot.commands.CommandBase;
import org.usfirst.frc.team4586.robot.subsystems.BoxLifter;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MoveBoxRailUp extends Command {
	private BoxLifter boxLifter;
	private boolean wasReleased;

	public MoveBoxRailUp(boolean isFront) {
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
		if (boxLifter.getCounter() < boxLifter.numOfValves
				&& boxLifter.getCheckContact1() && boxLifter.getCheckContact2())
			boxLifter.setSpeed(SmartDashboard.getNumber("Max speed of rails"));

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (boxLifter.getCounter() < boxLifter.numOfValves
				&& boxLifter.getCheckContact1() && boxLifter.getCheckContact2()) {
			boxLifter.setSpeed(SmartDashboard.getNumber("Max speed of rails"));
			if (!boxLifter.getHookState())
				wasReleased = true;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (boxLifter.getCounter() >= boxLifter.numOfValves) {
			return true;
		} else if (wasReleased && boxLifter.getHookState()) {
			return true;
		} else
			return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		boxLifter.setSpeed(0);
		boxLifter.incrementCounter();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
