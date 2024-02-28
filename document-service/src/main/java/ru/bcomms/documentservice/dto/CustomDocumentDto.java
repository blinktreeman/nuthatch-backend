package ru.bcomms.documentservice.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CustomDocumentDto {
    protected DocumentType typeOfDocument;
    protected List<String> fieldValues = new ArrayList<>();
    protected Date date;
    protected Date expirationDate;
    protected InternalAttachment attachment;

    @Data
    public class DocumentType {
        protected String typeOfDocument;
        protected String description;
        protected List<String> documentFields = new ArrayList<>();
    }

    @Data
    public class InternalAttachment {
        protected MultipartFile documentFile;
        protected String name;
        protected String description;
        protected String checksum;
    }
}
