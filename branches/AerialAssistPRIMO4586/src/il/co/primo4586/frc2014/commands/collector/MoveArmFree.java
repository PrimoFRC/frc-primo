/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.co.primo4586.frc2014.commands.collector;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Joystick;
import il.co.primo4586.frc2014.commands.CommandBase;

/**
 *
 * @author Gottlieb
 */
public class MoveArmFree extends CommandBase {



	private boolean finished;
	private Joystick operatorStick;
	private double direction;
        private boolean isZeroed;


    public MoveArmFree() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        operatorStick = oi.operatorStick;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		direction = operatorStick.getY();
                
		if((direction > 0.1 &&  !collector.getTopMicro()) ||  (direction < -0.1 &&  !collector.getBottomMicro()) )
		{
                        
                        isZeroed = false;
			collector.moveArm(direction);
                        DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser1, 1, "MoveArmFree");
                        DriverStationLCD.getInstance().updateLCD();
		}
                
                else if (!isZeroed)
                {
                    shooter.stretch(0);
                    isZeroed = true;
                }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {

        return false;
			}

    // Called once after isFinished returns true
    protected void end(){
        System.out.println("collector ended");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
System.out.println("collector interrupted");
    }
}
