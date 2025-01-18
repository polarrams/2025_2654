package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase{
    private SparkMax motor1 = new SparkMax(17,MotorType.kBrushless);
private SparkMax motor2 = new SparkMax(18,MotorType.kBrushless);
public void run(Double speed) {
    motor1.set(speed);
    motor2.set(-speed);
}
}
