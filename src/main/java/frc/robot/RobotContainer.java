// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import swervelib.SwerveInputStream;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.OperatorConstants;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

//import frc.robot.commands.Autos.Autos;
//Commands imported Here
import frc.robot.commands.ShooterArm.ShooterCommand;
import frc.robot.commands.ShooterArm.ShooterIntakeCommand;
import frc.robot.commands.ShooterArm.ShooterRotationCommand;
import frc.robot.commands.ShooterArm.ShooterRotationCommand2;
import frc.robot.commands.ShooterArm.Shootersetangle;
import frc.robot.commands.Autos.ElevatorAuto;
import frc.robot.commands.Autos.ElevatorWheelsAuto;
import frc.robot.commands.Elevator.ElevatorArmCommand;
import frc.robot.commands.Elevator.ElevatorArmCommand2;
import frc.robot.commands.Autos.ElevatorArmAuto;
import frc.robot.commands.Elevator.ElevatorCommand;
import frc.robot.commands.Elevator.ElevatorWheelsCommand;
import frc.robot.commands.Limelight.AprilTagCmd;
import frc.robot.subsystems.LimeLight.LimeLightSubsystem;
import frc.robot.subsystems.Miselaneous.InvertedControllerSubsystem;
import frc.robot.subsystems.Miselaneous.LifterSubsystem;
import frc.robot.commands.Elevator.ElevatorDTP;
import frc.robot.commands.LEDs.LEDCommand;
import frc.robot.commands.LEDs.ReefLEDCommand;
//Subsystems Imported Here
import frc.robot.subsystems.SwerveSubsystem;
import frc.robot.subsystems.Elevator.ElevatorArmSubsystem;
import frc.robot.subsystems.Elevator.ElevatorSubsystem;
import frc.robot.subsystems.Elevator.ElevatorWheelsSubsystem;
import frc.robot.subsystems.ShooterArm.ShooterIntakeSubsystem;
import frc.robot.subsystems.ShooterArm.ShooterRotation;
import frc.robot.subsystems.ShooterArm.ShooterSubsystem;
import frc.robot.commands.Limelight.LimeLightCommand;
import frc.robot.commands.Miselaneous.InvertedControllerCommand;
import frc.robot.commands.Miselaneous.LifterCommand;
import frc.robot.commands.Miselaneous.LockPoseCommand;
import frc.robot.subsystems.LEDs.LEDSubsystem;

import com.pathplanner.lib.commands.PathPlannerAuto;
import com.pathplanner.lib.events.EventTrigger;
import com.pathplanner.lib.auto.NamedCommands;

import java.util.concurrent.locks.Lock;

import com.ctre.phoenix6.signals.Led1OffColorValue;
import com.pathplanner.lib.auto.AutoBuilder;


//Camera Imports
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;




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
  private final LimeLightSubsystem m_LimeLight = new LimeLightSubsystem();

// Elevator Subsystems defined here
  private final ElevatorArmSubsystem m_ElevatorArmSubsystem = new ElevatorArmSubsystem();
  private final ElevatorSubsystem m_ElevatorSubsystem = new ElevatorSubsystem();
  private final ElevatorWheelsSubsystem m_ElevatorWheelsSubsystem = new ElevatorWheelsSubsystem();
//Lifter
  private final LifterSubsystem m_LifterSubsystem = new LifterSubsystem();
//Autos defined here

private final LEDSubsystem m_leds = new LEDSubsystem();

//Shooter defined here
private final InvertedControllerSubsystem m_InvertedControllerSubsystem = new InvertedControllerSubsystem();
// Autonomous chooser
private final SendableChooser<Command> autoChooser;
  
  
// Register commands in the constructor


//Set Default Commands
  public RobotContainer() {
    NamedCommands.registerCommand("Elevator Wheels Out", new ElevatorWheelsAuto(m_ElevatorWheelsSubsystem, .65,true));
    NamedCommands.registerCommand("Elevator Wheels In", new ElevatorWheelsAuto(m_ElevatorWheelsSubsystem, -0.75, false));
    NamedCommands.registerCommand("Elevator Trough", new ElevatorAuto(m_ElevatorSubsystem, m_ElevatorArmSubsystem, null, -15, 1, 14, 0.3, "Yellow"));
    NamedCommands.registerCommand("Elevator Coral Station", new ElevatorAuto(m_ElevatorSubsystem, m_ElevatorArmSubsystem, null, -77, 1, 7, 0.3, "Purple"));
    NamedCommands.registerCommand("Elevator First Pipe", new ElevatorAuto(m_ElevatorSubsystem, m_ElevatorArmSubsystem, null, -105, 1, 29, 0.3, "Teal"));
    NamedCommands.registerCommand("Elevator 2nd Pipe", new ElevatorAuto(m_ElevatorSubsystem, m_ElevatorArmSubsystem, null, -170, 1, 27, 0.3, "Pink"));
    NamedCommands.registerCommand("Elevator Top Pipe", new ElevatorAuto(m_ElevatorSubsystem, m_ElevatorArmSubsystem, null, -255, 1, 22, 0.3, "White"));
    NamedCommands.registerCommand("Shooter Inner Intake", new ShooterIntakeCommand(m_ShooterIntakeSubsystem, 0.4).withTimeout(0.5));
    NamedCommands.registerCommand("Shooter Outer Intake", new ShooterCommand(m_ShooterSubsystem, -0.7));
    NamedCommands.registerCommand("Shooter GiverBud", new ShooterIntakeCommand(m_ShooterIntakeSubsystem, 0.9).withTimeout(0.5));
    NamedCommands.registerCommand("Auto Target Barge", new AprilTagCmd(m_ShooterSubsystem, m_ShooterRotation, 0, 0.6, false, m_LimeLight, "Lime"));
    NamedCommands.registerCommand("Shooter Arm Pickup Point", new ShooterRotationCommand2(m_ShooterRotation, 30, 0.5, "White"));
    NamedCommands.registerCommand("Elevator Arm Up", new ElevatorArmAuto(m_ElevatorArmSubsystem, 0.5, 0));


    configureBindings();
    DriverStation.silenceJoystickConnectionWarning(true);

    drivebase.setDefaultCommand(driveFieldOrientedAngularVelocity);
    // drivebase.setDefaultCommand(drivebase.lock());
//Shooter Default Commands
    m_ShooterIntakeSubsystem.setDefaultCommand(new ShooterIntakeCommand(m_ShooterIntakeSubsystem,0));
    m_ShooterSubsystem.setDefaultCommand(new ShooterCommand(m_ShooterSubsystem,0));
    m_ShooterRotation.setDefaultCommand(new ShooterRotationCommand(m_ShooterRotation,0, "White",true));
    m_LimeLight.setDefaultCommand(new LimeLightCommand(m_LimeLight));
//Elevator Default Commands
    m_ElevatorSubsystem.setDefaultCommand(new ElevatorCommand(m_ElevatorSubsystem,0,0));
    m_ElevatorWheelsSubsystem.setDefaultCommand(new ElevatorWheelsCommand(m_ElevatorWheelsSubsystem,0));
    m_ElevatorArmSubsystem.setDefaultCommand(new ElevatorArmCommand(m_ElevatorArmSubsystem,0
    ));

//Lifter Defaults
    m_LifterSubsystem.setDefaultCommand(new LifterCommand(m_LifterSubsystem, 0));
    m_leds.setDefaultCommand(new LEDCommand(m_leds));
    CameraServer.startAutomaticCapture(0);
    CameraServer.startAutomaticCapture(1);
  
  // Build an auto chooser. This will use Commands.none() as the default option.
  boolean isCompetition = true;

  autoChooser = AutoBuilder.buildAutoChooserWithOptionsModifier(
    (stream) -> isCompetition
      ? stream.filter(auto -> auto.getName().startsWith("Polar"))
      : stream);
  SmartDashboard.putData("Auto Chooser", autoChooser);
  }



  
  SwerveInputStream driveAngularVelocity = SwerveInputStream.of(drivebase.getSwerveDrive(),
  ()-> m_InvertedControllerSubsystem.getY(m_XboxController.getLeftY()) * -1,
  ()-> m_InvertedControllerSubsystem.getX(m_XboxController.getLeftX()) * -1)
    .withControllerRotationAxis(()-> m_InvertedControllerSubsystem.getRightX(m_XboxController.getRightX()) * -1)
    .deadband(OperatorConstants.DEADBAND)
    .scaleTranslation(0.8)
    .allianceRelativeControl(true);



  SwerveInputStream driveDirectAngle = driveAngularVelocity.copy().withControllerHeadingAxis(()-> m_XboxController.getRightX() * -1,
  ()-> m_XboxController.getRightY() * -1) 
    .headingWhile(true);
  
  Command driveFieldOrientedDirectAngle = drivebase.driveFieldOriented(driveDirectAngle);

  Command driveFieldOrientedAngularVelocity = drivebase.driveFieldOriented(driveAngularVelocity);
  
  private void configureBindings() {

    //Driver Button Commands Go Here
    c_driverController.button(1).whileTrue(new ShooterRotationCommand(m_ShooterRotation, 0.3, "white",true));
    c_driverController.button(2).whileTrue(new ShooterRotationCommand(m_ShooterRotation, -0.3, "Lime",true));
    //c_driverController.button(5).whileTrue(new AprilTagCmd(m_ShooterSubsystem, m_ShooterRotation, 0, 0.3, false, m_LimeLight,  "Lime"));
    c_driverController.button(5).whileTrue(new Shootersetangle(m_ShooterRotation,null, -39,0.3,"white"));
    c_driverController.button(9).whileTrue(new LockPoseCommand(drivebase));
    c_driverController.button(4).whileTrue(new ElevatorArmCommand(m_ElevatorArmSubsystem, -0.10));//Elevator Arm Up
    c_driverController.button(3).whileTrue(new ElevatorArmCommand(m_ElevatorArmSubsystem, 0.10));//Elevator Arm Down
    c_driverController.povDown().whileTrue(new ShooterCommand(m_ShooterSubsystem, 0.2)); // Processor shoot
    c_driverController.button(6).whileTrue(new ShooterCommand(m_ShooterSubsystem, 0.81)); // Processor intake
    c_driverController.povRight().whileTrue(new InvertedControllerCommand(m_InvertedControllerSubsystem));
    //Button Box buttons go here
    m_driverController.button(1).whileTrue(new ShooterIntakeCommand(m_ShooterIntakeSubsystem, -0.4));//Shooter Intake
    m_driverController.button(2).whileTrue(new ShooterCommand(m_ShooterSubsystem, -.65));//Intake in
    m_driverController.button(3).whileTrue(new ShooterIntakeCommand(m_ShooterIntakeSubsystem, 0.9));//Intake Shoot
    m_driverController.button(6).whileTrue(new ElevatorDTP(m_ElevatorSubsystem, m_ElevatorArmSubsystem, null, -81.5, 1,8.5,0.3, "Purple"));//Coral Station setpoint
    m_driverController.button(9).whileTrue(new ElevatorDTP(m_ElevatorSubsystem, m_ElevatorArmSubsystem, null, -15, 1,14,0.3, "Yellow"));//Bottom Trough Coral
    m_driverController.button(10).whileTrue(new ElevatorDTP(m_ElevatorSubsystem, m_ElevatorArmSubsystem, null, -105, 1,27,0.3, "Orange"));//First Pipe Coral
    m_driverController.povRight().whileTrue(new ElevatorDTP(m_ElevatorSubsystem, m_ElevatorArmSubsystem, null,-170,1, 27, 0.3, "Pink"));//Second Pipe Coral
    m_driverController.povDown().whileTrue(new ElevatorDTP(m_ElevatorSubsystem, m_ElevatorArmSubsystem, null, -269,1, 25, 0.3, "White"));//Top Pipe COral
    m_driverController.button(4).whileTrue(new ReefLEDCommand(m_leds));
    m_driverController.button(5).whileTrue(new ReefLEDCommand(m_leds));
    m_driverController.button(6).whileTrue(new ReefLEDCommand(m_leds));
    m_driverController.button(9).whileTrue(new ReefLEDCommand(m_leds));
    m_driverController.button(10).whileTrue(new ReefLEDCommand(m_leds));
    c_driverController.button(6).whileTrue(new ReefLEDCommand(m_leds));
    c_driverController.button(5).whileTrue(new ReefLEDCommand(m_leds));
    m_driverController.button(1).whileTrue(new ReefLEDCommand(m_leds));
    m_driverController.button(2).whileTrue(new ReefLEDCommand(m_leds));
    m_driverController.povUp().whileTrue(new ElevatorWheelsCommand(m_ElevatorWheelsSubsystem,1));//Wheels out 
    m_driverController.povLeft().whileTrue(new ElevatorWheelsCommand(m_ElevatorWheelsSubsystem,-0.75));//wheels in
    m_driverController.button(4).whileTrue(new LifterCommand(m_LifterSubsystem, 0.8));//Lifter down
    m_driverController.button(5).whileTrue(new LifterCommand(m_LifterSubsystem, -0.8));//Lifter up
  }
  
    public Command getAutonomousCommand() {
    return autoChooser.getSelected();
  }

}


