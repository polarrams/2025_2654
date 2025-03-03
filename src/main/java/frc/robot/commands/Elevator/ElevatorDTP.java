package frc.robot.commands.Elevator;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator.ElevatorSubsystem;
import frc.robot.subsystems.LEDs.LEDSubsystem;
import frc.robot.subsystems.Elevator.ElevatorArmSubsystem;


public class ElevatorDTP extends Command{
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
    
        public ElevatorDTP(
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
}   //End of class ElevatorDTP





