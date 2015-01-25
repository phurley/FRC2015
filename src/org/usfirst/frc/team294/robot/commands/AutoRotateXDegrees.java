package org.usfirst.frc.team294.robot.commands;

import org.usfirst.frc.team294.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoRotateXDegrees extends Command {
private double degrees;
private double currentPosition=0;
private double desiredPosition=0;
private double degBuffer = 90; 

    public AutoRotateXDegrees(double degs) {//degs = degrees. positive number = turn Right. Negative number = turn Left
    	requires(Robot.drivetrain);
    	degrees = degs;
    	desiredPosition=Robot.drivetrain.getHeading();
    	desiredPosition+=degs;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (degrees>0)Robot.drivetrain.tankDrive(0.5,-0.5);
    	else Robot.drivetrain.tankDrive(-0.5, 0.5);

    	this.currentPosition = Robot.drivetrain.getHeading();

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (Math.abs(currentPosition-desiredPosition)< degBuffer){return true;}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stop(); 
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drivetrain.stop();
    }
}
