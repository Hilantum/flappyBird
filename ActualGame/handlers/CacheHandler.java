package handlers;

import java.awt.image.*;
import javax.imageio.*;
import java.util.*;
import java.io.*;


public class CacheHandler {
    private Map<String, BufferedImage> cache;

    public CacheHandler() {
        cache = new LinkedHashMap<String, BufferedImage>(100, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, BufferedImage> eldest) {
                return size() > 100;
            }
        };
    }

    public BufferedImage loadImage(String imagePath) {
        BufferedImage image = cache.get(imagePath);
        
        if (image == null) {
            try (InputStream inputStream = getClass().getResourceAsStream(imagePath)) {
                if (inputStream != null) {
                    image = ImageIO.read(inputStream);
                    cache.put(imagePath, image);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return image;
    }

    public void clearCache() {
        cache.clear();
    }
}