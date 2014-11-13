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
        RobotMap.init();
        CommandBase.init();
        initSmartDashboard();
        
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        autonomousCommand.start();
        Scheduler.getInstance().removeAll();
        
        Scheduler.getInstance().add(new AutonomousCommand());
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
        autonomousCommand.cancel();
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
        
        smartDashboardPeriodic();
                
    }
    
    public void initSmartDashboard()
    {
        SmartDashboard.putNumber("number of cycles: ", 0);
        SmartDashboard.putNumber("move to cycles: ", 0);
        SmartDashboard.putNumber("hang: ", 0);
        SmartDashboard.putNumber("move to hanging: ", 0);
        SmartDashboard.putNumber("move to collection: ", 0);
        SmartDashboard.putNumber("move to scoring: ", 0);
        

    }
    
    public void smartDashboardPeriodic()
    {
        SmartDashboard.putNumber("number of cycles: ", CommandBase.lifter.countCycles());
        
    }
}
