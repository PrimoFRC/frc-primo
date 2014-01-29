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
public class MoveArmFree extends CommandBase {

	// not finished
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
		finished = false;
		finished = (collector.getLevel() == 0);
		finished = (collector.getLevel() == 2);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

		if(!(collector.getBottomMicro()) && !(collector.getTopMicro()))
		{
		collector.moveArm(direction);
		}
		else
		{
			finished = true;
		}
/*
		 if(getMiddleMicro())
		 {
			 if (direction > 0)
				 collector.setLevel(1.5);
			 else
				 collector.setLevel(0.5);

		 }
*/
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {

        return (!oi.manualLowerCollectorArm.get() && !oi.manualRaiseCollectorArm.get()) || finished;
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
