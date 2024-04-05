package ru.bcomms.buildingobject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Описание комплексного типа: PermanentObjectInfo
 * Объект капительного строительства
 */
@Data
@Entity
public class PermanentObjectInfo implements Serializable {
    @Id
    @GeneratedValue
    protected UUID uuid;
    /**
     * Наименование объекта (этапа)
     * Обязательный элемент
     * Минимум 1 символ
     */
    protected String permanentObjectName;
    /**
     * Информация об адресе обьекта (Почтовом или строительном)
     * Обязательный элемент
     */
    @Embedded
    protected PostalOrConstructionSiteAddress permanentObjectAddress;
    /**
     * Наименование вида строительства
     * Обязательный элемент
     * Наложенные ограничения –только одно из значений:
     * - строительство
     * - реконструкция
     * - капитальный ремонт
     */
    @Enumerated(EnumType.STRING)
    protected ConstructionTypeName constructionTypeName;
    /**
     * Обязательный элемент (одно значение из элементов типа):
     * developerWithRepresentatives,
     * operatingPersonWithRepresentatives,
     * regionalOperatorWithRepresentatives
     * --
     * Застройщик и его представители
     */
    protected UUID developerWithRepresentatives;
    /**
     * Лицо, ответственное за эксплуатацию здания/сооружения и его представители
     */
    protected UUID operatingPersonWithRepresentatives;
    /**
     * Региональный оператор и его представители
     */
    protected UUID regionalOperatorWithRepresentatives;
    /**
     * Технический заказчик и его представители
     * Необязательный элемент
     */
    protected UUID technicalCustomerWithRepresentatives;
    /**
     * Лицо, осуществляющее подготовку проектной документации
     * Обязательный элемент
     */
    protected UUID projectDocumentationContractor;
    /**
     * Лицо, осуществляющее строительство и его представители
     * Обязательный элемент
     */
    protected UUID buildingContractorWithRepresentatives;
    /**
     * Другие лица, осуществляющие строительство, их уполномоченные представители
     * Необязательный элемент
     * Список
     */
    @ElementCollection
    protected List<UUID> otherDevelopersRepresentativesList = new ArrayList<>();
    /**
     * Сведения о государственном строительном надзоре
     * Обязательный элемент
     */
    protected SupervisoryAuthority supervisoryAuthority;
    /**
     * Сведения о разрешении на строительство
     * Необязательный элемент
     */
    protected ExecutiveAuthorityDocInfo permissionToConstructionRoot;
    /**
     * Сведения о государственной экспертизе проектной документации в случаях, предусмотренных
     * статьей 49 Градостроительного кодекса Российской Федерации
     * Необязательный элемент
     */
    protected ProjectDocumentationExaminationDetails projectDocumentationExaminationDetails;
    /**
     * Общие сведения об объекте капитального строительства
     * Обязательный элемент
     */
    protected PermanentObjectCommonInfo permanentObjectCommonInfo;
}
