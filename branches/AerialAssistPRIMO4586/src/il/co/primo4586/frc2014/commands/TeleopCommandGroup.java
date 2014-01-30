/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.co.primo4586.frc2014.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import il.co.primo4586.frc2014.commands.Driver.MechanumDrive;
import il.co.primo4586.frc2014.commands.collector.MoveArmFree;
import il.co.primo4586.frc2014.commands.shooter.InitStretcher;
import il.co.primo4586.frc2014.commands.shooter.StretchFree;

/**
 *
 * @author
 */
public class TeleopCommandGroup extends CommandGroup {

    public TeleopCommandGroup() {
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

        addSequential(new InitStretcher());
        addParallel(new MechanumDrive());
        addParallel(new StretchFree());
        addParallel(new MoveArmFree());
    }
}
