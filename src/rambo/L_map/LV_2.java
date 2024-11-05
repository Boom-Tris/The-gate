package rambo.L_map;

import java.awt.Image;
import rambo.character_all.Enemy;
import rambo.character_all.Enemy1;
import rambo.character_all.Enemy2;
import rambo.character_all.Enemy3;
import rambo.character_all.Enemy4;
import rambo.character_all.Enemy5;
import rambo.character_all.Enemy6;
import rambo.character_all.Enemy7;
import rambo.character_all.Enemy8;
import rambo.character_all.Character;
import rambo.item_all.HealthItem;
import rambo.item_all.Coin;

import rambo.item_all.CopperCoin; //SilverCoin
import rambo.item_all.TreasureChest;
import rambo.item_all.ChickenLeg;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class LV_2 implements Runnable {

    private List<Enemy> enemies; // List to hold enemies
    private List<HealthItem> healthItems; // List to hold health items
    private List<Coin> coins;

    private Character mainCharacter; // Main character reference
    private boolean running; // Control flag for the thread
    private List<CopperCoin> silverCoins;
    private List<TreasureChest> treasureChests;
    private List<Enemy1> enemies1;
    private List<Enemy2> enemies2;
    private List<Enemy3> enemies3;
    private List<Enemy4> enemies4;
    private List<Enemy5> enemies5;
    private List<Enemy6> enemies6;
    private List<Enemy7> enemies7;
    private List<Enemy8> enemies8;
    private List<ChickenLeg> ChickenLeg;

    public LV_2(Character mainCharacter) {
        this.mainCharacter = mainCharacter;

        this.enemies = createEnemies();
        this.enemies1 = createEnemies1();// Initialize enemies with the main character reference
        this.enemies2 = createEnemies2();
        this.enemies3 = createEnemies3();
        this.enemies4 = createEnemies4();
        this.enemies5 = createEnemies5();
        this.enemies6 = createEnemies6();
        this.enemies7 = createEnemies7();
        this.enemies8 = createEnemies8();
        this.healthItems = createHealthItems(); // Initialize health items
        this.coins = createCoins();
        this.silverCoins = createSilverCoins();
        this.treasureChests = createTreasureChests();
        this.ChickenLeg = createChickenLeg();
        this.running = true; // Set running to true to start the thread

    }

    // Layout for the level (can be modified to suit your level design)
    public static int[][] getLayout() {
        return new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0,},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1,},
            {0, 0, 0, 0, 0, 0, 0, 00, 0, 0, 0, 00, 0, 0, 0, 0, 0, 0, 0, 00, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},};
    }

    // Initialize health items with specified coordinates
    private List<HealthItem> createHealthItems() {
        List<HealthItem> healthItems = new ArrayList<>();
        healthItems.add(new HealthItem(100, 950)); // Add health item at (800, 650)
        healthItems.add(new HealthItem(500, 800));
        // Add more health items as needed
        return healthItems;
    }

    // Initialize enemies with positions and main character reference
    private List<Enemy> createEnemies() {
        List<Enemy> enemies = new ArrayList<>();

        // enemies.add(new Enemy(100, 870, mainCharacter)); // First enemy at (100, 650)
        //  enemies.add(new Enemy(500, 915, mainCharacter)); // Second enemy at (500, 650)
        // Add more enemies as needed
        return enemies;
    }

    private List<Enemy1> createEnemies1() {
        List<Enemy1> enemies1 = new ArrayList<>();
        enemies1.add(new Enemy1(1150, 510, mainCharacter));
        enemies1.add(new Enemy1(1150, 510, mainCharacter));
        enemies1.add(new Enemy1(1150, 510, mainCharacter));
        enemies1.add(new Enemy1(1150, 510, mainCharacter));

        // enemies1.add(new Enemy1(100, 820, mainCharacter)); // First enemy at (100, 650)
        //  enemies1.add(new Enemy1(500, 915, mainCharacter)); // Second enemy at (500, 650)
        // Add more enemies as needed
        return enemies1;
    }

    private List<Enemy2> createEnemies2() {
        List<Enemy2> enemies2 = new ArrayList<>();
        //enemies2.add(new Enemy2(100, 820, mainCharacter)); // First enemy at (100, 650)

        //   enemies2.add(new Enemy2(500, 915, mainCharacter)); // Second enemy at (500, 650)
        // Add more enemies as needed
        return enemies2;
    }

    private List<Enemy3> createEnemies3() {
        List<Enemy3> enemies3 = new ArrayList<>();
        enemies3.add(new Enemy3(400, 315, mainCharacter)); // First enemy at (100, 650)
        enemies3.add(new Enemy3(450, 315, mainCharacter)); // First enemy at (100, 650)
        enemies3.add(new Enemy3(500, 315, mainCharacter)); // First enemy at (100, 650)
        // enemies3.add(new Enemy3(500, 915, mainCharacter)); // Second enemy at (500, 650)
        // Add more enemies as needed
        return enemies3;
    }

    private List<Enemy4> createEnemies4() {
        List<Enemy4> enemies4 = new ArrayList<>();
        enemies4.add(new Enemy4(100, 931, mainCharacter)); // First enemy at (100, 650)
        enemies4.add(new Enemy4(200, 931, mainCharacter));
        enemies4.add(new Enemy4(300, 931, mainCharacter));
        enemies4.add(new Enemy4(400, 931, mainCharacter));
        enemies4.add(new Enemy4(500, 931, mainCharacter));
        enemies4.add(new Enemy4(600, 931, mainCharacter));
        enemies4.add(new Enemy4(700, 931, mainCharacter));
        enemies4.add(new Enemy4(800, 931, mainCharacter));
        enemies4.add(new Enemy4(900, 931, mainCharacter));
        // enemies4.add(new Enemy4(500, 915, mainCharacter)); // Second enemy at (500, 650)
        // Add more enemies as needed
        return enemies4;
    }

    private List<Enemy5> createEnemies5() {
        List<Enemy5> enemies5 = new ArrayList<>();
        enemies5.add(new Enemy5(500, 742, mainCharacter)); // First enemy at (100, 650)
        enemies5.add(new Enemy5(550, 742, mainCharacter)); // First enemy at (100, 650)
        enemies5.add(new Enemy5(600, 742, mainCharacter)); // First enemy at (100, 650)
        enemies5.add(new Enemy5(650, 742, mainCharacter)); // First enemy at (100, 650)
        // enemies5.add(new Enemy5(500, 915, mainCharacter)); // Second enemy at (500, 650)
        // Add more enemies as needed
        return enemies5;
    }

    private List<Enemy6> createEnemies6() {
        List<Enemy6> enemies6 = new ArrayList<>();

        // enemies6.add(new Enemy6(500, 810, mainCharacter)); // Second enemy at (500, 650)
        // Add more enemies as needed
        return enemies6;
    }

    private List<Enemy7> createEnemies7() {
        List<Enemy7> enemies7 = new ArrayList<>();
        // enemies7.add(new Enemy7(100, 810, mainCharacter)); // First enemy at (100, 650)

        // Add more enemies as needed
        return enemies7;
    }

    private List<Enemy8> createEnemies8() {
        List<Enemy8> enemies8 = new ArrayList<>();

        enemies8.add(new Enemy8(500, 900, mainCharacter)); // Second enemy at (500, 650)
        // Add more enemies as needed
        return enemies8;
    }

    private List<Coin> createCoins() {
        List<Coin> coins = new ArrayList<>();
        coins.add(new Coin(400, 420)); // Add a coin at (400, 600)
        coins.add(new Coin(450, 420));
        coins.add(new Coin(500, 420));
        coins.add(new Coin(550, 420));
        coins.add(new Coin(600, 420));
        coins.add(new Coin(650, 420));
        coins.add(new Coin(700, 420));
        coins.add(new Coin(750, 420));
        coins.add(new Coin(800, 420));
        coins.add(new Coin(850, 420));
        coins.add(new Coin(900, 420));
        coins.add(new Coin(950, 420));
        coins.add(new Coin(1000, 420));

        // coins.add(new Coin(780, 920));
        // Add more coins as needed
        return coins;
    }

    private List<CopperCoin> createSilverCoins() {
        List<CopperCoin> silverCoins = new ArrayList<>();

        silverCoins.add(new CopperCoin(1350, 420));
        silverCoins.add(new CopperCoin(1400, 420));
        silverCoins.add(new CopperCoin(1450, 420));
        silverCoins.add(new CopperCoin(1500, 420));
        silverCoins.add(new CopperCoin(1550, 420));
        silverCoins.add(new CopperCoin(1600, 420));

        silverCoins.add(new CopperCoin(1100, 600));
        silverCoins.add(new CopperCoin(1050, 600));
        silverCoins.add(new CopperCoin(1000, 600));
        silverCoins.add(new CopperCoin(950, 600));
        silverCoins.add(new CopperCoin(900, 600));
        silverCoins.add(new CopperCoin(850, 600));
        silverCoins.add(new CopperCoin(800, 600));

        silverCoins.add(new CopperCoin(200, 800));
        silverCoins.add(new CopperCoin(250, 800));
        silverCoins.add(new CopperCoin(300, 800));
        silverCoins.add(new CopperCoin(350, 800));
        // silverCoins.add(new CopperCoin(600, 920)); 

        return silverCoins;
    }

    private List<TreasureChest> createTreasureChests() {
        List<TreasureChest> treasureChests = new ArrayList<>();
        treasureChests.add(new TreasureChest(1700, 390)); // Add a treasure chest at (850, 650)
        // treasureChests.add(new TreasureChest(900, 920)); // Add another treasure chest at (900, 650)
        // Add more treasure chests as needed
        return treasureChests;
    }

    private List<ChickenLeg> createChickenLeg() {
        List<ChickenLeg> ChickenLeg = new ArrayList<>();
        ChickenLeg.add(new ChickenLeg(300, 420)); // Example position
        ChickenLeg.add(new ChickenLeg(700, 800));
        // Add more chocolate bars as needed
        return ChickenLeg;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    // Accessor for enemies list
    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Enemy1> getEnemies1() {
        return enemies1;
    }

    public List<Enemy2> getEnemies2() {
        return enemies2;
    }

    public List<Enemy3> getEnemies3() {
        return enemies3;
    }

    public List<Enemy4> getEnemies4() {
        return enemies4;
    }

    public List<Enemy5> getEnemies5() {
        return enemies5;
    }

    public List<Enemy6> getEnemies6() {
        return enemies6;
    }

    public List<Enemy7> getEnemies7() {
        return enemies7;
    }

    public List<Enemy8> getEnemies8() {
        return enemies8;
    }

    // Accessor for health items list
    public List<HealthItem> getHealthItems() {
        return healthItems;
    }

    public List<CopperCoin> getSilverCoins() {
        return silverCoins; // Correctly returns the list of silver coins
    }

    public List<TreasureChest> getTreasureChests() {
        return treasureChests; // Correctly returns the list of treasure chests
    }

    public List<ChickenLeg> getChickenLeg() {
        return ChickenLeg; // Chocolate Bars
    }

    public void removeEnemy(Enemy7 enemy) {
        enemies7.remove(enemy); // หรือการใช้วิธีที่เหมาะสมในการลบ
    }

    // Main game loop for handling logic
    @Override
    public void run() {
        while (running) {
            for (Coin coin : coins) {
                if (!coin.isCollected() && coin.isCollectedBy(mainCharacter)) {
                    mainCharacter.addScore(coin.getPoints()); // Add points to the character's score
                }
            }
            // Collision detection between the character and health items
            for (HealthItem healthItem : healthItems) {
                if (!healthItem.isCollected() && healthItem.checkCollision(mainCharacter.getX(), mainCharacter.getY(), mainCharacter.getWidth(), mainCharacter.getHeight())) {
                    healthItem.collect(mainCharacter); // Collect health item
                }
            }
            for (CopperCoin silverCoin : silverCoins) {
                if (!silverCoin.isCollected() && silverCoin.isCollectedBy(mainCharacter)) {
                    mainCharacter.addScore(silverCoin.getPoints());
                }
            }
            for (TreasureChest treasureChest : treasureChests) {
                if (!treasureChest.isCollected() && treasureChest.isCollectedBy(mainCharacter)) {
                    mainCharacter.addScore(treasureChest.getPoints()); // Add points from treasure chest
                }
            }
            for (ChickenLeg ChickenLeg : ChickenLeg) {
                if (!ChickenLeg.isCollected() && ChickenLeg.isCollectedBy(mainCharacter)) {
                    mainCharacter.increaseAttackPower(ChickenLeg.getDamageIncrease());

                    // The chocolate bar is collected; you may want to log or display a message
                }
            }

            // Control the update rate (e.g., every 100 milliseconds)
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    // Draw method to render all enemies and health items

    // Stop the level thread
    public void stop() {
        running = false;

    }

}
