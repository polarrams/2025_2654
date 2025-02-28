package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class InvertedControllerSubsystem extends SubsystemBase {
    public boolean Invertedstate = false;
public void Invertedset(boolean Inverted){Invertedstate = Inverted;
    
}
public boolean getInverted(){return Invertedstate;
}
}