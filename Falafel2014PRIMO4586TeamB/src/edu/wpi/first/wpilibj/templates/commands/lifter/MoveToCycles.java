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
public class MoveToCycles extends CommandBase {
    private boolean isClosing;
    public MoveToCycles() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
            if (lifter.countCycles() > SmartDashboard.getNumber("move to cycles: "))
            {
                lifter.setRailSpeed(-1);//need check
                isClosing = false;
            }
            else if (lifter.countCycles() < SmartDashboard.getNumber("move to cycles: "))
            {
                lifter.setRailSpeed(1);//need check
                isClosing = true;
            }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(lifter.getRailSpeed() > 0)
            return (lifter.countCycles() == SmartDashboard.getNumber("move to cycles: ") || lifter.getTopMicro() || oi.stopAll.get());
        else if(lifter.getRailSpeed() < 0)
            return (lifter.countCycles() == SmartDashboard.getNumber("move to cycles: ") || lifter.getBottomMicro() || oi.stopAll.get());
        else
            return true;    
    }

    // Called once after isFinished returns true
    protected void end() {
        lifter.setRailSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
