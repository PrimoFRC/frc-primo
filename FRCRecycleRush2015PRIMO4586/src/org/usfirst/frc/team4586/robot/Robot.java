package org.usfirst.frc.team4586.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4586.robot.commands.CommandBase;
import org.usfirst.frc.team4586.robot.commands.ExampleCommand;
import org.usfirst.frc.team4586.robot.commands.BoxLifter.MoveBoxRailByStick;
import org.usfirst.frc.team4586.robot.commands.autonomusCommands.*;
import org.usfirst.frc.team4586.robot.commands.binLifter.MoveBinRailByStick;
import org.usfirst.frc.team4586.robot.commands.driver.Accelerometer;
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
	
	
	public static SendableChooser autonomousMode = new SendableChooser();
	
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
		Scheduler.getInstance().add((Command)autonomousMode.getSelected());
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
		Scheduler.getInstance().removeAll(); 
		Scheduler.getInstance().add(new MecanumDrive());
		Scheduler.getInstance().add(new MoveBinRailByStick());
		Scheduler.getInstance().add(new MoveBoxRailByStick(false));
		Scheduler.getInstance().add(new MoveBoxRailByStick(true));
		Scheduler.getInstance().add(new Accelerometer());
		
		
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
		
		autonomousMode.addDefault("All", new AutoGeverAll());
        autonomousMode.addObject("Box", new AutoTakeBox());
        autonomousMode.addObject("Trash", new AutoTakeTrash());
        autonomousMode.addObject("Trash & Box", new AutoTakeTrashAndBox());
        SmartDashboard.putData("Autonomous Mode" , autonomousMode);
        
        /*
		SmartDashboard.putBoolean("Autonomus Take Trash", false);
		SmartDashboard.putBoolean("Autonomus Take Box", false);
		SmartDashboard.putBoolean("Autonomus Take Trash & Box", false);
		SmartDashboard.putBoolean("Autonomus Gever!!!!!!!", false);
		*/
        
		SmartDashboard.putNumber("max driving speed", 0.7);

		SmartDashboard.putNumber("autonomus drive back time", 1);
		SmartDashboard.putNumber("autonomus drive left time", 1);

		SmartDashboard.putNumber("accelerometer X", Driver.getAccelorometerX());
		SmartDashboard.putNumber("accelerometer Y", Driver.getAccelorometerY());
		SmartDashboard.putNumber("accelerometer Z", Driver.getAccelorometerZ());
		SmartDashboard.putNumber("Robot X Place", CommandBase.driver.getXPlace());
		SmartDashboard.putNumber("Robot Y Place", CommandBase.driver.getYPlace());
		SmartDashboard.putNumber("Robot X Speed", CommandBase.driver.getXSpeed());
		SmartDashboard.putNumber("Robot Y Speed", CommandBase.driver.getYSpeed());
		

		SmartDashboard.putBoolean("Microswitch 1 Front Rail",
				CommandBase.boxLifterFront.getCheckContact1());
		SmartDashboard.putBoolean("Microswitch 2 Front Rail",
				CommandBase.boxLifterFront.getCheckContact2());
		SmartDashboard.putBoolean("Valve Front Rail",
				CommandBase.boxLifterFront.getHookState());
		SmartDashboard.putNumber("Number of boxes on Front rail",
				CommandBase.boxLifterFront.getCounter());
		SmartDashboard.putNumber("Speed of Front rail",
				CommandBase.boxLifterFront.getSpeed());

		SmartDashboard.putBoolean("Microswitch 1 Back Rail",
				CommandBase.boxLifterBack.getCheckContact1());
		SmartDashboard.putBoolean("Microswitch 2 Back Rail",
				CommandBase.boxLifterBack.getCheckContact2());
		SmartDashboard.putBoolean("Valve Back Rail",
				CommandBase.boxLifterBack.getHookState());
		SmartDashboard.putNumber("Number of boxes on Back rail",
				CommandBase.boxLifterBack.getCounter());
		SmartDashboard.putNumber("Speed of Back rail",
				CommandBase.boxLifterBack.getSpeed());
		SmartDashboard.putNumber("Max Bin Rail Speed", 0.7);
		SmartDashboard.putBoolean("micro bin rail", CommandBase.binLifter.isBinRailSwitch());
		
		SmartDashboard.putNumber("Move Rail Down Time", 1);
		SmartDashboard.putNumber("move left speed", 0.5);
		SmartDashboard.putNumber("move back speed", -0.5);

		SmartDashboard.putNumber("Max speed of rails", 0.7);// to be tested
		SmartDashboard.putString("bin state", "");
	}

	public void smartDashboardPeriodic() {
		SmartDashboard.putNumber("accelerometer X", Driver.getAccelorometerX());
		SmartDashboard.putNumber("accelerometer Y", Driver.getAccelorometerY());
		SmartDashboard.putNumber("accelerometer Z", Driver.getAccelorometerZ());
		SmartDashboard.putNumber("Robot X Place", CommandBase.driver.getXPlace());
		SmartDashboard.putNumber("Robot Y Place", CommandBase.driver.getYPlace());
		SmartDashboard.putNumber("Robot X Speed", CommandBase.driver.getXSpeed());
		SmartDashboard.putNumber("Robot Y Speed", CommandBase.driver.getYSpeed());
		
		SmartDashboard.putBoolean("Microswitch 1 Front Rail",
				CommandBase.boxLifterFront.getCheckContact1());
		SmartDashboard.putBoolean("Microswitch 2 Front Rail",
				CommandBase.boxLifterFront.getCheckContact2());
		SmartDashboard.putBoolean("Valve Front Rail",
				CommandBase.boxLifterFront.getHookState());
		SmartDashboard.putNumber("Number of boxes on Front rail",
				CommandBase.boxLifterFront.getCounter());
		SmartDashboard.putNumber("Speed of Front rail",
				CommandBase.boxLifterFront.getSpeed());

		SmartDashboard.putBoolean("Microswitch 1 Back Rail",
				CommandBase.boxLifterBack.getCheckContact1());
		SmartDashboard.putBoolean("Microswitch 2 Back Rail",
				CommandBase.boxLifterBack.getCheckContact2());
		SmartDashboard.putBoolean("Valve Back Rail",
				CommandBase.boxLifterBack.getHookState());
		SmartDashboard.putNumber("Number of boxes on Back rail",
				CommandBase.boxLifterBack.getCounter());
		SmartDashboard.putNumber("Speed of Back rail",
				CommandBase.boxLifterBack.getSpeed());
		SmartDashboard.putBoolean("micro bin rail", CommandBase.binLifter.isBinRailSwitch());
		if(CommandBase.binLifter.isTop())
		{
			SmartDashboard.putString("bin state", "top");
		}
		else if (CommandBase.binLifter.isBottom())
		{
			SmartDashboard.putString("bin state", "bottom");
		}
		else if((CommandBase.binLifter.isBottom())&&(CommandBase.binLifter.isTop()))
		{
			SmartDashboard.putString("bin state", "buggggggg!!!!!!!!");
		}
		else
		{
			SmartDashboard.putString("bin state", "middle");
		}
	}
}
