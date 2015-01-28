package org.usfirst.frc.team4586.robot.commands.autonomusCommands;

import org.usfirst.frc.team4586.robot.commands.BoxLifter.MoveBoxRailByTime;
import org.usfirst.frc.team4586.robot.commands.BoxLifter.MoveBoxRailDown;
import org.usfirst.frc.team4586.robot.commands.BoxLifter.MoveBoxRailUp;
import org.usfirst.frc.team4586.robot.commands.binLifter.MoveBinRailToBottom;
import org.usfirst.frc.team4586.robot.commands.binLifter.MoveBinRailToTop;
import org.usfirst.frc.team4586.robot.commands.driver.MoveRobot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoTakeTrashAndBox extends CommandGroup {
    
    public  AutoTakeTrashAndBox() {
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
    	
    	addSequential(new MoveBoxRailUp(true));
    	addSequential(new MoveBoxRailUp(true));
    	//addSequential(new MoveBinRailToTop());	//lifting the trash
    	addSequential(new MoveRobot(-1, 0, 0, 1, true));	
    	addSequential(new MoveRobot(0, 0.5, 0, 1.5,false));
    	addSequential(new MoveBoxRailUp(true));
    	addSequential(new MoveRobot(0, -1, 0, 1,false));
    }
}
