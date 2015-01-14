package org.usfirst.frc.team4586.robot;

import edu.wpi.first.wpilibj.DigitalInput;
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
	public static Talon lifterBack;

	public static DigitalInput checkContactFront1;
	public static DigitalInput checkContactFront2;
	public static DigitalInput checkContactBack1;
	public static DigitalInput checkContactBack2;

	public static DigitalInput valveFront;
	public static DigitalInput valveBack;

	public static void init()// to be tested
	{
		lifterFront = new Talon(1);
		lifterBack = new Talon(2);

		checkContactBack1 = new DigitalInput(1);
		checkContactBack2 = new DigitalInput(2);
		checkContactFront1 = new DigitalInput(3);
		checkContactFront2 = new DigitalInput(4);

		valveBack = new DigitalInput(5);
		valveFront = new DigitalInput(6);

	}
}
