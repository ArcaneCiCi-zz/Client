package net.minecraft.client.setting;


import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

import java.io.*;

public class GameSettings {

    private static final String[] RENDER_DISTANCES = {
            "FAR", "NORMAL", "SHORT", "TINY"
    };
    private static final String[] DIFFICULTY_LEVELS = {
            "Peaceful", "Easy", "Normal", "Hard"
    };
    public float musicVolume;
    public float soundVolume;
    public float mouseSensitivity;
    public boolean invertMouse;
    public int renderDistance;
    public boolean viewBobbing;
    public boolean anaglyph;
    public boolean limitFramerate;
    public boolean fancyGraphics;
    public String skin;
    public KeyBinding keyBindForward;
    public KeyBinding keyBindLeft;
    public KeyBinding keyBindBack;
    public KeyBinding keyBindRight;
    public KeyBinding keyBindJump;
    public KeyBinding keyBindInventory;
    public KeyBinding keyBindDrop;
    public KeyBinding keyBindChat;
    public KeyBinding keyBindToggleFog;
    public KeyBinding keyBindSneak;
    public KeyBinding[] keyBindings;
    public int numberOfOptions;
    public int difficulty;
    public boolean thirdPersonView;
    public String field_12259_z;
    protected Minecraft mc;
    private File optionsFile;
    public GameSettings(Minecraft minecraft, File file) {
        musicVolume = 1.0F;
        soundVolume = 1.0F;
        mouseSensitivity = 0.5F;
        invertMouse = false;
        renderDistance = 0;
        viewBobbing = true;
        anaglyph = false;
        limitFramerate = false;
        fancyGraphics = true;
        skin = "Default";
        keyBindForward = new KeyBinding("Forward", 17);
        keyBindLeft = new KeyBinding("Left", 30);
        keyBindBack = new KeyBinding("Back", 31);
        keyBindRight = new KeyBinding("Right", 32);
        keyBindJump = new KeyBinding("Jump", 57);
        keyBindInventory = new KeyBinding("Inventory", 23);
        keyBindDrop = new KeyBinding("Drop", 16);
        keyBindChat = new KeyBinding("Chat", 20);
        keyBindToggleFog = new KeyBinding("Toggle fog", 33);
        keyBindSneak = new KeyBinding("Sneak", 42);
        keyBindings = (new KeyBinding[]{
                keyBindForward, keyBindLeft, keyBindBack, keyBindRight, keyBindJump, keyBindSneak, keyBindDrop, keyBindInventory, keyBindChat, keyBindToggleFog
        });
        numberOfOptions = 10;
        difficulty = 2;
        thirdPersonView = false;
        field_12259_z = "";
        mc = minecraft;
        optionsFile = new File(file, "options.txt");
        loadOptions();
    }
    public GameSettings() {
        musicVolume = 1.0F;
        soundVolume = 1.0F;
        mouseSensitivity = 0.5F;
        invertMouse = false;
        renderDistance = 0;
        viewBobbing = true;
        anaglyph = false;
        limitFramerate = false;
        fancyGraphics = true;
        skin = "Default";
        keyBindForward = new KeyBinding("Forward", 17);
        keyBindLeft = new KeyBinding("Left", 30);
        keyBindBack = new KeyBinding("Back", 31);
        keyBindRight = new KeyBinding("Right", 32);
        keyBindJump = new KeyBinding("Jump", 57);
        keyBindInventory = new KeyBinding("Inventory", 23);
        keyBindDrop = new KeyBinding("Drop", 16);
        keyBindChat = new KeyBinding("Chat", 20);
        keyBindToggleFog = new KeyBinding("Toggle fog", 33);
        keyBindSneak = new KeyBinding("Sneak", 42);
        keyBindings = (new KeyBinding[]{
                keyBindForward, keyBindLeft, keyBindBack, keyBindRight, keyBindJump, keyBindSneak, keyBindDrop, keyBindInventory, keyBindChat, keyBindToggleFog
        });
        numberOfOptions = 10;
        difficulty = 2;
        thirdPersonView = false;
        field_12259_z = "";
    }

    public String getKeyBinding(int i) {
        return (new StringBuilder()).append(keyBindings[i].keyDescription).append(": ").append(Keyboard.getKeyName(keyBindings[i].keyCode)).toString();
    }

    public void setKeyBinding(int i, int j) {
        keyBindings[i].keyCode = j;
        saveOptions();
    }

    public void setOptionFloatValue(int i, float f) {
        if (i == 0) {
            musicVolume = f;
            mc.sndManager.onSoundOptionsChanged();
        }
        if (i == 1) {
            soundVolume = f;
            mc.sndManager.onSoundOptionsChanged();
        }
        if (i == 3) {
            mouseSensitivity = f;
        }
    }

    public void setOptionValue(int setting, int j) {
        if (setting == 2) {
            invertMouse = !invertMouse;
        }
        if (setting == 4) {
            renderDistance = renderDistance + j & 3;
        }
        if (setting == 5) {
            viewBobbing = !viewBobbing;
        }
        if (setting == 6) {
            anaglyph = !anaglyph;
            mc.renderEngine.refreshTextures();
        }
        if (setting == 7) {
            limitFramerate = !limitFramerate;
        }
        if (setting == 8) {
            difficulty = difficulty + j & 3;
        }
        if (setting == 9) {
            fancyGraphics = !fancyGraphics;
            mc.renderGlobal.loadRenderers();
        }
        saveOptions();
    }

    public int getOptionControlType(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 1;
        }
        return i != 3 ? 0 : 1;
    }

    public float getOptionFloatValue(int i) {
        if (i == 0) {
            return musicVolume;
        }
        if (i == 1) {
            return soundVolume;
        }
        if (i == 3) {
            return mouseSensitivity;
        } else {
            return 0.0F;
        }
    }

    public String getOptionDisplayString(int i) {
        if (i == 0) {
            return (new StringBuilder()).append("Music: ").append(musicVolume <= 0.0F ? "OFF" : (new StringBuilder()).append((int) (musicVolume * 100F)).append("%").toString()).toString();
        }
        if (i == 1) {
            return (new StringBuilder()).append("Sound: ").append(soundVolume <= 0.0F ? "OFF" : (new StringBuilder()).append((int) (soundVolume * 100F)).append("%").toString()).toString();
        }
        if (i == 2) {
            return (new StringBuilder()).append("Invert mouse: ").append(invertMouse ? "ON" : "OFF").toString();
        }
        if (i == 3) {
            if (mouseSensitivity == 0.0F) {
                return "Sensitivity: *yawn*";
            }
            if (mouseSensitivity == 1.0F) {
                return "Sensitivity: HYPERSPEED!!!";
            } else {
                return (new StringBuilder()).append("Sensitivity: ").append((int) (mouseSensitivity * 200F)).append("%").toString();
            }
        }
        if (i == 4) {
            return (new StringBuilder()).append("Render distance: ").append(RENDER_DISTANCES[renderDistance]).toString();
        }
        if (i == 5) {
            return (new StringBuilder()).append("View bobbing: ").append(viewBobbing ? "ON" : "OFF").toString();
        }
        if (i == 6) {
            return (new StringBuilder()).append("3d anaglyph: ").append(anaglyph ? "ON" : "OFF").toString();
        }
        if (i == 7) {
            return (new StringBuilder()).append("Limit framerate: ").append(limitFramerate ? "ON" : "OFF").toString();
        }
        if (i == 8) {
            return (new StringBuilder()).append("Difficulty: ").append(DIFFICULTY_LEVELS[difficulty]).toString();
        }
        if (i == 9) {
            return (new StringBuilder()).append("Graphics: ").append(fancyGraphics ? "FANCY" : "FAST").toString();
        } else {
            return "";
        }
    }

    public void loadOptions() {
        try {
            if (!optionsFile.exists()) {
                return;
            }
            BufferedReader bufferedreader = new BufferedReader(new FileReader(optionsFile));
            for (String s = ""; (s = bufferedreader.readLine()) != null; ) {
                String[] as = s.split(":");
                if (as[0].equals("music")) {
                    musicVolume = parseFloat(as[1]);
                }
                if (as[0].equals("sound")) {
                    soundVolume = parseFloat(as[1]);
                }
                if (as[0].equals("mouseSensitivity")) {
                    mouseSensitivity = parseFloat(as[1]);
                }
                if (as[0].equals("invertYMouse")) {
                    invertMouse = as[1].equals("true");
                }
                if (as[0].equals("viewDistance")) {
                    renderDistance = Integer.parseInt(as[1]);
                }
                if (as[0].equals("bobView")) {
                    viewBobbing = as[1].equals("true");
                }
                if (as[0].equals("anaglyph3d")) {
                    anaglyph = as[1].equals("true");
                }
                if (as[0].equals("limitFramerate")) {
                    limitFramerate = as[1].equals("true");
                }
                if (as[0].equals("difficulty")) {
                    difficulty = Integer.parseInt(as[1]);
                }
                if (as[0].equals("fancyGraphics")) {
                    fancyGraphics = as[1].equals("true");
                }
                if (as[0].equals("skin")) {
                    skin = as[1];
                }
                if (as[0].equals("lastServer")) {
                    field_12259_z = as[1];
                }
                int i = 0;
                while (i < keyBindings.length) {
                    if (as[0].equals((new StringBuilder()).append("key_").append(keyBindings[i].keyDescription).toString())) {
                        keyBindings[i].keyCode = Integer.parseInt(as[1]);
                    }
                    i++;
                }
            }

            bufferedreader.close();
        } catch (Exception exception) {
            System.out.println("Failed to load options");
            exception.printStackTrace();
        }
    }

    private float parseFloat(String s) {
        if (s.equals("true")) {
            return 1.0F;
        }
        if (s.equals("false")) {
            return 0.0F;
        } else {
            return Float.parseFloat(s);
        }
    }

    public void saveOptions() {
        try {
            PrintWriter printwriter = new PrintWriter(new FileWriter(optionsFile));
            printwriter.println((new StringBuilder()).append("music:").append(musicVolume));
            printwriter.println((new StringBuilder()).append("sound:").append(soundVolume));
            printwriter.println((new StringBuilder()).append("invertYMouse:").append(invertMouse));
            printwriter.println((new StringBuilder()).append("mouseSensitivity:").append(mouseSensitivity));
            printwriter.println((new StringBuilder()).append("viewDistance:").append(renderDistance));
            printwriter.println((new StringBuilder()).append("bobView:").append(viewBobbing));
            printwriter.println((new StringBuilder()).append("anaglyph3d:").append(anaglyph));
            printwriter.println((new StringBuilder()).append("limitFramerate:").append(limitFramerate));
            printwriter.println((new StringBuilder()).append("difficulty:").append(difficulty));
            printwriter.println((new StringBuilder()).append("fancyGraphics:").append(fancyGraphics));
            printwriter.println((new StringBuilder()).append("skin:").append(skin));
            printwriter.println((new StringBuilder()).append("lastServer:").append(field_12259_z));
            for (int i = 0; i < keyBindings.length; i++) {
                printwriter.println((new StringBuilder()).append("key_").append(keyBindings[i].keyDescription).append(":").append(keyBindings[i].keyCode));
            }

            printwriter.close();
        } catch (Exception exception) {
            System.out.println("Failed to save options");
            exception.printStackTrace();
        }
    }

}
