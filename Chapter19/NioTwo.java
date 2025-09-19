package Chapter19;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class NioTwo{

    public static void readFile(String src) throws IOException {
        File f = new File(src);
        try(var in = new FileInputStream(f)){
            int b;
            while ((b = in.read()) != -1) {
                System.out.print((char)b);
            }
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static List<String> readAllLines(String src) {
        List<String> lines = new ArrayList<>();
        File f = new File(src);
        try (var in = new FileInputStream(f);
            var reader = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return lines;
    }

    public static void writeFile(String dest,String words, boolean append){
        File f = new File(dest);
        try (var out = new FileOutputStream(f,append)) {
            byte[] bytes = words.getBytes();
            out.write(bytes);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception{
        //readFile("C:\\dev\\sandbox\\github\\Java_OCP_Samples\\Chapter19\\sample.txt");
        writeFile("C:\\dev\\sandbox\\github\\Java_OCP_Samples\\Chapter19\\output.txt","Hello File",false);
        writeFile("C:\\dev\\sandbox\\github\\Java_OCP_Samples\\Chapter19\\output.txt","\n",true);
        writeFile("C:\\dev\\sandbox\\github\\Java_OCP_Samples\\Chapter19\\output.txt","Another line",true);
        List<String> lines= readAllLines("C:\\dev\\sandbox\\github\\Java_OCP_Samples\\Chapter19\\sample.txt");
        lines.stream().filter(s-> s.startsWith("L")).forEach(System.out::println);
    }


}