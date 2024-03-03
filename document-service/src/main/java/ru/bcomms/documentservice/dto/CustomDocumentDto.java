package ru.bcomms.documentservice.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class CustomDocumentDto {
    protected DocumentType documentType;
    protected List<String> fieldValues = new ArrayList<>();
    protected Date date;
    protected Date expirationDate;
    protected InternalAttachment attachment;

    @Data
    public class DocumentType {
        protected UUID uuid;
        protected String typeOfDocument;
        protected String description;
        protected List<String> documentFields = new ArrayList<>();
    }

    @Data
    public class InternalAttachment {
        protected String name;
        protected String description;
        protected String checksum;
    }
}
