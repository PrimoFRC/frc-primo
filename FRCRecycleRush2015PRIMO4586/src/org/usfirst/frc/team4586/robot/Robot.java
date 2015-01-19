package org.usfirst.frc.team4586.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4586.robot.commands.CommandBase;
import org.usfirst.frc.team4586.robot.commands.ExampleCommand;
import org.usfirst.frc.team4586.robot.commands.BoxLifter.MoveBoxRailByStick;
import org.usfirst.frc.team4586.robot.commands.binLifter.MoveBinRailByStick;
import org.usfirst.frc.team4586.robot.commands.driver.MecanumDrive;
import org.usfirst.frc.team4586.robot.subsystems.Driver;
import org.usfirst.frc.team4586.robot.subsystems.ExampleSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {

		RobotMap.init();
		// System.out.println("robotMap works");
		CommandBase.init();
		// System.out.println("commandBase works");
		// initMotors();
		// System.out.println("initMotors works");

		// System.out.println("autonoumusGroupCommand works");

		// System.out.println("robotInit finished");

		// instantiate the command used for the autonomous period

		smartDashboardInit();
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		Scheduler.getInstance().add(new MecanumDrive());
		Scheduler.getInstance().add(new MoveBinRailByStick());
		Scheduler.getInstance().add(new MoveBoxRailByStick(false));
		Scheduler.getInstance().add(new MoveBoxRailByStick(true));
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		smartDashboardPeriodic();
		SmartDashboard.putNumber("max driving speed", 0.7);
		System.out.println("SmartDashboard should work");
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}

	public void smartDashboardInit() {
		SmartDashboard.putBoolean("Autonomus Take Trash", false);
		SmartDashboard.putBoolean("Autonomus Take Box", false);
		SmartDashboard.putBoolean("Autonomus Take Trash & Box", false);
		SmartDashboard.putBoolean("Autonomus Gever!!!!!!!", false);

		SmartDashboard.putNumber("max driving speed", 0.7);

		SmartDashboard.putNumber("autonomus drive back time", 1);
		SmartDashboard.putNumber("autonomus drive left time", 1);

		SmartDashboard.putNumber("accelerometer X", Driver.getAccelorometerX());
		SmartDashboard.putNumber("accelerometer Y", Driver.getAccelorometerY());
		SmartDashboard.putNumber("accelerometer Z", Driver.getAccelorometerZ());

		SmartDashboard.putBoolean("Microswitch 1 Front Rail",
				CommandBase.boxLifterFront.getCheckContact1());
		SmartDashboard.putBoolean("Microswitch 2 Front Rail",
				CommandBase.boxLifterFront.getCheckContact2());
		SmartDashboard.putBoolean("Valve Front Rail",
				CommandBase.boxLifterFront.getValve());
		SmartDashboard.putNumber("Number of boxes on Front rail",
				CommandBase.boxLifterFront.getCounter());
		SmartDashboard.putNumber("Speed of Front rail",
				CommandBase.boxLifterFront.getSpeed());

		SmartDashboard.putBoolean("Microswitch 1 Back Rail",
				CommandBase.boxLifterBack.getCheckContact1());
		SmartDashboard.putBoolean("Microswitch 2 Back Rail",
				CommandBase.boxLifterBack.getCheckContact2());
		SmartDashboard.putBoolean("Valve Back Rail",
				CommandBase.boxLifterBack.getValve());
		SmartDashboard.putNumber("Number of boxes on Back rail",
				CommandBase.boxLifterBack.getCounter());
		SmartDashboard.putNumber("Speed of Back rail",
				CommandBase.boxLifterBack.getSpeed());
		SmartDashboard.putNumber("Max Bin Rail Speed", 0.7);

		SmartDashboard.putNumber("Max speed of rails", 0.7);// to be tested
	}

	public void smartDashboardPeriodic() {
		SmartDashboard.putNumber("accelerometer X", Driver.getAccelorometerX());
		SmartDashboard.putNumber("accelerometer Y", Driver.getAccelorometerY());
		SmartDashboard.putNumber("accelerometer Z", Driver.getAccelorometerZ());
		
		SmartDashboard.putBoolean("Microswitch 1 Front Rail",
				CommandBase.boxLifterFront.getCheckContact1());
		SmartDashboard.putBoolean("Microswitch 2 Front Rail",
				CommandBase.boxLifterFront.getCheckContact2());
		SmartDashboard.putBoolean("Valve Front Rail",
				CommandBase.boxLifterFront.getValve());
		SmartDashboard.putNumber("Number of boxes on Front rail",
				CommandBase.boxLifterFront.getCounter());
		SmartDashboard.putNumber("Speed of Front rail",
				CommandBase.boxLifterFront.getSpeed());

		SmartDashboard.putBoolean("Microswitch 1 Back Rail",
				CommandBase.boxLifterBack.getCheckContact1());
		SmartDashboard.putBoolean("Microswitch 2 Back Rail",
				CommandBase.boxLifterBack.getCheckContact2());
		SmartDashboard.putBoolean("Valve Back Rail",
				CommandBase.boxLifterBack.getValve());
		SmartDashboard.putNumber("Number of boxes on Back rail",
				CommandBase.boxLifterBack.getCounter());
		SmartDashboard.putNumber("Speed of Back rail",
				CommandBase.boxLifterBack.getSpeed());
	}
}
