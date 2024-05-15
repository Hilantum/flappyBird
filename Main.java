import components.*;

public class Main implements Runnable {
   private GamePanel panel;
   private GameFrame frame;

   public Main() {
      panel = new GamePanel();
      frame = new GameFrame(panel);

      Thread thread = new Thread(this);
      thread.start();
   }

   @Override public void run() {
      double frameTime = 1000000000 / Config.MAX_FRAMES;
      double tickTime = 1000000000 / Config.MAX_TICKS;
      double frameDelta = 0, tickDelta = 0;

      long lastSecondNano = System.nanoTime();
      long lastDeltaNano = System.nanoTime();

      int numFrames = 0, numTicks = 0;

      while (true) {
         long currentNano = System.nanoTime();

         frameDelta += (currentNano - lastDeltaNano) / frameTime;
         tickDelta += (currentNano - lastDeltaNano) / tickTime;
         lastDeltaNano = currentNano;

         if (tickDelta >= 1) {
            panel.getEnvironment().update();
            panel.getPlayer().update();
            tickDelta -= 1;
            numTicks += 1;
         }

         if (frameDelta >= 1) {
            panel.repaint();
            frameDelta -= 1;
            numFrames += 1;
         }

         if (currentNano - lastSecondNano >= 1000000000) {
            System.out.println("FPS: " + numFrames + " TICKS: " + numTicks);
            lastSecondNano = currentNano;
            numFrames = 0;
            numTicks = 0;
         }
      }
   }

   public static void main(String[] args) {
      new Main();
   }
}
