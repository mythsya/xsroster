spool create_roster_schema.log

prompt
prompt =============================================================
prompt Connect to oracle via SYS, then create user ROSTER
prompt =============================================================

conn sys/agfa123 as sysdba;
alter profile default limit password_life_time unlimited;

create user roster default tablespace roster identified by agfa123 profile default account unlock;
grant resource,connect,unlimited tablespace, create view to roster;

prompt
prompt =============================================================
prompt Connect to oracle via ROSTER
prompt =============================================================

conn roster/agfa123;

@@schema\create_all_tables.sql
@@schema\create_all_views.sql
@@schema\create_all_indexes.sql


disconn;

spool off
