/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.lifter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author user
 */
public class MoveToCycles extends CommandBase {
    
    private int target;
    public MoveToCycles() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        target=-1;
    }
    public MoveToCycles(int target)
    {
        this.target=target;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
        if(target==-1)
            target=(int)SmartDashboard.getNumber("Target Cycles: ");
        if(target==-2)
            target=(int)SmartDashboard.getNumber("Hanged Position in Cycles: ");
        if(target==-3)
            target=(int)SmartDashboard.getNumber("Collection Position in Cycles: ");
        if(target==-4)
            target=(int)SmartDashboard.getNumber("Hanging Position in Cycles: ");
        if(target==-5)
            target=(int)SmartDashboard.getNumber("Scoring Position in Cycles: ");
        if(target>SmartDashboard.getNumber("Cycles: "))
            lifter.setSpeedLifter(0.5); //to be tested
        else
            lifter.setSpeedLifter(-0.5); //to be tested
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return target==(int)SmartDashboard.getNumber("Cycles: ");
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
