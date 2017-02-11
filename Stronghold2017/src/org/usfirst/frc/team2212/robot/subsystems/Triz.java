package org.usfirst.frc.team2212.robot.subsystems;

import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

public class Triz extends LimitedSubsystem {
	private SpeedController speedController;
	private DigitalInput up, down;

	public Triz(SpeedController speedController, DigitalInput up, DigitalInput down) {
		this.speedController = speedController;
		speedController.setInverted(true);
		this.up = up;
		this.down = down;
	}

	@Override
	public boolean isMin() {
		// TODO Auto-generated method stub
		return !down.get();
	}

	@Override
	public boolean isMax() {
		// TODO Auto-generated method stub
		return !up.get();
	}

	@Override
	public PIDSource getPIDSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void move(double speed) {
		speedController.set(speed);

	}

}
