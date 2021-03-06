package org.usfirst.frc.team4586.robot.commands.BoxLifter;

import org.usfirst.frc.team4586.robot.commands.CommandBase;
import org.usfirst.frc.team4586.robot.subsystems.BoxLifter;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
		//if (isFront) {
			boxLifter = CommandBase.boxLifterFront;
		//} else {
			//boxLifter = CommandBase.boxLifterBack;
		//}
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		wasReleased = false;
		if (boxLifter.getCounter() > 1 || (boxLifter.getCounter() == 1 && !boxLifter.getHookState()))
			boxLifter.setSpeed(-SmartDashboard.getNumber("Max speed of rails")*SmartDashboard.getNumber("Down factor"));
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (!boxLifter.getHookState())
			wasReleased = true;
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {		
		if( CommandBase.oi.operatorStickFront.getY() > 0.1 || CommandBase.oi.operatorStickFront.getY() < -0.1)
		{
			return true;
		}
		return (!(boxLifter.getCounter() > 1 || (boxLifter.getCounter() == 1 && !boxLifter.getHookState())) || (wasReleased && boxLifter.getHookState()));
	}

	// Called once after isFinished returns true
	protected void end() {
		boxLifter.setSpeed(0);
		//if ((wasReleased && boxLifter.getHookState()))
		//boxLifter.decrementCounter();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
