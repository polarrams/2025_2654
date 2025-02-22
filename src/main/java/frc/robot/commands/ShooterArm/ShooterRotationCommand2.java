package frc.robot.commands.ShooterArm;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterArm.ShooterRotation;
import java.util.function.DoubleSupplier;

public class ShooterRotationCommand2 extends Command {
    private final ShooterRotation m_ShooterRotation;
    private final double pos;
    private final double speed;

    private final String armColor;


    //declare variables in this. format and through subsystem here.

    public ShooterRotationCommand2(
        ShooterRotation c_Armsub,
        double pos,
        double speed,
        String armColor
    )
     {
        this.armColor = armColor;
        this.m_ShooterRotation = c_Armsub;
        this.pos = pos;
        this.speed = speed;

   
        addRequirements(m_ShooterRotation);
     }

//Sets zero when robot starts.

//Arm movement command.
@Override
  public void execute() {
    m_ShooterRotation.drive_to_pos(pos, speed, armColor);
}

}

