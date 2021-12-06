package ua.kovalev.prolesson3task2;

import ua.kovalev.prolesson3task2.annotations.SaveTo;
import ua.kovalev.prolesson3task2.annotations.Saver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@SaveTo(path="result.txt")
public class TextContainer {
    private String text = "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...";

    @Saver
    public void save(String path) {
        File file = new File(path);
        try(FileWriter fileWriter = new FileWriter(file)){
            fileWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
