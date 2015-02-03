package org.usfirst.frc.team4586.robot.subsystems;

import org.usfirst.frc.team4586.robot.RobotMap;
import org.usfirst.frc.team4586.robot.commands.CommandBase;
import org.usfirst.frc.team4586.robot.commands.driver.Accelerometer;

import com.ni.vision.NIVision.Range;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.hal.AccelerometerJNI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
	
	static DigitalInput autonomusSwitch;
	
	static Gyro gyro;
	static BuiltInAccelerometer accel;

	double xSpeed, xPlace, ySpeed, yPlace,
			angle;
	static edu.wpi.first.wpilibj.interfaces.Accelerometer.Range range;
	
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
		
		autonomusSwitch = RobotMap.autoSwitch;
		

		gyro = new Gyro(0);
		accel = new BuiltInAccelerometer();
		accel.setRange(edu.wpi.first.wpilibj.interfaces.Accelerometer.Range.k8G);
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
        motorBackLeft.set(-speed * SmartDashboard.getNumber("Back wheels over power: " , 0.7));
    }
    
    public void setFR(double speed)
    {
        motorFrontRight.set(speed);
    }
    
    public void setBR(double speed)
    {
        motorBackRight.set(speed * SmartDashboard.getNumber("Back wheels over power: " , 0.7));
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
    
    public void resetGyro()
    {
    	gyro.reset();
    }
    public double getGyro()
    {
    	return gyro.getAngle();
    }
    
    public boolean getAutonomusSwitch()
    {
    	return autonomusSwitch.get();
    }
    
    
    
    
    
    
    
    
    
}

