package org.usfirst.frc.team4586.robot.commands.driver;

import org.usfirst.frc.team4586.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotateRobot extends Command {

	double degree, startingDegree;
	double z;
    public RotateRobot(double degree) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.degree = degree;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startingDegree = CommandBase.driver.getGyro();
    	
    	CommandBase.driver.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	z = (degree > CommandBase.driver.getGyro())? -0.5:0.5;
    	CommandBase.driver.mecanumDrive(0, 0, z);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Math.abs(CommandBase.driver.getGyro() - degree) < 2);
    }

    // Called once after isFinished returns true
    protected void end() {
    	CommandBase.driver.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
