/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package il.co.primo4586.frc2014.commands.collector;

import il.co.primo4586.frc2014.commands.CommandBase;

/**
 *
 * @author user
 */
public class MoveArmTop extends CommandBase
{
private boolean finished;

	public MoveArmTop()
	{
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(collector);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{

		finished = (collector.getTopMicro());
		if (!finished)
		{
			collector.moveArm(1);
		}
		collector.setAboveMiddle();

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{

		finished |= collector.getTopMicro();


		return finished;
	}

	// Called once after isFinished returns true
	protected void end()
	{
		collector.moveArm(0);
	//	collector.setLevel(2);


	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		end();
	}
}
