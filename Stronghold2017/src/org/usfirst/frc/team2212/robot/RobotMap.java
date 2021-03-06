package org.usfirst.frc.team2212.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public interface USB {
		public static final String FRONT_CAMERA = "cam2";
		public static final String REAR_CAMERA = "cam1";
	}

	public interface CAN {
		public static final int SHOOTER_MOTOR = 1;
	}

	public interface PWM {
		public static final int LEFT_FRONT_MOTOR = 2;
		public static final int LEFT_REAR_MOTOR = 1;
		public static final int RIGHT_FRONT_MOTOR = 8;
		public static final int RIGHT_REAR_MOTOR = 9;
		public static final int TRIZ_MOTOR = 4;
		public static final int FOLDER_MOTOR = 5;
		public static final int PICKER_MOTOR = 3;
	}

	public interface DIO {
		public static final int LEFT_ENCODER_A = 7;
		public static final int LEFT_ENCODER_B = 6;
		public static final int RIGHT_ENCODER_A = 9;
		public static final int RIGHT_ENCODER_B = 8;
		public static final int TRIZ_ENCODER_A = 14;
		public static final int TRIZ_ENCODER_B = 15;
		public static final int FOLDER_ENCODER_A = 17;
		public static final int FOLDER_ENCODER_B = 16;
		public static final int TRIZ_UP = 4;
		public static final int TRIZ_DOWN = 5;
		public static final int TRIZ_UNDER_PORTCULLIS = 11;
		public static final int FOLDER_UP = 1;
		public static final int FOLDER_DOWN = 2;
		public static final int BALL_INSIDE = 0;
	}

	public interface AnalogInput {
	}
}
