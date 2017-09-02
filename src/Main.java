import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        File myFile = new File("test");
        try {
            OutputStream os = new FileOutputStream(myFile);
            String myText = "test";
            os.write(myText.getBytes());
            byte[] myBytes = {0x17, 0x23, 0x18};

            char mychar = 't';
            byte value = (byte) mychar;
           // System.out.println(value);

            os.write(myBytes);
            os.close();
            //os.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStream is = null;
        try {
            is = new FileInputStream(myFile);
            int myData = 0;
            StringBuilder sb = new StringBuilder();

            do {
                myData = is.read();
                if (myData != -1)
                    sb.append((char)myData);
                //System.out.println((byte) myData);
            } while (myData > -1);
            System.out.println("my string is: " + sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(" ------------- ");
        File file = new File(".");
        String[] myStrings =  file.list();
        for (String myString : myStrings) {
            System.out.println(myString);
        }
        File[] myFiles = file.listFiles();
        for (File myFile1 : myFiles) {
            try {
                String currentName = myFile1.getCanonicalPath();
                if (currentName.contains("test")){
                    System.out.println("FILE FOUND!");
                    System.out.println("size in bytes: " + myFile1.length());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileReader fileReader = new FileReader("test2");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String readLine;
            System.out.println(" ----------- ");
            //while ((readLine = bufferedReader.readLine()) != null){
            readLine = bufferedReader.readLine();
            System.out.println(readLine);
            while (readLine != null){
                readLine = bufferedReader.readLine();
                if (readLine != null)
                    System.out.println(readLine);
            };
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(" readAllLines experiment");

        Path path = FileSystems.getDefault().getPath(".", "test2");
        try {
            List<String> myStrings2 = Files.readAllLines(path);
            for (String s : myStrings2) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //BufferedReader bufferedReader = new BufferedReader(fileReader);
        //bufferedReader.re



    }
}

