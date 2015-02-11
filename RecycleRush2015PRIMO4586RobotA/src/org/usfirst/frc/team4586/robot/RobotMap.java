package org.usfirst.frc.team4586.robot;

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
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	public static Talon lifterFront;
	public static Talon lifterFront2;
	//public static Talon lifterBack;
	public static Talon binRailMotor;
	
	public static Jaguar motorFrontLeft;
	public static Jaguar motorFrontRight;
	public static Jaguar motorBackLeft;
	public static Jaguar motorBackRight;
	
	public static DigitalInput checkContactFront1;
	public static DigitalInput checkContactFront2;
	/*
	public static DigitalInput checkContactBack1;
	public static DigitalInput checkContactBack2;
*/
	
	public static DigitalInput autoSwitch;
	
	public static DigitalInput valveFront;
	//public static DigitalInput valveBack;
	
	public static DigitalInput binRailSwitch;
	
	public static DigitalInput cylinderStuck;
	

	public static void init()// to be tested
	{
		lifterFront = new Talon(6);
		lifterFront2 = new Talon(4);
		//lifterBack = new Talon();
		binRailMotor = new Talon(5);
		
		motorFrontLeft = new Jaguar(2);
		motorFrontRight = new Jaguar(0);
		motorBackLeft = new Jaguar(3);
		motorBackRight = new Jaguar(1);

		/*
		checkContactBack1 = new DigitalInput(1);
		checkContactBack2 = new DigitalInput(8);
		*/
		checkContactFront1 = new DigitalInput(0);
		checkContactFront2 = new DigitalInput(3);
		
		autoSwitch = new DigitalInput(1);

		//valveBack = new DigitalInput(5);
		valveFront = new DigitalInput(2);
		
		binRailSwitch= new DigitalInput(5);
		
		cylinderStuck = new DigitalInput(4);
	}
}
