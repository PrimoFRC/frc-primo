/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.co.primo4586.frc2014.commands.shooter;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Joystick;
import il.co.primo4586.frc2014.commands.CommandBase;
/**
 *
 * @author mor meitar idan
 */
public class StretchFree extends CommandBase {
    /**
     *  Victor stretcher;
	Talon releaser;
	AnalogChannel cycleCounter;
	DigitalInput stretcherStart;
	DigitalInput stretcherEnd;
	DigitalInput releaserLock;
	double stretchCycles, strechDistance;
        long primeCountCycles; // prime cycles count situations
        long newCountCycles; // the cycles count since the prime situation
     */

    private Joystick operatorStick;
    private double direction;

    public StretchFree()
    {
        requires(shooter);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
        operatorStick = oi.operatorStick;
        shooter.initCount();

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
            direction = operatorStick.getRawAxis(1) / Math.abs(operatorStick.getRawAxis(1));  // check which port is it

        if ( (direction > 0 &&  !shooter.getEndMicro()) ||  (direction < 0 &&  !shooter.getStartMicro()) )
        {
            shooter.stretch(direction/2);
            DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser2, 1, "stretch cycles:" + shooter.getCount());
            DriverStationLCD.getInstance().updateLCD();
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
