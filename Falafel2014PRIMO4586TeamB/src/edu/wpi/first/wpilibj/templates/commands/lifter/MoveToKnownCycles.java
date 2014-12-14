/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.lifter;


import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;


/**
 *
 * @author lenovo
 */
public class MoveToKnownCycles extends CommandBase {
    private int cycles, type;
    private boolean isClosing;
    public MoveToKnownCycles(int type) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        this.type = type;
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
            switch (type)
            {
                case 1: this.cycles = (int)SmartDashboard.getNumber("move to collection: ",0);
                    break;
                case 2: this.cycles = (int)SmartDashboard.getNumber("move to hanging: ",0);
                    break;
            }
            System.out.println(cycles);
            if (lifter.countCycles() > cycles)
            {
                lifter.setRailSpeed(-1);//need check
                isClosing = false;
            }
            else if (lifter.countCycles() < cycles)
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
            return (lifter.countCycles() == cycles || lifter.getTopMicro() || oi.stopAll.get());
        else if(lifter.getRailSpeed() < 0)
            return (lifter.countCycles() == cycles || lifter.getBottomMicro() || oi.stopAll.get());
        else
            return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        lifter.setRailSpeed(0);
        System.out.println(isClosing);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
