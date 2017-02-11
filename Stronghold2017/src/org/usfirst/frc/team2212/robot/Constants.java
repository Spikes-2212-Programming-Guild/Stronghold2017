package org.usfirst.frc.team2212.robot;

import java.util.function.Supplier;

import com.spikes2212.dashboard.ConstantHandler;

public class Constants {
	public interface DRIVETRAIN {
		public static Supplier<Double> MAX_VELOCITY = ConstantHandler.addConstantDouble("MAX_VELOCITY", 3.5);
		public static double VOLTAGE_VELOCITY_PARAMETER = 1 / (MAX_VELOCITY.get());
		public static Supplier<Double> MAX_ACCELERATION = ConstantHandler.addConstantDouble("MAX_ACCELERATION", 0.75);
		public static double VOLTAGE_ACCELERATION_PARAMETER = 1/(MAX_ACCELERATION.get()*9.81);
		public static Supplier<Double> MAX_DECCELERATION = ConstantHandler.addConstantDouble("MAX_DECCELERATION", 0.75);
	}
}
