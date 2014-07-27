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
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import il.co.primo4586.frc2014.commands.CommandBase;
import il.co.primo4586.frc2014.commands.*;
import il.co.primo4586.frc2014.commands.ImageProcessing.SetHighLighting;
import il.co.primo4586.frc2014.commands.ImageProcessing.SetLowLighting;
import il.co.primo4586.frc2014.commands.ImageProcessing.SetWeirdLighting;
import il.co.primo4586.frc2014.commands.shooter.InitStretcher;
import il.co.primo4586.frc2014.commands.shooter.StretchToCycles;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {

    public static SendableChooser lighting = new SendableChooser();
    Timer timer = new Timer();
    
    CommandGroup autonomousCheck;
    CommandGroup autonomousShoot;
    CommandGroup teleopSequence;
    
    public static double defaultStretch = 141;
    public static final double passStretch = 67;
    public static final double autonomousStretch = 141;
    
    public static double distance;
    
    public static boolean moveFirstAutonomous = false;
    
    public static boolean isHot;
    public static boolean isAimed = false;
    public static boolean passTheBall = false;
    public static boolean shootAutonomous = false;
    
    public static boolean isEmergencyStopped;

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
        autonomousCheck = new AutonomousCheckCamera();
        autonomousShoot = new AutonomousShoot();
        System.out.println("autonoumusGroupCommand works");
        teleopSequence = new TeleopCommandGroup();
        initSmartDashboard();
        isEmergencyStopped = false;
        System.out.println("robotInit finished");
    }

    public void autonomousInit() {
        
        timer.reset();
        timer.start();
        if (teleopSequence != null)
            teleopSequence.cancel();
        if (autonomousCheck != null)
            autonomousCheck.cancel();
        if (autonomousShoot != null)
            autonomousShoot.cancel();
        
        Scheduler.getInstance().removeAll();
        initMotors();
        // schedule the autonomous command (example)
        isFinishedAutonomous = false;
        isMovedForwardAutonomous = false;
        isHot = false;
        CommandBase.shooter.setCount((long)autonomousStretch);
	Scheduler.getInstance().add(new AutonomousInit());
        
        
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putBoolean("movedForward",isMovedForwardAutonomous);
        SmartDashboard.putNumber("timer move" , timer.get());
        if (timer.get() < 5)
        {
           if (isFinishedAutonomous && !isHot && !isMovedForwardAutonomous)
            {
                isFinishedAutonomous = false;
            
                Scheduler.getInstance().add(autonomousCheck);
            }
            else if (!isMovedForwardAutonomous && isHot)
            {
                timer.stop();
                isMovedForwardAutonomous = true;
                Scheduler.getInstance().add(autonomousShoot);
            } 
        }
        else if (!isMovedForwardAutonomous)
        {
            timer.stop();
            isMovedForwardAutonomous = true;
            Scheduler.getInstance().add(autonomousShoot);
        }
        
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        System.out.println("teleopInit started");
        if (teleopSequence != null)
            teleopSequence.cancel();
        if (autonomousCheck != null)
            autonomousCheck.cancel();
        if (autonomousShoot != null)
            autonomousShoot.cancel();
        
        Scheduler.getInstance().removeAll();
        
        Scheduler.getInstance().add((Command)lighting.getSelected());
        
        Scheduler.getInstance().add(teleopSequence);
        Scheduler.getInstance().run();
        initMotors();
        isEmergencyStopped = false;
        System.out.println("teleopInit works");

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        
        
        Scheduler.getInstance().run();
        
        SmartDashboardPeriodic();
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
            SmartDashboard.putNumber("stretcher speed", 1);
                SmartDashboard.putNumber("Over stretch: ", 0);
            
                SmartDashboard.putData(FILE_NAME, autonomousCheck);
		SmartDashboard.putNumber("Power", 70);
                
                
                SmartDashboard.putNumber("max free collector power: " , 1);
                SmartDashboard.putNumber("collector down power: " , 0.5);
                SmartDashboard.putNumber("collector up power: " , 1);    
                
                SmartDashboard.putNumber("default stretch:", 141);
                
                
                lighting.addDefault("Low Lighting", new SetLowLighting());
                lighting.addObject("High Lighting", new SetHighLighting());
                lighting.addObject("Weird Lighting", new SetWeirdLighting());
                SmartDashboard.putData("Lighting" , lighting);
                
                SmartDashboard.putNumber("RedLow", 100);
                SmartDashboard.putNumber("RedHigh", 255);
                SmartDashboard.putNumber("GreenLow", 200);
                SmartDashboard.putNumber("GreenHigh", 255);
                SmartDashboard.putNumber("BlueLow", 100);
                SmartDashboard.putNumber("BlueHigh", 240);     
                SmartDashboard.putBoolean("checkcheck", true);
                
                SmartDashboard.putNumber("Driving Devide", 1);
	}
        
        public void SmartDashboardPeriodic()
        {
                SmartDashboard.putBoolean("collector top:  ", CommandBase.collector.getTopMicro());
                SmartDashboard.putBoolean("collector bottom:   ", CommandBase.collector.getBottomMicro());
                SmartDashboard.putBoolean("shooter start:  ", CommandBase.shooter.getStartMicro());
                SmartDashboard.putBoolean("shooter end:  ", CommandBase.shooter.getEndMicro());
                SmartDashboard.putBoolean("releaser lock:  ", CommandBase.shooter.getLockMicro());
                SmartDashboard.putBoolean("releaser free:  ", CommandBase.shooter.getFreeMicro());
                SmartDashboard.putBoolean("cycle counter:   ", CommandBase.shooter.getCycleMicro());
                defaultStretch = SmartDashboard.getNumber("default stretch:", 127);
                /*
                SmartDashboard.putBoolean("tryPort6 ", RobotMap.tryPort6.get());
                SmartDashboard.putBoolean("tryPort8 ", RobotMap.tryPort8.get());
                SmartDashboard.putBoolean("tryPort10 ", RobotMap.tryPort10.get());
                SmartDashboard.putBoolean("tryPort11 ", RobotMap.tryPort11.get());
                SmartDashboard.putBoolean("tryPort12 ", RobotMap.tryPort12.get());
                SmartDashboard.putBoolean("tryPort13 ", RobotMap.tryPort13.get());
                SmartDashboard.putBoolean("tryPort14 ", RobotMap.tryPort14.get());
                */
        }
        
        
}
