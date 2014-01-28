package il.co.primo4586.frc2014;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;


import edu.wpi.first.wpilibj.SpeedController;

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

	public static Talon collectArm;

	public static DigitalInput collector_top;

	public static DigitalInput collector_middle;

	public static DigitalInput collector_bottom;


	public static SpeedController drivingMotorLeftBack;
    public static SpeedController drivingMotorRightBack;
    public static SpeedController drivingMotorLeftFront;
    public static SpeedController drivingMotorRightFront;

	public static void init()
	{
		collectArm = new Talon(1); // need to check if there is two speed controlers or not

		collector_top = new DigitalInput(2);

		collector_middle = new DigitalInput(3);

		collector_bottom = new DigitalInput(4);



	}


}
