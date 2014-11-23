
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.dropper.ChangeDoorState;
import edu.wpi.first.wpilibj.templates.commands.lifter.LowerScissorsWhilePressed;
import edu.wpi.first.wpilibj.templates.commands.lifter.MoveToBottom;
import edu.wpi.first.wpilibj.templates.commands.lifter.MoveToCycles;
import edu.wpi.first.wpilibj.templates.commands.lifter.RaiseScissorsWhilePressed;

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
    public Joystick driverStick, operatorStick;
    public JoystickButton changeDoorState, lowerScissors, raiseScissors, hang, moveToBottom, moveToCollection, moveToCycles, moveToHanging, moveToScoringPosition; 
    public OI()
    {
        driverStick=new Joystick(1);
        operatorStick=new Joystick(2);
        
        
        changeDoorState=new JoystickButton(operatorStick, 1);
        lowerScissors=new JoystickButton(operatorStick, 3);
        raiseScissors=new JoystickButton(operatorStick, 4);
        hang=new JoystickButton(operatorStick, 2);
        moveToBottom=new JoystickButton(operatorStick, 7);
        moveToCollection=new JoystickButton(operatorStick, 8);
        moveToCycles=new JoystickButton(operatorStick, 9);
        moveToHanging=new JoystickButton(operatorStick, 10);
        moveToScoringPosition=new JoystickButton(operatorStick, 11);
        
        
        
        changeDoorState.whenPressed(new ChangeDoorState());
        lowerScissors.whileHeld(new LowerScissorsWhilePressed());
        raiseScissors.whileHeld(new RaiseScissorsWhilePressed());
        hang.whenPressed(new MoveToCycles(-2));
        moveToBottom.whenPressed(new MoveToBottom());
        moveToCollection.whenPressed(new MoveToCycles(-3));
        moveToCycles.whenPressed(new MoveToCycles());
        moveToHanging.whenPressed(new MoveToCycles(-4));
        moveToScoringPosition.whenPressed(new MoveToCycles(-5));
        
        
      
    }
}
