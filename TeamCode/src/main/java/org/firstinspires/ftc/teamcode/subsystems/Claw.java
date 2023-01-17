package org.firstinspires.ftc.teamcode.subsystems;

import com.asiankoala.koawalib.hardware.servo.KCRServo;
import com.asiankoala.koawalib.hardware.servo.KServo;
import com.asiankoala.koawalib.subsystem.KSubsystem;

import org.firstinspires.ftc.teamcode.Constants;

public class Claw extends KSubsystem {
    private final KServo clawServo1 = new KServo("claw")
            .reverse()
            .startAt(Constants.openedClaw);

    private final KServo clawServo2 = new KServo("claw2")
            .startAt(Constants.openedClaw);

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

    public void setClaw(double position) {
        clawServo1.setPosition(position);
        clawServo2.setPosition(position);
    }
}
