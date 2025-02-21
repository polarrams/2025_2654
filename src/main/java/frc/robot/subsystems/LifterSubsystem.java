package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LifterSubsystem extends SubsystemBase{
        private SparkMax motor1 = new SparkMax(22,MotorType.kBrushless);
        private RelativeEncoder c_up = motor1.getEncoder();

    public void run(double speed){
        motor1.set(speed);
    }

    public void setzero() { 
        c_up.setPosition(0);
    }

    public void getPos() {
      SmartDashboard.putNumber("Lifter Degrees", c_up.getPosition());
    }

    public void run1(double speed) {
    motor1.set(speed);
    }
}