package net.minecraft.client.entity.player.skin;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.Scanner;

/**
 * @author ArcaneCiCi
 */

public class SkinManager {

    public String getMinecraftID(String name) {

        String finalSkinUrl = "";
        URL apiURL;
        URL sessionURL;
        try {
            apiURL = new URL("https://api.mojang.com/users/profiles/minecraft/" + name);
            HttpURLConnection connectionGay = (HttpURLConnection) apiURL.openConnection();

            connectionGay.setRequestMethod("GET");
            connectionGay.connect();

            int whatTheFuck = connectionGay.getResponseCode();

            if (whatTheFuck != 200) {
                System.err.println("[MC] Skins will not work at this time because someone spilled water on them");
            } else {
                StringBuilder inline = new StringBuilder();
                Scanner scanner = new Scanner(apiURL.openStream());

                while (scanner.hasNext()) {
                    inline.append(scanner.nextLine());
                }

                scanner.close();
                JsonParser parser = new JsonParser();
                JsonObject data_obj = (JsonObject) parser.parse(inline.toString());
                JsonElement playerID = data_obj.get("id");
                String finalID = playerID.getAsString().replace("\"", "");

                sessionURL = new URL("https://sessionserver.mojang.com/session/minecraft/profile/" + finalID);
                StringBuilder inline2 = new StringBuilder();
                Scanner scanner2 = new Scanner(sessionURL.openStream());

                while (scanner2.hasNext()) {
                    inline2.append(scanner2.nextLine());
                }

                scanner2.close();
                JsonParser parser2 = new JsonParser();
                JsonObject data_obj2 = (JsonObject) parser2.parse(inline2.toString());
                JsonArray base = (JsonArray) data_obj2.get("properties");
                String base64 = base.toString().replace("[{\"name\":\"textures\",\"value\":\"", "").replace("\"}]", "");

                String decodedBase64 = new String(Base64.getDecoder().decode(base64.getBytes()));

                StringBuilder finalString = new StringBuilder();
                Scanner whatever = new Scanner(decodedBase64);

                while (whatever.hasNext()) {
                    finalString.append(whatever.nextLine());
                }
                whatever.close();


                System.out.println(finalString);

                JsonParser parser3 = new JsonParser();
                JsonObject data_obj3 = (JsonObject) parser3.parse(finalString.toString());
                JsonElement playerID3 = data_obj3.get("textures");

                finalSkinUrl = playerID3.toString().replace("{\"SKIN\":{\"url\":\"", "").replace("\"}}", "");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return finalSkinUrl;
    }

}
