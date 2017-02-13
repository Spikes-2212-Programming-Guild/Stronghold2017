package org.usfirst.frc.team2212.robot.commands.drivetrain;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import utils.FeedForward;

public class FeedForwardStraight extends Command {
	FeedForward feedforward;
	public double setpoint;
	Drivetrain drivetrain;
	public double startTime;

	public FeedForwardStraight(Drivetrain drivetrain, double setpoint) {
		requires(drivetrain);
		feedforward = new FeedForward(1, Robot.vel.get(), Robot.acc.get(), Robot.decc.get(), setpoint);
		SmartDashboard.putNumber("vel", Robot.vel.get());
		this.setpoint = setpoint;
		this.drivetrain = drivetrain;
		setTimeout(feedforward.getTotalTime() + 1.5);
	}

	@Override
	protected void initialize() {
		startTime = (double) System.currentTimeMillis() / 1000.0;
	}

	@Override
	protected void execute() {
		double[] expected = feedforward.getExpected(((double) System.currentTimeMillis() / 1000.0) - startTime);
		double value = feedforward.getVoltage(expected[1], expected[2], expected[0], drivetrain.getDistance());
		SmartDashboard.putNumber("time", ((double) System.currentTimeMillis() / 1000.0) - startTime);
		SmartDashboard.putNumber("Value", value);
		drivetrain.tankDrive(value, value);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut() /*
							 * || Math.abs(setpoint-drivetrain.getDistance())<
							 * Constants.epsilon
							 */;
	}

}
