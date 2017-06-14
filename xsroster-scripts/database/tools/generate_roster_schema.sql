set serveroutput on;
-- Created on 2012-11-16 by AXFNK 
declare 
  -- Local variables here
  i integer;
  rowDML varchar2(2000);
  dataType varchar2(100);
  pkDML  varchar2(2000);
  pkCols  varchar2(1000);
  ukDML  varchar2(2000);
  ukCols  varchar2(1000);
  fkDML  varchar2(2000);
  fkCols  varchar2(1000);
  fkTbl  varchar2(100);
begin
  DBMS_OUTPUT.ENABLE(1000000);
  
  DBMS_OUTPUT.PUT_LINE('');
  DBMS_OUTPUT.PUT_LINE('spool create_roster_schema.log');
  DBMS_OUTPUT.PUT_LINE('');
      
  -- Test statements here
  for tbl in (select * from user_tables t where t.temporary = 'N' order by t.table_name) 
  loop
      DBMS_OUTPUT.PUT_LINE('prompt');
      DBMS_OUTPUT.PUT_LINE('prompt Creating table '||tbl.table_name);
      DBMS_OUTPUT.PUT_LINE('prompt ===============================================');
      DBMS_OUTPUT.PUT_LINE('prompt');
      DBMS_OUTPUT.PUT_LINE('create table '||tbl.table_name);
      DBMS_OUTPUT.PUT_LINE('(');
      
      rowDML := '';
      for col in (select *
                    from user_tab_columns c
                   where c.table_name = tbl.table_name
                   order by c.column_name)
      loop
          if rowDML is not null then
              DBMS_OUTPUT.PUT_LINE(rowDML||',');
          end if;
          dataType := col.data_type;
          if dataType='VARCHAR2' or dataType='CHAR' then
             dataType := dataType||'('||nvl(col.char_length,255)||' CHAR)';
          elsif dataType='RAW' then
             dataType := dataType||'('||nvl(col.data_length,1024)||')'; 
          elsif dataType='NUMBER' then
             dataType := dataType|| '('||nvl(col.data_precision,10)||')';
          end if;
          if col.nullable='N' then
             dataType := dataType||' not null';
          end if;
          rowDML := '  '||RPAD(col.column_name, 34, ' ')||dataType;
          
      end loop;
      DBMS_OUTPUT.PUT_LINE(rowDML);      
      DBMS_OUTPUT.PUT_LINE(')');
      DBMS_OUTPUT.PUT_LINE(';');
      
      for pk in (select *  from user_constraints t where t.table_name = tbl.table_name and t.constraint_type='P')
      loop
          pkDML := 'alter table '||tbl.table_name||' add primary key (';
          pkCols := '';
          for pkcol in (select * from user_cons_columns t2 where t2.constraint_name = pk.constraint_name order by position asc)
          loop
              if pkCols is not null then
                 pkCols := pkCols||',';
              end if;
              pkCols := pkCols||pkcol.column_name;
          end loop;
          pkDML := pkDML||pkCols||');';
          DBMS_OUTPUT.PUT_LINE(pkDML);
      end loop;
      
      for uk in (select *  from user_constraints t where t.table_name = tbl.table_name and t.constraint_type='U')
      loop
          ukDML := 'alter table '||tbl.table_name||' add unique (';
          ukCols := '';
          for ukcol in (select * from user_cons_columns t2 where t2.constraint_name = uk.constraint_name order by position asc)
          loop
              if ukCols is not null then
                 ukCols := ukCols||',';
              end if;
              ukCols := ukCols||ukcol.column_name;
          end loop;
          ukDML := ukDML||ukCols||');';
          DBMS_OUTPUT.PUT_LINE(ukDML);
      end loop;
      
      DBMS_OUTPUT.PUT_LINE('');
  end loop;
  
  DBMS_OUTPUT.PUT_LINE('');
  DBMS_OUTPUT.PUT_LINE('');
  
  for tbl in (select * from user_tables t where t.temporary = 'N' order by t.table_name) 
  loop
      DBMS_OUTPUT.PUT_LINE('prompt');
      DBMS_OUTPUT.PUT_LINE('prompt Creating foreign key for table '||tbl.table_name);
      DBMS_OUTPUT.PUT_LINE('prompt ===============================================================');
      DBMS_OUTPUT.PUT_LINE('prompt');
      
      for fk in (select *  from user_constraints t where t.table_name = tbl.table_name and t.constraint_type='R' order by t.constraint_name)
      loop
          fkDML := 'alter table '||tbl.table_name||' add constraint '||fk.constraint_name||' foreign key (';
          fkCols := '';
          for fkcol in (select * from user_cons_columns t2 where t2.constraint_name = fk.constraint_name order by position asc)
          loop
              if fkCols is not null then
                 fkCols := fkCols||',';
              end if;
              fkCols := fkCols||fkcol.column_name;
          end loop;
          fkDML := fkDML||fkCols||') references ';
          
          fkTbl := '';
          for rkcol in (select * from user_cons_columns t2 where t2.constraint_name = fk.r_constraint_name order by position asc)
          loop
              if fkTbl is null then
                 fkTbl := rkcol.table_name;
                 fkDML := fkDML||fkTbl||' (';
              else
                 fkDML := fkDML||',';
              end if;
              
              fkDML := fkDML||rkcol.column_name;
              
          end loop;
          fkDML := fkDML||');';
          
          DBMS_OUTPUT.PUT_LINE(fkDML);
      end loop;
      
      DBMS_OUTPUT.PUT_LINE('');
      
  end loop;
  
  
end;
/