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
    public Counter cycleCounter;
    
    public Talon lifterMover;
    
    public Lifter()
    {
        top = RobotMap.topLifter;
        bottom = RobotMap.bottomLifter;
        collection = RobotMap.collection;
        hanging = RobotMap.hanging;
        
        cycleSensor = RobotMap.cycleSensor;
        cycleCounter = RobotMap.cycleCounter;
        
        lifterMover = RobotMap.lifterMover;
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
        return lifterMover.get();
    }
    
    public int getNumOfCycles()
    {
        return cycleCounter.get();
    }
    
    public void resetNumOfCycles()
    {
        cycleCounter.reset();
    }
    
    public void startNumOfCycles()
    {
        cycleCounter.start();
    }
    
    public void stopNumOfCycles()
    {
        cycleCounter.stop();
    }
    
    public void setRailSpeed(double railSpeed)
    {
        lifterMover.set(railSpeed);
    }
    
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
