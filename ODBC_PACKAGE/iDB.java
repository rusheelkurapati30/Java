package ODBC_PACKAGE;

import ODBC_PACKAGE.dbMySql;
import ODBC_PACKAGE.dbSqlite;
// import ODBC_PACKAGE.dbSQLite;


public interface iDB
{
	public void insert();
	public void display();
	public void update();
	public void delete();
	public void search();
	public void exit();
}
