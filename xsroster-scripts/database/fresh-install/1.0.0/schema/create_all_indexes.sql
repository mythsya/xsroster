
spool create_roster_indexes.log

prompt
prompt Creating indexes for table AC_PERMISSION
prompt ===============================================
prompt

prompt
prompt Creating indexes for table AC_PERMISSION_SET
prompt ===============================================
prompt
CREATE UNIQUE INDEX UK_8DREC5SDEI7V9DMMYLL6FRJNL ON AC_PERMISSION_SET (CODE);

prompt
prompt Creating indexes for table ASSIGNING_AUTHORITY
prompt ===============================================
prompt
CREATE UNIQUE INDEX UK_ASSIGNING_AUTHORITY_CODE ON ASSIGNING_AUTHORITY (CODE);

prompt
prompt Creating indexes for table CALENDAR_DEFINITION
prompt ===============================================
prompt
CREATE UNIQUE INDEX UK_CALENDAR_DEF_CODE ON CALENDAR_DEFINITION (CODE);

prompt
prompt Creating indexes for table CALENDAR_INSTANCE
prompt ===============================================
prompt

prompt
prompt Creating indexes for table CODING_CODE
prompt ===============================================
prompt

prompt
prompt Creating indexes for table COMMON_NAMECODE
prompt ===============================================
prompt

prompt
prompt Creating indexes for table COMMUNICATION_CHANNEL
prompt ===============================================
prompt

prompt
prompt Creating indexes for table CONFIG_KEY
prompt ===============================================
prompt
CREATE UNIQUE INDEX UK_BS1R4DKFCX4UBXD23E24PW4EL ON CONFIG_KEY (KEY);

prompt
prompt Creating indexes for table CONFIG_NAME_SPACE
prompt ===============================================
prompt
CREATE UNIQUE INDEX UK_H9C66XA9812L2IYS2WJ5Y557W ON CONFIG_NAME_SPACE (NAME);

prompt
prompt Creating indexes for table CONFIG_VALUE
prompt ===============================================
prompt

prompt
prompt Creating indexes for table CONFIG_VALUE_BLOB
prompt ===============================================
prompt

prompt
prompt Creating indexes for table DEPARTMENT
prompt ===============================================
prompt

prompt
prompt Creating indexes for table EXCEL_FILE
prompt ===============================================
prompt
CREATE UNIQUE INDEX UK_EXCEL_FILE_TAGNAME ON EXCEL_FILE (TAG, NAME);

prompt
prompt Creating indexes for table EXCEL_FILE_REV
prompt ===============================================
prompt

prompt
prompt Creating indexes for table EXCEL_FILE_REV_OUTPUT
prompt ===============================================
prompt

prompt
prompt Creating indexes for table FACILITY
prompt ===============================================
prompt

prompt
prompt Creating indexes for table IDENTITY_CODE
prompt ===============================================
prompt
CREATE UNIQUE INDEX UK_IDENTITY_CODE_CODE ON IDENTITY_CODE (CODE);

prompt
prompt Creating indexes for table MODALITY
prompt ===============================================
prompt
CREATE UNIQUE INDEX UK_MODALITY_CODE ON MODALITY (CODE);
CREATE UNIQUE INDEX UK_MODALITY_NAME_AETITLE ON MODALITY (NAME, AETITLE);

prompt
prompt Creating indexes for table PATIENT
prompt ===============================================
prompt

prompt
prompt Creating indexes for table PROFESSIONAL
prompt ===============================================
prompt

prompt
prompt Creating indexes for table PROFESSIONAL_DEPARTMENT
prompt ===============================================
prompt

prompt
prompt Creating indexes for table PROFESSIONAL_SPECIALISM
prompt ===============================================
prompt

prompt
prompt Creating indexes for table RESOURCE_DEFINITION
prompt ===============================================
prompt
CREATE UNIQUE INDEX UK_RESOURCE_DEF_CODE ON RESOURCE_DEFINITION (CODE);

prompt
prompt Creating indexes for table RESOURCE_LAYOUT
prompt ===============================================
prompt

prompt
prompt Creating indexes for table ROOM
prompt ===============================================
prompt
CREATE UNIQUE INDEX UK_ROOM_CODE ON ROOM (CODE);

prompt
prompt Creating indexes for table ROOM_DEPARTMENT
prompt ===============================================
prompt

prompt
prompt Creating indexes for table ROOM_FACILITY
prompt ===============================================
prompt

prompt
prompt Creating indexes for table ROOM_MODALITY
prompt ===============================================
prompt

prompt
prompt Creating indexes for table SEC_DOMAIN
prompt ===============================================
prompt

prompt
prompt Creating indexes for table SEC_EXTERNAL_ROLE
prompt ===============================================
prompt

prompt
prompt Creating indexes for table SEC_PASSWORD
prompt ===============================================
prompt

prompt
prompt Creating indexes for table SEC_ROLE
prompt ===============================================
prompt

prompt
prompt Creating indexes for table SEC_ROLE_MAPPING
prompt ===============================================
prompt

prompt
prompt Creating indexes for table SEC_TOKEN
prompt ===============================================
prompt

prompt
prompt Creating indexes for table SEC_USER
prompt ===============================================
prompt

prompt
prompt Creating indexes for table SEC_USER_DOMAIN
prompt ===============================================
prompt

prompt
prompt Creating indexes for table SEC_USER_ROLE
prompt ===============================================
prompt


