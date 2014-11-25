/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.dropper;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author user
 */
public class MoveDoorJoystick extends CommandBase
{
    private double speed;
    private boolean moved=false;
	public MoveDoorJoystick()
	{
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
            this.speed = oi.operatorStick.getRawAxis(5);//to be tested
            if (this.speed > -0.1 && this.speed < 0.1) {
                this.speed = 0;
            } else {
                if (dropper.getOpenMicro() && this.speed > 0) {
                    this.speed = 0;
                } else {
                    if (dropper.getCloseMicro() && this.speed < 0) {
                        this.speed = 0;
                    } else {
                        this.speed = this.speed * 0.5;//to be tested
                    }
                }

            }

            if (this.speed == 0) {
                if (moved) {
                    dropper.moveDoor(speed);
                    moved = false;
                }

            } else {
                dropper.moveDoor(this.speed);
                moved = true;
            }
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return false;
	}

	// Called once after isFinished returns true
	protected void end()
	{
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
	}
}
