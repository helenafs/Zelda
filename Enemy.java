public class Enemy {
    // Variables pour représenter l'état de l'ennemi
    private int x;
    private int y;
    private int health;

    // Constructeur pour initialiser l'état de l'ennemi
    public Enemy(int startX, int startY, int startHealth) {
        x = startX;
        y = startY;
        health = startHealth;
    }

    // Méthodes pour contrôler le comportement de l'ennemi
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public void attack() {
        // Code pour gérer l'attaque de l'ennemi
    }

    // Autres méthodes pour les autres actions de l'ennemi

    // Méthodes pour accéder aux variables de l'ennemi
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHealth() {
        return health;
    }
}
