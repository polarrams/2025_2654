package frc.robot.commands.Elevator;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator.ElevatorArmSubsystem;

public class ElevatorArmCommand extends Command{
    private final ElevatorArmSubsystem m_ElevatorArmSubsystem;
    private final double speed;

    public ElevatorArmCommand(
    ElevatorArmSubsystem c_ElevatorArmSubsystem,
    double speed
    
    ){
        this.speed = speed;
        this.m_ElevatorArmSubsystem = c_ElevatorArmSubsystem;
        addRequirements(c_ElevatorArmSubsystem);
    }
    //Stopping Arm Movement when between values below
@Override
  public void execute() {
    double current_pos = m_ElevatorArmSubsystem.getPos();
    if (current_pos < 5 && speed>0){
        m_ElevatorArmSubsystem.p2(speed);
        
    } else if(current_pos > 0 && speed<0){
    m_ElevatorArmSubsystem.p2(speed);
    }
    else{m_ElevatorArmSubsystem.p2(0);}
    }
}
