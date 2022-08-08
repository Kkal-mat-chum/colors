package com.ssafy.colors.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.internal.Mimetypes;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.util.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Service
public class S3Service {
    private AmazonS3 s3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Value("${cloud.aws.region.static}")
    private String region;

    @PostConstruct
    public void setS3Client() {

        s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(this.region)
                .build();
    }

    public String uploadImage(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String mimeType = Mimetypes.getInstance().getMimetype(fileName);
        System.out.println("filename: " + fileName);
        System.out.println(mimeType);



        ObjectMetadata objMeta = new ObjectMetadata();
        objMeta.setContentType(mimeType);
        byte[] bytes = IOUtils.toByteArray(file.getInputStream());
        objMeta.setContentLength(bytes.length);

        ByteArrayInputStream byteArrayIs = new ByteArrayInputStream(bytes);

//        PutObjectRequest putObjReq = new PutObjectRequest(bucketName, key, byteArrayIs, objMeta);
//        s3client.putObject(putObjReq);


        s3Client.putObject(new PutObjectRequest(bucket, fileName, byteArrayIs, objMeta)
                .withCannedAcl(CannedAccessControlList.PublicRead));
        return s3Client.getUrl(bucket, fileName).toString();
    }
}
