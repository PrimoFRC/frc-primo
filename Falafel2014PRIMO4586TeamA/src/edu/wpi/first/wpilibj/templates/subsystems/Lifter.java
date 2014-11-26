/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Counter;
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
    
  
     private Talon lifterMover;
     private  DigitalInput top, bottom, cycleSensor;
     private Counter cycleCounter;
     public int numOfCycles=0;    
 
    public Lifter()
        {
            lifterMover = RobotMap.lifterMover;
            top = RobotMap.top;
            bottom = RobotMap.bottom;
            cycleSensor = RobotMap.cycleSensor;
            cycleCounter = new Counter ();
            cycleCounter.start();
        }
 
    public void setSpeedLifter(double speed)
            {
                if(lifterMover.getSpeed()!=0)
                    if (lifterMover.getSpeed() * speed <= 0) {
                        if (lifterMover.getSpeed() > 0) 
                            numOfCycles += cycleCounter.get();
                        else 
                            numOfCycles -= cycleCounter.get();
                        cycleCounter.reset();
                    }
                lifterMover.set(speed);
                
            }
    public double getSpeedLifter1()
            {
                return lifterMover.get ();
            }
    public boolean getTop()
            {
                return top.get();
            }
     public boolean getBottom()
            {
                return bottom.get();
            }
      
    public int getNumOfCycles ()
            {
                return cycleCounter.get();
            }
    public void resetCycles()
    {
        cycleCounter.reset();
    }
   public void startCycles()
   {
       cycleCounter.start();
   }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        
        
    }
}
