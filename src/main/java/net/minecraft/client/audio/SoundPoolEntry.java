package net.minecraft.client.audio;


import java.net.URL;

public class SoundPoolEntry {

    public String soundName;
    public URL soundUrl;
    public SoundPoolEntry(String s, URL url) {
        soundName = s;
        soundUrl = url;
    }
}
