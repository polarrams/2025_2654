// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.DrivetrainSubsystem;

public final class Autos {
  public static Command auto1(DrivetrainSubsystem drive,  BooleanSupplier bSupplier) {
    return Commands.sequence(
      //new RepeatCommand(new AutonomousSwerveDriveCommand(bSupplier, drive, 1, 1, 0, 0.5, 0.1, 0.1, 0.1, spins)),
      //new RepeatCommand(new AutonomousSwerveDriveCommand(bSupplier, drive, -3, 3, 0, 0.5, 0.1, 0.1, 0.1, spins)),
      //new RepeatCommand(new AutonomousSwerveDriveCommand(bSupplier, drive, 4, -4, 0, 0.5, 0.1, 0.1, 0.1, spins)),
      //new RepeatCommand(new AutonomousSwerveDriveCommand(bSupplier, drive, 3, 3, 0, 0.5, 0.1, 0.1, 0.1, spins))
      new AutonomousSwerveDriveCommand(bSupplier, drive, 15, 0, 0, 0.0, 0.05, 0.01, 5, false),
      new AutonomousSwerveDriveCommand(bSupplier, drive, -1, -1, 0, 0.1, 0.1, 0.01, 5, true)
      //new AutonomousSwerveDriveCommand(bSupplier, drive, -.5, 5, 0, 0.5, 0.1, 0.1, 0.1, spins),
      //new AutonomousSwerveDriveCommand(bSupplier, drive, -.5, -.5, 0, 0.5, 0.1, 0.1, 0.1, spins),
      //new AutonomousSwerveDriveCommand(bSupplier, drive, .5, -.5, 0, 0.5, 0.1, 0.1, 0.1, spins)
  /** Example static factory for an autonomous command. */
    );
  }
  public static Command exampleAuto(ExampleSubsystem subsystem) {
    return Commands.sequence(subsystem.exampleMethodCommand(), new ExampleCommand(subsystem));
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
