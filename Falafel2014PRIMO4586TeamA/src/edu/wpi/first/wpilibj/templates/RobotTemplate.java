/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.AutonomousCommand;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.ExampleCommand;
import edu.wpi.first.wpilibj.templates.commands.driver.Drive;
import edu.wpi.first.wpilibj.templates.commands.dropper.MoveDoorJoystick;
import edu.wpi.first.wpilibj.templates.commands.lifter.ControlScissors;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
        autonomousCommand = new ExampleCommand();

        // Initialize all subsystems
        CommandBase.init();
        RobotMap.init();
        initSmartDashboard();
        
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        autonomousCommand.start();
        Scheduler.getInstance().add(new AutonomousCommand());
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        periodicSmartDashboard();
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        autonomousCommand.cancel();
        Scheduler.getInstance().removeAll();
        Scheduler.getInstance().add(new Drive());
        Scheduler.getInstance().add(new ControlScissors());
        Scheduler.getInstance().add(new MoveDoorJoystick());
        Scheduler.getInstance().run();
        
        
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        periodicSmartDashboard();
    }
    public void initSmartDashboard() //to be tested
    {
        SmartDashboard.putNumber("Cycles: ", 0);
        SmartDashboard.putNumber("Target Cycles: ", 0);
        SmartDashboard.putNumber("Hanged Position in Cycles: ",0);
        SmartDashboard.putNumber("Collection Position in Cycles: ",0);
        SmartDashboard.putNumber("Hanging Position in Cycles: ",0);
        SmartDashboard.putNumber("Scoring Position in Cycles: ",0);
    }
    public void periodicSmartDashboard()
    {
        if (CommandBase.lifter.getSpeedLifter1() > 0) {
            SmartDashboard.putNumber("Cycles: ", CommandBase.lifter.numOfCycles + CommandBase.lifter.getNumOfCycles());
        } else {
            SmartDashboard.putNumber("Cycles: ", CommandBase.lifter.numOfCycles - CommandBase.lifter.getNumOfCycles());
        }
        SmartDashboard.putBoolean("Is the Door Closed: ", CommandBase.dropper.getCloseMicro());
        SmartDashboard.putBoolean("Is the Door Open: ", CommandBase.dropper.getOpenMicro());
        SmartDashboard.putBoolean("Are the Scissors at the Bottom: ", CommandBase.lifter.getBottom());
        SmartDashboard.putBoolean("Are the Scissors at the Top: ", CommandBase.lifter.getTop());
        SmartDashboard.putNumber("Speed of Scissors Engine 1: ", CommandBase.lifter.getSpeedLifter1());
        SmartDashboard.putNumber("Speed of Scissors Engine 2: ", CommandBase.lifter.getSpeedLifter2());
    }
}
