
package org.jangaon.familyfriendsservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class IOService {

    public void createNewFile(MultipartFile multipartFile) throws IOException {
        InputStream inputStream = multipartFile.getInputStream();
        System.out.println(inputStream.read());
        System.out.println(inputStream.read());
        File f1 = new File("New.txt");
        FileOutputStream fos = new FileOutputStream(f1);
        FileInputStream fis = new FileInputStream(f1);
//        fos.write(inputStream);

    }
}
