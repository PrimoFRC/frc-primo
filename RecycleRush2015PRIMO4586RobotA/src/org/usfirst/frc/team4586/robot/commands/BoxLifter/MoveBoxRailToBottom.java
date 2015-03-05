package org.usfirst.frc.team4586.robot.commands.BoxLifter;

import org.usfirst.frc.team4586.robot.commands.CommandBase;
import org.usfirst.frc.team4586.robot.subsystems.BoxLifter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MoveBoxRailToBottom extends Command {

	private BoxLifter boxLifter;
	private boolean wasReleased;
	private Timer time;

	public MoveBoxRailToBottom(boolean isFront) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);

		// if(isFront)
		boxLifter = CommandBase.boxLifterFront;
		// else
		// boxLifter=CommandBase.boxLifterBack;
		time = boxLifter.getTime();
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		if (boxLifter.getCounter() > 1)
			boxLifter.setSpeed(-SmartDashboard.getNumber("Max speed of rails")
					* SmartDashboard.getNumber("Down factor"));
		time.reset();
		time.start();
		wasReleased = !boxLifter.getHookState();
		time.reset();
		time.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (!boxLifter.getHookState())
			wasReleased = true;
		else if (boxLifter.getHookState() && wasReleased) {
			// boxLifter.decrementCounter();
			wasReleased = false;
		}

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (time.get() >= 1.5)
			return true;
		if (CommandBase.oi.operatorStickFront.getY() > 0.1
				|| CommandBase.oi.operatorStickFront.getY() < -0.1) {
			return true;
		}
		return boxLifter.getCounter() <= 1 && boxLifter.getHookState();
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
