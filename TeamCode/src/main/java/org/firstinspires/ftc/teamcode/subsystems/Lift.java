package org.firstinspires.ftc.teamcode.subsystems;

import com.asiankoala.koawalib.control.controller.PIDGains;
import com.asiankoala.koawalib.control.motor.FFGains;
import com.asiankoala.koawalib.control.profile.MotionConstraints;
import com.asiankoala.koawalib.hardware.motor.EncoderFactory;
import com.asiankoala.koawalib.hardware.motor.KMotor;
import com.asiankoala.koawalib.hardware.motor.MotorFactory;
import com.asiankoala.koawalib.hardware.servo.KServo;
import com.asiankoala.koawalib.subsystem.KSubsystem;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.opmodes.PIDConfig;

public class Lift extends KSubsystem {
    public final KMotor lift1 = new MotorFactory("lift1")
            .getFloat()
            .getReverse()
            .build();

    /**
     * TODO: Ticks per unit redo PID lol funny!!!!!
     */
    public final KMotor lift2 = new MotorFactory("lift2")
            .getFloat()
            .pairEncoder(lift1,
                    new EncoderFactory(38.0)
                            .getReverse()
                            .zero()
            )
            .withPositionControl(
                    new PIDGains(
                            0.6,
                            0.0,
                            0.0025),
                    new FFGains(0.0, 0.0, 0.0, 0.2, 0.0),
                    0.2
            )
            .build();

    public void setTarget(double target) {
        lift2.setPositionTarget(target);
    }

    public double getCurrentHeight() { return lift2.getPos(); }

    public double getTargetPosition() { return lift2.getTargetState().getX(); }

    @Override
    public void periodic() {
        lift1.setPower(lift2.getPower());
    }
}
