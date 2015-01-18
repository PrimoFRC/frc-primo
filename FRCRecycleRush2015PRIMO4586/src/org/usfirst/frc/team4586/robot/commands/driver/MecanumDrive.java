package org.usfirst.frc.team4586.robot.commands.driver;

import java.awt.Robot;

import org.usfirst.frc.team4586.robot.commands.CommandBase;
import org.usfirst.frc.team4586.robot.subsystems.Driver;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MecanumDrive extends Command {
	int sign;
	double x,y,z;
    public MecanumDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	sign = CommandBase.driver.sign;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	x = CommandBase.oi.drivingStick.getX()*sign*SmartDashboard.getNumber("max driving speed", 0.7);
    	y = CommandBase.oi.drivingStick.getY()*sign*SmartDashboard.getNumber("max driving speed", 0.7);
    	z = -CommandBase.oi.drivingStick.getRawAxis(4)*SmartDashboard.getNumber("max driving speed", 0.7);
    	CommandBase.driver.mecanumDrive(x, y, z);
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
