package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Talon;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    public static DigitalInput top, bottom, cycleSensor, doorClose, doorOpen; 
    public static Jaguar frontLeft, frontRight, backLeft, backRight;
    public static Talon doorMover, lifterMover;
    
    
    public static void init()
    {
        top=new DigitalInput(1);
        bottom=new DigitalInput(2);
        cycleSensor=new DigitalInput(3);
        doorClose=new DigitalInput(4);
        doorOpen=new DigitalInput(5);
        
        
        frontLeft=new Jaguar(1);
        frontRight=new Jaguar(2);
        backLeft=new Jaguar(3);
        backRight=new Jaguar(4);
        
        
        doorMover=new Talon(1);
        lifterMover=new Talon(2);
    }
    
    
    
}
