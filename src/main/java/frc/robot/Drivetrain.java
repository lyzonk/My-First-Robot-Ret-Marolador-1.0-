package frc.robot;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain extends RobotContainer{
    public VictorSPX leftboss = new VictorSPX(1);
    public VictorSPX rightboss = new VictorSPX(2);
    public TalonSRX leftslave = new TalonSRX(3);
    public TalonSRX rightslave = new TalonSRX(4);
    public DifferentialDrive Drive = new DifferentialDrive 

private Drivetrain () {
Sendable Drive;
SendableRegistry.addChild(Drive, leftboss);
SendableRegistry.addChild(Drive, rightboss);

    }



