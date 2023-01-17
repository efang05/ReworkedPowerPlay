package org.firstinspires.ftc.teamcode.subsystems;

import com.asiankoala.koawalib.hardware.servo.KServo;
import com.asiankoala.koawalib.subsystem.KSubsystem;

import org.firstinspires.ftc.teamcode.Constants;

public class Arm extends KSubsystem {

    private final KServo armServo1 = new KServo("arm")
            .startAt(Constants.liftedArm);

    private final KServo armServo2 = new KServo("arm2")
            .reverse()
            .startAt(Constants.liftedArm);

    /**
     * TODO: Intake Servos
     **/

//    private final KCRServo intakeServo1 = new KCRServo("intake1");
//    private final KCRServo intakeServo2 = new KCRServo("intake2").reverse();
//
//    public void setIntake(double power) {
//        intakeServo1.setPower(power);
//        intakeServo2.setPower(power);
//    }

    public void setArm(double position) {
        armServo1.setPosition(position);
        armServo2.setPosition(position);
    }
}
