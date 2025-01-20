package frc.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.RelativeEncoder;

public class ElevatorSubsystem extends SubsystemBase{
    private SparkMax motor1 = new SparkMax(19,MotorType.kBrushless);
    
    private RelativeEncoder c_up = motor1.getEncoder();
    
public void run(double speed){
motor1.set(speed);

}
public void setzero() { 
        
        c_up.setPosition(0);
    }
    public void getPos() {
      SmartDashboard.putNumber("Hook1 Degrees", c_up.getPosition());

      
    
}
public void run1(double speed) {
    motor1.set(speed);
}

}

