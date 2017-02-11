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

	private Button drive = new JoystickButton(j, 1);

	public OI() {
		drive.whenPressed(new DriveArcade(Robot.drivetrain, () -> -j.getY(), j::getX));
	}
	
	public double getX(){return j.getX();}
	public double getY(){return -j.getY();}

}
