
package org.usfirst.frc.team2212.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.commands.drivetrain.FeedForwardStraight;
import org.usfirst.frc.team2212.robot.subsystems.Drivetrain;
import org.usfirst.frc.team2212.robot.subsystems.Triz;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.dashboard.DashBoardController;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;
import com.spikes2212.utils.DoubleSpeedcontroller;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static Drivetrain drivetrain;
	public static Triz triz;
	public static Supplier<Double> acc,decc,vel;
	public DashBoardController db;
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		drivetrain = new Drivetrain(
				new DoubleSpeedcontroller(new VictorSP(RobotMap.PWM.LEFT_FRONT_MOTOR),
						new VictorSP(RobotMap.PWM.LEFT_REAR_MOTOR)),
				new DoubleSpeedcontroller(new VictorSP(RobotMap.PWM.RIGHT_FRONT_MOTOR),
						new VictorSP(RobotMap.PWM.RIGHT_REAR_MOTOR)),new Encoder(RobotMap.DIO.ENCODER_A,RobotMap.DIO.ENCODER_B));
		triz = new Triz(new VictorSP(RobotMap.PWM.TRIZ_MOTOR), new DigitalInput(RobotMap.DIO.TRIZ_UP),
				new DigitalInput(RobotMap.DIO.TRIZ_DOWN));
		acc=ConstantHandler.addConstantDouble("MAX_ACCELERATION",0.75);
		decc=ConstantHandler.addConstantDouble("MAX_DECC", -0.75);
		vel=ConstantHandler.addConstantDouble("VELOCITY", 3.5);
		db=new DashBoardController();
		db.addDouble("speed", ()->drivetrain.getRate());
		oi = new OI();
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("triz move", new MoveLimitedSubsystem(triz, ConstantHandler.addConstantDouble("Triz Speed", 0.4)));
		SmartDashboard.putNumber("setpoint", 1);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		SmartDashboard.putData("feedforward",new FeedForwardStraight(drivetrain, SmartDashboard.getNumber("setpoint",0)));
		drivetrain.resetEncoder();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
