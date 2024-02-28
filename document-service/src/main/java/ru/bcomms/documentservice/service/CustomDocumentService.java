package ru.bcomms.documentservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.bcomms.documentservice.dto.CustomDocumentDto;
import ru.bcomms.documentservice.entity.CustomDocument;
import ru.bcomms.documentservice.repository.CustomDocumentRepository;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetUrlRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomDocumentService {
    private final CustomDocumentRepository repository;
    private final ModelMapper modelMapper;
    private final S3Client s3Client;
    private final String BUCKET = "bcomms-01";

    @Autowired
    public CustomDocumentService(CustomDocumentRepository repository,
                                 ModelMapper modelMapper,
                                 S3Client s3Client) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.s3Client = s3Client;
    }

//    public String upload(MultipartFile file) throws IOException {
//        String keyName = file.getOriginalFilename();
//        System.out.println(s3Client.listBuckets());
//        s3Client
//                .putObject(PutObjectRequest
//                                .builder()
//                                .bucket(BUCKET)
//                                .key(keyName)
//                                .build(),
//                        RequestBody.fromBytes(file.getBytes()));
//        GetUrlRequest request = GetUrlRequest.builder().bucket(BUCKET).key(keyName).build();
//        String fileLink = s3Client.utilities().getUrl(request).toExternalForm();
//        return fileLink;
//    }

    public CustomDocument save(CustomDocumentDto entity) throws IOException {
        MultipartFile file = entity.getAttachment().getDocumentFile();
        String keyName = file.getOriginalFilename();
        s3Client
                .putObject(PutObjectRequest
                                .builder()
                                .bucket(BUCKET)
                                .key(keyName)
                                .build(),
                        RequestBody.fromBytes(file.getBytes()));
        GetUrlRequest request = GetUrlRequest
                .builder()
                .bucket(BUCKET)
                .key(keyName)
                .build();
        String fileLink = s3Client.utilities().getUrl(request).toExternalForm();
        CustomDocument document = modelMapper.map(entity, CustomDocument.class);
        document.getAttachment().setName(fileLink);
        return repository.save(document);
    }

    public Optional<CustomDocument> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public Iterable<CustomDocument> findAll() {
        return repository.findAll();
    }

    public CustomDocument update(CustomDocument entity) {
        return repository.save(entity);
    }

    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
