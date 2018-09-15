package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="AutonomousExample", group="Example")
public class AutonomousExample extends LinearOpMode {
    DcMotor leftDrive;
    DcMotor rightDrive;


    @Override
    public void runOpMode() throws InterruptedException {
        leftDrive = hardwareMap.dcMotor.get("left_drive");
        rightDrive = hardwareMap.dcMotor.get("right_drive");
        leftDrive.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        moveForward(.5);
        wait(1000);
        turnRight(.25);
        sleep(500);
        moveForward(.75);
        sleep(750);
        stopDriving();
    }
    // Methods
    public void moveForward(double power)
    {
        leftDrive.setPower(power);
        rightDrive.setPower(power);
    }

    public void moveBackward(double power)
    {
        moveForward(-power);
    }

    public void turnLeft(double power)
    {
        leftDrive.setPower(-power);
        rightDrive.setPower(power);
    }

    public void turnRight(double power)
    {
        turnLeft(-power);
    }

    public void stopDriving()
    {
        moveForward(0);
    }
}
