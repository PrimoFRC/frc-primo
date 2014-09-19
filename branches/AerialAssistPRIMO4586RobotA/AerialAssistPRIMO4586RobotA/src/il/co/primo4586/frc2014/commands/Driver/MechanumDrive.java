/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package il.co.primo4586.frc2014.commands.Driver;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import il.co.primo4586.frc2014.commands.CommandBase;

/**
 *
 * @author User
 */
public class MechanumDrive extends CommandBase {
    private Joystick drivingStick;

    public MechanumDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driver);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        drivingStick = CommandBase.oi.drivingStick;
        driver.sign = 1;
        System.out.println("mechanumDrive works");
        //drivingStick2 = CommandBase.oi.getDrivingStick2();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double magnitude, direction, rotation;
        /*
        magnitude = drivingStick1.getY() * drivingStick1.getY();
        magnitude += drivingStick2.getX() * drivingStick2.getX();
        magnitude = MathUtils.pow(magnitude, 0.5);
        direction = drivingStick1.getY() / drivingStick2.getX();
        direction = MathUtils.atan(direction);
        if (drivingStick1.getX() < 0)
            direction += 180;
        rotation = drivingStick1.getX();
        */
        
        int axis = 4;
        
        if(Math.abs(drivingStick.getRawAxis(3))>Math.abs(drivingStick.getRawAxis(4)))
        {
           axis = 3;         
        }
            
        
        magnitude = driver.sign * drivingStick.getMagnitude() / SmartDashboard.getNumber("Driving Devide", 1);
        direction = drivingStick.getDirectionDegrees();
        rotation = drivingStick.getRawAxis(axis) / 2;
        //driver.MecanumDrive(magnitude, direction, rotation);
        double x = driver.sign*drivingStick.getX() / SmartDashboard.getNumber("Driving Devide", 1);
        double y = driver.sign*drivingStick.getY() / SmartDashboard.getNumber("Driving Devide", 1);
        double z = drivingStick.getRawAxis(axis)/ SmartDashboard.getNumber("Driving Devide", 1);
        
        driver.MecanumDriveTry(x, y, z);
        
        //System.out.println("x: " + x + "    y: " + y + "    z: " + z);

        //driving.ArcadeDrive(drivingStick);
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
