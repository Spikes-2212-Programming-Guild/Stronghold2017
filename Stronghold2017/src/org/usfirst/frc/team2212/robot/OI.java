package org.usfirst.frc.team2212.robot;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;
import com.spikes2212.genericsubsystems.drivetrains.commands.DriveArcade;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
	private Joystick j = new Joystick(0);

	private Button shoot = new JoystickButton(j, 2);
	private Button pick = new JoystickButton(j, 3);
	private Button foldUp = new JoystickButton(j, 8);
	private Button foldDown = new JoystickButton(j, 9);
	private Button drive = new JoystickButton(j, 1);

	public OI() {
		shoot.whileHeld(new MoveLimitedSubsystem(Robot.shooter, 0.8));
		pick.whileHeld(new MoveLimitedSubsystem(Robot.picker, ConstantHandler.addConstantDouble("picker speed", 0.4)));
		foldUp.whileHeld(new MoveLimitedSubsystem(Robot.folder, ConstantHandler.addConstantDouble("Folder up", 0.3)));
		foldDown.whileHeld(new MoveLimitedSubsystem(Robot.folder, ConstantHandler.addConstantDouble("Folder down", -0.3)));
		drive.whenPressed(new DriveArcade(Robot.drivetrain, () -> -j.getY(), j::getX));
	}

}
