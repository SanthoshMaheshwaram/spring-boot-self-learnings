
package org.jangaon.familyfriendsservice.controller;

import org.jangaon.familyfriendsservice.service.IOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController()
@RequestMapping("/fAndFServices/IO")
public class InputOutputStreamController {

    @Autowired
    IOService ioService;

    //1. take the input file and write into a different file, using FileInputStream and FileOutputStream
    @PostMapping("/readInputFile")
    public void readInputFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        ioService.createNewFile(multipartFile);
    }

    //2. take and input as an input, and then write the data of another file into this empty file

    //3. create some java object and store that object into a file (called serialization, object state -> byte stream)

    //4. similarly, convert the file's byte stream data into a java object.

    //5. write some data into a file using buffered output streams

    //6. read some data from the file using buffered input streams

}
