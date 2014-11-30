
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 */
public class Driver extends Subsystem 
{
    private Jaguar frontLeft, frontRight, backLeft, backRight;
    private RobotDrive driver; 
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public Driver()
    {
        this.frontLeft=RobotMap.frontLeft;
        this.backLeft=RobotMap.backLeft;
        this.frontRight=RobotMap.frontRight;
        this.backRight=RobotMap.backRight;
        
        this.driver= new RobotDrive(frontLeft, backLeft, frontRight, backRight);
    }
    public void arcadeDrive(Joystick joystick)
    {
        //הפעולה מעניקה למקל נהיגה שליטה על תנועת הרובוט  
        this.driver.arcadeDrive(joystick);
    }
    public void moveForward(double speed)
    {
        driver.arcadeDrive(speed, 0);
    }
    public void setSpeedXY(double x, double y)
    {
        //הפעולה מקבלת מהירויות x ו-y
        //הפעולה מזיזה את הרובוט קדימה במהירות -y ומסובבות אותו עם כיוון השעון במהירות x
        double left=Math.min(Math.max(x+y, -1), 1);
        double right=left-2*x;
        this.frontLeft.set(left);
        this.backLeft.set(left);
        this.frontRight.set(right);
        this.backRight.set(right);
    }
    public void stopAll()
    {
        //הפעולה אינה מקבלת פרמטרים
        //הפעולה עוצרת את הרובוט
        this.frontLeft.set(0);
        this.backLeft.set(0);
        this.frontRight.set(0);
        this.backRight.set(0);
    }
    public double getFrontLeft()
    {
        return frontLeft.getSpeed();
    }
    public double getBackLeft()
    {
        return backLeft.getSpeed();
    }
    public double getFrontRight()
    {
        return frontRight.getSpeed();
    }
    public double getBackRight()
    {
        return backRight.getSpeed();
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

