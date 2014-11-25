package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;

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
    
    public static Victor doorMover;
    public static Talon lifterMover1, lifterMover2;
    
    public static void init()
    {
        //DigitalInputs
        topLifter = new DigitalInput(1);
        bottomLifter = new DigitalInput(8);
        collection = new DigitalInput(6);
        hanging = new DigitalInput(7);
        
        doorOpen = new DigitalInput(3);
        doorClose = new DigitalInput(2);
        
        cycleSensor = new DigitalInput(10);
        cycleCounterPositive = new Counter(cycleSensor);
        cycleCounterNegative = new Counter(cycleSensor);
                
        //speedControllers
        frontLeft = new Jaguar(3);
        frontRight = new Jaguar(1);
        backLeft = new Jaguar(4);
        backRight = new Jaguar(8);
        
        doorMover = new Victor(5);
        lifterMover1 = new Talon(6);
        lifterMover2 = new Talon(7);
    }
}
