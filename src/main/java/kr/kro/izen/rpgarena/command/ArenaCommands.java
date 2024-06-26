package kr.kro.izen.rpgarena.command;

import kr.kro.izen.rpgarena.game.GameSetup;
import kr.kro.izen.rpgarena.gui.ChoseWeapon;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class ArenaCommands extends BukkitCommand {
    public ArenaCommands(@NotNull String name, GameSetup gameSetup) {
        super(name);
        this.gameSetup = gameSetup;
    }

    private GameSetup gameSetup;
    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String command, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return false;
        if (args.length == 0) {
            player.sendMessage("올바르지 않은 사용법입니다. /arena < start, stop, logs >");
            return true;
        }
        if (args.length == 1) {
            switch (args[0]) {
                case "start" -> {
                    gameSetup.startGame(player);
                }
                case "stop" -> {
                    gameSetup.endGame(player);
                }
                case "logs" -> {
                    gameSetup.getLogs(player);
                }
            }
        }
        return false;
    }

    @Override
    public @NotNull List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) throws IllegalArgumentException {
        if (args.length == 1) return Arrays.asList("start","stop", "logs");
        return super.tabComplete(sender, alias, args);
    }
}
