package frc.robot.commands.ShooterArm;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterArm.ShooterRotation;

public class Shootersetangle extends Command{
private final ShooterRotation m_ShooterRotation;
private final double pos;
    private final double speed;
    private final boolean reset = false;
    private final DoubleSupplier m_PositionSupplier;
    private String color;
    
        //declare variables in this. format and through subsystem here.
    
        public Shootersetangle(
            ShooterRotation c_ShooterRotation,
            DoubleSupplier c_PostionSupplier,
            double pos,
            double speed,
            String color
    
        )
         {
        
        this.color = color;
        this.m_ShooterRotation = c_ShooterRotation;
        this.pos = pos;
        this.speed = speed;
        this.m_PositionSupplier = c_PostionSupplier;
        addRequirements(m_ShooterRotation);
     }


//Elevator movement command.
@Override
    public void execute() {
    
m_ShooterRotation.drive_to_pos(pos, speed, color);
    }




}