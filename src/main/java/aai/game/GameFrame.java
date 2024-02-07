package aai.game;

import aai.behaviour.SeekBehaviour;
import aai.entity.Vehicle;
import aai.util.Vector2D;
import aai.world.World;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * Created by gh0073874 on 13-2-2017.
 */
public class GameFrame extends JFrame implements Runnable, MouseInputListener {

    final int TARGET_FPS = 60;
    final long OPTIMAL_TIME = 1000000 / TARGET_FPS;

    private boolean running = false;

    private JPanel panel;
    private World world;

    private BufferedImage buffer = null;

    public GameFrame(String name, int width, int height) throws HeadlessException {
        super(name);

        world = new World(width, height);
        buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB );

        Vehicle vehicle = new Vehicle(width/2, height/2, world);
        vehicle.setBehaviour(new SeekBehaviour(vehicle, world.getTarget()));
        world.addEntity(vehicle);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(width, height));
        panel.addMouseListener(this);
        panel.setDoubleBuffered(true);
        add(panel);

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void update(float delta) {
        world.update(delta);
    }

    public void render() {
        Graphics g = buffer.getGraphics();
        world.render(g);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        panel.getGraphics().drawImage(buffer, 0, 0, this);
    }

    @Override
    public void run() {

        long lastUpdateTime = System.currentTimeMillis();
        running = true;

        while (running) {
            lastUpdateTime = System.currentTimeMillis();

            render();
            update(0.1f);

            try {
                Thread.sleep((lastUpdateTime - System.currentTimeMillis() + OPTIMAL_TIME) / 1000);
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {
            world.setTarget(new Vector2D(e.getX(), e.getY()));
        } else if(e.getButton() == MouseEvent.BUTTON3) {
            world.clearTarget();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}