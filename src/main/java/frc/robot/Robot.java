/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
  WPI_TalonSRX fr;
  WPI_TalonSRX fl;
  WPI_TalonSRX br;
  WPI_TalonSRX bl;
  
  Joystick driveStick;
  JoystickButton speedLimiter;

  double leftPower = 0;
  double rightPower = 0;
  double speedLimit = 0.5;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    //These are placeholder values
     driveStick = new Joystick(0);
     speedLimiter = new JoystickButton(driveStick, 0);

    //These are placeholder value
    fr = new WPI_TalonSRX(0);
    fl = new WPI_TalonSRX(1);
    br = new WPI_TalonSRX(2);
    bl = new WPI_TalonSRX(3);
    
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    
    //I get that this is bad, I was trying to show stuff to Harry without actually looking into how commands work with the other methods
    if (speedLimiter.get()) {
      speedLimit = 0.5;
    }
    else {
      speedLimit = 1;
    }

    leftPower = driveStick.getY() + driveStick.getX();
    rightPower = driveStick.getY() - driveStick.getX();

    

    fr.set(speedLimit * rightPower);
    br.set(speedLimit * rightPower);
    fl.set(speedLimit * leftPower);
    bl.set(speedLimit * leftPower);

  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
