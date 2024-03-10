package ru.bcomms.documentservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.bcomms.documentservice.dto.CustomDocumentDto;
import ru.bcomms.documentservice.entity.CustomDocument;
import ru.bcomms.documentservice.entity.InternalAttachment;
import ru.bcomms.documentservice.repository.CustomDocumentRepository;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetUrlRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

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

    public InternalAttachment upload(MultipartFile file) throws IOException {
        String keyName = file.getOriginalFilename();

        byte[] data = file.getBytes();
        // File CRC32 checksum
        Checksum crc32 = new CRC32();
        crc32.update(data, 0, data.length);
        String checksum = String.valueOf(crc32.getValue());
        // Upload file
        s3Client
                .putObject(PutObjectRequest
                                .builder()
                                .bucket(BUCKET)
                                .key(keyName)
                                .checksumCRC32(checksum)
                                .build(),
                        RequestBody.fromBytes(data));
        // Get uploaded file attr
        GetUrlRequest request = GetUrlRequest.builder().bucket(BUCKET).key(keyName).build();

        InternalAttachment attachment = new InternalAttachment();
        attachment.setName(s3Client.utilities().getUrl(request).toExternalForm());
        attachment.setUuid(UUID.randomUUID());
        attachment.setChecksum(checksum);

        return attachment;
    }

    public CustomDocument save(CustomDocumentDto entity) {
        return repository.save(modelMapper.map(entity, CustomDocument.class));
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
