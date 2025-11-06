package org.firstinspires.ftc.teamcode.Components;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake {

    private LinearOpMode parent;
    private Telemetry telemetry;

    public DcMotorEx intake;

    public void initialize(){

        stop();
        intake.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
//        intake.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
//        intake.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

    }

    public Intake(HardwareMap hardwareMap) {

        intake = hardwareMap.get(DcMotorEx.class, "intake");

    }

    public void intake(){

        intake.setPower(1);

    }

    public void out(){

        intake.setPower(-1);

    }

    public void stop(){

        intake.setPower(0);

    }

}