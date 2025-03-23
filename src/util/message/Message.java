package util.message;

import java.util.List;

public class Message {
    public void print(String str){
        System.out.print(str);
    }
    public void println(String str){
        System.out.println(str);
    }
    public void printf(String format, Object... args) {
        System.out.printf(format, args);
    }
    public void textBox(List<String> lore) {
        int width = 60;
        String border = "┌" + "─".repeat(width) + "┐";

        println(border);
        for (String line : lore) {
            printf(" %-"+ (width - 2) +"s %n", line);
        }
        println("└" + "─".repeat(width) + "┘");
    }
}
