package org.usfirst.frc.team4586.robot.commands.driver;

import org.usfirst.frc.team4586.robot.OI;
import org.usfirst.frc.team4586.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MoveRobotMicroSwitch extends Command {
	
	double x,y,z;

    public MoveRobotMicroSwitch(double x, double y, double z) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	this.x = x;
    	this.y = y;
    	this.z = z;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	z = CommandBase.driver.getGyro()*SmartDashboard.getNumber("Gyro factor", 0.05);
    	
    	CommandBase.driver.mecanumDrive(x*SmartDashboard.getNumber("move left speed", 0.5),
    			-y*SmartDashboard.getNumber("move back speed"), z*SmartDashboard.getNumber("max driving speed"));
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return CommandBase.driver.getAutonomusSwitch();
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
