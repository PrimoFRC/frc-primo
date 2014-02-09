/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.co.primo4586.frc2014.commands.shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import il.co.primo4586.frc2014.RobotTemplate;
import il.co.primo4586.frc2014.commands.CommandBase;

/**
 *
 * @author mor meitar idan
 */
public class StretchToCycles extends CommandBase {
    private double desiredCycles, currentCycles, difference , power ;
	private final double cyclesToSpeed = SmartDashboard.getNumber("Cycles To Speed", 0.01);
    
    public StretchToCycles() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		

    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
                desiredCycles = 150;
                if (RobotTemplate.isAimed)
                {
                   desiredCycles = distanceToCycles(RobotTemplate.distance);
                }
		currentCycles = shooter.getCount();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
	{
                
		currentCycles = shooter.getCount();
		difference = desiredCycles-currentCycles;
		if ( (difference > 0 &&  !shooter.getEndMicro()) ||  (difference < 0 &&  !shooter.getStartMicro()) )
		{
                    power = -difference / Math.abs(difference);
                    if (shooter.getCount() < 100 || power > 0)
                    {
                        power = 0.7*power;
                    }
			shooter.stretch(power);
                }

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
	{
		if ((-1 <= difference && difference <= 1) || (difference > 0 &&  shooter.getEndMicro()) ||  (difference < 0 &&  shooter.getStartMicro()) )
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
    
    public static double distanceToCycles(double d)
    {
        double cycles = 6.2012*d*d*d - 59.433*d*d + 207.01*d - 93.3;
        System.out.println("############# cycles: ############ " + cycles);
        return (cycles);
            
    }
}
