/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.lifter;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author user
 */
public class LowerScissorsWhilePressed extends CommandBase {
    
    public LowerScissorsWhilePressed() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        lifter.setSpeedLifter(-1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (!oi.lowerScissors.get() ||lifter.getBottom() );
    }

    // Called once after isFinished returns true
    protected void end() {
        lifter.setSpeedLifter(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
