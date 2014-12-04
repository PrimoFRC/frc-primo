/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.lifter;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author lenovo
 */
public class MoveToTop extends CommandBase {
    
    public MoveToTop() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
          if (!lifter.getTopMicro())
            lifter.setRailSpeed(1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (lifter.getTopMicro() || oi.stopAll.get()||lifter.getRailSpeed() != 1);
    }

    // Called once after isFinished returns true
    protected void end() {
        if(lifter.getRailSpeed() == 1)
        {
        lifter.setRailSpeed(0);
        }
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
