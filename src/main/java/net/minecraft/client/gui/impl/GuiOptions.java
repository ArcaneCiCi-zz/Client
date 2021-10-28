package net.minecraft.client.gui.impl;


import net.minecraft.client.setting.GameSettings;

public class GuiOptions extends GuiScreen {

    private final GuiScreen parentScreen;
    private final GameSettings options;
    protected String screenTitle;

    public GuiOptions(GuiScreen guiscreen, GameSettings gamesettings) {
        screenTitle = "Options";
        parentScreen = guiscreen;
        options = gamesettings;
    }

    public void initGui() {
        for (int i = 0; i < options.numberOfOptions; i++) {
            int j = options.getOptionControlType(i);
            if (j == 0) {
                controlList.add(new GuiSmallButton(i, (width / 2 - 155) + (i % 2) * 160, height / 6 + 24 * (i >> 1), options.getOptionDisplayString(i)));
            } else {
                controlList.add(new GuiSlider(i, (width / 2 - 155) + (i % 2) * 160, height / 6 + 24 * (i >> 1), i, options.getOptionDisplayString(i), options.getOptionFloatValue(i)));
            }
        }

        controlList.add(new GuiButton(100, width / 2 - 100, height / 6 + 120 + 12, "Controls..."));
        controlList.add(new GuiButton(200, width / 2 - 100, height / 6 + 168, "Done"));
    }

    protected void actionPerformed(GuiButton guibutton) {
        if (!guibutton.enabled) {
            return;
        }
        if (guibutton.id < 100) {
            options.setOptionValue(guibutton.id, 1);
            guibutton.displayString = options.getOptionDisplayString(guibutton.id);
        }
        if (guibutton.id == 100) {
            mc.gameSettings.saveOptions();
            mc.displayGuiScreen(new GuiControls(this, options));
        }
        if (guibutton.id == 200) {
            mc.gameSettings.saveOptions();
            mc.displayGuiScreen(parentScreen);
        }
    }

    public void drawScreen(int i, int j, float f) {
        drawDefaultBackground();
        drawCenteredString(fontRenderer, screenTitle, width / 2, 20, 0xffffff);
        super.drawScreen(i, j, f);
    }
}
