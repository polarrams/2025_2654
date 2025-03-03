package frc.robot.subsystems.Miselaneous;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class InvertedControllerSubsystem extends SubsystemBase {
    public boolean Invertedstate = false;
public void Invertedset(boolean Inverted){Invertedstate = Inverted;
    
}
public boolean getInverted(){return Invertedstate;
}
public double getX(double X){if (Invertedstate == true){return -X;}else{return X;}}
public double getY(double Y){if (Invertedstate == true){return -Y;}else{return Y;}
     }
public double getRightX(double X){if (Invertedstate == true){return -X;}else{return X;}}
    }
