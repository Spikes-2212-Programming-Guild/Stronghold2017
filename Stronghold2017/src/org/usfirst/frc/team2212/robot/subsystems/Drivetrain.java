package org.usfirst.frc.team2212.robot.subsystems;

import com.spikes2212.genericsubsystems.drivetrains.TankDrivetrain;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

public class Drivetrain extends TankDrivetrain {

	private SpeedController left, right;

	public Drivetrain(SpeedController left, SpeedController right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public void setLeft(double speedLeft) {
		left.set(speedLeft);

	}

	@Override
	public void setRight(double speedRight) {
		right.set(-speedRight);

	}

	@Override
	public PIDSource getLeftPIDSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PIDSource getRightPIDSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}
