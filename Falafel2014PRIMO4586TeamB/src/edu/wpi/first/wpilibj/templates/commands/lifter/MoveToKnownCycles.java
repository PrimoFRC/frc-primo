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
public class MoveToKnownCycles extends CommandBase {
    private int cycles;
    public MoveToKnownCycles(int cycles) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        this.cycles = cycles;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if (lifter.countCycles() > cycles)
            lifter.setRailSpeed(-0.5);
        else if (lifter.countCycles() < cycles)
            lifter.setRailSpeed(0.5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (lifter.countCycles() == cycles);
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
