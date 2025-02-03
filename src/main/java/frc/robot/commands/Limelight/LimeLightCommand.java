package frc.robot.commands.Limelight;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.LimeLight.LimeLight2Subsystem;
import frc.robot.subsystems.LimeLight.LimeLightSubsystem;
import frc.robot.LimelightHelpers;

public class LimeLightCommand extends Command{
    private final LimeLightSubsystem m_LimeLightSubsystem;
    private final LimeLight2Subsystem m_LimeLight2Subsystem;
    public LimeLightCommand(LimeLightSubsystem c_LimeLightSubsystem, LimeLight2Subsystem c_LimeLight2Subsystem) {
        this.m_LimeLightSubsystem = c_LimeLightSubsystem;
        this.m_LimeLight2Subsystem = c_LimeLight2Subsystem;
    addRequirements(m_LimeLightSubsystem, m_LimeLight2Subsystem);
}
@Override
  public void execute() {
    m_LimeLightSubsystem.limelight();
    m_LimeLight2Subsystem.limelight();
}
}