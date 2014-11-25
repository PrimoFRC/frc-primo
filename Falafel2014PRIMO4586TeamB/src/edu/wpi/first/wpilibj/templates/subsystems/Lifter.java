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
    public DigitalInput top;
    public DigitalInput bottom;
    public DigitalInput collection;
    public DigitalInput hanging;
    
    public DigitalInput cycleSensor;
    public Counter cycleCounterPositive, cycleCounterNegative;
    
    public Talon lifterMover1;
    
    public int cycles = 0;
    private boolean doCount = true;
    
    public Lifter()
    {
        top = RobotMap.topLifter;
        bottom = RobotMap.bottomLifter;
        collection = RobotMap.collection;
        hanging = RobotMap.hanging;
        
        cycleSensor = RobotMap.cycleSensor;
        cycleCounterPositive = RobotMap.cycleCounterPositive;
        cycleCounterNegative = RobotMap.cycleCounterNegative;
        
        lifterMover1 = RobotMap.lifterMover1;
    }
    
    public boolean getTopMicro()
    {
        return top.get();
    }
    
    public boolean getBottomMicro()
    {
        return bottom.get();
    }
    
    public boolean getHangingMicro()
    {
        return hanging.get();
    }
    
    public boolean getCollectionMicro()
    {
        return collection.get();
    }
    
    public double getRailSpeed()
    {
        return lifterMover1.get();
    }
    
    public void resetNumOfCycles()
    {
        cycleCounterNegative.reset();
        cycleCounterPositive.reset();
    }
    
    public void startNumOfCycles()
    {
        doCount = true;
    }
    
    public void stopNumOfCycles()
    {
        doCount = false;
    }
    
    public void setRailSpeed(double railSpeed)
    {
        lifterMover1.set(railSpeed);
    }
    
    public int countCycles()
    {
        if (doCount)
        {
            if (getRailSpeed() > 0)
            {
                cycleCounterNegative.stop();
                cycleCounterPositive.start();
            }
            else
            {
                cycleCounterPositive.stop();
                cycleCounterNegative.start();
            }
            
            cycles = cycleCounterPositive.get() - cycleCounterNegative.get();
        }
        else
        {
            cycleCounterNegative.stop();
            cycleCounterPositive.stop();
        }
        if (this.getBottomMicro())
        {
            resetNumOfCycles();
        }
        return cycles;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
