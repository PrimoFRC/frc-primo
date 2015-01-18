package org.usfirst.frc.team4586.robot.commands.driver;


import org.usfirst.frc.team4586.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveRobot extends Command {

	double x,y,z,time;
    public MoveRobot(double x, double y, double z, double time) {
    	
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.x = x;
    	this.y = y;
    	this.z = z;
    	this.time = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	CommandBase.driver.mecanumDrive(x, y, z);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	CommandBase.driver.mecanumDrive(0, 0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
