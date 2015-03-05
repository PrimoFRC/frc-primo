package org.usfirst.frc.team4586.robot.commands.BoxLifter;

import org.usfirst.frc.team4586.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ResetRail extends Command {
	boolean wasDown, wasFinished;

	public ResetRail() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		wasDown = false;
		wasFinished = false;

	}

	// Called just before this Command runs the first time
	protected void initialize() {
		wasDown = false;
		wasFinished = false;
		System.out.println("reset init");
		if (!CommandBase.boxLifterFront.getCylinderStuck()) {
			CommandBase.boxLifterFront.setSpeed(-1
					* SmartDashboard.getNumber("Max speed of rails"));
		}

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (CommandBase.boxLifterFront.getCylinderStuck()) {
			CommandBase.boxLifterFront.setSpeed(0);
			System.out.println("in cylinder");
			wasDown = true;
		}
		if (wasDown) {
			if (!CommandBase.boxLifterFront.getHookState()) {
				CommandBase.boxLifterFront.setSpeed(0.7 * SmartDashboard
						.getNumber("Max speed of rails", 1));
				System.out.println("going down");
			} else {
				System.out.println("finished");
				wasFinished = true;
			}
		}

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return wasFinished
				|| (CommandBase.boxLifterFront.getSpeed() > 0 && !wasDown);
	}

	// Called once after isFinished returns true
	protected void end() {
		CommandBase.boxLifterFront.setSpeed(0);
		CommandBase.boxLifterFront.resetCounter();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
