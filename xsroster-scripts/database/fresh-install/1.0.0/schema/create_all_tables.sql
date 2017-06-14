
spool create_roster_schema.log

prompt
prompt Creating table AC_PERMISSION
prompt ===============================================
prompt
create table AC_PERMISSION
(
  ID                                VARCHAR2(36 CHAR) not null,
  PERMISSION_SET                    VARCHAR2(36 CHAR)
)
;
alter table AC_PERMISSION add primary key (ID);

prompt
prompt Creating table AC_PERMISSION_SET
prompt ===============================================
prompt
create table AC_PERMISSION_SET
(
  ACTIVE                            NUMBER(1),
  CODE                              VARCHAR2(255 CHAR),
  CREATED_BY                        VARCHAR2(36 CHAR),
  CREATED_WHEN                      TIMESTAMP(6),
  DESCRIPTION                       VARCHAR2(1000 CHAR),
  ID                                VARCHAR2(36 CHAR) not null,
  MODIFIED_BY                       VARCHAR2(36 CHAR),
  MODIFIED_WHEN                     TIMESTAMP(6)
)
;
alter table AC_PERMISSION_SET add primary key (ID);
alter table AC_PERMISSION_SET add unique (CODE);

prompt
prompt Creating table ASSIGNING_AUTHORITY
prompt ===============================================
prompt
create table ASSIGNING_AUTHORITY
(
  CODE                              VARCHAR2(200 CHAR) not null,
  CREATED_BY                        VARCHAR2(36 CHAR),
  CREATED_WHEN                      TIMESTAMP(6),
  DESCRIPTION                       VARCHAR2(2000 CHAR),
  FACILITY                          VARCHAR2(36 CHAR) not null,
  ID                                VARCHAR2(36 CHAR) not null,
  MODIFIED_BY                       VARCHAR2(36 CHAR),
  MODIFIED_WHEN                     TIMESTAMP(6),
  NAME                              VARCHAR2(1000 CHAR)
)
;
alter table ASSIGNING_AUTHORITY add primary key (ID);
alter table ASSIGNING_AUTHORITY add unique (CODE);

prompt
prompt Creating table CALENDAR_DEFINITION
prompt ===============================================
prompt
create table CALENDAR_DEFINITION
(
  ACTIVE                            NUMBER(1),
  AUTO_CREATED                      NUMBER(1),
  CODE                              VARCHAR2(200 CHAR) not null,
  CREATED_BY                        VARCHAR2(36 CHAR),
  CREATED_WHEN                      TIMESTAMP(6),
  DESCRIPTION                       VARCHAR2(2000 CHAR),
  ID                                VARCHAR2(36 CHAR) not null,
  MODIFIED_BY                       VARCHAR2(36 CHAR),
  MODIFIED_WHEN                     TIMESTAMP(6),
  NAME                              VARCHAR2(1000 CHAR) not null,
  NAME_SOUNDEX                      VARCHAR2(1000 CHAR),
  VERSION                           NUMBER(19)
)
;
alter table CALENDAR_DEFINITION add primary key (ID);
alter table CALENDAR_DEFINITION add unique (CODE);

prompt
prompt Creating table CALENDAR_INSTANCE
prompt ===============================================
prompt
create table CALENDAR_INSTANCE
(
  CALENDAR_DEFINITION               VARCHAR2(36 CHAR),
  ID                                VARCHAR2(36 CHAR) not null
)
;
alter table CALENDAR_INSTANCE add primary key (ID);

prompt
prompt Creating table CODING_CODE
prompt ===============================================
prompt
create table CODING_CODE
(
  CATEGORY                          VARCHAR2(50 CHAR) not null,
  ID                                VARCHAR2(36 CHAR) not null
)
;
alter table CODING_CODE add primary key (ID);

prompt
prompt Creating table COMMON_NAMECODE
prompt ===============================================
prompt
create table COMMON_NAMECODE
(
  ACTIVE                            NUMBER(1),
  AUTO_CREATED                      NUMBER(1),
  CATEGORY                          VARCHAR2(255 CHAR),
  CATEGORY2                         VARCHAR2(255 CHAR),
  CATEGORY3                         VARCHAR2(255 CHAR),
  CODE                              VARCHAR2(200 CHAR) not null,
  CREATED_BY                        VARCHAR2(36 CHAR),
  CREATED_WHEN                      TIMESTAMP(6),
  DATA_TYPE                         VARCHAR2(50 CHAR),
  DESCRIPTION                       VARCHAR2(2000 CHAR),
  HL7_CODE                          VARCHAR2(255 CHAR),
  HL7_FIELD                         VARCHAR2(255 CHAR),
  HL7_TYPE                          VARCHAR2(255 CHAR),
  ICON                              BLOB,
  ID                                VARCHAR2(36 CHAR) not null,
  IDENTIFIER_TYPE_USAGE             VARCHAR2(100 CHAR),
  MODIFIED_BY                       VARCHAR2(36 CHAR),
  MODIFIED_WHEN                     TIMESTAMP(6),
  NAME                              VARCHAR2(1000 CHAR) not null,
  NAME_SOUNDEX                      VARCHAR2(1000 CHAR),
  ORDER_NR                          NUMBER(10),
  PARENT                            VARCHAR2(36 CHAR),
  TYPE                              VARCHAR2(50 CHAR) not null
)
;
alter table COMMON_NAMECODE add primary key (ID);

prompt
prompt Creating table COMMUNICATION_CHANNEL
prompt ===============================================
prompt
create table COMMUNICATION_CHANNEL
(
  ADDRESS_LINE1                     VARCHAR2(1000 CHAR),
  ADDRESS_LINE2                     VARCHAR2(500 CHAR),
  ADDRESS_LINE3                     VARCHAR2(500 CHAR),
  ADDRESS_LINE4                     VARCHAR2(500 CHAR),
  ALIAS                             VARCHAR2(255 CHAR),
  COMMENTS                          VARCHAR2(2000 CHAR),
  COMMUNICATION_TYPE                VARCHAR2(36 CHAR),
  COUNTRY                           VARCHAR2(100 CHAR),
  DAFAULT_FOR_DATA_TYPE             NUMBER(1),
  DEPARTMENT_ID                     VARCHAR2(36 CHAR),
  EMAIL                             VARCHAR2(100 CHAR),
  FACILITY_ID                       VARCHAR2(36 CHAR),
  ID                                VARCHAR2(36 CHAR) not null,
  IDENTITY_ID                       NUMBER(19),
  IDENTITY_TYPE                     CHAR(1 CHAR),
  INSTANT_MESSAGING                 VARCHAR2(100 CHAR),
  MOBILE_NUMBER                     VARCHAR2(50 CHAR),
  MUNICIPALITY                      VARCHAR2(100 CHAR),
  PATIENT_ID                        VARCHAR2(36 CHAR),
  PREFERRED                         NUMBER(1),
  PRINTER                           VARCHAR2(255 CHAR),
  PROFESSIONAL_ID                   VARCHAR2(36 CHAR),
  STREET                            VARCHAR2(500 CHAR),
  STREET_NR                         VARCHAR2(50 CHAR),
  TELEPHONE_NUMBER                  VARCHAR2(50 CHAR),
  TOWN                              VARCHAR2(255 CHAR),
  VALID_FROM                        TIMESTAMP(6),
  VALID_TILL                        TIMESTAMP(6),
  ZIP_CODE                          VARCHAR2(50 CHAR)
)
;
alter table COMMUNICATION_CHANNEL add primary key (ID);

prompt
prompt Creating table CONFIG_KEY
prompt ===============================================
prompt
create table CONFIG_KEY
(
  ACTIVE                            NUMBER(1),
  CREATED_BY                        VARCHAR2(36 CHAR),
  CREATED_WHEN                      TIMESTAMP(6),
  DATA_TYPE                         VARCHAR2(6 CHAR),
  ID                                VARCHAR2(36 CHAR) not null,
  KEY                               VARCHAR2(255 CHAR),
  LABEL                             VARCHAR2(1000 CHAR),
  MODIFIED_BY                       VARCHAR2(36 CHAR),
  MODIFIED_WHEN                     TIMESTAMP(6),
  NAME_SPACE                        VARCHAR2(36 CHAR),
  ON_DEPARTMENT                     NUMBER(1),
  ON_FACILITY                       NUMBER(1),
  ON_PROFILE                        NUMBER(1),
  ON_SYSTEM                         NUMBER(1),
  ON_USER                           NUMBER(1),
  SHOW_IN_PREFERENCES               NUMBER(1)
)
;
alter table CONFIG_KEY add primary key (ID);
alter table CONFIG_KEY add unique (KEY);

prompt
prompt Creating table CONFIG_NAME_SPACE
prompt ===============================================
prompt
create table CONFIG_NAME_SPACE
(
  ACTIVE                            NUMBER(1),
  CREATED_BY                        VARCHAR2(36 CHAR),
  CREATED_WHEN                      TIMESTAMP(6),
  ID                                VARCHAR2(36 CHAR) not null,
  LABEL                             VARCHAR2(1000 CHAR),
  MODIFIED_BY                       VARCHAR2(36 CHAR),
  MODIFIED_WHEN                     TIMESTAMP(6),
  NAME                              VARCHAR2(255 CHAR),
  SHOW_IN_PREFERENCES               NUMBER(1)
)
;
alter table CONFIG_NAME_SPACE add primary key (ID);
alter table CONFIG_NAME_SPACE add unique (NAME);

prompt
prompt Creating table CONFIG_VALUE
prompt ===============================================
prompt
create table CONFIG_VALUE
(
  BLOB_VALUE                        VARCHAR2(36 CHAR),
  BOOLEAN_VALUE                     NUMBER(1),
  CREATED_BY                        VARCHAR2(36 CHAR),
  CREATED_WHEN                      TIMESTAMP(6),
  DATETIME_VALUE                    TIMESTAMP(6),
  ID                                VARCHAR2(36 CHAR) not null,
  INTEGER_VALUE                     NUMBER(10),
  KEY                               VARCHAR2(255 CHAR),
  MODIFIED_BY                       VARCHAR2(36 CHAR),
  MODIFIED_WHEN                     TIMESTAMP(6),
  SET_ON_LEVEL                      VARCHAR2(4 CHAR),
  SET_ON_TARGET                     VARCHAR2(64 CHAR),
  STRING_VALUE                      VARCHAR2(1000 CHAR)
)
;
alter table CONFIG_VALUE add primary key (ID);

prompt
prompt Creating table CONFIG_VALUE_BLOB
prompt ===============================================
prompt
create table CONFIG_VALUE_BLOB
(
  BLOB_VALUE                        BLOB,
  ID                                VARCHAR2(36 CHAR) not null
)
;
alter table CONFIG_VALUE_BLOB add primary key (ID);

prompt
prompt Creating table DEPARTMENT
prompt ===============================================
prompt
create table DEPARTMENT
(
  ACTIVE                            NUMBER(1),
  CAN_BE_CURRENT                    NUMBER(1),
  CREATED_BY                        VARCHAR2(36 CHAR),
  CREATED_WHEN                      TIMESTAMP(6),
  DEPARTMENT_TYPE                   VARCHAR2(2 CHAR),
  FACILITY                          VARCHAR2(36 CHAR),
  ID                                VARCHAR2(36 CHAR) not null,
  IS_ER                             NUMBER(1),
  IS_EXTERNAL                       NUMBER(1),
  IS_PERFORMING                     NUMBER(1),
  IS_REQUESTING                     NUMBER(1),
  LOGO                              BLOB,
  MODIFIED_BY                       VARCHAR2(36 CHAR),
  MODIFIED_WHEN                     TIMESTAMP(6),
  NAME                              VARCHAR2(1000 CHAR),
  NAME_SOUNDEX                      VARCHAR2(1000 CHAR),
  PARENT                            VARCHAR2(36 CHAR),
  VERSION                           NUMBER(19)
)
;
alter table DEPARTMENT add primary key (ID);

prompt
prompt Creating table EXCEL_FILE
prompt ===============================================
prompt
create table EXCEL_FILE
(
  CREATED_BY                        VARCHAR2(36 CHAR),
  CREATED_WHEN                      TIMESTAMP(6),
  CURRENT_REVISION                  VARCHAR2(36 CHAR),
  ID                                VARCHAR2(36 CHAR) not null,
  IS_PUBLISHED                      NUMBER(1),
  MODIFIED_BY                       VARCHAR2(36 CHAR),
  MODIFIED_WHEN                     TIMESTAMP(6),
  NAME                              VARCHAR2(255 CHAR) not null,
  OWNER_ID                          VARCHAR2(255 CHAR),
  OWNER_TYPE                        CHAR(1 CHAR),
  PERMISSION_SET                    VARCHAR2(36 CHAR),
  TAG                               VARCHAR2(50 CHAR),
  VALID                             NUMBER(1),
  VERSION                           NUMBER(19)
)
;
alter table EXCEL_FILE add primary key (ID);
alter table EXCEL_FILE add unique (TAG,NAME);

prompt
prompt Creating table EXCEL_FILE_REV
prompt ===============================================
prompt
create table EXCEL_FILE_REV
(
  CREATED_BY                        VARCHAR2(36 CHAR),
  CREATED_WHEN                      TIMESTAMP(6),
  EXCEL_CONTENT                     BLOB,
  EXCEL_FILE                        VARCHAR2(36 CHAR) not null,
  ID                                VARCHAR2(36 CHAR) not null,
  IS_PUBLISHED                      NUMBER(1),
  JSON_CONTENT                      CLOB,
  MODIFIED_BY                       VARCHAR2(36 CHAR),
  MODIFIED_WHEN                     TIMESTAMP(6),
  NAME                              VARCHAR2(255 CHAR),
  SNAPSHOT_NAME                     VARCHAR2(100 CHAR)
)
;
alter table EXCEL_FILE_REV add primary key (ID);

prompt
prompt Creating table EXCEL_FILE_REV_OUTPUT
prompt ===============================================
prompt
create table EXCEL_FILE_REV_OUTPUT
(
  CREATED_BY                        VARCHAR2(36 CHAR),
  CREATED_WHEN                      TIMESTAMP(6),
  DATA_CONTENT                      BLOB,
  DATA_FORMAT                       VARCHAR2(20 CHAR),
  EXCEL_FILE_REV                    VARCHAR2(36 CHAR),
  ID                                VARCHAR2(36 CHAR) not null,
  MODIFIED_BY                       VARCHAR2(36 CHAR),
  MODIFIED_WHEN                     TIMESTAMP(6),
  SHEET_INDEX                       NUMBER(10),
  SHEET_NAME                        VARCHAR2(255 CHAR)
)
;
alter table EXCEL_FILE_REV_OUTPUT add primary key (ID);

prompt
prompt Creating table FACILITY
prompt ===============================================
prompt
create table FACILITY
(
  ACTIVE                            NUMBER(1),
  CREATED_BY                        VARCHAR2(36 CHAR),
  CREATED_WHEN                      TIMESTAMP(6),
  FACILITY_TYPE                     VARCHAR2(36 CHAR) not null,
  ID                                VARCHAR2(36 CHAR) not null,
  IS_EXTERNAL                       NUMBER(1) not null,
  LOGO                              BLOB,
  MODIFIED_BY                       VARCHAR2(36 CHAR),
  MODIFIED_WHEN                     TIMESTAMP(6),
  NAME                              VARCHAR2(1000 CHAR),
  NAME_SOUNDEX                      VARCHAR2(1000 CHAR),
  TYPE                              VARCHAR2(2 CHAR) not null,
  VERSION                           NUMBER(19),
  WEBSITE                           VARCHAR2(1000 CHAR)
)
;
alter table FACILITY add primary key (ID);

prompt
prompt Creating table IDENTITY_CODE
prompt ===============================================
prompt
create table IDENTITY_CODE
(
  ASSIGNING_AUTHORITY               VARCHAR2(36 CHAR),
  CODE                              VARCHAR2(200 CHAR) not null,
  DEPARTMENT_ID                     VARCHAR2(36 CHAR),
  FACILITY_ID                       VARCHAR2(36 CHAR),
  ID                                VARCHAR2(36 CHAR) not null,
  IDENTIFIER_TYPE                   VARCHAR2(36 CHAR),
  IDENTITY_ID                       VARCHAR2(255 CHAR),
  IDENTITY_TYPE                     CHAR(1 CHAR),
  MERGED_TO                         VARCHAR2(36 CHAR),
  MERGE_CHECKED                     NUMBER(1) not null,
  PATIENT_ID                        VARCHAR2(36 CHAR),
  PROFESSIONAL_ID                   VARCHAR2(36 CHAR),
  VALID_FROM                        TIMESTAMP(6),
  VALID_TILL                        TIMESTAMP(6)
)
;
alter table IDENTITY_CODE add primary key (ID);
alter table IDENTITY_CODE add unique (CODE);

prompt
prompt Creating table MODALITY
prompt ===============================================
prompt
create table MODALITY
(
  ACTIVE                            NUMBER(1),
  AETITLE                           VARCHAR2(200 CHAR),
  AUTO_CREATED                      NUMBER(1),
  CALLING_AETITLE                   VARCHAR2(200 CHAR),
  CODE                              VARCHAR2(200 CHAR) not null,
  CREATED_BY                        VARCHAR2(36 CHAR),
  CREATED_WHEN                      TIMESTAMP(6),
  DEPARTMENT                        VARCHAR2(36 CHAR),
  DESCRIPTION                       VARCHAR2(2000 CHAR),
  FACILITY                          VARCHAR2(36 CHAR),
  ID                                VARCHAR2(36 CHAR) not null,
  MODALITY_TYPE                     VARCHAR2(36 CHAR),
  MODIFIED_BY                       VARCHAR2(36 CHAR),
  MODIFIED_WHEN                     TIMESTAMP(6),
  NAME                              VARCHAR2(1000 CHAR) not null,
  NAME_SOUNDEX                      VARCHAR2(1000 CHAR),
  USE_AS_DEFAULT                    NUMBER(1),
  VERSION                           NUMBER(19)
)
;
alter table MODALITY add primary key (ID);
alter table MODALITY add unique (CODE);
alter table MODALITY add unique (NAME,AETITLE);

prompt
prompt Creating table PATIENT
prompt ===============================================
prompt
create table PATIENT
(
  ACTIVE                            NUMBER(1),
  AVATAR                            BLOB,
  CREATED_BY                        VARCHAR2(36 CHAR),
  CREATED_WHEN                      TIMESTAMP(6),
  DATE_OF_BIRTH                     TIMESTAMP(6),
  DECEASED_DATE                     TIMESTAMP(6),
  FIRST_NAME                        VARCHAR2(255 CHAR),
  GENDER                            VARCHAR2(2 CHAR),
  ID                                VARCHAR2(36 CHAR) not null,
  IDIOGRAPHIC_NAME                  VARCHAR2(1000 CHAR),
  IS_VIP                            NUMBER(1),
  LAST_NAME                         VARCHAR2(255 CHAR),
  MIDDLE_NAME                       VARCHAR2(255 CHAR),
  MODIFIED_BY                       VARCHAR2(36 CHAR),
  MODIFIED_WHEN                     TIMESTAMP(6),
  PHONETIC_NAME                     VARCHAR2(1000 CHAR),
  PLACE_OF_BIRTH                    VARCHAR2(1000 CHAR),
  SHORTCUT                          VARCHAR2(255 CHAR),
  SIGNATURE                         BLOB,
  SSN                               VARCHAR2(100 CHAR),
  VERSION                           NUMBER(19),
  VIP_TYPE                          VARCHAR2(20 CHAR)
)
;
alter table PATIENT add primary key (ID);

prompt
prompt Creating table PROFESSIONAL
prompt ===============================================
prompt
create table PROFESSIONAL
(
  ACTIVE                            NUMBER(1),
  AUTO_CREATED                      NUMBER(1),
  AVATAR                            BLOB,
  CREATED_BY                        VARCHAR2(36 CHAR),
  CREATED_WHEN                      TIMESTAMP(6),
  DATE_OF_BIRTH                     TIMESTAMP(6),
  DECEASED_DATE                     TIMESTAMP(6),
  FIRST_NAME                        VARCHAR2(255 CHAR),
  GENDER                            VARCHAR2(2 CHAR),
  ID                                VARCHAR2(36 CHAR) not null,
  IDIOGRAPHIC_NAME                  VARCHAR2(1000 CHAR),
  IS_EXTERNAL                       NUMBER(1),
  LAST_NAME                         VARCHAR2(255 CHAR),
  MIDDLE_NAME                       VARCHAR2(255 CHAR),
  MODIFIED_BY                       VARCHAR2(36 CHAR),
  MODIFIED_WHEN                     TIMESTAMP(6),
  PHONETIC_NAME                     VARCHAR2(1000 CHAR),
  PLACE_OF_BIRTH                    VARCHAR2(1000 CHAR),
  SHORTCUT                          VARCHAR2(255 CHAR),
  SIGNATURE                         BLOB,
  VERSION                           NUMBER(19)
)
;
alter table PROFESSIONAL add primary key (ID);

prompt
prompt Creating table PROFESSIONAL_DEPARTMENT
prompt ===============================================
prompt
create table PROFESSIONAL_DEPARTMENT
(
  DEPARTMENT                        VARCHAR2(36 CHAR) not null,
  PROFESSIONAL                      VARCHAR2(36 CHAR) not null
)
;
alter table PROFESSIONAL_DEPARTMENT add primary key (PROFESSIONAL,DEPARTMENT);

prompt
prompt Creating table PROFESSIONAL_SPECIALISM
prompt ===============================================
prompt
create table PROFESSIONAL_SPECIALISM
(
  PROFESSIONAL                      VARCHAR2(36 CHAR) not null,
  SPECIALISM                        VARCHAR2(36 CHAR) not null
)
;
alter table PROFESSIONAL_SPECIALISM add primary key (PROFESSIONAL,SPECIALISM);

prompt
prompt Creating table RESOURCE_DEFINITION
prompt ===============================================
prompt
create table RESOURCE_DEFINITION
(
  ACTIVE                            NUMBER(1),
  AUTO_CREATED                      NUMBER(1),
  CATEGORY                          VARCHAR2(255 CHAR),
  CATEGORY2                         VARCHAR2(255 CHAR),
  CATEGORY3                         VARCHAR2(255 CHAR),
  CODE                              VARCHAR2(200 CHAR) not null,
  CREATED_BY                        VARCHAR2(36 CHAR),
  CREATED_WHEN                      TIMESTAMP(6),
  DESCRIPTION                       VARCHAR2(2000 CHAR),
  ICON                              BLOB,
  ID                                VARCHAR2(36 CHAR) not null,
  LEAF                              NUMBER(1),
  MODIFIED_BY                       VARCHAR2(36 CHAR),
  MODIFIED_WHEN                     TIMESTAMP(6),
  NAME                              VARCHAR2(1000 CHAR) not null,
  NAME_SOUNDEX                      VARCHAR2(1000 CHAR),
  PARENT                            VARCHAR2(36 CHAR),
  REF_ID                            VARCHAR2(255 CHAR),
  REF_TYPE                          VARCHAR2(255 CHAR),
  TYPE                              VARCHAR2(2 CHAR) not null,
  VERSION                           NUMBER(19)
)
;
alter table RESOURCE_DEFINITION add primary key (ID);
alter table RESOURCE_DEFINITION add unique (CODE);

prompt
prompt Creating table RESOURCE_LAYOUT
prompt ===============================================
prompt
create table RESOURCE_LAYOUT
(
  CREATED_BY                        VARCHAR2(36 CHAR),
  CREATED_WHEN                      TIMESTAMP(6),
  ID                                VARCHAR2(36 CHAR) not null,
  MODIFIED_BY                       VARCHAR2(36 CHAR),
  MODIFIED_WHEN                     TIMESTAMP(6),
  VERSION                           NUMBER(19)
)
;
alter table RESOURCE_LAYOUT add primary key (ID);

prompt
prompt Creating table ROOM
prompt ===============================================
prompt
create table ROOM
(
  ACTIVE                            NUMBER(1),
  AUTO_CREATED                      NUMBER(1),
  CODE                              VARCHAR2(200 CHAR) not null,
  CREATED_BY                        VARCHAR2(36 CHAR),
  CREATED_WHEN                      TIMESTAMP(6),
  DESCRIPTION                       VARCHAR2(2000 CHAR),
  ID                                VARCHAR2(36 CHAR) not null,
  MODIFIED_BY                       VARCHAR2(36 CHAR),
  MODIFIED_WHEN                     TIMESTAMP(6),
  NAME                              VARCHAR2(1000 CHAR) not null,
  NAME_SOUNDEX                      VARCHAR2(1000 CHAR),
  VERSION                           NUMBER(19)
)
;
alter table ROOM add primary key (ID);
alter table ROOM add unique (CODE);

prompt
prompt Creating table ROOM_DEPARTMENT
prompt ===============================================
prompt
create table ROOM_DEPARTMENT
(
  DEPARTMENT                        VARCHAR2(36 CHAR) not null,
  ROOM                              VARCHAR2(36 CHAR) not null
)
;
alter table ROOM_DEPARTMENT add primary key (ROOM,DEPARTMENT);

prompt
prompt Creating table ROOM_FACILITY
prompt ===============================================
prompt
create table ROOM_FACILITY
(
  FACILITY                          VARCHAR2(36 CHAR) not null,
  ROOM                              VARCHAR2(36 CHAR) not null
)
;
alter table ROOM_FACILITY add primary key (ROOM,FACILITY);

prompt
prompt Creating table ROOM_MODALITY
prompt ===============================================
prompt
create table ROOM_MODALITY
(
  MODALITY                          VARCHAR2(36 CHAR) not null,
  ROOM                              VARCHAR2(36 CHAR) not null
)
;
alter table ROOM_MODALITY add primary key (ROOM,MODALITY);

prompt
prompt Creating table SEC_DOMAIN
prompt ===============================================
prompt
create table SEC_DOMAIN
(
  CODE                              VARCHAR2(255 CHAR),
  ID                                VARCHAR2(36 CHAR) not null,
  NAME                              VARCHAR2(255 CHAR),
  SEQUENCE                          NUMBER(19),
  VERSION                           NUMBER(19)
)
;
alter table SEC_DOMAIN add primary key (ID);

prompt
prompt Creating table SEC_EXTERNAL_ROLE
prompt ===============================================
prompt
create table SEC_EXTERNAL_ROLE
(
  DOMAIN_ID                         VARCHAR2(36 CHAR) not null,
  GUID                              VARCHAR2(255 CHAR),
  ID                                VARCHAR2(36 CHAR) not null,
  NAME                              VARCHAR2(255 CHAR),
  VERSION                           NUMBER(19)
)
;
alter table SEC_EXTERNAL_ROLE add primary key (ID);

prompt
prompt Creating table SEC_PASSWORD
prompt ===============================================
prompt
create table SEC_PASSWORD
(
  DATE_OF_CREATION                  TIMESTAMP(6) not null,
  DATE_OF_EXPIRATION                TIMESTAMP(6),
  ID                                VARCHAR2(36 CHAR) not null,
  PASSWORD                          VARCHAR2(1000 CHAR),
  USER_ID                           VARCHAR2(36 CHAR) not null
)
;
alter table SEC_PASSWORD add primary key (ID);

prompt
prompt Creating table SEC_ROLE
prompt ===============================================
prompt
create table SEC_ROLE
(
  ACTIVE                            NUMBER(1),
  CODE                              VARCHAR2(255 CHAR),
  DESCRIPTION                       VARCHAR2(4000 CHAR),
  ID                                VARCHAR2(36 CHAR) not null,
  NAME                              VARCHAR2(255 CHAR),
  VERSION                           NUMBER(19)
)
;
alter table SEC_ROLE add primary key (ID);

prompt
prompt Creating table SEC_ROLE_MAPPING
prompt ===============================================
prompt
create table SEC_ROLE_MAPPING
(
  EXTERNAL_ROLE_ID                  VARCHAR2(36 CHAR) not null,
  ROLE_ID                           VARCHAR2(36 CHAR) not null
)
;
alter table SEC_ROLE_MAPPING add primary key (ROLE_ID,EXTERNAL_ROLE_ID);

prompt
prompt Creating table SEC_TOKEN
prompt ===============================================
prompt
create table SEC_TOKEN
(
  DATE_OF_EXPIRATION                TIMESTAMP(6),
  ID                                VARCHAR2(36 CHAR) not null,
  OBJECT                            CLOB,
  USER_ID                           VARCHAR2(36 CHAR) not null
)
;
alter table SEC_TOKEN add primary key (ID);

prompt
prompt Creating table SEC_USER
prompt ===============================================
prompt
create table SEC_USER
(
  ACTIVE_FROM                       TIMESTAMP(6),
  ACTIVE_TILL                       TIMESTAMP(6),
  CREATED_WHEN                      TIMESTAMP(6),
  FAIL_LOGIN_COUNT                  NUMBER(19),
  GUI_LANGUAGE                      VARCHAR2(255 CHAR),
  ID                                VARCHAR2(36 CHAR) not null,
  LOCKED_WHEN                       TIMESTAMP(6),
  LOGIN_NAME                        VARCHAR2(255 CHAR),
  MODIFIED_WHEN                     TIMESTAMP(6),
  PERSON_ID                         VARCHAR2(255 CHAR),
  PERSON_TYPE                       CHAR(1 CHAR),
  RESERVED_USER                     NUMBER(1),
  VALID                             NUMBER(1),
  VERSION                           NUMBER(19)
)
;
alter table SEC_USER add primary key (ID);

prompt
prompt Creating table SEC_USER_DOMAIN
prompt ===============================================
prompt
create table SEC_USER_DOMAIN
(
  DOMAIN_ID                         VARCHAR2(36 CHAR) not null,
  EXTERNAL_ID                       VARCHAR2(255 CHAR),
  EXTERNAL_LOGIN_NAME               VARCHAR2(255 CHAR),
  ID                                VARCHAR2(36 CHAR) not null,
  USER_ID                           VARCHAR2(36 CHAR) not null,
  VERSION                           NUMBER(19)
)
;
alter table SEC_USER_DOMAIN add primary key (ID);

prompt
prompt Creating table SEC_USER_ROLE
prompt ===============================================
prompt
create table SEC_USER_ROLE
(
  ROLE_ID                           VARCHAR2(36 CHAR) not null,
  USER_ID                           VARCHAR2(36 CHAR) not null
)
;
alter table SEC_USER_ROLE add primary key (USER_ID,ROLE_ID);



prompt
prompt Creating foreign key for table AC_PERMISSION
prompt ===============================================================
prompt
alter table AC_PERMISSION add constraint FK6BKWTR71XNOP5V1VBWN1171RS foreign key (PERMISSION_SET) references AC_PERMISSION_SET (ID);

prompt
prompt Creating foreign key for table AC_PERMISSION_SET
prompt ===============================================================
prompt
alter table AC_PERMISSION_SET add constraint FKDBTYSFYVITAXH12DNJCQIBEI6 foreign key (MODIFIED_BY) references SEC_USER (ID);
alter table AC_PERMISSION_SET add constraint FKRBGB6TJASNTVE907N9Q929OCP foreign key (CREATED_BY) references SEC_USER (ID);

prompt
prompt Creating foreign key for table ASSIGNING_AUTHORITY
prompt ===============================================================
prompt
alter table ASSIGNING_AUTHORITY add constraint FKHYRYVGDOEVXYBE1B6KP80H75M foreign key (CREATED_BY) references SEC_USER (ID);
alter table ASSIGNING_AUTHORITY add constraint FKK398T6Y4564M26B71X718OWTH foreign key (FACILITY) references FACILITY (ID);
alter table ASSIGNING_AUTHORITY add constraint FKMUPALXJ88CXS5U3GP3AFXM1PL foreign key (MODIFIED_BY) references SEC_USER (ID);

prompt
prompt Creating foreign key for table CALENDAR_DEFINITION
prompt ===============================================================
prompt
alter table CALENDAR_DEFINITION add constraint FKCYWA5QJU9RCV59AIBIM0SMXFQ foreign key (MODIFIED_BY) references SEC_USER (ID);
alter table CALENDAR_DEFINITION add constraint FKR5SQ96WBSR2LB08AGAPY08SHW foreign key (CREATED_BY) references SEC_USER (ID);

prompt
prompt Creating foreign key for table CALENDAR_INSTANCE
prompt ===============================================================
prompt
alter table CALENDAR_INSTANCE add constraint FKORQAWRF8VMNMKITBYTG443GO foreign key (CALENDAR_DEFINITION) references CALENDAR_DEFINITION (ID);

prompt
prompt Creating foreign key for table CODING_CODE
prompt ===============================================================
prompt

prompt
prompt Creating foreign key for table COMMON_NAMECODE
prompt ===============================================================
prompt
alter table COMMON_NAMECODE add constraint FK6CUATMST1PN3PDR0XLASESKQP foreign key (PARENT) references COMMON_NAMECODE (ID);
alter table COMMON_NAMECODE add constraint FKP1FFMO3V6OKBGW151YFLYECD2 foreign key (MODIFIED_BY) references SEC_USER (ID);
alter table COMMON_NAMECODE add constraint FKTKTBA86B8N4LEGKE0WNNBCA7B foreign key (CREATED_BY) references SEC_USER (ID);

prompt
prompt Creating foreign key for table COMMUNICATION_CHANNEL
prompt ===============================================================
prompt
alter table COMMUNICATION_CHANNEL add constraint FK9S945D4YMF3A5RGVRIPF2A6QH foreign key (FACILITY_ID) references FACILITY (ID);
alter table COMMUNICATION_CHANNEL add constraint FKDE7NUX557IGEUG8VXK6SJK6EU foreign key (PROFESSIONAL_ID) references PROFESSIONAL (ID);
alter table COMMUNICATION_CHANNEL add constraint FKEQWTWOAJP3LJT8AYMEFTP94R5 foreign key (PATIENT_ID) references PATIENT (ID);
alter table COMMUNICATION_CHANNEL add constraint FKF991DEHDB744NCQEILGVH07MX foreign key (DEPARTMENT_ID) references DEPARTMENT (ID);
alter table COMMUNICATION_CHANNEL add constraint FKPU8L93O5OX8XHW6QET751D1M5 foreign key (COMMUNICATION_TYPE) references COMMON_NAMECODE (ID);

prompt
prompt Creating foreign key for table CONFIG_KEY
prompt ===============================================================
prompt
alter table CONFIG_KEY add constraint FK74H7XDGEH5NGCR1SGQTBQKCJL foreign key (NAME_SPACE) references CONFIG_NAME_SPACE (ID);
alter table CONFIG_KEY add constraint FK7JNJO97INL32AN1OPVPLRTOSY foreign key (CREATED_BY) references SEC_USER (ID);
alter table CONFIG_KEY add constraint FKDLXOLIX0VMTA1HNQS0W8VS7MS foreign key (MODIFIED_BY) references SEC_USER (ID);

prompt
prompt Creating foreign key for table CONFIG_NAME_SPACE
prompt ===============================================================
prompt
alter table CONFIG_NAME_SPACE add constraint FK19VAHG6NGO2J2QG9880PTYONW foreign key (CREATED_BY) references SEC_USER (ID);
alter table CONFIG_NAME_SPACE add constraint FK3JL29N997IPT7CC1QDW2FGGQ2 foreign key (MODIFIED_BY) references SEC_USER (ID);

prompt
prompt Creating foreign key for table CONFIG_VALUE
prompt ===============================================================
prompt
alter table CONFIG_VALUE add constraint FKHB15G5J4G2SPTCBYWF1W3TWOS foreign key (MODIFIED_BY) references SEC_USER (ID);
alter table CONFIG_VALUE add constraint FKHLEUOS7VLD8LKXVAFMNHRJMDU foreign key (CREATED_BY) references SEC_USER (ID);
alter table CONFIG_VALUE add constraint FKK6039I9G1LY1LKL6TE4Y4XX6B foreign key (BLOB_VALUE) references CONFIG_VALUE_BLOB (ID);

prompt
prompt Creating foreign key for table CONFIG_VALUE_BLOB
prompt ===============================================================
prompt

prompt
prompt Creating foreign key for table DEPARTMENT
prompt ===============================================================
prompt
alter table DEPARTMENT add constraint FK2L34G1XPYEFMBIK8EAXLO78S7 foreign key (CREATED_BY) references SEC_USER (ID);
alter table DEPARTMENT add constraint FKDBYFH542I93SS645GVK7AJ4P8 foreign key (MODIFIED_BY) references SEC_USER (ID);
alter table DEPARTMENT add constraint FKPT975XPJ9FCHLEWKPK6X7M3GG foreign key (FACILITY) references FACILITY (ID);
alter table DEPARTMENT add constraint FKTQ6P1RIT9CTH7DOCD7UXUCLQS foreign key (PARENT) references DEPARTMENT (ID);

prompt
prompt Creating foreign key for table EXCEL_FILE
prompt ===============================================================
prompt
alter table EXCEL_FILE add constraint FK5Y67FRRM905F7UW7T7UK9HCH2 foreign key (CREATED_BY) references SEC_USER (ID);
alter table EXCEL_FILE add constraint FKBIY0T61KLUWQG9EQ164RLC6HK foreign key (CURRENT_REVISION) references EXCEL_FILE_REV (ID);
alter table EXCEL_FILE add constraint FKCEPP77T4X8YHCIFY03M33A3YG foreign key (MODIFIED_BY) references SEC_USER (ID);
alter table EXCEL_FILE add constraint FKNK5YBMKUDEBW4IIM2FU4T4796 foreign key (PERMISSION_SET) references AC_PERMISSION_SET (ID);

prompt
prompt Creating foreign key for table EXCEL_FILE_REV
prompt ===============================================================
prompt
alter table EXCEL_FILE_REV add constraint FK3YS9DIK3FYJ83PV8B2DDGOP1J foreign key (MODIFIED_BY) references SEC_USER (ID);
alter table EXCEL_FILE_REV add constraint FKG34M1EJA8IFQMSAE5SJG6U89 foreign key (EXCEL_FILE) references EXCEL_FILE (ID);
alter table EXCEL_FILE_REV add constraint FKT92AJCVTSX049JLPBISOEMB8N foreign key (CREATED_BY) references SEC_USER (ID);

prompt
prompt Creating foreign key for table EXCEL_FILE_REV_OUTPUT
prompt ===============================================================
prompt
alter table EXCEL_FILE_REV_OUTPUT add constraint FKAJSAWQFVNJ4QVBM8CMXB2WO3I foreign key (MODIFIED_BY) references SEC_USER (ID);
alter table EXCEL_FILE_REV_OUTPUT add constraint FKHXLSBGH6MQ30BGHYEIN1J6LWB foreign key (CREATED_BY) references SEC_USER (ID);
alter table EXCEL_FILE_REV_OUTPUT add constraint FKRWG54Q7FV27QK8Q5G2G7CKYXS foreign key (EXCEL_FILE_REV) references EXCEL_FILE_REV (ID);

prompt
prompt Creating foreign key for table FACILITY
prompt ===============================================================
prompt
alter table FACILITY add constraint FK6D5QAPK15L1VJ2GO2R4SDD43P foreign key (MODIFIED_BY) references SEC_USER (ID);
alter table FACILITY add constraint FKQ1YO9R83JT1TMGEU5V9ULSMNS foreign key (CREATED_BY) references SEC_USER (ID);
alter table FACILITY add constraint FKRG8F8FASEI3938T6TY3T87G5W foreign key (FACILITY_TYPE) references COMMON_NAMECODE (ID);

prompt
prompt Creating foreign key for table IDENTITY_CODE
prompt ===============================================================
prompt
alter table IDENTITY_CODE add constraint FK9MCCY4EH0OWO45NWMIUG3EB65 foreign key (PATIENT_ID) references PATIENT (ID);
alter table IDENTITY_CODE add constraint FKC9274WTPN9CQKTCKVEK2GIP23 foreign key (FACILITY_ID) references FACILITY (ID);
alter table IDENTITY_CODE add constraint FKG1EEQO54GA4UR8XLV9UR7TBHY foreign key (IDENTIFIER_TYPE) references COMMON_NAMECODE (ID);
alter table IDENTITY_CODE add constraint FKHNYMLIF47DJCGTCR8UTBWFLO1 foreign key (PROFESSIONAL_ID) references PROFESSIONAL (ID);
alter table IDENTITY_CODE add constraint FKHOY4NSRAXXI7WDH4PYY5CACNI foreign key (DEPARTMENT_ID) references DEPARTMENT (ID);
alter table IDENTITY_CODE add constraint FKI9FEB17LT8L5945U8YIBDSNUV foreign key (ASSIGNING_AUTHORITY) references ASSIGNING_AUTHORITY (ID);
alter table IDENTITY_CODE add constraint FKQ6TPEYOQB5S9GJW0LECCWH7OB foreign key (MERGED_TO) references IDENTITY_CODE (ID);

prompt
prompt Creating foreign key for table MODALITY
prompt ===============================================================
prompt
alter table MODALITY add constraint FK1T8ABEUV8STSMIN65VOGFCOK4 foreign key (FACILITY) references FACILITY (ID);
alter table MODALITY add constraint FKCIIWUOH9TQQU6HTYIKJ5QIT5V foreign key (DEPARTMENT) references DEPARTMENT (ID);
alter table MODALITY add constraint FKLBAV3M74N6NXYB60IP1ELVCRM foreign key (CREATED_BY) references SEC_USER (ID);
alter table MODALITY add constraint FKMJ8LV1IL9V375MR7F9HTWG7TE foreign key (MODIFIED_BY) references SEC_USER (ID);
alter table MODALITY add constraint FKOOWM62FKX9Y0P822X47KPSYRG foreign key (MODALITY_TYPE) references COMMON_NAMECODE (ID);

prompt
prompt Creating foreign key for table PATIENT
prompt ===============================================================
prompt
alter table PATIENT add constraint FKKAUBBPSD73T7MPYNEYCL77BCN foreign key (CREATED_BY) references SEC_USER (ID);
alter table PATIENT add constraint FKP21NVBVUK49IY8M8G4RI2YCAY foreign key (MODIFIED_BY) references SEC_USER (ID);

prompt
prompt Creating foreign key for table PROFESSIONAL
prompt ===============================================================
prompt
alter table PROFESSIONAL add constraint FK2BDUSJLM4YFI939WJHIAFLEAY foreign key (MODIFIED_BY) references SEC_USER (ID);
alter table PROFESSIONAL add constraint FKBRCBQR2IG5T9A5TJKS8DEL5IU foreign key (CREATED_BY) references SEC_USER (ID);

prompt
prompt Creating foreign key for table PROFESSIONAL_DEPARTMENT
prompt ===============================================================
prompt
alter table PROFESSIONAL_DEPARTMENT add constraint FKCG0JGY12KE0HYUC9CWMFFWMDN foreign key (PROFESSIONAL) references PROFESSIONAL (ID);
alter table PROFESSIONAL_DEPARTMENT add constraint FKDCG8MXBI4OPCJ6OVQG5NDNL9O foreign key (DEPARTMENT) references DEPARTMENT (ID);

prompt
prompt Creating foreign key for table PROFESSIONAL_SPECIALISM
prompt ===============================================================
prompt
alter table PROFESSIONAL_SPECIALISM add constraint FK5UXQ24DFSCA8HVWV6VIGLNGHO foreign key (SPECIALISM) references COMMON_NAMECODE (ID);
alter table PROFESSIONAL_SPECIALISM add constraint FKGI11LN8YQPB5REVEGK0DR9RQ9 foreign key (PROFESSIONAL) references PROFESSIONAL (ID);

prompt
prompt Creating foreign key for table RESOURCE_DEFINITION
prompt ===============================================================
prompt
alter table RESOURCE_DEFINITION add constraint FK1JVLUQR3S6VSG8SW2UK3XLJ5F foreign key (MODIFIED_BY) references SEC_USER (ID);
alter table RESOURCE_DEFINITION add constraint FK2K4N5D4BSPS2DML632IQPK3F2 foreign key (PARENT) references RESOURCE_DEFINITION (ID);
alter table RESOURCE_DEFINITION add constraint FKOLQAONFEYSPYAE2199MQL3N5C foreign key (CREATED_BY) references SEC_USER (ID);

prompt
prompt Creating foreign key for table RESOURCE_LAYOUT
prompt ===============================================================
prompt
alter table RESOURCE_LAYOUT add constraint FK9WDK78KADTW3H65KCDKGW48L6 foreign key (MODIFIED_BY) references SEC_USER (ID);
alter table RESOURCE_LAYOUT add constraint FKOGCPYIBNCOMX1HFT8FY2Y9Y1B foreign key (CREATED_BY) references SEC_USER (ID);

prompt
prompt Creating foreign key for table ROOM
prompt ===============================================================
prompt
alter table ROOM add constraint FK7Q5MWFGORM2L8WRD4IHKE8BSH foreign key (MODIFIED_BY) references SEC_USER (ID);
alter table ROOM add constraint FKJHT8BX10S0SH5QDF5HKSQDUWH foreign key (CREATED_BY) references SEC_USER (ID);

prompt
prompt Creating foreign key for table ROOM_DEPARTMENT
prompt ===============================================================
prompt
alter table ROOM_DEPARTMENT add constraint FKJ2DR6148418TG8RDGK3CD5J83 foreign key (DEPARTMENT) references DEPARTMENT (ID);
alter table ROOM_DEPARTMENT add constraint FKNWMGYWYGDQR3LUTDU7DAP4YU3 foreign key (ROOM) references ROOM (ID);

prompt
prompt Creating foreign key for table ROOM_FACILITY
prompt ===============================================================
prompt
alter table ROOM_FACILITY add constraint FK6FIY71U7G2Q66QWVSI2GNUAKG foreign key (FACILITY) references FACILITY (ID);
alter table ROOM_FACILITY add constraint FKBJIVOV1BCQ8464A40XTUCYKLO foreign key (ROOM) references ROOM (ID);

prompt
prompt Creating foreign key for table ROOM_MODALITY
prompt ===============================================================
prompt
alter table ROOM_MODALITY add constraint FK6CI0A828AQYI9E4DRFLOJV358 foreign key (ROOM) references ROOM (ID);
alter table ROOM_MODALITY add constraint FKHTLYI2II5B2JDQOVSOE3RHT3T foreign key (MODALITY) references MODALITY (ID);

prompt
prompt Creating foreign key for table SEC_DOMAIN
prompt ===============================================================
prompt

prompt
prompt Creating foreign key for table SEC_EXTERNAL_ROLE
prompt ===============================================================
prompt
alter table SEC_EXTERNAL_ROLE add constraint FKJ5T2YDXN8X2YU5A0GF9K308KP foreign key (DOMAIN_ID) references SEC_DOMAIN (ID);

prompt
prompt Creating foreign key for table SEC_PASSWORD
prompt ===============================================================
prompt
alter table SEC_PASSWORD add constraint FKIHBM886F427IH7J11NPJT9MB0 foreign key (USER_ID) references SEC_USER (ID);

prompt
prompt Creating foreign key for table SEC_ROLE
prompt ===============================================================
prompt

prompt
prompt Creating foreign key for table SEC_ROLE_MAPPING
prompt ===============================================================
prompt
alter table SEC_ROLE_MAPPING add constraint FK10AHF5ABRLEP674NOC2QA1GQT foreign key (EXTERNAL_ROLE_ID) references SEC_EXTERNAL_ROLE (ID);
alter table SEC_ROLE_MAPPING add constraint FK8N78UDP5D2XI0C1L2DBTUA4H3 foreign key (ROLE_ID) references SEC_ROLE (ID);

prompt
prompt Creating foreign key for table SEC_TOKEN
prompt ===============================================================
prompt
alter table SEC_TOKEN add constraint FKS99PTRPAF15UJP4LNQHFQLXCJ foreign key (USER_ID) references SEC_USER (ID);

prompt
prompt Creating foreign key for table SEC_USER
prompt ===============================================================
prompt

prompt
prompt Creating foreign key for table SEC_USER_DOMAIN
prompt ===============================================================
prompt
alter table SEC_USER_DOMAIN add constraint FKOP6QKQO5RV4AHY2EMP3V7SKXT foreign key (USER_ID) references SEC_USER (ID);
alter table SEC_USER_DOMAIN add constraint FKPHN10M2DP3D3F90NJ41XSU5Y8 foreign key (DOMAIN_ID) references SEC_DOMAIN (ID);

prompt
prompt Creating foreign key for table SEC_USER_ROLE
prompt ===============================================================
prompt
alter table SEC_USER_ROLE add constraint FK835BBYIY6MAJROLCOV7BP0YO0 foreign key (USER_ID) references SEC_USER (ID);
alter table SEC_USER_ROLE add constraint FKFOWKD8VW5QARH8B8Y9NOAF4ET foreign key (ROLE_ID) references SEC_ROLE (ID);
