package ru.bcomms.incomingmaterialcontroljournal.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class DocumentResponseDto {
    protected UUID uuid;
    protected DocumentType documentType;
    protected List<String> fieldValues;
    protected Date expirationDate;
    protected InternalAttachment attachment;

    @Data
    protected static class DocumentType {
        protected UUID uuid;
        protected String typeOfDocument;
        protected String description;
        protected List<String> documentFields;
    }

    @Data
    protected static class InternalAttachment {
        protected UUID uuid;
        protected String name;
        protected String description;
        protected String checksum;
    }

}
