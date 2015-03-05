package org.usfirst.frc.team4586.robot.commands.BoxLifter;

import org.usfirst.frc.team4586.robot.commands.CommandBase;
import org.usfirst.frc.team4586.robot.subsystems.BoxLifter;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MoveBoxRailByStick extends Command {
	private Joystick operatorStick;
	private Joystick drivingStick;
	private BoxLifter boxLifter;
	private boolean wasItMoved;
	private boolean wasReleased;
	private boolean wasItZero;

	public MoveBoxRailByStick(boolean isFront) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		// if (isFront) {
		operatorStick = CommandBase.oi.operatorStickFront;
		drivingStick = CommandBase.oi.drivingStick;
		boxLifter = CommandBase.boxLifterFront;
		// } else {
		// operatorStick = CommandBase.oi.operatorStickBack;
		// boxLifter = CommandBase.boxLifterBack;
		// }
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		wasItMoved = false;
		wasReleased = false;
		wasItZero = true;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		boxLifter.count();

		double yAxis;

		if (drivingStick.getRawAxis(2) > 0.05) {
			yAxis = -drivingStick.getRawAxis(2);
		} else if (drivingStick.getRawAxis(3) > 0.05) {
			yAxis = drivingStick.getRawAxis(3);
		} else {
			yAxis = operatorStick.getY();
		}
		/*
		 * if(!wasItZero && (yAxis < 0.1 && yAxis > -0.1)) wasItZero = true;
		 */
		if ((yAxis > 0.1 || yAxis < -0.1) && boxLifter.getHookState()
				&& wasReleased && !CommandBase.oi.freeStick.get()
				&& !CommandBase.oi.freeDrivingStick.get()) {
			boxLifter.setSpeed(0);
			wasItZero = false;
		} else {
			if (!boxLifter.getHookState())
				wasReleased = true;
			else if (wasReleased) {

				wasReleased = false;
			}

			if (yAxis > 0.1 && wasItZero) {
				boxLifter.setSpeed(yAxis
						* SmartDashboard.getNumber("Max speed of rails"));
				wasItMoved = true;
				/*
				 * if(boxLifter.getHookState()) wasReleased = false; else if
				 * (!wasReleased) { boxLifter.incrementCounter(); wasReleased =
				 * true; }
				 */
				/*
				 * if (!boxLifter.getHookState() ) { if(!wasReleased)
				 * boxLifter.incrementCounter();
				 * 
				 * wasReleased = true; }
				 */
			} else if (yAxis < -0.1 && wasItZero) {
				boxLifter.setSpeed(yAxis
						* SmartDashboard.getNumber("Max speed of rails"));
				wasItMoved = true;

				/*
				 * if(!boxLifter.getHookState()) wasReleased = true; else if
				 * (wasReleased) { boxLifter.decrementCounter(); wasReleased =
				 * false; }
				 */

			} else if ((wasItMoved && yAxis > -0.1 && yAxis < 0.1) /*
																	 * ||
																	 * (CommandBase
																	 * .
																	 * boxLifterFront
																	 * .
																	 * getHookState
																	 * ())
																	 */) {
				boxLifter.setSpeed(0);
				wasItMoved = false;
				wasItZero = true;
			}
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
