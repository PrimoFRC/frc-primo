package org.usfirst.frc.team4586.robot.commands.BoxLifter;

import org.usfirst.frc.team4586.robot.OI;
import org.usfirst.frc.team4586.robot.commands.CommandBase;
import org.usfirst.frc.team4586.robot.subsystems.BoxLifter;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveBoxRailByStick extends Command {
	private Joystick operatorStick;
	private BoxLifter boxLifter;
	private boolean wasItMoved;

	public MoveBoxRailByStick(boolean isFront) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		if (isFront) {
			operatorStick = CommandBase.oi.operatorStickFront;
			boxLifter = CommandBase.boxLifterFront;
		} else {
			operatorStick = CommandBase.oi.operatorStickBack;
			boxLifter = CommandBase.boxLifterBack;
		}
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		wasItMoved = false;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double direction = operatorStick.getY();
		if (direction > 0.1) {
			boxLifter.setSpeed(1);// add smartDashboard field
			wasItMoved = true;
			if (boxLifter.getValve())
				boxLifter.incrementCounter();
		} else if (direction < -0.1) {
			boxLifter.setSpeed(-1);// add smartDashboard field
			wasItMoved = true;
			if (boxLifter.getValve())
				boxLifter.decrementCounter();
		} else if (wasItMoved) {
			boxLifter.setSpeed(0);
			wasItMoved = false;
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
