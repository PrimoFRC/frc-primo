/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package il.co.primo4586.frc2014.commands.shooter;

import edu.wpi.first.wpilibj.Joystick;
import il.co.primo4586.frc2014.RobotTemplate;
import il.co.primo4586.frc2014.commands.CommandBase;

/**
 *
 * @author meitar
 */
public class InitStretcher extends CommandBase {
    
    private Joystick operatorStick;
    public InitStretcher() {
        
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize()
	{
            operatorStick = oi.operatorStick;
		if (!shooter.getStartMicro())
		{
			shooter.stretch(1);
                }

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return shooter.getStartMicro() || operatorStick.getRawAxis(5) != 0;
    }

    // Called once after isFinished returns true
    protected void end()
	{
		shooter.stretch(0);
		shooter.initCount();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
		end();
    }
}