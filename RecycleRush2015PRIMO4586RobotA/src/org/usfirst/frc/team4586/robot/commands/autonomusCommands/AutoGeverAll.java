package org.usfirst.frc.team4586.robot.commands.autonomusCommands;

import org.usfirst.frc.team4586.robot.RobotMap;
import org.usfirst.frc.team4586.robot.commands.Wait;
import org.usfirst.frc.team4586.robot.commands.BoxLifter.MoveBoxRailByTime;
import org.usfirst.frc.team4586.robot.commands.BoxLifter.MoveBoxRailUp;
import org.usfirst.frc.team4586.robot.commands.driver.MoveRobot;
import org.usfirst.frc.team4586.robot.commands.driver.MoveRobotMicroSwitch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoGeverAll extends CommandGroup {

	public AutoGeverAll() {
		// Add Commands here:
		// e.g. addSequential(new Command1());
		// addSequential(new Command2());
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.
		/*
		 * addSequential(new MoveBoxRailUp(true)); addSequential(new
		 * MoveRobot(0, -1, 0, 0.5, false)); addSequential(new MoveRobot(1, 0,
		 * 0, 2, true)); addSequential(new MoveRobot(0, 1, 0, 1.1, false));
		 * addSequential(new MoveRobotMicroSwitch(0.5, 0, 0));
		 * 
		 * 
		 * addSequential(new MoveRobot(0, 0.3, 0, 2, false)); addParallel(new
		 * MoveBoxRailUp(true)); addSequential(new Wait(0.75));
		 * addSequential(new MoveRobot(0, -1, 0, 0.7, false)); addSequential(new
		 * MoveRobot(1, 0, 0, 2, true)); addSequential(new MoveRobot(0, 1, 0,
		 * 1.1, false)); addSequential(new MoveRobotMicroSwitch(0.5, 0, 0));
		 * 
		 * 
		 * addSequential(new MoveRobot(0, 0.3, 0, 2.5, false)); addParallel(new
		 * MoveBoxRailUp(true)); addSequential(new Wait(0.75));
		 * addSequential(new MoveRobot(0, -1, 0, 3.5, false));
		 * 
		 * addSequential(new MoveBoxRailByTime(-1, 1)); addSequential(new
		 * MoveRobot(0, -1, 0, 0.2,false));
		 */

		addSequential(new MoveBoxRailUp(true));
		addSequential(new MoveRobot(0, -1, 0, 1.15, false));
		addSequential(new MoveRobot(1, 0, 0, 1.5, true));
		addSequential(new MoveRobot(0, 1, 0, 0.9, false));
		addSequential(new MoveRobotMicroSwitch(0.5, 0, 0, RobotMap.autoSwitch));

		addSequential(new MoveRobot(0, 0.3, 0, 2, false));
		addParallel(new MoveBoxRailUp(true));
		addSequential(new Wait(0.75));
		addSequential(new MoveRobot(0, -1, 0, 1.4, false));
		addSequential(new MoveRobot(1, 0, 0, 1.5, true));
		addSequential(new MoveRobot(0, 1, 0, 1.0, false));
		addSequential(new MoveRobotMicroSwitch(0.5, 0, 0, RobotMap.autoSwitch));

		addSequential(new MoveRobot(0, 0.3, 0, 2.5, false));
		addParallel(new MoveBoxRailUp(true));
		addSequential(new Wait(0.75));
		addSequential(new MoveRobot(0, -1, 0, 4, false));
		addSequential(new MoveRobot(0, 1, 0, 0.4, false));

		addSequential(new MoveBoxRailByTime(-1, 1.2));
		addSequential(new MoveRobot(0, -1, 0, 0.3, false));
	}
}
