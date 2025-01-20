package frc.robot.commands.ShooterArm;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterArm.ShooterRotation;

public class ShooterRotationCommand2 extends Command{
    private final ShooterRotation m_ShooterRotationSubsystem2;
    private final double speed;

    public ShooterRotationCommand2(
    ShooterRotation c_ShooterRotation2,
    double speed
    
    ){
        this.speed = speed;
        this.m_ShooterRotationSubsystem2 = c_ShooterRotation2;
        addRequirements(c_ShooterRotation2);
    }

@Override
public void initialize(){
 
 SmartDashboard.putNumber("Shooter Rotation Value",m_ShooterRotationSubsystem2.getPos());
}
@Override
  public void execute() {
    m_ShooterRotationSubsystem2.drive_to_pos(SmartDashboard.getNumber("Shooter Rotation Value",-60)*1.4976, speed);
}
}
