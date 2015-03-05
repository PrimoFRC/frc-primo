package org.usfirst.frc.team4586.robot.subsystems;

import org.usfirst.frc.team4586.robot.RobotMap;
import org.usfirst.frc.team4586.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class BinLifter extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	static Talon binRailMotor;
	static DigitalInput binRailSwitch;
	static boolean isTop, isBottom;

	public BinLifter() {
		binRailSwitch = RobotMap.binRailSwitch;
		binRailMotor = RobotMap.binRailMotor;
		isBottom = isBinRailSwitch();
		isTop = false;
	}

	public void moveBinRail(double speed) {
		binRailMotor
				.set(speed * SmartDashboard.getNumber("Max Bin Rail Speed"));
	}

	public boolean isBinRailSwitch() {
		return binRailSwitch.get();
	}

	public void setIsBottom(boolean value) {
		isBottom = value;
	}

	public void setIsTop(boolean value) {
		isTop = value;
	}

	public boolean isBottom() {
		return isBottom;
	}

	public boolean isTop() {
		return isTop;
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());

	}
}
