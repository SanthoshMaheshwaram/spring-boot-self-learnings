
package org.jangaon.familyfriendsservice;

import java.io.*;

public class InputOutputStreamsJava {
    public static void main(String[] args) throws IOException {
        InputStream fis = null;
        OutputStream fos = null;
        InputStream bufferedInputStream = null;
        OutputStream bufferedOutputStream = null;
        BufferedWriter bufferedWriter = null;
        BufferedReader bufferedReader = null;
        byte b[] = { 0, 1, 2, 68, 69 };
        try{
            //
            fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\SelfLearnings\\SPRING-BOOT-APPLICATIONS\\multi-module-project\\family-friends-service\\src\\main\\resources\\static\\InputFileOne.txt");
            System.out.println("first byte "+ (char) fis.read()); //read, give next byte (0-255)of the source data, ASCII values of representation
            System.out.println("second byte "+ (char) fis.read());
            fis.mark(0); //marks current position of input stream
            System.out.println("second byte "+ (char) fis.read());
            System.out.println("all byte "+ fis.readAllBytes());
            System.out.println("list of byte "+ fis.read(b));

            fos = new FileOutputStream("C:\\Users\\Admin\\Desktop\\SelfLearnings\\SPRING-BOOT-APPLICATIONS\\multi-module-project\\family-friends-service\\src\\main\\resources\\static\\InputFileOne.txt", true);
            fos.write('\n');
            String strAppend = "Please forgive me GOD";
            fos.write(strAppend.getBytes());
            fos.write('\n');
            fos.write(42);
            fos.flush();

            //bufferInputStream and bufferOutputStream
            bufferedInputStream = new BufferedInputStream(fis);
            System.out.println("Number of remaining bytes in bIS:" + bufferedInputStream.available());
            System.out.println("Char-1:" + (char) bufferedInputStream.read());
            System.out.println("Char-1:" + bufferedInputStream.readAllBytes());
            System.out.println("Char-2:" + bufferedInputStream.readNBytes(10));
            bufferedOutputStream = new BufferedOutputStream(fos);
            bufferedOutputStream.write(strAppend.getBytes());
            //buffer writer and buffer reader
            bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Admin\\Desktop\\SelfLearnings\\SPRING-BOOT-APPLICATIONS\\multi-module-project\\family-friends-service\\src\\main\\resources\\static\\InputFileOne.txt", true));
            bufferedWriter.write(strAppend);
            bufferedWriter.newLine();
            bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Admin\\Desktop\\SelfLearnings\\SPRING-BOOT-APPLICATIONS\\multi-module-project\\family-friends-service\\src\\main\\resources\\static\\InputFileOne.txt"));
            System.out.println(bufferedReader.readLine());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(fis!=null) fis.close();
            if(fos!=null) fos.close();
            if(bufferedInputStream!=null) bufferedInputStream.close();
//            if(bufferedOutputStream!=null) bufferedOutputStream.close();
            if(bufferedReader!=null) bufferedReader.close();
            if(bufferedWriter!=null) bufferedWriter.close();
        }
    }
}
