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
public class MoveArmDown extends CommandBase {

	private boolean finished;

    public MoveArmDown() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		requires(collector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

		finished = (collector.getLevel() == 0);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
	{
		if (!finished)
			collector.moveArm(-1);
	}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
		finished &= collector.getMiddleMicro();
		finished &= collector.getBottomMicro();

		return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
		collector.moveArm(0);
		collector.setLevel(collector.getLevel()-1);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
