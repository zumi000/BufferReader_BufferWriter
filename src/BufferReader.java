import java.io.*;

public class BufferReader {
    public static String readFile(String fileName) {
        BufferedReader reader = null;
        StringBuilder result = new StringBuilder();

        try {
            reader = new BufferedReader(new FileReader(new java.io.File(fileName)));
            String line = null;

            while ((line = reader.readLine()) != null) {
                result.append(line).append(System.lineSeparator());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result.toString();
    }

    public static void writeContent(String fileName, String content) {
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(content);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void copyFile(String fromFileName, String toFileName) {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(fromFileName));
            writer = new BufferedWriter(new FileWriter(toFileName));
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line + "\n");
            }
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void copyFile2 (String from, String to) {
        writeContent(to, readFile(from));
    }

    public static void main (String[]args){
        //writeContent("macska.txt", "kismacska");
        //System.out.println(readFile("./macska.txt"));
        copyFile("./macska.txt", "./kutya.txt");
    }
}


