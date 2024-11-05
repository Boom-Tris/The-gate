package ram_bo;

import rambo.sound.SoundManager;
import rambo.L_map.Map;

import rambo.character_all.Character;
import rambo.L_map.LV_2;
import rambo.L_map.LV_1;
import rambo.L_map.LV_3;
import java.awt.event.*;

import rambo.gui.HealthIndicator;
import rambo.character_all.Enemy; // Import Enemy
import rambo.character_all.Enemy1;
import rambo.character_all.Enemy2;// Import Enemy
import rambo.character_all.Enemy3;// Import Enemy
import rambo.character_all.Enemy4;// Import Enemy
import rambo.character_all.Enemy5;// Import Enemy
import rambo.character_all.Enemy6;// Import Enemy BOSS
import rambo.character_all.Enemy7;// Import Enemy BOSS
import rambo.character_all.Enemy8;// Import Enemy BOSS
import rambo.item_all.HealthItem;
import rambo.item_all.Coin;
import rambo.gui.ScoreIndicator; // ScoreIndicator
import rambo.item_all.CopperCoin;
import rambo.item_all.TreasureChest;
import rambo.item_all.ChickenLeg;

import javax.swing.*;
import java.awt.*;

import java.io.IOException;
import java.util.List;

import rambo.L_map.MapSelectionScreen;

public class RamBo extends JPanel implements KeyListener, Runnable {

    private Font customFont;
    private Character character;  // The main character

    private SoundManager soundManager; // The pet
    private Image backgroundImage; // Background image
    private Map map;              // The map
    private int cameraX = 0;      // Camera position on the X axis
    private int cameraY = 0;      // Camera position on the Y axis
    private Thread gameThread;     // Game thread
    private volatile boolean running; // Control the game loop running state
    private int currentLevel;      // Current level index
    private List<Enemy> enemies;   // List of enemies
    private List<Enemy1> enemies1;
    private List<Enemy2> enemies2;// List of 
    private List<Enemy3> enemies3;
    private List<Enemy4> enemies4;

    private List<Enemy5> enemies5;
    private List<Enemy6> enemies6;
    private List<Enemy7> enemies7;
    private List<Enemy8> enemies8;
    private List<TreasureChest> treasureChests;
    private List<HealthItem> healthItems;
    private List<Coin> coin;

    private List<CopperCoin> silverCoins;
    private HealthIndicator healthIndicator;
    private List<ChickenLeg> ChickenLeg;
    // Map dimensions

    private boolean isGameOver;
    private boolean isGameWIN;
    private ScoreIndicator scoreIndicator;
    private final int MAP_WIDTH = 1920;  // Map width
    private final int MAP_HEIGHT = 1080; // Map height
    private JButton exitButton;
    private JButton restartButton;
    private JButton nextButton;

    LV_1 level1;

    public RamBo(int levelIndex) {
        setLayout(new FlowLayout()); // หรือ Layout ที่คุณต้องการ

        nextButton = new JButton("NEXT Game");
        restartButton = new JButton("Start New Game");
        exitButton = new JButton("Exit Game");
        exitButton.addActionListener(e -> System.exit(0));
        exitButton.setVisible(false); // ซ่อนปุ่มเมื่อเริ่มต้น
        add(exitButton); // เพิ่มปุ่มลงใน JPanel
        this.add(restartButton);
        this.add(nextButton);
        this.soundManager = new SoundManager();
        restartButton.setVisible(false);

        nextButton.setVisible(false);
        this.currentLevel = levelIndex;

        customFont = loadCustomFont();
        loadLevel(currentLevel);
        setFocusable(true);
        addKeyListener(this);
        this.setLayout(null); // ใช้ Layout แบบ null เพื่อกำหนดตำแหน่งเอง

        // Load the background image
        backgroundImage = new ImageIcon(getClass().getResource("../rambo/map/m.png")).getImage();

        // Create and start the game thread
        running = true; // Set running to true before starting the thread
        gameThread = new Thread(this);
        gameThread.start();
        healthIndicator = new HealthIndicator(3);
        scoreIndicator = new ScoreIndicator(character);
        isGameOver = false;
        isGameWIN = false;
    }

    private Font loadCustomFont() {
        try {
            // Load the font file from the fonts directory
            return Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("../rambo/fonts/PixeloidSansBold-PKnYd.ttf")).deriveFont(24f);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            return new Font("Pixeloid Sans", Font.BOLD, 24); // Fallback to default font if loading fails
        }
    }

    public void loadLevel(int levelIndex) {

        System.out.println("Loading level: " + levelIndex);
        character = new Character(); // Create character instance
        switch (levelIndex) {
            case 0:
                LV_1 level1 = new LV_1(character); // Pass character instance to level
                map = new Map(level1.getLayout(), MAP_WIDTH, MAP_HEIGHT, "../map/Terrain1.png");
                enemies = level1.getEnemies();  // Initialize enemies list
                enemies1 = level1.getEnemies1();
                enemies2 = level1.getEnemies2();
                enemies3 = level1.getEnemies3();
                enemies4 = level1.getEnemies4();
                enemies5 = level1.getEnemies5();
                enemies6 = level1.getEnemies6();
                enemies7 = level1.getEnemies7();
                enemies8 = level1.getEnemies8();

                healthItems = level1.getHealthItems();
                coin = level1.getCoins();
                silverCoins = level1.getSilverCoins();
                treasureChests = level1.getTreasureChests();
                ChickenLeg = level1.getChickenLeg();
               

                break;
            case 1:
                LV_2 level2 = new LV_2(character);
                map = new Map(LV_2.getLayout(), MAP_WIDTH, MAP_HEIGHT, "../map/Terrain1.png");
                enemies = level2.getEnemies();  // Initialize enemies list
                enemies1 = level2.getEnemies1();
                enemies2 = level2.getEnemies2();
                enemies3 = level2.getEnemies3();
                enemies4 = level2.getEnemies4();
                enemies5 = level2.getEnemies5();
                enemies6 = level2.getEnemies6();
                enemies7 = level2.getEnemies7();
                enemies8 = level2.getEnemies8();

                healthItems = level2.getHealthItems();
                coin = level2.getCoins();
                silverCoins = level2.getSilverCoins();
                treasureChests = level2.getTreasureChests();
                ChickenLeg = level2.getChickenLeg();

                break;
            case 2:
                LV_3 level3 = new LV_3(character);
                map = new Map(LV_3.getLayout(), MAP_WIDTH, MAP_HEIGHT, "../map/Terrain1.png");
                enemies = level3.getEnemies();  // Initialize enemies list
                enemies1 = level3.getEnemies1();
                enemies2 = level3.getEnemies2();
                enemies3 = level3.getEnemies3();
                enemies4 = level3.getEnemies4();
                enemies5 = level3.getEnemies5();
                enemies6 = level3.getEnemies6();
                enemies7 = level3.getEnemies7();
                enemies8 = level3.getEnemies8();

                healthItems = level3.getHealthItems();
                coin = level3.getCoins();
                silverCoins = level3.getSilverCoins();
                treasureChests = level3.getTreasureChests();
                ChickenLeg = level3.getChickenLeg();

                break;
            default:
                System.out.println("Invalid level index. Resetting to Level 1.");
                currentLevel = 0;
                loadLevel(currentLevel);
                return;
        }

        System.out.println("Map loaded successfully for level: " + levelIndex);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw background
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        // Use Graphics2D for camera translation
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(-cameraX, -cameraY); // Move camera

        // Draw map and characters
        if (map != null) {
            map.drawMap(g2d, cameraX, cameraY);
        }
        if (character != null) {
            character.draw(g2d);

        }

        // Draw enemies
        if (enemies != null) {
            for (int i = 0; i < enemies.size(); i++) {
                Enemy enemy = enemies.get(i);
                enemy.draw(g2d); // Draw each enemy
                if (enemy.getHealth() <= 0) {
                    enemies.remove(i);
                    i--; // Adjust index since we've removed an enemy
                }
            }
        }

        if (enemies1 != null) {
            for (int i = 0; i < enemies1.size(); i++) {
                Enemy1 enemy1 = enemies1.get(i);
                enemy1.draw(g2d); // Draw each enemy
                if (enemy1.getHealth() <= 0) {
                    enemies1.remove(i);
                    i--; // Adjust index since we've removed an enemy
                }
            }
        }

        if (enemies2 != null) {
            for (int i = 0; i < enemies2.size(); i++) {
                Enemy2 enemy2 = enemies2.get(i);
                enemy2.draw(g2d); // Draw each enemy
                if (enemy2.getHealth() <= 0) {
                    enemies2.remove(i);
                    i--; // Adjust index since we've removed an enemy
                }
            }
        }

        if (enemies3 != null) {
            for (int i = 0; i < enemies3.size(); i++) {
                Enemy3 enemy3 = enemies3.get(i);
                enemy3.draw(g2d); // Draw each enemy
                if (enemy3.getHealth() <= 0) {
                    enemies3.remove(i);
                    i--; // Adjust index since we've removed an enemy
                }
            }
        }

        if (enemies4 != null) {
            for (int i = 0; i < enemies4.size(); i++) {
                Enemy4 enemy4 = enemies4.get(i);
                enemy4.draw(g2d); // Draw each enemy
                if (enemy4.getHealth() <= 0) {
                    enemies4.remove(i);
                    i--; // Adjust index since we've removed an enemy
                }
            }
        }

        if (enemies5 != null) {
            for (int i = 0; i < enemies5.size(); i++) {
                Enemy5 enemy5 = enemies5.get(i);
                enemy5.draw(g2d); // Draw each enemy
                if (enemy5.getHealth() <= 0) {
                    enemies5.remove(i);
                    i--; // Adjust index since we've removed an enemy
                }
            }
        }

        if (enemies6 != null) {
            for (int i = 0; i < enemies6.size(); i++) {
                Enemy6 enemy6 = enemies6.get(i);
                enemy6.draw(g2d); // Draw each enemy
                if (enemy6.getHealth() <= 0) {
                    enemies6.remove(i);
                    i--; // Adjust index since we've removed an enemy
                }
            }
        }

        if (enemies7 != null) {
            for (int i = 0; i < enemies7.size(); i++) {
                Enemy7 enemy7 = enemies7.get(i);
                enemy7.draw(g2d); // Draw each enemy
                if (enemy7.getHealth() <= 0) {
                    enemies7.remove(i);
                    i--; // Adjust index since we've removed an enemy
                }
            }
        }

        if (enemies8 != null) {
            for (int i = 0; i < enemies8.size(); i++) {
                Enemy8 enemy8 = enemies8.get(i);
                enemy8.draw(g2d); // Draw each enemy
                if (enemy8.getHealth() <= 0) {
                    enemies8.remove(i);
                    i--; // Adjust index since we've removed an enemy
                }
            }
        }

        if (healthItems != null) {
            for (HealthItem healthItem : healthItems) {
                healthItem.draw(g2d); // Draw each health item
            }

        }
        if (coin != null) {
            for (Coin coin : coin) {
                coin.draw(g2d); // Draw each health item
            }
            if (ChickenLeg != null) {
                for (ChickenLeg chocolateBar : ChickenLeg) {
                    chocolateBar.draw(g2d); // วาดแต่ละ Chocolate Bar
                }
            }

        }
        if (silverCoins != null) { // Ensure silverCoins list is not null
            for (CopperCoin silverCoin : silverCoins) {
                silverCoin.draw(g2d); // Draw each silver coin
            }
        }
        if (treasureChests != null) {
            for (TreasureChest treasureChest : treasureChests) {
                treasureChest.draw(g2d); // Draw each treasure chest
            }
        }

        if (isGameOver) {

            g.setColor(Color.RED);
            g.setFont(customFont.deriveFont(50f));
            g.drawString("Game Over", getWidth() / 2 - 150, getHeight() / 2); // วาดข้อความเกมโอเวอร์
            g.drawString("Score: " + character.getScore(), getWidth() / 2 - 150, getHeight() / 2 + 70); // วาดคะแนน
            restartButton.setVisible(true);
            restartButton.setBounds(getWidth() / 2 - 50, getHeight() / 2 + 100, 150, 40);
            restartButton.addActionListener(e -> {
                resetGame();
            });

            exitButton.setBounds(getWidth() / 2 - 50, getHeight() / 2 + 150, 150, 40);

            exitButton.setVisible(true);
        }

        if (isGameWIN) {

            g.setColor(Color.GREEN);
            g.setFont(customFont.deriveFont(50f));
            g.drawString("WIN", getWidth() / 2 - 50, getHeight() / 2);
            g.drawString("Score: " + character.getScore(), getWidth() / 2 - 150, getHeight() / 2 + 70); // วาดคะแนน
            nextButton.setBounds(getWidth() / 2 - 50, getHeight() / 2 + 100, 150, 40);
            nextButton.addActionListener(e -> {
                resetGame();
            });
            nextButton.setVisible(true);
            exitButton.setBounds(getWidth() / 2 - 50, getHeight() / 2 + 150, 150, 40);

            exitButton.setVisible(true);

        }
        scoreIndicator.draw(g);
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (character != null) { // Ensure character is created
            switch (key) {
                case KeyEvent.VK_A:
                    character.setMovingLeft(true);
                    break;
                case KeyEvent.VK_D:
                    character.setMovingRight(true);

                    break;
                case KeyEvent.VK_W:
                    character.jump();

                    break;
                case KeyEvent.VK_SPACE:

                    character.attack();
                    soundManager.playSound("mixkit-game-gun-shot-1662.wav");

                    // Call attack function on spacebar press
                    break;
                case KeyEvent.VK_N: // Press 'N' to go to the next level
                    currentLevel++;
                    loadLevel(currentLevel); // Load the next level
                    break;
                case KeyEvent.VK_B: // Press 'N' to go to the next level
                    character.getHealthIndicator().collectHealth(1);
                    character.updateHealth(1);
                    // Load the next level
                    break;
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (character != null) { // Ensure character is created
            switch (key) {
                case KeyEvent.VK_A:
                    character.setMovingLeft(false);
                    break;
                case KeyEvent.VK_D:
                    character.setMovingRight(false);
                    break;
            }
        }
    }

    @Override
    public void run() {
        // Game loop
        while (running) {
            if (character != null && map != null) {
                // Update character and pet positions
                character.update(map.getHitboxes(), enemies, enemies1, enemies2, enemies3, enemies4, enemies5, enemies6, enemies7, enemies8, getWidth(), getHeight()); // Update character with enemies

                SwingUtilities.invokeLater(this::repaint); // Redraw the panel
            }
            for (HealthItem healthItem : healthItems) {
                if (healthItem.checkCollision(character.getX(), character.getY(), character.getWidth(), character.getHeight()) && !healthItem.isCollected()) {
                    healthItem.collect(character);
                    character.updateHealth(1);

                    break;
                }
            }
            for (Coin coin : coin) {
                if (coin.isCollectedBy(character) && !coin.isCollected()) {
                    character.addScore(coin.getPoints()); // Increase character's score by the coin's value

                    break; // Exit the loop after collecting the coin
                }
            }
            // Check for silver coins collected by the character and increase score
            for (CopperCoin silverCoin : silverCoins) {
                if (silverCoin.isCollectedBy(character) && !silverCoin.isCollected()) {
                    character.addScore(silverCoin.getPoints()); // Increase character's score by the silver coin's value
                    // Mark the silver coin as collected
                    silverCoin.setCollected(true);
                    break; // Exit the loop after collecting the silver coin
                }
            }
            if (treasureChests != null) {
                for (TreasureChest treasureChest : treasureChests) {
                    if (treasureChest.isCollectedBy(character) && !treasureChest.isCollected()) {
                        character.addScore(treasureChest.getPoints());

                        break;
                    }
                }
            }

            if (ChickenLeg != null) {
                for (ChickenLeg ChickenLeg : ChickenLeg) {
                    if (ChickenLeg.isCollectedBy(character) && !ChickenLeg.isCollected()) {

                        character.increaseAttackPower(ChickenLeg.getDamageIncrease()); //  ChickenLeg

                        break;
                    }
                }
            }
            if (character.getHealth() <= 0) {
                running = false; // Stop the game loop
               
                // Show the game over screen
                isGameOver = true;
                break; // Exit the loop
            }

            if (character.getScore() >= 20000) {
                running = false;
                soundManager.playSound("mixkit-medieval-show-fanfare-announcement-226.wav");
                isGameWIN = true;

                break;
            }

            try {
                Thread.sleep(1000 / 60); // Maintain 60 FPS
            } catch (InterruptedException e) {
                running = false; // Stop the game loop on interruption
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StartScreen startScreen = new StartScreen();
            startScreen.setVisible(true);
        });
    }

    private boolean isResetting = false;

    private void resetGame() {

        if (isResetting) {

            return;
        }

        isResetting = true;

        character.reset();
        character.setScore(0);
        isGameOver = false;

        soundManager.stopSound();
        SwingUtilities.getWindowAncestor(this).dispose();

        SwingUtilities.invokeLater(() -> {
            MapSelectionScreen mapSelectionScreen = new MapSelectionScreen();
            mapSelectionScreen.setVisible(true);

            isResetting = false;

        });

    }

}
