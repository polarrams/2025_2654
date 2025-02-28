package frc.robot.commands.ShooterArm;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator.ElevatorArmSubsystem;
import frc.robot.subsystems.ShooterArm.ShooterSubsystem;

public class Shootersetangle extends Command{
private final ShooterSubsystem m_ShooterSubsystem;
private final double pos;
    private final double posA;
    private final double speedA;
    private final double speed;
    private final boolean reset = false;
    private final DoubleSupplier m_PositionSupplier;
    private String color;
    
        //declare variables in this. format and through subsystem here.
    
        public Shootersetangle(
            ShooterSubsystem c_ShooterSubsystem,
            DoubleSupplier c_PostionSupplier,
            double pos,
            double speed,
            double posA,
            double speedA,
            String color
    
        )
         {
        
        this.color = color;
        this.m_ShooterSubsystem = c_ShooterSubsystem;
        this.pos = pos;
        this.speed = speed;
        this.m_PositionSupplier = c_PostionSupplier;
        this.posA = posA;
        this.speedA = speedA;
        addRequirements(m_ShooterSubsystem);
     }


//Elevator movement command.
@Override
    public void execute() {
    
m_ShooterSubsystem.drive_to_pos(pos, speed, color);
    }




}