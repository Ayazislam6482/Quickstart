package org.firstinspires.ftc.teamcode.Tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Components.DriveTrain;
import org.firstinspires.ftc.teamcode.Components.Intake;
import org.firstinspires.ftc.teamcode.Components.Outtake;
import org.firstinspires.ftc.teamcode.Components.Pusher;

@TeleOp(name = "TestTeleOp1")
public class  TestTeleOp1 extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        DriveTrain drivetrain = new DriveTrain(hardwareMap);
        Intake intake = new Intake(hardwareMap);
        Outtake outtake = new Outtake(hardwareMap);
        Pusher pusher = new Pusher(hardwareMap);

        while (opModeInInit()){

            drivetrain.initialize();
            intake.initialize();
            outtake.initialize();
            pusher.initialize();

        }

        waitForStart();
        while (opModeIsActive()){

            double movement = gamepad1.left_stick_y;
            double rotation = -gamepad1.right_stick_x;
            double strafe = gamepad1.left_stick_x;
            boolean precision = gamepad1.right_bumper;

            drivetrain.TeleOpControl(precision, movement, rotation, strafe);

            if(gamepad2.dpad_up){

                intake.intake();

            } else if (gamepad2.dpad_down) {

                intake.out();

            } else if (gamepad2.y) {

                outtake.shoot();

            } else if (gamepad2.a) {

                pusher.pushUp();

            } else if (gamepad2.b) {

                pusher.pushDown();

            }

            if (gamepad1.dpad_up) {

                pusher.pusher.setPosition(0);

            } else if (gamepad1.dpad_down) {

                pusher.pusher.setPosition(1);

            } else if (gamepad1.dpad_right) {

                pusher.pusher.setPosition(0.5);

            }

            telemetry.addData("Pusher Position", pusher.pusher.getPosition());

            telemetry.update();
        }
    }
}