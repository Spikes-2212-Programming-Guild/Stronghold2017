package utils;

import org.usfirst.frc.team2212.robot.Constants;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class FeedForward {

	private double maxV, maxA, maxD, setpoint;
	/*
	 * the algorithm work by breaking the movement to 3 parts *
	 */
	double dt1, dt2, dt3;
	
	/**
	 * 
	 * @param p
	 *            - kp
	 * @param maxV
	 *            max velocity of subsystem
	 * @param maxA
	 *            max acceleration of subsystem
	 * @param maxD
	 *            max deceleration of subsystem
	 * @param setpoint
	 *            the distance to go
	 */
	public FeedForward(double p, double maxV, double maxA, double maxD, double setpoint) {
		this.maxA = maxA;
		this.maxD = maxD;
		this.maxV = maxV;
		this.setpoint = setpoint;
		dt1 = (maxV / maxA);
		dt2 = (setpoint / maxV - maxV / (2 * maxA) + maxV / (2 * maxD));
		dt3 = -(maxV / maxD);
		if (dt2 < 0) {
			dt2 = 0;
			double v = Math.sqrt((2 * setpoint * maxA * maxD) / (maxD - maxA));
			SmartDashboard.putNumber("v", v);
			dt3 = -v / maxD;
			dt1 = v / maxA;
			this.maxV=v;
		}
		SmartDashboard.putString("times", "" + dt1 + "," + dt2 + "," + dt3);
	}

	/**
	 * 
	 * @param velocity
	 * @param acceleration
	 * @param location
	 * @param expected
	 * @return value for speed controller
	 */
	// TODO: check return type
	public double getVoltage(double velocity, double acceleration, double expected, double location) {
		return (Constants.DRIVETRAIN.VOLTAGE_VELOCITY_PARAMETER * (velocity)
				+ Constants.DRIVETRAIN.VOLTAGE_ACCELERATION_PARAMETER * acceleration);
	}

	public double getTotalTime() {
		return dt1 + dt2 + dt3;
	}

	/**
	 * 
	 * @param t=time[sec]
	 * @return [expectedLoaction, velocity, acceleration]
	 */
	public double[] getExpected(double t) {
		if (t <= dt1) {
			return new double[] { maxA * t * t, maxA * t, maxA };
		} else if (t <= (dt1 + dt2)) {
			return new double[] { maxA * dt1 * dt1 + maxV * (t - dt1), maxV, 0 };
		} else if (t <= getTotalTime()) {
			// ask no questions, you will hear no lies
			return new double[] {
					maxA * dt1 * dt1 + maxV * dt2 + (maxV - dt1 - dt2) + 0.5 * maxD * Math.pow(t - dt1 - dt2, 2),
					maxV + maxD * (t - dt1 - dt2), maxD };
		}
		return new double[] { setpoint, 0, 0 };
	}
}