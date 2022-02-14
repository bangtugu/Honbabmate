package ssafy.singlemeal.file;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Slf4j
@Component
public class FileStore {

    @Value("${spring.servlet.multipart.location}")
    private String fileDir;

    public String getFullPath(String fileName){
        return fileDir + fileName;
    }

    public UploadFile storeFile(MultipartFile multipartFile) throws IOException {
        if(multipartFile.isEmpty())
            return null;

        String originalFileName = multipartFile.getOriginalFilename();
        String storeFileName = createStoreName(originalFileName);
        String fullPath = getFullPath(storeFileName);

        multipartFile.transferTo(new File(fullPath));

        return new UploadFile(originalFileName, storeFileName, fullPath);
    }

    public UploadFile storeUrltoFIle(String fileURL){
        String storeFileName = createStoreName(fileURL);
        String fullPath = getFullPath(storeFileName);

        try{
            URL url = new URL(fileURL);
            InputStream in = url.openStream();
            Files.copy(in, Paths.get(fullPath));
            in.close();
        }catch (IOException e){
            log.info(e.toString());
        }

        return new UploadFile(fileURL, storeFileName, fullPath);

    }

    private String createStoreName(String originalFileName) {
        String ext = extractExt(originalFileName);
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + ext;
    }

    private String extractExt(String originalFileName) {
        int pos = originalFileName.lastIndexOf(".");
        return originalFileName.substring(pos + 1);
    }


}
