package rambo.character_all;

public interface Damageable {
    int getX();
    int getY();
    int getWidth();
    int getHeight();
    void takeDamage(int damage);
}