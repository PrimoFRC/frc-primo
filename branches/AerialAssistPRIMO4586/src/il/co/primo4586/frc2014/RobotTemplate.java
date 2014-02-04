/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package il.co.primo4586.frc2014;


import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import il.co.primo4586.frc2014.commands.CommandBase;
import il.co.primo4586.frc2014.commands.*;
import il.co.primo4586.frc2014.commands.shooter.InitStretcher;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {


    CommandGroup autonomousSequence;
    CommandGroup teleopSequence;
    public static double distance;
    public static boolean isHot;

    public static boolean isFinishedAutonomous;
	public static boolean isMovedForwardAutonomous;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        System.out.println("robotInit started");
		
                System.out.println("smartdashboard works");
        // instantiate the command used for the autonomous period
        //autonomousCommand = new ExampleCommand();

        // Initialize all subsystems
        RobotMap.init();
        System.out.println("robotMap works");
        CommandBase.init();
        System.out.println("commandBase works");
        initMotors();
        System.out.println("initMotors works");
        autonomousSequence = new AutonomousCommandGroup();
        System.out.println("autonoumusGroupCommand works");
        teleopSequence = new TeleopCommandGroup();
        initSmartDashboard();
        System.out.println("robotInit finished");
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        isFinishedAutonomous = false;
		Scheduler.getInstance().add(new InitStretcher());
        Scheduler.getInstance().add(autonomousSequence);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        if (isFinishedAutonomous && !isMovedForwardAutonomous)
        {
            isFinishedAutonomous = false;
            Scheduler.getInstance().add(autonomousSequence);
        }
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        System.out.println("teleopInit started");
        if (autonomousSequence != null)
            autonomousSequence.cancel();
        Scheduler.getInstance().add(teleopSequence);
        Scheduler.getInstance().run();
        System.out.println("teleopInit works");

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        initSmartDashboard();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }

    public void initMotors()
    {
		RobotMap.collectArm.set(0);

		RobotMap.shooterStretcher.set(0);
		RobotMap.shooterReleaser.set(0);

		RobotMap.drivingMotorLeftBack.set(0);
        RobotMap.drivingMotorRightBack.set(0);
        RobotMap.drivingMotorLeftFront.set(0);
        RobotMap.drivingMotorRightFront.set(0);

    }

	public void initSmartDashboard()
    {
		SmartDashboard.putNumber("Power", 50);
		SmartDashboard.putNumber("Cycles To Speed", 0.01);
                SmartDashboard.putNumber("Cycles", 0);
                SmartDashboard.putBoolean("collector top: ", CommandBase.collector.getTopMicro());
                SmartDashboard.putBoolean("collector bottom: ", CommandBase.collector.getBottomMicro());
                SmartDashboard.putBoolean("shooter start: ", CommandBase.shooter.getStartMicro());
                SmartDashboard.putBoolean("shooter end: ", CommandBase.shooter.getEndMicro());
                SmartDashboard.putBoolean("releaser lock: ", CommandBase.shooter.getLockMicro());
                SmartDashboard.putBoolean("releaser free: ", CommandBase.shooter.getFreeMicro());
	}
}
