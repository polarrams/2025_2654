package frc.robot.commands.Elevator;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator.ElevatorWheelsSubsystem;



public class ElevatorWheelsCommand extends Command{
    private final ElevatorWheelsSubsystem m_ElevatorWheels;
    private final double speed;

    public ElevatorWheelsCommand(
        ElevatorWheelsSubsystem c_ElevatorWheels,
        double speed
        
        ){
            this.speed = speed;
            this.m_ElevatorWheels = c_ElevatorWheels;
            addRequirements(c_ElevatorWheels);
        }
    

    

@Override
public void execute() {
    m_ElevatorWheels.run(speed);
    }
}

