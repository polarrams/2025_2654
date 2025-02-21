package frc.robot.subsystems.ShooterArm;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class ShooterIntakeSubsystem extends SubsystemBase {
    private SparkMax motor1 = new SparkMax(15,MotorType.kBrushless);
    private SparkMax motor2 = new SparkMax(16,MotorType.kBrushless);
    private DigitalInput DIO = new DigitalInput(0);
    public void run(Double speed) {
       SmartDashboard.getString("ReefColor", "Teal");
        if(DIO.get() || speed < 0) {
            motor1.set(speed);
            motor2.set(-speed);
            
            SmartDashboard.putBoolean("ReefReached", false);
        }
        else {
            motor1.set(0);
            motor2.set(0);
            SmartDashboard.putBoolean("ReefReached", true);
        }
    }
}
