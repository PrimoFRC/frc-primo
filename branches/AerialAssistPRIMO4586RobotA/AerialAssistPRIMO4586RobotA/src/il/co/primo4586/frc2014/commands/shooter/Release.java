/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.co.primo4586.frc2014.commands.shooter;


import edu.wpi.first.wpilibj.DriverStationLCD;
import il.co.primo4586.frc2014.commands.CommandBase;

/**
 *
 * @author mor meitar idan
 */
public class Release extends CommandBase {
    public Release() 
    {
        
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
        if (!shooter.getFreeMicro())
        {
            shooter.release(1);
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
   {
       
   }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return shooter.getFreeMicro() || oi.initMotors.get();
       
    }

    // Called once after isFinished returns true
    protected void end() 
    {   
        shooter.release(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
        end();
    }
}
