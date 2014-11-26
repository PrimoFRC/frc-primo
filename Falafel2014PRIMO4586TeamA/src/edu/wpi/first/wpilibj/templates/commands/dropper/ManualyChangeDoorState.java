/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.dropper;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author lenovo
 */
public class ManualyChangeDoorState extends CommandBase {
    
    public ManualyChangeDoorState() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if(oi.emergencyCloseDoor.get() && !oi.emergencyOpenDoor.get())
            dropper.moveDoor(0.5);//to be tested
        else if(oi.emergencyOpenDoor.get() && !oi.emergencyCloseDoor.get())
            dropper.moveDoor(-0.5);//to be tested
        else
        {
        DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser1, 4, "Conflicting buttons are being pressed simultaneously, please release one of them");
        DriverStationLCD.getInstance().updateLCD();
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return oi.emergencyCloseDoor.get()==false && oi.emergencyOpenDoor.get()==false;
    }

    // Called once after isFinished returns true
    protected void end() {
        dropper.moveDoor(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
