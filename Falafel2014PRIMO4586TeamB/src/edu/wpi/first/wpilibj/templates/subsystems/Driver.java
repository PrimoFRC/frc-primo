
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
        //driver.arcadeDrive(stick);
        driver.arcadeDrive(-stick.getY()*SmartDashboard.getNumber("drive move speed: "), -stick.getX()*SmartDashboard.getNumber("drive move speed: "));
    }
    
    public void moveForward()
    {

        driver.arcadeDrive(1*SmartDashboard.getNumber("drive move speed: "),0);
        /*
        frontLeft.set(-1*SmartDashboard.getNumber("drive move speed: "));
        frontRight.set(-1*SmartDashboard.getNumber("drive move speed: "));
        backLeft.set(-1*SmartDashboard.getNumber("drive move speed: "));
        backRight.set(-1*SmartDashboard.getNumber("drive move speed: "));
         */

        driver.arcadeDrive(0.5, 0);

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

