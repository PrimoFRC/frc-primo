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
 * @author mor, idan, meitar
 */
public class Grasp extends CommandBase {
    
    public Grasp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
        DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser2, 1, "lock: " + shooter.getLockMicro());
        DriverStationLCD.getInstance().updateLCD();
         if (!shooter.getLockMicro())
        {
            shooter.release(0.5);
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {     
        return shooter.getLockMicro();
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
