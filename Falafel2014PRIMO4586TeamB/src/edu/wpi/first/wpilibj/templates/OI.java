
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.dropper.ChangeDoorState;
import edu.wpi.first.wpilibj.templates.commands.dropper.CloseDoorWhilePressed;
import edu.wpi.first.wpilibj.templates.commands.dropper.OpenDoorWhilePressed;
import edu.wpi.first.wpilibj.templates.commands.lifter.LowerScissors;
import edu.wpi.first.wpilibj.templates.commands.lifter.MoveToKnownCycles;
import edu.wpi.first.wpilibj.templates.commands.lifter.RaiseScissors;

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
    
    public JoystickButton changeDoorState, closeDoor, openDoor, raiseScissors, 
            lowerScissors, moveToHanging, moveToCollection, moveToScoring, hang;
    
    public OI()
    {
        drivingStick = new Joystick(1);
        operatorStick = new Joystick(2);
                
        changeDoorState = new JoystickButton(operatorStick, 1);
        closeDoor = new JoystickButton(operatorStick, 3);
        openDoor = new JoystickButton(operatorStick, 4);
        
        changeDoorState.whenPressed(new ChangeDoorState());
        closeDoor.whenPressed(new CloseDoorWhilePressed());
        openDoor.whenPressed(new OpenDoorWhilePressed());
        
        raiseScissors = new JoystickButton(operatorStick, 5);
        lowerScissors = new JoystickButton(operatorStick, 6);
        moveToCollection = new JoystickButton(operatorStick, 7);
        moveToHanging = new JoystickButton(operatorStick, 8);
        moveToScoring = new JoystickButton(operatorStick, 9);
        hang = new JoystickButton(operatorStick, 10);
        
        raiseScissors.whenPressed(new RaiseScissors());
        lowerScissors.whenPressed(new LowerScissors());
        moveToCollection.whenPressed(new MoveToKnownCycles((int)SmartDashboard.getNumber("move to collection: ")));
        moveToHanging.whenPressed(new MoveToKnownCycles((int)SmartDashboard.getNumber("move to hanging: ")));
        moveToScoring.whenPressed(new MoveToKnownCycles((int)SmartDashboard.getNumber("move to scoring: ")));
        hang.whenPressed(new MoveToKnownCycles((int)SmartDashboard.getNumber("hang: ")));
    }
    
}

