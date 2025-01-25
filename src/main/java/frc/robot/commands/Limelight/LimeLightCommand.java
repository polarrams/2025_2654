package frc.robot.commands.Limelight;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.LimeLight.LimeLightSubsystem;

public class LimeLightCommand extends Command{
        private final LimeLightSubsystem m_LimelightSubsystem;
        
    public LimeLightCommand(LimeLightSubsystem c_LimelightSubsystem) {
        this.m_LimelightSubsystem = c_LimelightSubsystem;
        addRequirements(m_LimelightSubsystem);
    }

    @Override
      public void execute() {
        m_LimelightSubsystem.limelight();
    }
}

