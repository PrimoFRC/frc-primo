/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.co.primo4586.frc2014.commands.collector;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import il.co.primo4586.frc2014.commands.CommandBase;

/**
 *
 * @author Gottlieb
 */
public class MoveArmMicroswitches extends CommandBase {
    
    int whereToStop;
    public MoveArmMicroswitches() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
        if (collector.getBottomMicro())
        {
            whereToStop = 1;
            collector.moveArm(SmartDashboard.getNumber("collector up power: " , 1));
        }
        else if (collector.getTopMicro())
        {
            whereToStop = 0;
            collector.moveArm(-SmartDashboard.getNumber("collector down power: " , 0.3));
        }
        else 
        {
            whereToStop = 2;
            collector.moveArm(-SmartDashboard.getNumber("collector down power: " , 0.3));
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        boolean finished = false;
        switch (whereToStop)
        {
            case 0:
                finished = collector.getBottomMicro();
                break;
            case 1:
                finished = collector.getTopMicro();
                break;
            case 2:
                finished = collector.getBottomMicro() || collector.getTopMicro();
                break;
        }
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
        collector.moveArm(0);
        System.out.println("movearmmicroswitches ended");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
}
