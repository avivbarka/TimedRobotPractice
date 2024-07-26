// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.beans.beancontext.BeanContextMembershipEvent;
import edu.wpi.first.math.controller.PIDController;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Robot extends TimedRobot {
    private DigitalInput beamBreak;
    private TalonSRX frontLeft;
    private TalonSRX rearLeft;
    private TalonSRX rearRight;
    private TalonSRX frontRight;
    

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
    @Override
    public void robotInit() {
        frontLeft = new TalonSRX(2);
        frontRight = new TalonSRX(4);
        rearLeft = new TalonSRX(1);
        rearRight = new TalonSRX(3);
        frontLeft.follow(rearLeft);
        frontRight.follow(rearRight);
        frontRight.setInverted(true);
        
        beamBreak = new DigitalInput(1);
        beamBreak.get();
        
    }

    @Override
    public void robotPeriodic() {
    }

    @Override
    public void autonomousInit() {}

    @Override
    public void autonomousPeriodic() {}

    @Override
    public void teleopInit() {}

    @Override
    public void teleopPeriodic() {
        if(beamBreak.get()) {
            frontLeft.set(ControlMode.PercentOutput, 0.3);
            frontRight.set(ControlMode.PercentOutput, 0.3);
        } else {
            frontLeft.set(ControlMode.PercentOutput, 0);
            frontRight.set(ControlMode.PercentOutput, 0);
        SmartDashboard.putBoolean("beamBreaker", beamBreak.get());
        
    }

    @Override
    public void disabledInit() {}

    @Override
    public void disabledPeriodic() {}

    @Override
    public void testInit() {}

    @Override
    public void testPeriodic() {}

    @Override
    public void simulationInit() {}

    @Override
    public void simulationPeriodic() {}


}

