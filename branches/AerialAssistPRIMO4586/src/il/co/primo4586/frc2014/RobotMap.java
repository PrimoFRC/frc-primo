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
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
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

	/**
	 * shooter properties
	 * @ author mor, idan, meitar
	 */
	public static Victor shooterStretcher; // controls the speed of the streaching motor
	public static Talon shooterReleaser; // controls the speed of the realesing motor
	public static AnalogChannel shooterCycleCounter; // optic sensor for counting the cycles of the streaching motor
	public static DigitalInput shooterStretcherStart; // digital sensor for when the rubber band is at the start
	public static DigitalInput shooterStretcherEnd; // digital sensor for when the rubber band is at the end
	public static DigitalInput shooterReleaserLock; // digital sensor for when the hook of the rubber band is locked

	public static void init()
	{
		shooterStretcher = new Victor (1);
		shooterReleaser = new Talon(1);
		shooterCycleCounter = new AnalogChannel(1);
		shooterStretcherStart = new DigitalInput(1);
		shooterStretcherEnd = new DigitalInput(1);
		shooterReleaserLock = new DigitalInput(1);
		collectArm = new Talon(1); // need to check if there is two speed controlers or not

		collector_top = new DigitalInput(2);

		collector_middle = new DigitalInput(3);

		collector_bottom = new DigitalInput(4);


	}


}
