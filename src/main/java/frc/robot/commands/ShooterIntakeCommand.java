package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterIntakeSubsystem;

public class ShooterIntakeCommand extends Command{
    private final ShooterIntakeSubsystem m_ShooterIntakeSubsystem;
    private double m_speed1 = 0;
    public ShooterIntakeCommand(
        ShooterIntakeSubsystem c_ShooterIntakeSubsystem,
        double c_speed1
        )
    {
        this.m_ShooterIntakeSubsystem = c_ShooterIntakeSubsystem;
        this.m_speed1 = c_speed1;
        addRequirements(m_ShooterIntakeSubsystem);
    }
    
  
    @Override
    public void execute() {
        m_ShooterIntakeSubsystem.run(m_speed1);
        
    }
}
