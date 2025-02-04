package frc.robot.commands.ShooterArm;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterArm.ShooterRotation;


public class ShooterRotationCommand extends Command{
    private final ShooterRotation m_ArmSubsystem;
    private final double speed;

    public ShooterRotationCommand(
    ShooterRotation c_ArmSubsystem,
    double speed
    
    ){
        this.speed = speed;
        this.m_ArmSubsystem = c_ArmSubsystem;
        addRequirements(c_ArmSubsystem);
    }
@Override
  public void execute() {
    double current_pos = m_ArmSubsystem.getPos();
    if (current_pos > 0 && speed < 0){
        m_ArmSubsystem.p2(speed);
        
    } else if(current_pos < 150 && speed > 0){
        m_ArmSubsystem.p2(speed);
    }
    else{m_ArmSubsystem.p2(0);}
}
}