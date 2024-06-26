package kr.kro.izen.rpgarena.utill;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import kr.kro.izen.rpgarena.round.Round;
import org.bukkit.entity.Player;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class SaveJson {
    private final Gson gson = new Gson();

    public void saveLog(Player player) {
        Path path = Path.of("./plugins/RPGArena/" + player.getName() + ".json");
        if (Files.notExists(path)) {
            try {
                Files.createDirectories(path.getParent());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path.toFile()))) {
            gson.toJson(Round.roundMap, bufferedWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadLog(Player player) {
        Path path = Path.of("./plugins/RPGArena/" + player.getName() + ".json");
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            Type type = new TypeToken<Map<String, Integer>>() {}.getType();
            Map<String, Integer> data = gson.fromJson(reader, type);
            if (data != null) {
                Round.roundMap.putAll(data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
