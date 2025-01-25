package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.revrobotics.RelativeEncoder;


public class ParkSub extends SubsystemBase {
    private SparkMax FLD = new SparkMax(3,MotorType.kBrushless);
    private SparkMax FLR = new SparkMax(4,MotorType.kBrushless);
    private SparkMax FRD = new SparkMax(2,MotorType.kBrushless);
    private SparkMax FRR = new SparkMax(1,MotorType.kBrushless);
    private SparkMax BLD = new SparkMax(8,MotorType.kBrushless);
    private SparkMax BLR = new SparkMax(7,MotorType.kBrushless);
    private SparkMax BRD = new SparkMax(6,MotorType.kBrushless);
    private SparkMax BRR = new SparkMax(5,MotorType.kBrushless);
    private RelativeEncoder m_FLR = FLR.getEncoder();
    private RelativeEncoder m_FRR = FRR.getEncoder();
    private RelativeEncoder m_BLR = BLR.getEncoder();
    private RelativeEncoder m_BRR = BRR.getEncoder();

    public void Dpark(double Dspeed){
        FLD.set(0);
        FRD.set(0);
        BLD.set(0);
        BRD.set(0);
    }

    public void Rpark(double Rspeed, double WPOS){
        FLR.set(0.5);
        FRR.set(0.5);
        BLR.set(0.5);
        BRR.set(0.5);
       double FLR = FLR();
       double FRR = -FRR();
       double BLR = -BLR();
       double BRR = BRR();
       
    }

    public double FLR() {
        SmartDashboard.putNumber("FLR Degrees", m_FLR.getPosition());
        return  m_FLR.getPosition();
        
      
    }
    public double FRR() {
        SmartDashboard.putNumber("FRR Degrees", m_FRR.getPosition());
        return  m_FRR.getPosition();
      
    }
    public double BLR() {
        SmartDashboard.putNumber("BLR Degrees", m_BLR.getPosition());
        return  m_BLR.getPosition();
      
    }
    public double BRR() {
        SmartDashboard.putNumber("BRR Degrees", m_BRR.getPosition());
        return  m_BRR.getPosition();
      
    }
    
}
