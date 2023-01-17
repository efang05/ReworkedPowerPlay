package org.firstinspires.ftc.teamcode.commands.subsystem.turret;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.Turret;

public class TurretFrontCmd extends TurretCmd {
    public TurretFrontCmd(Turret turret) {
        super(turret, Constants.front);
    }
}
