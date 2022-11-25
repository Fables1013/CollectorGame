package Model;

public class GameSettings {
    double movementSpeed;

    void setMovementSpeed(double speed) { this.movementSpeed = Math.min(4, Math.max(0.0, speed)); }
}
