/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.co.primo4586.frc2014.commands.collector;

import il.co.primo4586.frc2014.commands.CommandBase;

/**
 *
 * @author Gottlieb
 */
public class InitCollectorToTop extends CommandBase {
    
    public InitCollectorToTop() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		if (!collector.getTopMicro())
		{
			collector.moveArm(-0.3);
		}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return collector.getTopMicro();
    }

    // Called once after isFinished returns true
    protected void end() {
        collector.moveArm(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
