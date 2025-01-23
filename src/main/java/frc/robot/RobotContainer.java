// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import swervelib.SwerveInputStream;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.OperatorConstants;

//import frc.robot.commands.Autos.Autos;
//Commands imported Here
import frc.robot.commands.ShooterArm.ShooterCommand;
import frc.robot.commands.ShooterArm.ShooterIntakeCommand;
import frc.robot.commands.ShooterArm.ShooterRotationCommand;
import frc.robot.commands.ShooterArm.ShooterRotationCommand2;
import frc.robot.commands.Elevator.ElevatorArmCommand;
import frc.robot.commands.Elevator.ElevatorArmCommand2;
import frc.robot.commands.Elevator.ElevatorCommand;
import frc.robot.commands.Elevator.ElevatorWheelsCommand;
//Subsystems Imported Here
import frc.robot.subsystems.SwerveSubsystem;
import frc.robot.subsystems.Elevator.ElevatorArmSubsystem;
import frc.robot.subsystems.Elevator.ElevatorSubsystem;
import frc.robot.subsystems.Elevator.ElevatorWheelsSubsystem;
import frc.robot.subsystems.ShooterArm.ShooterIntakeSubsystem;
import frc.robot.subsystems.ShooterArm.ShooterRotation;
import frc.robot.subsystems.ShooterArm.ShooterSubsystem;




public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final SwerveSubsystem drivebase = new SwerveSubsystem();
  private final CommandXboxController m_XboxController =
//Drive controller
  new CommandXboxController(OperatorConstants.kDriverControllerPort);
  //Controller 1
  private final CommandJoystick c_driverController =
      new CommandJoystick(OperatorConstants.kDriverControllerPort);

  //Controller 2/Button Box
  private final CommandJoystick m_driverController =
  new CommandJoystick(OperatorConstants.mDriverControllerPort);

//ShooterSubsystems Defined here.
  private final ShooterRotation m_ShooterRotation = new ShooterRotation();
  private final ShooterIntakeSubsystem m_ShooterIntakeSubsystem = new ShooterIntakeSubsystem();
  private final ShooterSubsystem m_ShooterSubsystem = new ShooterSubsystem();
  //private final ShooterRotation m_ShooterRotation2 = new ShooterRotation();
// Elevator Subsystems defined here
  private final ElevatorArmSubsystem m_ElevatorArmSubsystem = new ElevatorArmSubsystem();
  private final ElevatorSubsystem m_ElevatorSubsystem = new ElevatorSubsystem();
  private final ElevatorWheelsSubsystem m_ElevatorWheelsSubsystem = new ElevatorWheelsSubsystem();
  //private final ElevatorArmSubsystem m_ElevatorArmSubsystem2 = new ElevatorArmSubsystem();


//Set Default Commands
  public RobotContainer() {
    configureBindings();
    drivebase.setDefaultCommand(driveFieldOrientedAngularVelocity);
//Shooter Default Commands
    m_ShooterIntakeSubsystem.setDefaultCommand(new ShooterIntakeCommand(m_ShooterIntakeSubsystem,0));
    m_ShooterSubsystem.setDefaultCommand(new ShooterCommand(m_ShooterSubsystem,0));
   // m_ShooterRotation2.setDefaultCommand(new ShooterRotationCommand2(m_ShooterRotation2,0));
//Elevator Default Commands
   // m_ElevatorArmSubsystem2.setDefaultCommand(new ElevatorArmCommand2(m_ElevatorArmSubsystem2,0));
    m_ElevatorSubsystem.setDefaultCommand(new ElevatorCommand(m_ElevatorSubsystem,0));
    m_ElevatorWheelsSubsystem.setDefaultCommand(new ElevatorWheelsCommand(m_ElevatorWheelsSubsystem,0));
  }



  SwerveInputStream driveAngularVelocity = SwerveInputStream.of(drivebase.getSwerveDrive(),
  ()-> m_XboxController.getLeftY() * -1,
  ()-> m_XboxController.getLeftX() * -1)
    .withControllerRotationAxis(()-> m_XboxController.getRightX() * -1)
    .deadband(OperatorConstants.DEADBAND)
    .scaleTranslation(0.8)
    .allianceRelativeControl(true);



  SwerveInputStream driveDirectAngle = driveAngularVelocity.copy().withControllerHeadingAxis(()-> m_XboxController.getRightX() * -1,
  ()-> m_XboxController.getRightY() * -1) 
    .headingWhile(true);
  
  Command driveFieldOrientedDirectAngle = drivebase.driveFieldOriented(driveDirectAngle);

  Command driveFieldOrientedAngularVelocity = drivebase.driveFieldOriented(driveAngularVelocity);

  private void configureBindings() {

    //Button Commands Go Here
    c_driverController.button(1).whileTrue(new ShooterRotationCommand(m_ShooterRotation, 0.1));
    c_driverController.button(2).whileTrue(new ShooterRotationCommand(m_ShooterRotation, -0.1));
  //c_driverController.button(4).whileTrue(new LimeLightAuto(m_LimeLightAuto, -0.1)); 
    m_driverController.button(1).whileTrue(new ShooterIntakeCommand(m_ShooterIntakeSubsystem, 0.6));
    m_driverController.button(2).whileTrue(new ShooterIntakeCommand(m_ShooterIntakeSubsystem, -0.6));
    m_driverController.button(3).whileTrue(new ShooterCommand(m_ShooterSubsystem, 0.6));
    m_driverController.button(4).whileTrue(new ShooterCommand(m_ShooterSubsystem, -0.6));
    m_driverController.button(5).whileTrue(new ElevatorCommand(m_ElevatorSubsystem, 0));
    m_driverController.button(6).whileTrue(new ElevatorArmCommand(m_ElevatorArmSubsystem, 0));
    m_driverController.button(7).whileTrue(new ElevatorWheelsCommand(m_ElevatorWheelsSubsystem, 0));
    m_driverController.button(9).whileTrue(new ShooterCommand(m_ShooterSubsystem, 0));
  // Call Sam to make button for Auto Limelight Targeting. Has to be on Driver Controller
  // Only Shooter up and down, And Limelight auto target to be on the Driver Controller
  }




}
