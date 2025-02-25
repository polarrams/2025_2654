package frc.robot.commands.ShooterArm;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterArm.ShooterRotation;
public class ShooterRotationBrake extends Command{
    private final ShooterRotation m_ShooterRotation;
    private final double speed;
    private final String armColor;

    public ShooterRotationBrake(
        ShooterRotation c_ShooterRotation,
        double speed,
        String armColor
    ){
        this.armColor = armColor;
        this.speed = speed;
        this.m_ShooterRotation = c_ShooterRotation;
        addRequirements(c_ShooterRotation);
    }
    
    @Override
    public void initialize() {
        m_ShooterRotation.mbrake();
    }
    
}
