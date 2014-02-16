/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.co.primo4586.frc2014.commands.ImageProcessing;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import il.co.primo4586.frc2014.RobotTemplate;
import il.co.primo4586.frc2014.commands.CommandBase;

/**
 *
 * @author Gottlieb
 */
public class SetLowLighting extends CommandBase {
    
    public SetLowLighting() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

        /*
        SmartDashboard.putNumber("HueLow", 100);
        SmartDashboard.putNumber("HueHigh", 150);
        SmartDashboard.putNumber("SaturationLow", 100);
        SmartDashboard.putNumber("SaturationHigh", 255);
        SmartDashboard.putNumber("IntensityLow", 120);
        SmartDashboard.putNumber("IntensityHigh", 255);
         */
        
        SmartDashboard.putNumber("HueLow", 100);
        SmartDashboard.putNumber("HueHigh", 255);
        SmartDashboard.putNumber("SaturationLow", 200);
        SmartDashboard.putNumber("SaturationHigh", 255);
        SmartDashboard.putNumber("IntensityLow", 100);
        SmartDashboard.putNumber("IntensityHigh", 255);    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
