package zork;

import zork.rooms.Room;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Map {

    public static void map(String mapName) throws IOException {
        final Path fileName = Path.of("src/main/resources/maps/" + mapName + ".txt");

        System.out.println(Files.readString(fileName));
    }
}
