package org.usfirst.frc.team4586.robot.commands.autonomusCommands;

import org.usfirst.frc.team4586.robot.RobotMap;
import org.usfirst.frc.team4586.robot.commands.Wait;
import org.usfirst.frc.team4586.robot.commands.BoxLifter.MoveBoxRailByTime;
import org.usfirst.frc.team4586.robot.commands.BoxLifter.MoveBoxRailUpNoMicro;
import org.usfirst.frc.team4586.robot.commands.driver.MoveRobot;
import org.usfirst.frc.team4586.robot.commands.driver.MoveRobotMicroSwitch;
import org.usfirst.frc.team4586.robot.commands.driver.RotateRobot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoAllLiftBoxes extends CommandGroup {

	public AutoAllLiftBoxes() {
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
		 * addSequential(new MoveBoxRailToTarget(4)); addSequential(new
		 * MoveRobotMicroSwitch(1, 0, 0, RobotMap.autoSwitch));
		 * addSequential(new MoveRobot(1, 0, 0, 1, true)); addSequential(new
		 * MoveRobotMicroSwitch(1, 0, 0, RobotMap.autoSwitch));
		 * addSequential(new MoveBoxRailToTarget(2)); addSequential(new
		 * MoveRobotMicroSwitch(0, 0.5, 0, RobotMap.checkContactFront1));
		 * addSequential(new MoveBoxRailToTarget(5)); addSequential(new
		 * MoveRobotMicroSwitch(1, 0, 0, RobotMap.autoSwitch));
		 * addSequential(new MoveRobot(1, 0, 0, 1, true)); addSequential(new
		 * MoveRobotMicroSwitch(1, 0, 0, RobotMap.autoSwitch));
		 * addSequential(new MoveBoxRailByTime(0.7 , 0.2));
		 */
		
		/*
		 * RobotA code before send
		 
		addParallel(new MoveBoxRailUpNoMicro(true));
		addSequential(new Wait(0.5));
		addSequential(new RotateRobot(-75));
		addSequential(new MoveRobot(0, -1, 0, 2.6, false));
		addSequential(new RotateRobot(75));
		addSequential(new MoveRobot(0, 0.5, 0, 1, false));
		addSequential(new MoveRobotMicroSwitch(1, 0, 0, RobotMap.autoSwitch));
		addSequential(new MoveRobotMicroSwitch(0.3, 0.5, 0,
				RobotMap.checkContactFront1));
		addSequential(new MoveBoxRailUpNoMicro(true));
		addSequential(new RotateRobot(-75));
		addSequential(new MoveRobot(0, -1, 0, 2.6, false));
		addSequential(new RotateRobot(75));
		addSequential(new MoveRobot(0, 0.5, 0, 1, false));
		addSequential(new MoveRobotMicroSwitch(1, 0, 0, RobotMap.autoSwitch));
		addSequential(new MoveRobotMicroSwitch(0, 0.5, 0,
				RobotMap.checkContactFront1));
		addSequential(new MoveBoxRailUpNoMicro(true));

		addSequential(new MoveRobot(0, -1, 0, 5, false));
		addSequential(new MoveRobot(0, 1, 0, 0.4, false));

		addSequential(new MoveBoxRailByTime(-1, 1.2));
		addSequential(new MoveRobot(0, -1, 0, 0.3, false));
		*/
		
		addParallel(new MoveBoxRailUpNoMicro(true));
		addSequential(new Wait(0.5));
		addSequential(new RotateRobot(-70));
		addSequential(new MoveRobot(0, -1, 0, 2.6, false));
		addSequential(new RotateRobot(70));
		//addSequential(new MoveRobot(0, 0.5, 0, 1, false));
		addSequential(new MoveRobotMicroSwitch(1, 0.5, 0, RobotMap.autoSwitch));
		addSequential(new MoveRobotMicroSwitch(0.2, 0.35, 0,
				RobotMap.checkContactFront1));
		
		addParallel(new MoveBoxRailUpNoMicro(true));
		addSequential(new Wait(0.5));
		addSequential(new RotateRobot(-70));
		addSequential(new MoveRobot(0, -1, 0, 2.6, false));
		addSequential(new RotateRobot(70));
		//addSequential(new MoveRobot(0, 0.5, 0, 1, false));
		addSequential(new MoveRobotMicroSwitch(1, 0.7, 0, RobotMap.autoSwitch));
		addSequential(new MoveRobotMicroSwitch(0.2, 0.35, 0,
				RobotMap.checkContactFront1));
		
		
		addSequential(new MoveBoxRailByTime(1 ,0.2));
		
		addSequential(new MoveRobot(0, -1, 0, 4, false));
		addSequential(new MoveRobot(0, 1, 0, 0.4, false));

		addSequential(new MoveBoxRailByTime(-1, 0.6));
		addSequential(new MoveRobot(0, -1, 0, 0.3, false));

	}

}
