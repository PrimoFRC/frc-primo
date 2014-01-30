/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.co.primo4586.frc2014.commands.Collector;

import il.co.primo4586.frc2014.commands.CommandBase;

/**
 *
 * @author Gottlieb
 */
public class MoveArmFree extends CommandBase {


	int direction;
	private boolean finished;



    public MoveArmFree(int direction) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		requires(collector);
		this.direction = direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() {

		finished = (collector.getTopMicro());
		finished |= (collector.getBottomMicro());

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

		if(!finished)
		{

			collector.moveArm(direction);

			if(collector.getMiddleMicro())
			{
				if (direction>0)
				{
					collector.getAboveMiddle();
				}
				else
				{
					collector.setBelowMiddle();
				}

			}

			if(collector.getTopMicro())
			{
				finished= true;
			}

			if(collector.getBottomMicro())
			{
				finished= true;
			}

		}




    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {

		if(collector.getTopMicro() && direction>0)
			{
				finished= true;
			}

			if(collector.getBottomMicro() && direction<0)
			{
				finished= true;
			}


        return (!oi.manualLowerCollectorArm.get() && !oi.manualRaiseCollectorArm.get()) || finished; //needs to be changed from isHeld to joystick
    }

    // Called once after isFinished returns true
    protected void end()
	{
		collector.moveArm(0);
	}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
