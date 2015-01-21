package org.usfirst.frc.team4586.robot.subsystems;

import org.usfirst.frc.team4586.robot.RobotMap;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Driver extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	static Jaguar motorFrontLeft;
	static Jaguar motorFrontRight;
	static Jaguar motorBackLeft;
	static Jaguar motorBackRight;
	
	static BuiltInAccelerometer accel;

	double xSpeed, xPlace, ySpeed, yPlace;
	
	
	public int sign = 1;
	
	
	//RobotDrive drive= new RobotDrive(motorFrontLeft, motorBackLeft, motorFrontRight, motorBackRight);
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public Driver()
    {
    	motorFrontLeft = RobotMap.motorFrontLeft;
		motorFrontRight = RobotMap.motorFrontRight;
		motorBackLeft = RobotMap.motorBackLeft;
		motorBackRight = RobotMap.motorBackRight;
		
		xSpeed = 0;
		ySpeed = 0;
		xPlace = 0;
		yPlace = 0;
		
		accel = new BuiltInAccelerometer();
    }
    
    public void stop()
    {
        motorBackLeft.set(0);
		motorFrontLeft.set(0);
		motorBackRight.set(0);
		motorFrontRight.set(0);
    }

    public void setFL(double speed)
    {
        motorFrontLeft.set(-speed);
    }
    
    public void setBL(double speed)
    {
        motorBackLeft.set(-speed);
    }
    
    public void setFR(double speed)
    {
        motorFrontRight.set(speed);
    }
    
    public void setBR(double speed)
    {
        motorBackRight.set(speed);
    }
    public void mecanumDrive(double x, double y, double z)
    {
        setFL(y-x+z);
        setBL(y+x+z);
        setFR(y+x-z);
        setBR(y-x-z);
    }
    public void invert()
    {
    	sign*=-1;
    }
    public static double getAccelorometerX()
    {
    	return accel.getX();
    }
    public static double getAccelorometerY()
    {
    	return accel.getY();
    }
    public static double getAccelorometerZ()
    {
    	return accel.getZ();
    }
    public double getXPlace()
    {
    	return this.xPlace;
    }
    public double getYPlace()
    {
    	return this.yPlace;
    }
    public double getXSpeed()
    {
    	return this.xSpeed;
    }
    public double getYSpeed()
    {
    	return this.ySpeed;
    }
    public void setXPlace(double xPlace)
    {
    	this.xPlace = xPlace;
    }
    public void setYPlace(double yPlace)
    {
    	this.yPlace = yPlace;
    }
    public void setXSpeed(double xSpeed)
    {
    	this.xSpeed = xSpeed;
    }
    public void setYSpeed(double ySpeed)
    {
    	this.ySpeed = ySpeed;
    }
    
    
    
    
    
    
    
    
    
}

