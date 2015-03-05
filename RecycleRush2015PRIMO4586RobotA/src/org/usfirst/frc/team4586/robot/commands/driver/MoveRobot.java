package org.usfirst.frc.team4586.robot.commands.driver;

import org.usfirst.frc.team4586.robot.commands.CommandBase;
import org.usfirst.frc.team4586.robot.subsystems.Driver;

import edu.wpi.first.wpilibj.AnalogAccelerometer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MoveRobot extends Command {

	double runTime;
	Timer timer = new Timer();
	static double xSpeed, xPlace, ySpeed, yPlace, difTime, lastTime;
	double x, y, z, time;
	boolean isX;

	public MoveRobot(double x, double y, double z, double time, boolean isX) {

		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		this.x = x;
		this.y = y;
		this.z = z;
		this.time = time;
		this.isX = isX;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		CommandBase.driver.resetGyro();
		System.out.println("init move robot");
		runTime = (isX) ? time
				* SmartDashboard.getNumber("autonomus drive left time") : time
				* SmartDashboard.getNumber("autonomus drive back time");

		initAccelometer();

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		z = (CommandBase.driver.getGyro())
				* SmartDashboard.getNumber("Gyro factor", 0.05);
		CommandBase.driver.mecanumDrive(
				x * SmartDashboard.getNumber("move left speed", 0.5), -y
						* SmartDashboard.getNumber("move back speed"), z
						* SmartDashboard.getNumber("max driving speed"));

		accelometer();

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		System.out.println(runTime);
		return timer.get() > runTime;

	}

	// Called once after isFinished returns true
	protected void end() {
		timer.stop();
		timer.reset();

		CommandBase.driver.stop();

		System.out.println("end move robot");

		endAccelometer();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}

	protected void accelometer() {
		difTime = timer.get() - lastTime;

		xSpeed = xSpeed + difTime * (Driver.getAccelorometerX()) * 9.81;
		ySpeed = ySpeed + difTime * (Driver.getAccelorometerY()) * 9.81;
		xPlace = xPlace + difTime * xSpeed;
		yPlace = yPlace + difTime * ySpeed;

		CommandBase.driver.setXSpeed(xSpeed);
		CommandBase.driver.setXPlace(xPlace);
		CommandBase.driver.setYSpeed(ySpeed);
		CommandBase.driver.setYPlace(yPlace);

		lastTime = difTime + lastTime;
	}

	protected void initAccelometer() {
		xSpeed = 0;
		xPlace = 0;
		ySpeed = 0;
		yPlace = 0;
		difTime = 0;
		timer.reset();
		timer.start();
		lastTime = 0;
	}

	protected void endAccelometer() {
		xSpeed = 0;
		ySpeed = 0;
	}

	protected double round(double num) {
		num = (int) num;
		return (double) num;
	}
}
