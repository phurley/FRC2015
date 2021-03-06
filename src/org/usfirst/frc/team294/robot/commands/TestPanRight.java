package org.usfirst.frc.team294.robot.commands;

import org.usfirst.frc.team294.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TestPanRight extends Command {

	double leftSpeed=  .25;
	double rightSpeed= -.25;
	
    public TestPanRight() {
    	requires(Robot.toteGrab);
    	
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("panning right");
    	//relativeDistance=Math.abs(Robot.toteGrab.getLeftMotor().getAnalogInPosition()-Robot.toteGrab.getRightMotor().getAnalogInPosition());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.toteGrab.setLeftTest(leftSpeed);
    	Robot.toteGrab.setRightTest(rightSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
