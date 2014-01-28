/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.co.primo4586.frc2014.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import il.co.primo4586.frc2014.RobotMap;

/**
 *
 * @author mor, idan, meitar
 */
public class Shooter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	Victor stretcher;
	Talon releaser;
	AnalogChannel cycleCounter;
	DigitalInput stretcherStart;
	DigitalInput stretcherEnd;
	DigitalInput releaserLock;
	double stretchCycles, strechDistance;

	public Shooter()
	{
	stretcher = RobotMap.shooterStretcher; // controls the speed of the streaching motor
	releaser= RobotMap.shooterReleaser; // controls the speed of the realesing motor
	cycleCounter = RobotMap.shooterCycleCounter; // optic sensor for counting the cycles of the streaching motor
	stretcherStart = RobotMap.shooterStretcherStart; // digital sensor for when the rubber band is at the start
	stretcherEnd = RobotMap.shooterStretcherEnd; // digital sensor for when the rubber band is at the end
	releaserLock = RobotMap.shooterReleaserLock; // digital sensor for when the hook of the rubber band is locked
	}


	/**-----------------------------------
	 *
	 * @param speed
	 */
	public void stretch(double speed)
	{
		stretcher.set(speed);
	}

	/**------------------------------------
	 *
	 */
	public void release()
	{
		releaser.set(1);
	}

	/**------------------------------------
	 *
	 * @return
	 */
	public boolean getStartMicro()
	{
		return stretcherStart.get();
	}

	/**------------------------------------
	 *
	 * @return
	 */
	public boolean getEndMicro()
	{
		return stretcherEnd.get();
	}

	/**------------------------------------
	 *
	 * @return
	 */
	public boolean getLockMicro()
	{
		return releaserLock.get();
	}

	/**------------------------------------
	 *
	 * @return
	 */
	public long getCount()
	{
		return cycleCounter.getAccumulatorCount();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
