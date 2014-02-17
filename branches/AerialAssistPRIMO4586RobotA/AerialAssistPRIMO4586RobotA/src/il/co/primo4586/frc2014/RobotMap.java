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
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;

    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
	public static SpeedController collectArm;

	public static SpeedController shooterStretcher; // controls the speed of the streaching motor
	public static SpeedController shooterReleaser; // controls the speed of the realesing motor

	public static SpeedController drivingMotorLeftBack;
    public static SpeedController drivingMotorRightBack;
    public static SpeedController drivingMotorLeftFront;
    public static SpeedController drivingMotorRightFront;

	public static DigitalInput collector_top;
	public static DigitalInput collector_middle;
	public static DigitalInput collector_bottom;

	public static DigitalInput shooterStretcherStart; // digital sensor for when the rubber band is at the start
	public static DigitalInput shooterStretcherEnd; // digital sensor for when the rubber band is at the end
	public static DigitalInput shooterReleaserLock; // digital sensor for when the hook of the rubber band is locked
        public static DigitalInput shooterReleaserFree;
	public static DigitalInput shooterCycleCounter; // optic sensor for counting the cycles of the streaching motor
        
        public static DigitalInput tryPort6;
        public static DigitalInput tryPort8;
        public static DigitalInput tryPort10;
        public static DigitalInput tryPort11;
        public static DigitalInput tryPort12;
        public static DigitalInput tryPort13;
        public static DigitalInput tryPort14;
        
	/**
	 * shooter properties
	 * @ author mor
	 */




	public static void init()
	{
		collectArm = new Victor(7); // need to check if there is two speed controlers or not

		shooterStretcher = new Talon(5);
		shooterReleaser = new Talon(8);//6

		drivingMotorLeftBack = new Jaguar(3);
		drivingMotorRightBack = new Jaguar(4);
		drivingMotorLeftFront = new Jaguar(1);
		drivingMotorRightFront = new Jaguar(2);

                
		collector_top = new DigitalInput(13);//7
		collector_bottom = new DigitalInput(9);


		shooterStretcherStart = new DigitalInput(2);//2
		shooterStretcherEnd = new DigitalInput(1);//1
		shooterReleaserLock = new DigitalInput(3);
                shooterReleaserFree = new DigitalInput(4);

		shooterCycleCounter = new DigitalInput(5);
                
                tryPort6 = new DigitalInput(6);
                tryPort8 = new DigitalInput(8);
                tryPort10 = new DigitalInput(10);
                tryPort11 = new DigitalInput(11);
                tryPort12 = new DigitalInput(12);
                tryPort13 = new DigitalInput(7);
                tryPort14 = new DigitalInput(14);
	}

	public static void initLiveWindow()
	{
		//LiveWindow.addActuator("Collector", "collectArm", (LiveWindowSendable)collectArm);
	}

}
