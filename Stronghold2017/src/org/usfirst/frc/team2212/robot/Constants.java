package org.usfirst.frc.team2212.robot;

import java.util.function.Supplier;

import com.spikes2212.dashboard.ConstantHandler;

public class Constants {
	public interface DRIVETRAIN {

		double VOLTAGE_VELOCITY_PARAMETER = 1/(3.5);
		double VOLTAGE_ACCELERATION_PARAMETER = 1/(0.75*9.81);
	}

	public static final double epsilon = 0.5;
}
