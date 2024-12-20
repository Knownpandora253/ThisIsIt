// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package folder;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants;

/** Add your docs here. */
public class Controllerr extends CommandXboxController {
  public static Controllerr pilot = new Controllerr(Constants.controller.PILOT_PORT);
  public static Controllerr copilot = new Controllerr(Constants.controller.COPILOT_PORT);
  public enum Scale {
    LINEAR,
    SQUARED,
    CUBED,
    QUARTIC
  }

  public Controllerr(int port) {
    super(port);
  }

  private double getOutput(double input, Scale scale) {
    if (Math.abs(input) > Constants.controller.DEADBAND) {
      if (scale == Scale.SQUARED) return Math.signum(input) * Math.pow(input, 2);
      else if (scale == Scale.CUBED) return Math.pow(input, 3);
      else if (scale == Scale.QUARTIC) return Math.signum(input) * Math.pow(input, 4);
      else return input;
    } else {
      return 0;
    }
  }

  public Translation2d getCorrectedRight() {
    Translation2d input = new Translation2d(super.getRightY(), super.getRightX());
    if (input.getNorm() < Constants.controller.DEADBAND) {
      return new Translation2d();
    }
    return new Translation2d((input.getNorm() - Constants.controller.DEADBAND) / (1.0 - Constants.controller.DEADBAND), input.getAngle());
  }

  public Translation2d getCorrectedLeft() {
    Translation2d input = new Translation2d(super.getLeftY(), super.getLeftX());
    if (input.getNorm() < Constants.controller.DEADBAND) {
      return new Translation2d();
    }
    return new Translation2d((input.getNorm() - Constants.controller.DEADBAND) / (1.0 - Constants.controller.DEADBAND), input.getAngle()); 
  }
  public double getRightY(Scale scale) {
    return -getOutput(this.getRightY(), scale);
  }
  public double getRightX(Scale scale) {
    return getOutput(this.getRightX(), scale);
  }
  public double getLeftY(Scale scale) {
    return -getOutput(this.getLeftY(), scale);
  }
  public double getLeftX(Scale scale) {
    return -getOutput(this.getLeftX(), scale);
  }
  public Trigger getLeftS() {
    return this.leftStick();
  }
  public Trigger getRightS() {
    return this.rightStick();
  }

}