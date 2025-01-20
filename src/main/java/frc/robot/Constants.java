// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.util.Units;

public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final int mDriverControllerPort = 1;
    public static final double DEADBAND = 0.05;
  }
  public static final double maxSpeed = Units.feetToMeters(50);
}
