/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author lenovo
 */
public class Dropper extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private Talon doorMover;
    
    private DigitalInput doorOpen;
    private DigitalInput doorClose;
    
    public Dropper()
    {
        doorMover = RobotMap.doorMover;
        
        doorOpen = RobotMap.doorOpen;
        doorClose = RobotMap.doorClose;
    }
    
    public boolean getOpenMicro()
    {
        return doorOpen.get();
    }
    
    public boolean getCloseMicro()
    {
        return doorClose.get();
    }
    
    public void moveDoor(double speed)
    {
        doorMover.set(SmartDashboard.getNumber("door move speed: ")*speed);
    }
    
    public void stop()
    
    {
        doorMover.set(0);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
