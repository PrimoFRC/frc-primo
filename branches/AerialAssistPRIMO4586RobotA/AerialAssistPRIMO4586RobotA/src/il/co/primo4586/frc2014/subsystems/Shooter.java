/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.co.primo4586.frc2014.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import il.co.primo4586.frc2014.RobotMap;


/**
 *
 * @author mor, idan, meitar
 */
public class Shooter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	SpeedController stretcher;
	SpeedController releaser;

	DigitalInput cycleCounter;
        Counter cycles;
	DigitalInput stretcherStart;
	DigitalInput stretcherEnd;
	DigitalInput releaserLock;
        DigitalInput releaserFree;

	
        long lastCountCycles; // cycles count situation
        long newCountCycles; // the cycles count since the situation
        long currentCycles;
        double distanceByCycles;

	public Shooter()
	{
            stretcher = RobotMap.shooterStretcher; // controls the speed of the streaching motor
            releaser= RobotMap.shooterReleaser; // controls the speed of the realesing motor

            cycleCounter = RobotMap.shooterCycleCounter; // optic sensor for counting the cycles of the streaching motor

            stretcherStart = RobotMap.shooterStretcherStart; // digital sensor for when the rubber band is at the start
            stretcherEnd = RobotMap.shooterStretcherEnd; // digital sensor for when the rubber band is at the end
            releaserLock = RobotMap.shooterReleaserLock; // digital sensor for when the hook of the rubber band is locked
            releaserFree = RobotMap.shooterReleaserFree;
            
            distanceByCycles = 0;
            cycles = new Counter();
            cycles.setUpSource(cycleCounter);
            
            cycles.start();
            
	}


	/**-----------------------------------
	 *
	 * @param speed
	 */
	public void stretch(double speed)
	{
		stretcher.set(speed * SmartDashboard.getNumber("stretcher speed", 1));
                currentCycles = cycles.get() - lastCountCycles;
                newCountCycles -= currentCycles*(long)(Math.abs(speed)/speed);
                lastCountCycles += currentCycles;
                SmartDashboard.putNumber("Cycles", newCountCycles);
                //max cycles : 181
                
	}
        public void showCycles(double speed)
        {
            currentCycles = cycles.get() - lastCountCycles;
            newCountCycles -= currentCycles*(long)(Math.abs(speed)/speed);
            lastCountCycles += currentCycles;
            SmartDashboard.putNumber("Cycles", newCountCycles);
        }

	/**------------------------------------
	 *
	 */
	public void release(double speed)
	{
		releaser.set(speed);
	}

	/**------------------------------------
	 *
	 * @return
	 */
	public boolean getStartMicro()
	{
            //return false;
            return stretcherStart.get();
	}

	/**------------------------------------
	 *
	 * @return
	 */
	public boolean getEndMicro()
	{
            //return false;
            return stretcherEnd.get();
	}
        
        public boolean getCycleMicro()
	{
            //return false;
            return cycleCounter.get();
	}

	/**------------------------------------
	 *
	 * @return
	 */
	public boolean getLockMicro()
	{
            //return false;
            return releaserLock.get();
	}
        
        public boolean getFreeMicro()
	{
            //return false;
            return releaserFree.get();
	}

        /**------------------------------------
         *
         */
        public void initCount()
        {
            cycles.reset();
            lastCountCycles = cycles.get();
            newCountCycles = 0;
        }

	/**------------------------------------
	 *
	 *
	 */
	public long getCount()
	{
            return  newCountCycles;
	}
        
        public void setCount(long cycles)
	{
            newCountCycles = cycles;
	}
        

        

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
