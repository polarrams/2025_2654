// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;

import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.SwerveSubsystem;
import swervelib.SwerveInputStream;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
//Subsystems Imported Here
import frc.robot.subsystems.ShooterRotation;
import frc.robot.subsystems.ShooterIntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
//Commands Imported here
import frc.robot.commands.ShooterIntakeCommand;
import frc.robot.commands.ShooterRotationCommand;
import frc.robot.commands.ShooterCommand;

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
   // Replace with CommandPS4Controller or CommandJoystick if needed
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final SwerveSubsystem drivebase = new SwerveSubsystem();
  private final CommandXboxController m_driverController =

  new CommandXboxController(OperatorConstants.kDriverControllerPort);
  private final CommandJoystick c_driverController =
      new CommandJoystick(OperatorConstants.kDriverControllerPort);

  private final ShooterRotation m_ShooterRotation = new ShooterRotation();
  private final ShooterIntakeSubsystem m_ShooterIntakeSubsystem = new ShooterIntakeSubsystem();
  private final ShooterSubsystem m_ShooterSubsystem = new ShooterSubsystem();



  public RobotContainer() {
    configureBindings();
    drivebase.setDefaultCommand(driveFieldOrientedAngularVelocity);
  }



  SwerveInputStream driveAngularVelocity = SwerveInputStream.of(drivebase.getSwerveDrive(),
  ()-> m_driverController.getLeftY() * -1,
  ()-> m_driverController.getLeftX() * -1)
    .withControllerRotationAxis(()-> m_driverController.getRightX() * -1)
    .deadband(OperatorConstants.DEADBAND)
    .scaleTranslation(0.8)
    .allianceRelativeControl(true);



  SwerveInputStream driveDirectAngle = driveAngularVelocity.copy().withControllerHeadingAxis(()-> m_driverController.getRightX() * -1,
  ()-> m_driverController.getRightY() * -1) 
    .headingWhile(true);
  
  Command driveFieldOrientedDirectAngle = drivebase.driveFieldOriented(driveDirectAngle);

  Command driveFieldOrientedAngularVelocity = drivebase.driveFieldOriented(driveAngularVelocity);

  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    new Trigger(m_exampleSubsystem::exampleCondition)    
        .onTrue(new ExampleCommand(m_exampleSubsystem));
    //m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());


    //Button Commands Go Here
    c_driverController.button(1).whileTrue(new ShooterRotationCommand(m_ShooterRotation, .1));
    c_driverController.button(2).whileTrue(new ShooterIntakeCommand(m_ShooterIntakeSubsystem, 0.1));
    c_driverController.button(3).whileTrue(new ShooterIntakeCommand(m_ShooterIntakeSubsystem, -0.1));
    c_driverController.button(4).whileTrue(new ShooterCommand(m_ShooterSubsystem, 0.1));
    c_driverController.button(5).whileTrue(new ShooterCommand(m_ShooterSubsystem, -0.1));

  }

  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
