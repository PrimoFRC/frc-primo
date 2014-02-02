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
    //Talon releaser;
    //DigitalInput releaserLock;
    public Release() 
    {
        
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
        //setTimeout(1);
        shooter.release(0.5);
        DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser1, 1, "Shooting");
        DriverStationLCD.getInstance().updateLCD();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
   {
       
   }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return !oi.shoot.get();//!shooter.getLockMicro();
       
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
