package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="TeleOp Example", group="Example")
public class TeleOP extends OpMode {
    // Declare all hardware members
    DcMotor leftDrive;
    DcMotor rightDrive;

    @Override
    public void init() {
        // Map hardware
        leftDrive = hardwareMap.dcMotor.get("left_motor");
        rightDrive = hardwareMap.dcMotor.get("right_motor");
        leftDrive.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        // Delare drive variables
        double leftPower;
        double rightPower;

        // Wheels
        double drive = -gamepad1.left_stick_y;
        double turn = gamepad1.right_stick_x;
        leftPower = Range.clip(drive + turn, -1.00, 1.00);
        rightPower = Range.clip(drive - turn, -1.00, 1.00);

        // Send calculated power to wheels
        leftDrive.setPower(-leftPower);
        rightDrive.setPower(-rightPower);

    }
}
