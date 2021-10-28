package net.minecraft.client.thread;


import net.minecraft.client.interfaces.ImageBuffer;

import javax.imageio.ImageIO;
import java.net.HttpURLConnection;
import java.net.URL;

class ThreadDownloadImage extends Thread {

    final String location;
    final ImageBuffer buffer;
    final ThreadDownloadImageData imageData;
    ThreadDownloadImage(ThreadDownloadImageData threaddownloadimagedata, String s, ImageBuffer imagebuffer) {
        imageData = threaddownloadimagedata;
        location = s;
        buffer = imagebuffer;
    }

    public void run() {
        HttpURLConnection httpurlconnection = null;
        try {
            URL url = new URL(location);
            httpurlconnection = (HttpURLConnection) url.openConnection();
            httpurlconnection.setDoInput(true);
            httpurlconnection.setDoOutput(false);
            httpurlconnection.connect();
            if (httpurlconnection.getResponseCode() == 404) {
                return;
            }
            if (buffer == null) {
                imageData.image = ImageIO.read(httpurlconnection.getInputStream());
            } else {
                imageData.image = buffer.func_883_a(ImageIO.read(httpurlconnection.getInputStream()));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            httpurlconnection.disconnect();
        }
    }
}
