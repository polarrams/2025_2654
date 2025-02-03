// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autos;

import edu.wpi.first.networktables.NetworkTableInstance;
//import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.LimeLight.LimeLight2Subsystem;
import frc.robot.subsystems.LimeLight.LimeLightSubsystem;
import frc.robot.LimelightHelpers;
import frc.robot.commands.Limelight.LimeLightCommand;

public final class Autos {
    public static Command limelighttestAuto(LimeLightSubsystem limelight, LimeLight2Subsystem limelight2) {
        return Commands.sequence(
            new LimeLightCommand(limelight, limelight2)
        );
    }
}
