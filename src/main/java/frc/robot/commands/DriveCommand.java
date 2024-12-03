
package frc.robot.commands;

import frc.robot.subsystems.Drivesubsystem;
import edu.wpi.first.wpilibj2.command.Command;


public class DriveCommand extends Command{
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivesubsystem drivesubsystem;
  private final double leftspeed;
  private final double rightspeed;

 public DriveCommand (Drivesubsystem subsystem, double leftspeed, double rightspeed){
  this.drivesubsystem = subsystem;
  this.leftspeed = leftspeed;
  this.rightspeed = rightspeed;
  addRequirements(subsystem);
 }

  
  @Override
  public void initialize() {}

 
  @Override
  public void execute() {
    drivesubsystem.drive(leftspeed, rightspeed);
  }

 
  @Override
  public void end(boolean interrupted) {
    drivesubsystem.drive(0, 0);
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}
