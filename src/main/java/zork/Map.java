package zork;

import zork.rooms.Room;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @Author: Alex Smolders & Silvan Dubach
 * @Date: 27.01.22
 * @Version: 1.1
 *
 */

public class Map {

    /**
     *
     * @param mapName -> name of current room
     * @throws IOException
     */

    public static void map(String mapName) throws IOException {
        final Path fileName = Path.of("src/main/resources/maps/" + mapName + ".txt");
        System.out.println(Files.readString(fileName));
    }
}
