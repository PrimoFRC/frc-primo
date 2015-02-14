package org.usfirst.frc.team4586.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team4586.robot.commands.ExampleCommand;
import org.usfirst.frc.team4586.robot.commands.Rumble;
import org.usfirst.frc.team4586.robot.commands.BoxLifter.MoveBoxRailDown;
import org.usfirst.frc.team4586.robot.commands.BoxLifter.MoveBoxRailToBottom;
import org.usfirst.frc.team4586.robot.commands.BoxLifter.MoveBoxRailUp;
import org.usfirst.frc.team4586.robot.commands.BoxLifter.MoveBoxRailUpNoMicro;
import org.usfirst.frc.team4586.robot.commands.BoxLifter.ResetCounter;
import org.usfirst.frc.team4586.robot.commands.BoxLifter.ResetRail;
import org.usfirst.frc.team4586.robot.commands.binLifter.MoveBinRailToBottom;
import org.usfirst.frc.team4586.robot.commands.binLifter.MoveBinRailToTop;
import org.usfirst.frc.team4586.robot.commands.driver.ChangeMaxDrivingSpeed;
import org.usfirst.frc.team4586.robot.commands.driver.InitGyro;
import org.usfirst.frc.team4586.robot.commands.driver.InvertMotors;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	public Joystick operatorStickFront;
	//public Joystick operatorStickBack;
	public Joystick drivingStick;

	public JoystickButton resetCounter;
	public JoystickButton moveBoxRailFrontOneUp;
	public JoystickButton moveBoxRailFrontOneUpNoMicro;
	public JoystickButton moveBoxRailFrontOneDown;
	public JoystickButton moveBoxRailFrontBottom;
	
	public JoystickButton resetRail;
	
	public JoystickButton moveBoxRailFrontOneUpDriver;
	public JoystickButton moveBoxRailFrontOneDownDriver;
	/*public JoystickButton moveBoxRailBackOneUp;
	public JoystickButton moveBoxRailBackOneDown;
	public JoystickButton moveBoxRaillBackBottom;*/
	
	//public JoystickButton binRailToBottom;
	//public JoystickButton binRailToTop;
	
	public JoystickButton invertMotors;
	public JoystickButton increaseDrivingSpeed;
	public JoystickButton decreaseDrivingSpeed;
	public JoystickButton initGyro;
	public JoystickButton rumble;
	
	public JoystickButton freeStick;
	public JoystickButton freeDrivingStick;
	
	public OI() // to be tested
	{
		operatorStickFront = new Joystick(1);
		//operatorStickBack = new Joystick(2);
		drivingStick = new Joystick(0);
		
		 resetCounter = new JoystickButton (operatorStickFront , 12 );
		 moveBoxRailFrontOneUp = new JoystickButton(operatorStickFront,3);
		 moveBoxRailFrontOneUpNoMicro = new JoystickButton(operatorStickFront,5);
		 moveBoxRailFrontOneDown = new JoystickButton(operatorStickFront,4);
		 moveBoxRailFrontBottom = new JoystickButton(operatorStickFront,11);

		 resetRail = new JoystickButton(operatorStickFront, 9);
		 
		 moveBoxRailFrontOneUpDriver = new JoystickButton(drivingStick,6);
		 moveBoxRailFrontOneDownDriver = new JoystickButton(drivingStick,5);
		 /*moveBoxRailBackOneUp = new JoystickButton(operatorStickBack,3);
		 moveBoxRailBackOneDown = new JoystickButton(operatorStickBack,4);
		 moveBoxRaillBackBottom = new JoystickButton(operatorStickBack,11);*/
		 
		 decreaseDrivingSpeed = new JoystickButton(drivingStick, 3);
		 increaseDrivingSpeed = new JoystickButton(drivingStick, 1);
		 initGyro = new JoystickButton(drivingStick, 2);
		
		 rumble=new JoystickButton(operatorStickFront, 8); //just for fun/testing. may be removed later
		 
		 //binRailToBottom = new JoystickButton(operatorStickFront,6);
		 //binRailToTop = new JoystickButton(operatorStickFront,5);
		 
		 invertMotors = new JoystickButton(drivingStick,4);
		 
		 freeStick = new JoystickButton(operatorStickFront, 2);
		 freeDrivingStick = new JoystickButton(drivingStick, 8);

		 
		 resetCounter.whenPressed(new ResetCounter() );
		 moveBoxRailFrontOneUp.whenPressed(new MoveBoxRailUp(true));
		 moveBoxRailFrontOneUpNoMicro.whenPressed(new MoveBoxRailUpNoMicro(true));
		 moveBoxRailFrontOneDown.whenPressed(new MoveBoxRailDown(true));
		 moveBoxRailFrontBottom.whenPressed(new MoveBoxRailToBottom(true));
		 
		 resetRail.whenPressed(new ResetRail());
		 
		 moveBoxRailFrontOneUpDriver.whenPressed(new MoveBoxRailUpNoMicro(true));
		 moveBoxRailFrontOneDownDriver.whenPressed(new MoveBoxRailDown(true));
		 /*moveBoxRailBackOneUp.whenPressed(new MoveBoxRailUp(false));
		 moveBoxRailBackOneDown.whenPressed(new MoveBoxRailDown(false));
		 moveBoxRaillBackBottom.whenPressed(new MoveBoxRailToBottom(false));*/
		 
		 //binRailToBottom.whenPressed(new MoveBinRailToBottom());
		 //binRailToTop.whenPressed(new MoveBinRailToTop());
		 invertMotors.whenPressed(new InvertMotors());
		 
		 rumble.whenPressed(new Rumble());
		 
		 decreaseDrivingSpeed.whenPressed(new ChangeMaxDrivingSpeed(-1));
		 increaseDrivingSpeed.whenPressed(new ChangeMaxDrivingSpeed(1));
		 initGyro.whenPressed(new InitGyro());
	}
}

