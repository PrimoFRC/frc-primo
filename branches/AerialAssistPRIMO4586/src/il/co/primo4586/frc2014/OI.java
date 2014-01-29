
package il.co.primo4586.frc2014;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import il.co.primo4586.frc2014.commands.collector.MoveArmBottom;
import il.co.primo4586.frc2014.commands.collector.MoveArmDown;
import il.co.primo4586.frc2014.commands.collector.MoveArmFree;
import il.co.primo4586.frc2014.commands.collector.MoveArmTop;
import il.co.primo4586.frc2014.commands.collector.MoveArmUp;

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

    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);

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
    public Joystick drivingStick;
	public Joystick operatorStick;
    public JoystickButton button1, button2, manualLowerCollectorArm, manualRaiseCollectorArm, lowerCollectorArm, raiseCollectorArm, collectorToBottom, collectorToTop, collectorToMiddle ;

    public OI()
    {
                drivingStick = new Joystick(1);
		button1 = new JoystickButton(operatorStick, 1);
		button2 = new JoystickButton(operatorStick, 2);
		manualLowerCollectorArm = new JoystickButton(operatorStick, 3);
		manualRaiseCollectorArm = new JoystickButton(operatorStick, 4);
		// lowerCollectorArm = new JoystickButton(operatorStick, 5);
		// raiseCollectorArm = new JoystickButton(operatorStick, 6);

		collectorToBottom = new JoystickButton(operatorStick, 7);
		collectorToTop = new JoystickButton(operatorStick, 8);
		collectorToMiddle = new JoystickButton(operatorStick, 9);

		collectorToBottom.whenPressed(new MoveArmBottom());
		collectorToTop.whenPressed(new MoveArmTop());
		collectorToMiddle.whenPressed(new MoveArmBottom());



	//	lowerCollectorArm.whenPressed(new MoveArmDown());
	//	raiseCollectorArm.whenPressed(new MoveArmUp());

		manualLowerCollectorArm.whileHeld(new MoveArmFree(1));
		manualRaiseCollectorArm.whileHeld(new MoveArmFree(-1));



    }

    public Joystick getDrivingStick()
    {
        return drivingStick;
    }
}



