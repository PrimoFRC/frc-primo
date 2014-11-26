/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author lenovo
 */
public class Dropper extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private Victor doorMover;
    
    private DigitalInput doorOpen, doorClose;
    
    public Dropper()
    {
        this.doorMover=RobotMap.doorMover;
        
        this.doorOpen=RobotMap.doorOpen;
        this.doorClose=RobotMap.doorClose;
   }
   public boolean getOpenMicro()
   {
       return this.doorOpen.get();
   }
    public boolean getCloseMicro()
   {
       return this.doorClose.get();
   }
    public void moveDoor(double speed)
    {
        //הפעולה מקבלת מהירות
        //הפעולה מעניקה את המהיקות למנוע שאחראי על הדלת
        this.doorMover.set(speed);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
