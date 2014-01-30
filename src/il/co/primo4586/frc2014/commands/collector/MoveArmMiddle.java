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
public class MoveArmMiddle extends CommandBase
{

private boolean finished;

	public MoveArmMiddle()
	{
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(collector);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{

            finished = (collector.getMiddleMicro());
            if (!finished)
            {
                if(collector.getAboveMiddle())
		{
                    if (collector.getBottomMicro())
                    {
                        collector.setBelowMiddle();
                    }
                    collector.moveArm(-1);
                }
                else
		{
                    if (collector.getTopMicro())
                    {
                       collector.setAboveMiddle();
                    }
                    collector.moveArm(1);
		}
            }
	}
	protected void execute()
    {

    }

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		finished |= collector.getMiddleMicro();


		return finished;
	}

	// Called once after isFinished returns true
	protected void end()
	{

		collector.moveArm(0);
		// collector.setLevel(1);

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		end();
	}
}
