package frc.robot.commands.Autos;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator.ElevatorWheelsSubsystem;
public class ElevatorWheelsAuto extends Command{
    private final ElevatorWheelsSubsystem m_ElevatorWheelsSubsystem;
    private double m_speed1 = 0;
    public ElevatorWheelsAuto(
        ElevatorWheelsSubsystem c_ElevatorWheelsSubsystem,
        double c_speed1


    )
    {
        this.m_ElevatorWheelsSubsystem = c_ElevatorWheelsSubsystem;
        this.m_speed1 = c_speed1;
        addRequirements(m_ElevatorWheelsSubsystem);
    }

    
    @Override
    public void execute() {
        m_ElevatorWheelsSubsystem.run(m_speed1);
    }
    @Override
    public boolean isFinished() {
        return true;
    }

    
}

