/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.co.primo4586.frc2014.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import il.co.primo4586.frc2014.commands.Driver.MoveAfterShooting;
import il.co.primo4586.frc2014.commands.shooter.Grasp;
import il.co.primo4586.frc2014.commands.shooter.InitStretcher;
import il.co.primo4586.frc2014.commands.shooter.Release;
import il.co.primo4586.frc2014.commands.shooter.SetDefaultStretch;
import il.co.primo4586.frc2014.commands.shooter.SetStretchToDistance;
import il.co.primo4586.frc2014.commands.shooter.Shoot;
import il.co.primo4586.frc2014.commands.shooter.StretchToCycles;

/**
 *
 * @author Gottlieb
 */
public class AutonomousShoot extends CommandGroup {
    
    public AutonomousShoot() {
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
        addSequential(new SetStretchToDistance());
        addSequential(new StretchToCycles());
        
        addSequential(new Release());
        addSequential(new Wait());
        
        addSequential(new MoveAfterShooting());
        
        addSequential(new InitStretcher());
        addSequential(new Grasp());
        addSequential(new SetDefaultStretch());
        addSequential(new StretchToCycles());
        
    }
}
