package zelda;

public class Player {
    private int x;
    private int y;
    private int health;
    private int damage;

    public Player(int startX, int startY, int startHealth, int startDamage) {
        x = startX;
        y = startY;
        health = startHealth;
        damage = startDamage;
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public void attack() {
        // Code to handle the player's attack
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }
}
