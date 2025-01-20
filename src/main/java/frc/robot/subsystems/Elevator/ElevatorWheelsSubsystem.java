package frc.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

public class ElevatorWheelsSubsystem extends SubsystemBase{
    private SparkMax motor1 = new SparkMax(20,MotorType.kBrushless);


public void run(Double speed) {
        motor1.set(speed);
    }
}
