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
public class ControlScissors extends CommandBase {

    double y;
    boolean moved = false;

    public ControlScissors() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        y = oi.operatorStick.getY();
        if (y > -0.1 && y < 0.1) {
            this.y = 0;
        } else {
            if (lifter.getTop() && this.y > 0) {
                this.y = 0;
            } else {
                if (lifter.getBottom() && y < 0) {
                    this.y = 0;
                } else {
                    this.y = y * 0.5;//to be tested
                }
            }

        }

        if (y == 0) {
            if (moved) {
                lifter.setSpeedLifter(0);
                moved = false;
            }

        } else {
            lifter.setSpeedLifter(y);
            moved = true;
        }
        
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
