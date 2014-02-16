/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package il.co.primo4586.frc2014.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import il.co.primo4586.frc2014.RobotMap;
import il.co.primo4586.frc2014.commands.Driver.MechanumDrive;

/**
 *
 * @author User
 */
public class Driver extends Subsystem
{
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    SpeedController motorLeftBack;
    SpeedController motorRightBack;
    SpeedController motorLeftFront;
    SpeedController motorRightFront;

    public int sign;
    
    RobotDrive driver;

    public Driver()
    {
        motorLeftBack = RobotMap.drivingMotorLeftBack;
        motorRightBack = RobotMap.drivingMotorRightBack;
        motorLeftFront = RobotMap.drivingMotorLeftFront;
        motorRightFront = RobotMap.drivingMotorRightFront;

        driver = new RobotDrive(motorLeftFront, motorLeftBack, motorRightFront, motorRightBack);
        driver.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        driver.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
	}

    public void MecanumDrive(double magnitude, double direction, double rotation)
    {
        driver.mecanumDrive_Polar(magnitude, direction, rotation);
    }

    public void ArcadeDrive(Joystick stick)
    {
        driver.arcadeDrive(stick);
    }

    public void driveForward()
    {
        double speed = 1;
        motorLeftBack.set(speed);
        motorLeftFront.set(speed);
		motorRightBack.set(-speed);
		motorRightFront.set(-speed);
    }

    public void stop()
    {
        motorLeftBack.set(0);
		motorLeftFront.set(0);
		motorRightBack.set(0);
		motorRightFront.set(0);
    }

    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new MechanumDrive());
    }
}
