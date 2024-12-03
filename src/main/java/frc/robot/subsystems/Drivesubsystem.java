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
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.math.controller.PIDController;


public class Drivesubsystem extends SubsystemBase {
 //Declarando motores e encoders
     private final VictorSPX leftboss = new VictorSPX(1);
     private final VictorSPX rightboss = new VictorSPX(2);
     private final TalonSRX leftslave = new TalonSRX(3);
     private final TalonSRX rightslave = new TalonSRX(4);
     private final DifferentialDrive drive = new DifferentialDrive (leftboss, rightboss);

     private final Encoder leftEncoder = new Encoder (0, 1);
     private final Encoder rightEncoder = new Encoder (1, 0);

     // Declaração dos controladores PID 
     private final PIDController leftPIDController = new PIDController(0.1, 0.0, 0.0); 
     private final PIDController rightPIDController = new PIDController(0.1, 0.0, 0.0); 

     // Setpoints iniciais para os controladores PID

      private double leftSetpoint = 0; 
      private double rightSetpoint = 0;

     public double getEncoderMeters() {
      return (leftEncoder.getDistance() + rightEncoder.getDistance()) / 2.0;
    }

    public Drivesubsystem () {
      leftboss.setInverted (true);
      rightboss.setInverted (true);
      leftslave.follow(leftboss);
      rightslave.follow(rightboss);

      leftEncoder.setReverseDirection(false);
      rightEncoder.setReverseDirection(true);

      // Configura os setpoints iniciais dos controladores PID
       leftPIDController.setSetpoint(leftSetpoint); 
       rightPIDController.setSetpoint(rightSetpoint);
    }

    public void drive (double leftspeed, double rightspeed) {
      leftboss.set (ControlMode.PercentOutput, leftspeed);
      rightboss.set (ControlMode.PercentOutput,-rightspeed);

    }
    public void arcadeDrive (double fwd, double rot) {
      drive.arcadeDrive(fwd, rot);
    }

    public void driveWithPID(double leftSetpoint, double rightSetpoint) {
      double leftOutput = leftPIDController.calculate(leftEncoder.getRate(), leftSetpoint);
      double rightOutput = rightPIDController.calculate(rightEncoder.getRate(), rightSetpoint);
  
      leftboss.set(ControlMode.PercentOutput, leftOutput);
      rightboss.set(ControlMode.PercentOutput, rightOutput);
    }

    @Override
    public void periodic() {
       // Atualiza os controladores PID com os setpoints atuais 
    driveWithPID(leftSetpoint, rightSetpoint);
  }
    
    }
  
    

     

 