package org.firstinspires.ftc.teamcode.commands.subsystem.turret;

import com.asiankoala.koawalib.command.commands.InstantCmd;

import org.firstinspires.ftc.teamcode.subsystems.Turret;

public class TurretCmd extends InstantCmd {
    public TurretCmd(Turret turret, double position) {
        super(() -> {
            turret.setTarget(position);
            return null;
        });
    }
}
