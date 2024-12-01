// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.VictorSPX; 
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.hal.EncoderJNI;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class Drivesubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
     private final VictorSPX leftboss = new VictorSPX(1);
     private final VictorSPX rightboss = new VictorSPX(2);
     private final TalonSRX leftslave = new TalonSRX(3);
     private final TalonSRX rightslave = new TalonSRX(4);
     private final Encoder leftEncoder = new Encoder (0, 1);
     private final Encoder rightEncoder = new Encoder (1, 0);

    public double getEnconderMeters() {
        return leftEncoder.get() + -rightEncoder.get();
      }
      

    public Drivesubsystem () {
      leftboss.setInverted (true);
      rightboss.setInverted (true);
      leftslave.follow(leftboss);
      rightslave.follow(rightboss);

      leftEncoder.setReverseDirection(false);
      rightEncoder.setReverseDirection(true);
    }

    public void drive (double leftspeed, double rightspeed) {
      leftboss.set (ControlMode.PercentOutput, leftspeed);
      rightboss.set (ControlMode.PercentOutput,-rightspeed);

    }
    }
     

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
