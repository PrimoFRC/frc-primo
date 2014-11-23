
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 */
public class Driver extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public Jaguar frontLeft;
    public Jaguar frontRight;
    public Jaguar backLeft;
    public Jaguar backRight;
    
    public RobotDrive driver;
    
    public Driver()
    {
        frontLeft = RobotMap.frontLeft;
        frontRight = RobotMap.frontRight;
        backLeft = RobotMap.backLeft;
        backRight = RobotMap.backRight;
        
        driver = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
    }
     
    public void arcadeDrive(Joystick stick)
    {
        driver.arcadeDrive(stick);
    }
    
    public void moveForward()
    {
        frontLeft.set(0.5);
        frontRight.set(0.5);
        backLeft.set(0.5);
        backRight.set(0.5);
    }
    
    public void stop()
    {
        frontLeft.set(0);
        frontRight.set(0);
        backLeft.set(0);
        backRight.set(0);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        
    }
   
}

