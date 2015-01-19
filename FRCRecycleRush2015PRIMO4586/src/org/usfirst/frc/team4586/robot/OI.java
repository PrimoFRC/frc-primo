package org.usfirst.frc.team4586.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team4586.robot.commands.ExampleCommand;
import org.usfirst.frc.team4586.robot.commands.binLifter.MoveBinRailToBottom;
import org.usfirst.frc.team4586.robot.commands.binLifter.MoveBinRailToTop;
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
	public Joystick operatorStickBack;
	public Joystick drivingStick;

	public JoystickButton moveBoxRailFrontOneUp;
	public JoystickButton moveBoxRailFrontOneDown;
	public JoystickButton moveBoxRailFrontBottom;

	public JoystickButton moveBoxRailBackOneUp;
	public JoystickButton moveBoxRailBackOneDown;
	public JoystickButton moveBoxRaillBackBottom;
	
	public JoystickButton binRailToBottom;
	public JoystickButton binRailToTop;
	
	public JoystickButton invertMotors;
	
	public OI() // to be tested
	{
		operatorStickFront = new Joystick(2);
		operatorStickBack = new Joystick(3);
		drivingStick = new Joystick(0);
		
		 moveBoxRailFrontOneUp = new JoystickButton(operatorStickFront,1);
		 moveBoxRailFrontOneDown = new JoystickButton(operatorStickFront,2);
		 moveBoxRailFrontBottom = new JoystickButton(operatorStickFront,3);

		 moveBoxRailBackOneUp = new JoystickButton(operatorStickBack,1);;
		 moveBoxRailBackOneDown = new JoystickButton(operatorStickBack,2);;
		 moveBoxRaillBackBottom = new JoystickButton(operatorStickBack,3);;
		 
		 binRailToBottom = new JoystickButton(operatorStickBack,4);
		 binRailToTop = new JoystickButton(operatorStickBack,5);
		 
		 invertMotors = new JoystickButton(drivingStick,5);
		 
		 binRailToBottom.whenPressed(new MoveBinRailToBottom());
		 binRailToTop.whenPressed(new MoveBinRailToTop());
		 invertMotors.whenPressed(new InvertMotors());
	}
}

