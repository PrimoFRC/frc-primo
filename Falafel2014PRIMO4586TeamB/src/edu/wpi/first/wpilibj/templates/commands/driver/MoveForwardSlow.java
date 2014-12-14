/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.driver;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author lenovo
 */
public class MoveForwardSlow extends CommandBase {
    double direction;
    public MoveForwardSlow(double direction) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        this.direction = direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(SmartDashboard.getNumber("slowAutonomousTime", 1.0000000001));
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        driver.moveForward(direction*SmartDashboard.getNumber("slowAutonomousSpeed", 0.4));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
