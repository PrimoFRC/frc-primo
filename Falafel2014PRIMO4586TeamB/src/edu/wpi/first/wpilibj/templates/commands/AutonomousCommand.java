/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.driver.MoveForward;
import edu.wpi.first.wpilibj.templates.commands.driver.MoveForwardSlow;
import edu.wpi.first.wpilibj.templates.commands.dropper.ChangeDoorState;
import edu.wpi.first.wpilibj.templates.commands.lifter.MoveToKnownCycles;
import edu.wpi.first.wpilibj.templates.commands.lifter.MoveToTop;

/**
 *
 * @author lenovo
 */
public class AutonomousCommand extends CommandGroup {
    
    public AutonomousCommand() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        
        addParallel(new MoveForward());
        addSequential(new MoveToTop());
        addSequential(new MoveForwardSlow(1));
        addParallel(new ChangeDoorState());
        addSequential(new Wait());
        addSequential(new MoveForwardSlow(-0.8));
    }
}
