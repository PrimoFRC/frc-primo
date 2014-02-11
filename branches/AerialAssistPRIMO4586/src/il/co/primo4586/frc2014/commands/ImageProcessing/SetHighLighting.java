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
public class SetHighLighting extends CommandBase {
    
    public SetHighLighting() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

            SmartDashboard.putNumber("HueLow", 60);
            SmartDashboard.putNumber("HueHigh", 120);
            SmartDashboard.putNumber("SaturationLow", 30);
            SmartDashboard.putNumber("SaturationHigh", 240);
            SmartDashboard.putNumber("IntensityLow", 50);
            SmartDashboard.putNumber("IntensityHigh", 240);     
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
