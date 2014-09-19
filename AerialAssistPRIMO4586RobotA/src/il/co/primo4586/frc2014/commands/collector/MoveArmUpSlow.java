/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.co.primo4586.frc2014.commands.collector;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import il.co.primo4586.frc2014.commands.CommandBase;

/**
 *
 * @author lenovo
 */
public class MoveArmUpSlow extends CommandBase {
    
    public MoveArmUpSlow() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        collector.moveArm(SmartDashboard.getNumber("up slow power: " , 0.7));
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !oi.moveArmUpSlow.get();
    }

    // Called once after isFinished returns true
    protected void end() {
        collector.moveArm(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
