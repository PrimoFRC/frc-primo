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
    private String targetSmartDashboard;
    private boolean goingBack;
    public MoveToCycles() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        this.target=-1;
        this.targetSmartDashboard="";
    }
    public MoveToCycles(int target)
    {
        this.target=target;
        this.targetSmartDashboard="";
    }
    public MoveToCycles(String targetSmartDashboard)
    {
        this.targetSmartDashboard=targetSmartDashboard;
        this.target=-1;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
        if(this.targetSmartDashboard!="")
            target=(int)SmartDashboard.getNumber(targetSmartDashboard);
        else
            switch (target) {
                case (-1):
                    target = (int) SmartDashboard.getNumber("Target Cycles: ");
                    break;
                case (-2):
                    target = (int) SmartDashboard.getNumber("Hanged Position in Cycles: ");
                    break;
                case (-3):
                    target = (int) SmartDashboard.getNumber("Collection Position in Cycles: ");
                    break;
                case (-4):
                    target = (int) SmartDashboard.getNumber("Hanging Position in Cycles: ");
                    break;
                case (-5):
                    target = (int) SmartDashboard.getNumber("Scoring Position in Cycles: ");
                    break;
            }
        if(target>SmartDashboard.getNumber("Cycles: "))
        {
            lifter.setSpeedLifter(1);
            goingBack=false;
        }
        else
        {
            lifter.setSpeedLifter(-1); 
            goingBack=true;
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(goingBack)
            if (target <= (int) SmartDashboard.getNumber("Cycles: "))
                return true;
            else if(lifter.getBottom())
                return true;
        if(!goingBack)
            if (target >= (int) SmartDashboard.getNumber("Cycles: "))
                return true;
            else if(lifter.getTop())
                return true;
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        lifter.setSpeedLifter(0);
        System.out.println("Lifter Moved to: "+this.target);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
