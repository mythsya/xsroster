set serveroutput on;
declare 
  lIdxDDLStr string(2000);
begin
  DBMS_OUTPUT.ENABLE(1000000);
  
  DBMS_OUTPUT.PUT_LINE('');
  DBMS_OUTPUT.PUT_LINE('spool create_roster_indexes.log');
  DBMS_OUTPUT.PUT_LINE('');
  
  for tbl in (select * from user_tables t where t.temporary = 'N' order by t.table_name) 
  loop
      DBMS_OUTPUT.PUT_LINE('prompt');      
      DBMS_OUTPUT.PUT_LINE('prompt Creating indexes for table '||tbl.table_name);
      DBMS_OUTPUT.PUT_LINE('prompt ===============================================');
      DBMS_OUTPUT.PUT_LINE('prompt');

      for idx in (select * from user_indexes t where t.table_name=tbl.table_name and t.index_type in ('NORMAL', 'FUNCTION-BASED NORMAL') and t.index_name not like 'SYS_%' order by t.index_name) 
      loop
          lIdxDDLStr := '';
          
          select replace(replace(substr(ddlstr, 4, instr(ddlstr, 'PCTFREE')-8),'"'||idx.table_owner||'".',''),'"','')||';' into lIdxDDLStr from (select dbms_metadata.get_ddl('INDEX', idx.index_name, idx.table_owner) ddlstr from dual);
         
          if lIdxDDLStr is not null then
          	DBMS_OUTPUT.PUT_LINE(lIdxDDLStr);
          else
            DBMS_OUTPUT.PUT_LINE('--EMPTY--');
          end if;
         
      end loop;
      
      DBMS_OUTPUT.PUT_LINE('');
         
  end loop;
  
end;
/
