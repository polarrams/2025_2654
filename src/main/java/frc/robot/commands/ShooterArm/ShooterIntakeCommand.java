package frc.robot.commands.ShooterArm;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterArm.ShooterIntakeSubsystem;

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
//When Limit Switch is False, It is activated. When Limit Switch is True, It is deactivated.