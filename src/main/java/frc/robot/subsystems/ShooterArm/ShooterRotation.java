package frc.robot.subsystems.ShooterArm;


import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.RelativeEncoder;


public class ShooterRotation extends SubsystemBase{
    private SparkMax motor1 = new SparkMax(14,MotorType.kBrushless);
    private SparkMaxConfig config = new SparkMaxConfig();
    private RelativeEncoder m_Rotation = motor1.getEncoder();


public void run(double speed){
    motor1.set(speed);
    
    }


   /*  public void setzero() { 
     m_Rotation.setPosition(0);
    }

    public double getPos() {
      SmartDashboard.putNumber("Shooter Arm Degrees", m_Rotation.getPosition());
      return  m_Rotation.getPosition();
    
    }

    public void mbrake(){
        config.idleMode(IdleMode.kBrake);
       
    }

    public void stop(){
        motor1.set(0);

    }
    public void p2(double n){
        motor1.set(n);

    }
 */
}

