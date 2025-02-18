package frc.robot.commands.Autos;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterArm.ShooterRotation;

public class AutoShooterArmRotation extends Command {
    private ShooterRotation m_ShooterRotation;
    private double speed;
    private double pos;

    public AutoShooterArmRotation(
            ShooterRotation c_ShooterRotation,
            double speed,
            double pos
          ) {
        this.m_ShooterRotation = c_ShooterRotation;
        this.speed = speed;
        this.pos = pos;
        addRequirements(m_ShooterRotation);
        
    }
    @Override
    public void execute() {
        m_ShooterRotation.drive_to_pos(pos, speed);
    }
    @Override
    public boolean isFinished() {
        m_ShooterRotation.getPos();
        if(m_ShooterRotation.getPos() - pos <= 0.5) {
            return true;
        }
        else {
            return false;
        }
    }
}
