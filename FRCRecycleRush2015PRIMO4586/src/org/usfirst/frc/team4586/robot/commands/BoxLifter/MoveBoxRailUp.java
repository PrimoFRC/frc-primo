package org.usfirst.frc.team4586.robot.commands.BoxLifter;

import org.usfirst.frc.team4586.robot.RobotMap;
import org.usfirst.frc.team4586.robot.commands.CommandBase;
import org.usfirst.frc.team4586.robot.subsystems.BoxLifter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MoveBoxRailUp extends Command {
	private BoxLifter boxLifter;
	private boolean wasReleased, wasInitialized;
	Timer timer;
	private boolean startedOn;

	public MoveBoxRailUp(boolean isFront) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		wasReleased = false;
		wasInitialized = false;
		//if (isFront) {
			boxLifter = CommandBase.boxLifterFront;
		//} else {
			//boxLifter = CommandBase.boxLifterBack;
		//}
		
		timer = new Timer();
		
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		//System.out.println(CommandBase.boxLifterFront.getCounter());
		
		wasReleased = false;
		wasInitialized = false;
		
		if (boxLifter.getCounter() < boxLifter.numOfValves)
				//&& boxLifter.getCheckContact1() && boxLifter.getCheckContact2())
		{
			if (boxLifter.getCounter() < 3)
				boxLifter.setSpeed(SmartDashboard.getNumber("Max speed of rails") * SmartDashboard.getNumber("Down factor"));
			else
				boxLifter.setSpeed(SmartDashboard.getNumber("Max speed of rails"));
			wasInitialized=true;
		}
		timer.reset();
		timer.stop();
		
		if(boxLifter.getHookState())
			startedOn=true;
		else
			startedOn=false;
			

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (boxLifter.getCounter() < boxLifter.numOfValves
				&& boxLifter.getCheckContact1() && boxLifter.getCheckContact2()) {
			
			if (boxLifter.getCounter() < 3)
				boxLifter.setSpeed(SmartDashboard.getNumber("Max speed of rails") * SmartDashboard.getNumber("Down factor"));
			else
				boxLifter.setSpeed(SmartDashboard.getNumber("Max speed of rails"));
			timer.start();
			System.out.println("time start");
		}
		
		if (!boxLifter.getHookState())
		{
			if(!wasReleased)
				//if(startedOn)
					//boxLifter.incrementCounter();
			wasReleased = true;
		}
		
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (!wasInitialized && boxLifter.getCounter() >= boxLifter.numOfValves ) || (wasReleased && boxLifter.getHookState()) ;//|| /timer.get()>2;
	}
	// Called once after isFinished returns true
	protected void end() {
		boxLifter.setSpeed(0);
		System.out.println("ended rail move up");
	
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
