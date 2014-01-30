
import il.co.primo4586.frc2014.commands.CommandBase;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class StretchMax extends CommandBase
{

	public StretchMax()
	{
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		if(!shooter.getEndMicro())
		{
			shooter.stretch(1);
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return shooter.getEndMicro();
	}

	// Called once after isFinished returns true
	protected void end()
	{
		shooter.stretch(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{

	}
}
