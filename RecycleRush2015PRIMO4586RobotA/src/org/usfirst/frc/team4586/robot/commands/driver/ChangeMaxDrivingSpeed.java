package org.usfirst.frc.team4586.robot.commands.driver;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ChangeMaxDrivingSpeed extends Command {

	int sign;

	public ChangeMaxDrivingSpeed(int sign) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);

		this.sign = sign;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		if (SmartDashboard.getNumber("max driving speed") < 1 && sign > 0
				|| SmartDashboard.getNumber("max driving speed") > 0
				&& sign < 0)
			SmartDashboard.putNumber("max driving speed",
					SmartDashboard.getNumber("max driving speed")
							+ (sign * 0.1));

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
