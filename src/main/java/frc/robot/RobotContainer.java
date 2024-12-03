package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.Drivesubsystem;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.RunCommand;

public class RobotContainer {
    // Instâncias do subsistema e controlador
    private final Drivesubsystem drivesubsystem = new Drivesubsystem();
    private final CommandXboxController driverController = new CommandXboxController(OperatorConstants.kDriverControllerPort);

    public RobotContainer() {
        configureBindings();
    }

    private void configureBindings() {
        // Configura o comando padrão para o Drivesubsystem
        drivesubsystem.setDefaultCommand(
            new RunCommand(
                () -> drivesubsystem.arcadeDrive(driverController.getLeftY(), driverController.getRightX()),
                drivesubsystem
            )
        );

        // Configura o comando de direção (DriveCommand) no botão A
        driverController.a().whileTrue(new DriveCommand(drivesubsystem, 0.5, 0.5)); // Substitua os valores de velocidade conforme necessário
    }
     // Retorna o comando autônomo

    public Command getAutonomousCommand() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getAutonomousCommand'");
    }
        
    }
}

