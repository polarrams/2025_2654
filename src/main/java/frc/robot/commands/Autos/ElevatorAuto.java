package frc.robot.commands.Autos;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator.ElevatorArmSubsystem;
import frc.robot.subsystems.Elevator.ElevatorSubsystem;

public class ElevatorAuto extends Command{
    private final ElevatorSubsystem m_ElevatorSubsystem;
    private final double pos;
    private final double posA;
    private final double speedA;
    private final double speed;
    private final boolean reset = false;
    private final DoubleSupplier m_PositionSupplier;
    private final ElevatorArmSubsystem m_ElevatorArmSubsystem;
    private String color;
    
        //declare variables in this. format and through subsystem here.
    
        public ElevatorAuto(
            ElevatorSubsystem c_Armsub,
            ElevatorArmSubsystem c_ElevatorArmSubsystem,
            DoubleSupplier c_PostionSupplier,
            double pos,
            double speed,
            double posA,
            double speedA,
            String color
    
        )
         {
        
        this.color = color;
        this.m_ElevatorSubsystem = c_Armsub;
        this.m_ElevatorArmSubsystem = c_ElevatorArmSubsystem;
        this.pos = pos;
        this.speed = speed;
        this.m_PositionSupplier = c_PostionSupplier;
        this.posA = posA;
        this.speedA = speedA;
        addRequirements(m_ElevatorSubsystem, m_ElevatorArmSubsystem);
     }


//Elevator movement command.
@Override
    public void execute() {
    
m_ElevatorSubsystem.drive_to_pos(pos, speed, color);
m_ElevatorArmSubsystem.drive_to_pos(posA, speedA);
    }

@Override
    public boolean isFinished() {
        return true;
    }
}   







