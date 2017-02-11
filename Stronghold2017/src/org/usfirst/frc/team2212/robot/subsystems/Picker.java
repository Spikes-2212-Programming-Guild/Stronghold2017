package org.usfirst.frc.team2212.robot.subsystems;

import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

public class Picker extends LimitedSubsystem {
	private SpeedController speedController;

	public Picker(SpeedController speedController) {
		this.speedController = speedController;
	}

	@Override
	public boolean isMin() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMax() {
		// TODO Auto-generated method stub
		return false;
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
