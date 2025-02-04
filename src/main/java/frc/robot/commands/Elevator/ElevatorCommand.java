package frc.robot.commands.Elevator;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator.ElevatorSubsystem;
import frc.robot.subsystems.ShooterArm.ShooterSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevatorCommand extends Command{
    private final ElevatorSubsystem m_ElevatorSubsystem;
    private double m_speed1 = 0;
    public ElevatorCommand(
        ElevatorSubsystem c_ElevatorSubsystem,
        double c_speed1
        )
    {
        this.m_ElevatorSubsystem = c_ElevatorSubsystem;
        this.m_speed1 = c_speed1;
        addRequirements(m_ElevatorSubsystem);
    }
    
  
   // @Override
   // public void execute() {
   //     m_ElevatorSubsystem.run(m_speed1);
   //     
   // }

    @Override
    public void execute() {
    //m_Elevator.run(m_speed1);
    m_ElevatorSubsystem.getPos();
    double Elevator_pos = SmartDashboard.getNumber("Elevator Degrees",0);
    if (Elevator_pos <=0 && Elevator_pos >= -257){
        m_ElevatorSubsystem.run1(m_speed1);
    }
    else if (Elevator_pos >=0 && Elevator_pos >= -257){
        if (m_speed1 < 0){
        m_ElevatorSubsystem.run1(m_speed1);
        }
        else{m_ElevatorSubsystem.run1(0);
        }
    }
    else if (Elevator_pos <=0 && Elevator_pos <= -257){
        if (m_speed1 > 0){
        m_ElevatorSubsystem.run1(m_speed1);
        }
      else{m_ElevatorSubsystem.run1(0);
        }
    }
    else{m_ElevatorSubsystem.run1(0);}



        
} 
}
