// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.math.controller.SimpleMotorFeedforward;

import edu.wpi.first.math.geometry.Translation2d;

import edu.wpi.first.math.util.Units;

import edu.wpi.first.math.controller.PIDController;


/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static class controller {
    public static final int PILOT_PORT = 0;
    public static final int COPILOT_PORT = 1;
    public static final double DEADBAND = 0.1;
    public static final double TRIGGER_THRESHOLD = 0.6;
  }

    public static final int kDriverControllerPort = 0;

  

  
    public static final double A_LENGTH = Units.inchesToMeters(24.0); // Axel length (Meters).
    public static final double A_WIDTH = Units.inchesToMeters(24.0); // Axel width (Meters).
    public static final double A_CROSSLENGTH = Math.hypot(A_LENGTH, A_WIDTH);

    public static final double FALCON_ENCODER_TICKS =
        2048.0; // Counts per revolution of the Falcon 500 motor.
    public static final double FALCON_MAX_VEL = 6380.0;

    public static final double MAX_TEMP = 50.0;

   
  

  
    
    public static final int FR_SPEED = 1;//front right
    public static final int FR_ANGLE = 2;
    public static final int FR_ENCODER = 11;

    public static final int FL_SPEED = 3;//front left
    public static final int FL_ANGLE = 4;
    public static final int FL_ENCODER = 12;

    public static final int BL_SPEED = 5;//back left
    public static final int BL_ANGLE = 6;
    public static final int BL_ENCODER = 13;

    public static final int BR_SPEED = 7;//back right
    public static final int BR_ANGLE = 8;
    public static final int BR_ENCODER = 14;

    public static final int PIGEON = 15;//pigeon

    public static final int INTAKE = 16;

    
  

  
    public static final double DRIVE_GEARING = 4.75; 
    public static final double WHEEL_DIAMETER = Units.inchesToMeters(4);
    public static final double DRIVE_TICKS_PER_ROTATION = FALCON_ENCODER_TICKS * DRIVE_GEARING;
    public static final double WHEEL_CIRCUMFRENCE = Math.PI * WHEEL_DIAMETER;
    public static final double DRIVE_TICKS_PER_METER = DRIVE_GEARING / WHEEL_CIRCUMFRENCE;
    

    public static final double ANGLE_GEARING = 11.3142;
    public static final double ANGLE_TICKS_PER_ROTATION = FALCON_ENCODER_TICKS * ANGLE_GEARING;
    public static final double ANGLE_TICKS_PER_DEGREE = ANGLE_TICKS_PER_ROTATION / 360.0;
    public static final double ANGLE_DEGREES_PER_TICK = 1.0 / ANGLE_TICKS_PER_DEGREE;

    public static final double MAX_VOLTS = 12.0;
    public static final double MAX_VELOCITY = 5.0;
    public static final double MAX_ACCEL = 12.6;
    public static final double MAX_CACCEL = 8.0;
    public static final double MAX_RADIANS = 5 * Math.PI;
    public static final double RAMP_RATE = 0.5;



    public static final Translation2d FL_LOCATION = new Translation2d((Constants.A_LENGTH / 2), (Constants.A_WIDTH / 2));//math for front left location
    public static final Translation2d FR_LOCATION = new Translation2d((Constants.A_LENGTH / 2), -(Constants.A_WIDTH / 2));//math for front right location
    public static final Translation2d BL_LOCATION = new Translation2d(-(Constants.A_LENGTH / 2), (Constants.A_WIDTH / 2));//math for back left location
    public static final Translation2d BR_LOCATION = new Translation2d(-(Constants.A_LENGTH / 2), -(Constants.A_WIDTH / 2));//math for back right location

    public static final double FL_ZERO = 148.623046875;
    public static final double BL_ZERO = 115.751953125;
    public static final double BR_ZERO = -155.21484375;
    public static final double FR_ZERO = 85.95703125;

    public static final PIDController ANGLE_PID = new PIDController(0.008 * 12.0, 0.0, 0.0);
    public static final SimpleMotorFeedforward ANGLE_FF = new SimpleMotorFeedforward(0.0, 1);

    public static final PIDController SPEED_PID = new PIDController(0.1, 0.0, 0.0);
    public static final SimpleMotorFeedforward SPEED_FF = new SimpleMotorFeedforward(0, 0);

    // public static final PIDConstants XY_PID = new PIDConstants(3.0, 0.0, 0.0);

    public static final PIDController ROT_PID = new PIDController(0.15, 0.0, 0.006);

    // public static final PIDConstants CORRECTION_PID = new PIDConstants(-0.1, 0.0, -0.006);

    public static final PIDController CORRECTION_PID = new PIDController(0.1, 0.0, 0.006);
  

}
