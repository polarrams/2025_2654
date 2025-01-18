package frc.robot.subsystems.ShooterArm;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class ShooterIntakeSubsystem extends SubsystemBase {
    private SparkMax motor1 = new SparkMax(15,MotorType.kBrushless);
    private SparkMax motor2 = new SparkMax(16,MotorType.kBrushless);

public void run(Double speed) {
    motor1.set(speed);
    motor2.set(-speed);
    }
}
