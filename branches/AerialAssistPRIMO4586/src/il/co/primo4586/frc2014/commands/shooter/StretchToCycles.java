/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.co.primo4586.frc2014.commands.shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import il.co.primo4586.frc2014.commands.CommandBase;

/**
 *
 * @author mor meitar idan
 */
public class StretchToCycles extends CommandBase {
    private double desiredCycles, currentCycles, difference ;
	private final double cyclesToSpeed = SmartDashboard.getNumber("Cycles To Speed", 0.01);
    
    public StretchToCycles(double cycles) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		desiredCycles = cycles;

    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
                desiredCycles = (SmartDashboard.getNumber("Power"));
		currentCycles = shooter.getCount();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
	{
                desiredCycles = (SmartDashboard.getNumber("Power"));
		currentCycles = shooter.getCount();
		difference = desiredCycles-currentCycles;
		if ( (difference > 0 &&  !shooter.getEndMicro()) ||  (difference < 0 &&  !shooter.getStartMicro()) )
		{
			shooter.stretch(-difference / Math.abs(difference));
                }

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
	{
		if ((-1 <= difference && difference <= 1) || (difference > 0 &&  !shooter.getEndMicro()) ||  (difference < 0 &&  !shooter.getStartMicro()) )
		{
			return true;
		}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
		shooter.stretch(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
		end();
    }
}
