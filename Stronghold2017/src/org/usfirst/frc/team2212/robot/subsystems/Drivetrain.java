package org.usfirst.frc.team2212.robot.subsystems;

import org.usfirst.frc.team2212.robot.Robot;

import com.spikes2212.genericsubsystems.drivetrains.TankDrivetrain;
import com.spikes2212.genericsubsystems.drivetrains.commands.DriveArcade;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

public class Drivetrain extends TankDrivetrain {

	private SpeedController left, right;
	private Encoder encoder;

	public Drivetrain(SpeedController left, SpeedController right, Encoder encoder) {
		this.left = left;
		this.right = right;
		this.encoder=encoder;
		encoder.setDistancePerPulse( 0.203 * Math.PI /360);
	}

	@Override
	public void setLeft(double speedLeft) {
		left.set(speedLeft);

	}

	@Override
	public void setRight(double speedRight) {
		right.set(-speedRight);

	}
	
	public double getRate() {
		return encoder.getRate();
	}

	@Override
	public PIDSource getLeftPIDSource() {
		// TODO Auto-generated method stub
		return encoder;
	}

	@Override
	public PIDSource getRightPIDSource() {
		// TODO Auto-generated method stub
		return encoder;
	}
	
	public boolean resetEncoder(){
		try{
			encoder.reset();
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public double getDistance() {
		return encoder.getDistance();
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new DriveArcade(this,Robot.oi::getY,Robot.oi::getX));
	}

}
