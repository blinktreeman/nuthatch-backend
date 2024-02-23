package ru.bcomms.organizationandrepresentative.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Описание комплексного типа: DocRequisitesWithOptionalSignaturesFiles.
 * Информация о документе (наименование, номер, дата, срок действия (необяз.),
 * файл документа, массив файлов подписей (необяз.))
 */
@Data
@Entity
@Table(name = "doc_requisites")
public class DocRequisites implements Serializable {
    @Id
    @GeneratedValue
    private UUID uuid;
    /**
     * Наименование, номер и дата документа.
     * Обязательный элемент
     */
    @Embedded
    private DocInfoGroup docInfoGroup;
    /**
     * Срок действия.
     * Необязательный элемент
     * Дата в формате <ГГГГ-ММ-ДД> (год-месяц-день)
     */
    private Date expirationDate;
    /**
     * Файл документа.
     * Обязательный элемент
     */
    @Embedded
    private InternalAttachment file;
    /**
     * Файлы подписей документа.
     * Необязательный элемент
     * Список/Set
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "doc_signature",
            joinColumns = @JoinColumn(name = "doc_requisites_uuid"),
            inverseJoinColumns = @JoinColumn(name = "signature_files_list_item_uuid")
    )
    private Set<SignatureFilesListItem> signatureFilesList = new HashSet<>();
}
