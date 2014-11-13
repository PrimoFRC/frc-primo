package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Counter;
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
    
    
    //microswitches
    public static DigitalInput topLifter;
    public static DigitalInput bottomLifter;
    public static DigitalInput collection;
    public static DigitalInput hanging;
    
    public static DigitalInput doorOpen;
    public static DigitalInput doorClose;
    
    public static DigitalInput cycleSensor;
    public static Counter cycleCounterPositive, cycleCounterNegative; 
    
    //speedControllers
    public static Jaguar frontLeft;
    public static Jaguar frontRight;
    public static Jaguar backLeft;
    public static Jaguar backRight;
    
    public static Talon doorMover;
    public static Talon lifterMover;
    
    public static void init()
    {
        //DigitalInputs
        topLifter = new DigitalInput(1);
        bottomLifter = new DigitalInput(2);
        collection = new DigitalInput(6);
        hanging = new DigitalInput(7);
        
        doorOpen = new DigitalInput(3);
        doorClose = new DigitalInput(4);
        
        cycleSensor = new DigitalInput(5);
        cycleCounterPositive = new Counter(cycleSensor);
        cycleCounterNegative = new Counter(cycleSensor);
                
        //speedControllers
        frontLeft = new Jaguar(1);
        frontRight = new Jaguar(2);
        backLeft = new Jaguar(3);
        backRight = new Jaguar(4);
        
        doorMover = new Talon(5);
        lifterMover = new Talon(6);
    }
}
