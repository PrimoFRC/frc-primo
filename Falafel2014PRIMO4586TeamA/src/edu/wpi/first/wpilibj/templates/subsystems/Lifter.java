/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author lenovo
 */
public class Lifter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
  
    Talon lifterMover1,lifterMover2;
    DigitalInput top, bottom, cycleSensor;
    
    
 
    public Lifter()
        {
            lifterMover1 = RobotMap.lifterMover1;
            lifterMover2 = RobotMap.lifterMover2;
            top = RobotMap.top;
            bottom = RobotMap.bottom;
            cycleSensor = RobotMap.cycleSensor;
        }
 
    public void setSpeedLifter(double speed)
            {
                lifterMover1.set(speed);
                lifterMover2.set (speed);
            }
    public double getSpeedLifter1()
            {
                return lifterMover1.get ();
            }
    public double getSpeedLifter2()
            {
                return lifterMover2.get ();
            }
    public boolean getTop()
            {
                return top.get();
            }
     public boolean getBottom()
            {
                return bottom.get();
            }
      
    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        
        
    }
}
