package org.usfirst.frc.team4586.robot.commands.BoxLifter;

import org.usfirst.frc.team4586.robot.commands.CommandBase;
import org.usfirst.frc.team4586.robot.subsystems.BoxLifter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MoveBoxRailUpFast extends Command {

	private BoxLifter boxLifter;
	private boolean wasReleased, wasInitialized;
	private Timer timer;

	public MoveBoxRailUpFast() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		wasReleased = false;
		wasInitialized = false;
		boxLifter = CommandBase.boxLifterFront;
		timer = new Timer();
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		wasReleased = false;
		wasInitialized = false;

		if (boxLifter.getCounter() < boxLifter.numOfValves)
		// && boxLifter.getCheckContact1() && boxLifter.getCheckContact2())
		{
			boxLifter.setSpeed(1.);
			wasInitialized = true;
		}
		timer.reset();
		timer.stop();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		if (!boxLifter.getHookState()) {
			if (!wasReleased)
				// if(startedOn)
				// boxLifter.incrementCounter();
				wasReleased = true;
		}

		if (!boxLifter.getCheckContact1() && boxLifter.getCheckContact2()) {
			CommandBase.driver.setSpinFactor(SmartDashboard.getNumber(
					"Spin factor", 0.2));
		} else if (boxLifter.getCheckContact1()
				&& !boxLifter.getCheckContact2()) {
			CommandBase.driver.setSpinFactor(-SmartDashboard.getNumber(
					"Spin factor", 0.2));
		} else {
			CommandBase.driver.setSpinFactor(0);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (!wasInitialized && boxLifter.getCounter() >= boxLifter.numOfValves)
				|| (wasReleased && boxLifter.getHookState());
	}

	// Called once after isFinished returns true
	protected void end() {
		boxLifter.setSpeed(0);
		CommandBase.driver.setSpinFactor(0);
		System.out.println("ended rail move up");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
