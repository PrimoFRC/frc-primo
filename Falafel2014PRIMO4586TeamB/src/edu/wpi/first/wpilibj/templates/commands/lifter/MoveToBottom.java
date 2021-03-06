/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.lifter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author user
 */
public class MoveToBottom extends CommandBase {
    
    public MoveToBottom() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if (!lifter.getBottomMicro())
            lifter.setRailSpeed(-1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        
                return (lifter.getBottomMicro() || oi.stopAll.get()||lifter.getRailSpeed() != -1 * SmartDashboard.getNumber("lifter move speed: "));
    }

    // Called once after isFinished returns true
    protected void end() {
        if(lifter.getRailSpeed() == -1 * SmartDashboard.getNumber("lifter move speed: "))
        {
        lifter.setRailSpeed(0);
        }
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
