package frc.robot.commands.Autos;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator.ElevatorWheelsSubsystem;
public class ElevatorWheelsAuto extends Command{
    private final ElevatorWheelsSubsystem m_ElevatorWheelsSubsystem;
    private double m_speed1 = 0;
    private boolean m_check_value;
    public ElevatorWheelsAuto(
        ElevatorWheelsSubsystem c_ElevatorWheelsSubsystem,
        double c_speed1,
        boolean c_check_value


    )
    {
        this.m_ElevatorWheelsSubsystem = c_ElevatorWheelsSubsystem;
        this.m_speed1 = c_speed1;
        this.m_check_value = c_check_value;
        addRequirements(m_ElevatorWheelsSubsystem);
    }
    // @Override
    // public void initialize() {
    //     m_ElevatorWheelsSubsystem.run(0.0);
    // }
    
    @Override
    public void execute() {
        m_ElevatorWheelsSubsystem.run(m_speed1);
    }

//     @Override
//   public void end(boolean interrupted) {

//   }
  
    @Override
    public boolean isFinished() {
        if (m_check_value == SmartDashboard.getBoolean("dioelevator", m_check_value)){
            return true;
        }
        
        return false;
    }

    
}

