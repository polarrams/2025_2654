package frc.robot.commands.Elevator;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator.ElevatorArmSubsystem;

public class ElevatorArmCommand2 extends Command{
    private final ElevatorArmSubsystem m_ElevatorArmSubsystem2;
    private final double speed;

    public ElevatorArmCommand2(
    ElevatorArmSubsystem c_ElevatorArmSubsystem2,
    double speed
    ){
        this.speed = speed;
        this.m_ElevatorArmSubsystem2 = c_ElevatorArmSubsystem2;
        addRequirements(m_ElevatorArmSubsystem2);
    }

@Override
public void initialize(){
 
 SmartDashboard.putNumber("Elevator Arm Value",m_ElevatorArmSubsystem2.getPos());
}
@Override
  public void execute() {
    m_ElevatorArmSubsystem2.drive_to_pos(SmartDashboard.getNumber("Elevator Arm Value",-60)*1.4976, speed);
} 
}
