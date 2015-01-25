package org.usfirst.frc.team4586.robot.commands.driver;

import org.usfirst.frc.team4586.robot.commands.CommandBase;
import org.usfirst.frc.team4586.robot.subsystems.Driver;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Accelerometer extends Command {

	Timer timer = new Timer();
	
	Driver driver = new Driver();
	
	double xSpeed, xPlace, ySpeed, yPlace, time, lastTime;
    public Accelerometer() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	driver = CommandBase.driver;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	xSpeed = 0; 
    	xPlace = 0; 
    	ySpeed = 0; 
    	yPlace = 0;
    	time = 0;
    	timer.reset();
    	timer.start();
    	lastTime = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	time = timer.get() - lastTime;
    	lastTime = time + lastTime;
    	
    	xSpeed = xSpeed + time * round(Driver.getAccelorometerX()) * 9.81;
    	xPlace = xPlace + time * xSpeed;
    	ySpeed = ySpeed + time * round(Driver.getAccelorometerY()) * 9.81;
    	yPlace = yPlace + time * ySpeed;
    	
    	driver.setXSpeed(xSpeed);
    	driver.setXPlace(xPlace);
    	driver.setYSpeed(ySpeed);
    	driver.setYPlace(yPlace);

    }

    protected double round(double num)
    {
    	num *= 10;
    	num = (int)num;
    	return num / 10.0;
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
