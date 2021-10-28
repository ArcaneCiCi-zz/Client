package net.minecraft.client.misc;


import paulscode.sound.codecs.CodecJOrbis;

import java.io.IOException;
import java.io.InputStream;

public class CodecMus extends CodecJOrbis {

    public CodecMus() {

    }

    protected InputStream openInputStream() {
        try {
			return new MusInputStream(this, url, urlConnection.getInputStream());
		} catch (IOException e) {
			return null;
		}
    }
}
