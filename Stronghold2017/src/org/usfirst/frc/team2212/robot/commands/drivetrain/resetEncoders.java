package org.usfirst.frc.team2212.robot.commands.drivetrain;

import org.usfirst.frc.team2212.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class resetEncoders extends Command{

	@Override
	protected boolean isFinished() {
		return Robot.drivetrain.resetEncoder();
	}

}
