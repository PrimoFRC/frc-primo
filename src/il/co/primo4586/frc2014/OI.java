
package il.co.primo4586.frc2014;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import il.co.primo4586.frc2014.commands.Aim;
import il.co.primo4586.frc2014.commands.shooter.*;
import il.co.primo4586.frc2014.commands.collector.*;

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

    public JoystickButton manualLowerCollectorArm, manualRaiseCollectorArm, collectorToBottom, collectorToTop, collectorToMiddle ;
    public JoystickButton shoot , aim , trussThrow , initStretcher , grasp , release;


    public OI()
    {System.out.println("oi started");
		drivingStick = new Joystick(1);
        operatorStick = new Joystick(2);
        System.out.println("joysticks initiated");
        
        
		collectorToBottom = new JoystickButton(operatorStick, 11);
		collectorToTop = new JoystickButton(operatorStick, 12);
	
                
		collectorToBottom.whenPressed(new MoveArmBottom());
		collectorToTop.whenPressed(new MoveArmTop());

                grasp = new JoystickButton(operatorStick, 7);
                release = new JoystickButton(operatorStick, 8);
		aim = new JoystickButton(operatorStick, 2);
		shoot = new JoystickButton(operatorStick, 1);
		trussThrow = new JoystickButton(operatorStick, 3);
		initStretcher = new JoystickButton(operatorStick, 10);

                grasp.whenPressed(new Grasp());
                release.whenPressed(new Release());
                aim.whenPressed(new Aim());
                shoot.whenPressed(new Shoot());
		trussThrow.whenPressed(new ThrowOverTruss());
		initStretcher.whenPressed(new InitStretcher());
                

    }

}



