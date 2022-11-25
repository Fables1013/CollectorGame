package Model.Creature_Configs;

public class Health {
    int maxHealth;
    int currentHealth;

    public Health (int maxHealth, int currentHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
    }

    public void setCurrentHealth(int newHealth) {
        this.currentHealth = Math.max(0, Math.min(newHealth, this.maxHealth));
    }

    public double healthPercent() { return (double) currentHealth / (double) maxHealth; }

    public void takeDamage(int damage) { setCurrentHealth(currentHealth - damage); }
    public void takePercent(int damagePercent) { setCurrentHealth(currentHealth - damagePercent * maxHealth); }
    public void healDamage(int healAmount) { setCurrentHealth(currentHealth + healAmount); }
    public void healPercent(int healPercent) { setCurrentHealth(currentHealth + healPercent * maxHealth); }

    public int getCurrentHealth() { return this.currentHealth; }
}
