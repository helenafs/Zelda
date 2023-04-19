package zelda.objects;

public class Shield {
    
    public enum Kind {
        SMALL,
        MAGICAL
    }
    
    private Kind kind;
    private int defense; // The amount of damage that can be blocked
    
    public Shield(Kind kind) {
        this.kind = kind;
        this.defense = (kind == Kind.SMALL) ? 1 : 2; // Set the amount of defense based on the shield type
    }
    
    public int getDefense() {
        return defense;
    }
}
