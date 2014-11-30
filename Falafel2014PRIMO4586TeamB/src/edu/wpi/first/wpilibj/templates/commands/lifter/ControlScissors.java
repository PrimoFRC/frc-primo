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
public class ControlScissors extends CommandBase {
    boolean isZero;
    
    public ControlScissors() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        isZero = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        if ((!lifter.getBottomMicro() && oi.operatorStick.getY() < -0.2) || (!lifter.getTopMicro() && oi.operatorStick.getY() > 0.2))
        {
            lifter.setRailSpeed(oi.operatorStick.getY());
            isZero = false;
        } 
        
        else if (!isZero)
        {
            lifter.setRailSpeed(0);
            isZero = true;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        lifter.setRailSpeed(-0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
