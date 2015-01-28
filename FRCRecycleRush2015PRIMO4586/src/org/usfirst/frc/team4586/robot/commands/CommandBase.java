package org.usfirst.frc.team4586.robot.commands;


import org.usfirst.frc.team4586.robot.OI;
import org.usfirst.frc.team4586.robot.RobotMap;
import org.usfirst.frc.team4586.robot.subsystems.BinLifter;
import org.usfirst.frc.team4586.robot.subsystems.BoxLifter;
import org.usfirst.frc.team4586.robot.subsystems.Driver;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {
	public static Driver driver;
    public static OI oi;
    public static BinLifter binLifter;
    // Create a single static instance of all of your subsystems
    public static BoxLifter boxLifterFront;
    //public static BoxLifter boxLifterBack;
    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        
        driver = new Driver();
        binLifter=new BinLifter();
        boxLifterFront=new BoxLifter(RobotMap.checkContactFront1, RobotMap.checkContactFront2, RobotMap.valveFront, RobotMap.lifterFront , RobotMap.lifterFront2);
        //boxLifterBack = new BoxLifter(RobotMap.checkContactBack1,RobotMap.checkContactBack2, RobotMap.valveBack, RobotMap.lifterBack,RobotMap.lifterBack);
        oi = new OI();
        // Show what command your subsystem is running on the SmartDashboard
        
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
