package frc.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

public class ElevatorWheelsSubsystem extends SubsystemBase{
    private SparkMax motor1 = new SparkMax(20,MotorType.kBrushless);
    private DigitalInput DIO = new DigitalInput(1);

    public void run(Double speed) {
        if(DIO.get()|| speed > 0) {
            motor1.set(speed);
        }
        else {
            motor1.set(0);
        }

    }
}
