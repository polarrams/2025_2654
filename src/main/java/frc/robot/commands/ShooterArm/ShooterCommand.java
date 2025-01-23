package frc.robot.commands.ShooterArm;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterArm.ShooterSubsystem;

public class ShooterCommand extends Command{
    private final ShooterSubsystem m_ShooterSubsystem;
    private double m_speed1 = 0;
    public ShooterCommand(
        ShooterSubsystem c_ShooterSubsystem,
        double c_speed1
        )
    {
        this.m_ShooterSubsystem = c_ShooterSubsystem;
        this.m_speed1 = c_speed1;
        addRequirements(m_ShooterSubsystem);
    }
   
    private final ShooterSubsystem m_ShooterSubsystem2;
    private double m_speed2 = 0;
    public ShooterCommand2(
        ShooterSubsystem c_ShooterSubsystem2,
        double c_speed1
        )
    {
        this.m_ShooterSubsystem = c_ShooterSubsystem2;
        this.m_speed1 = c_speed1;
        this.m_ShooterSubsystem2 = c_ShooterSubsystem2;
        this.m_speed2 = c_speed2;
        addRequirements(m_ShooterSubsystem);
    }

    @Override
    public void execute() {
        m_ShooterSubsystem.run(m_speed1);
        
    }
}
