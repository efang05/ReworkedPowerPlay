package org.firstinspires.ftc.teamcode.commands.subsystem;

import com.asiankoala.koawalib.command.commands.InstantCmd;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.Turret;

class TurretCmd extends InstantCmd { TurretCmd(Turret turret, double position) { super(() -> { turret.setTarget(position); return null; }); } }
class TurretFrontCmd extends TurretCmd { TurretFrontCmd(Turret turret) { super(turret, Constants.front); } }
class TurretBackCmd extends TurretCmd { TurretBackCmd(Turret turret) { super(turret, Constants.back); } }
