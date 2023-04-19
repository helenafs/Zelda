package zelda;

public class Life {
	 private int currentHealth;
	    private int maxHealth;
	    
	    public Life(int maxHealth) {
	        this.maxHealth = maxHealth;
	        this.currentHealth = maxHealth;
	    }
	    
	    public int getCurrentHealth() {
	        return currentHealth;
	    }
	    
	    public int getMaxHealth() {
	        return maxHealth;
	    }
	    
	    public void setCurrentHealth(int currentHealth) {
	        this.currentHealth = currentHealth;
	    }
	    
	    public void takeDamage(int damage) {
	        currentHealth -= damage;
	        if (currentHealth < 0) {
	            currentHealth = 0;
	        }
	    }
	    
	    public boolean isDead() {
	        return currentHealth <= 0;
	    }
}
