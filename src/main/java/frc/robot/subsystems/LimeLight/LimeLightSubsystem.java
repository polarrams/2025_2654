package frc.robot.subsystems.LimeLight;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.LimelightHelpers;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class LimeLightSubsystem extends SubsystemBase {
    public double[] limelight() {
        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight-two");
        NetworkTableEntry tx = table.getEntry("tx");
        NetworkTableEntry ty = table.getEntry("ty");
        NetworkTableEntry ta = table.getEntry("ta");
        NetworkTableEntry tid = table.getEntry("tid");
        
        
        //read values periodically
        double x = tx.getDouble(0.0);
        double y = ty.getDouble(0.0);
        double Area = ta.getDouble(0.0);
        double Tid = tid.getDouble(0.0);
        
        //post to smart dashboard periodically
        SmartDashboard.putNumber("Limelight2X", x);
        SmartDashboard.putNumber("Limelight2Y", y);
        SmartDashboard.putNumber("Limelight2Area", Area);
        SmartDashboard.putNumber("Limelight2Tid", Tid);

        //limelight pipelines
        LimelightHelpers.setPipelineIndex("limelight-one", 0);
        LimelightHelpers.setPipelineIndex("limelight-one", 1);
        LimelightHelpers.setPipelineIndex("limelight-two", 0);
        LimelightHelpers.setPipelineIndex("limelight-two", 1);
        
        double[] ans = new double[4];
        ans[0] = x;
        ans[1] = y;
        ans[2] = Area;
        ans[3] = Tid;
        return ans;
        }
}
