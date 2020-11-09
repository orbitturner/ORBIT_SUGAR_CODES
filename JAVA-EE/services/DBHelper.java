
package services;
import java.sql.*;

public class DBHelper {
	private Connection cnx;
	private Statement stmt;
	private PreparedStatement pstmt;
	private int nbrows;
	private static DBHelper db;

	public static DBHelper getInstance()
	{
		if(db==null)
		{
			db=new DBHelper();
		}
		return db;
	}
	public void beginTransaction() throws Exception{
		try {
			cnx.setAutoCommit(false);
		} catch (Exception e) {
			throw e;
		}
	}
	public void endTransaction() throws Exception{
		try {
			cnx.setAutoCommit(true);
		} catch (Exception e) {
			throw e;
		}
	}
	public void commit() throws Exception{
		try {
			cnx.commit();
		} catch (Exception e) {
			throw e;
		}
	}
	public void rollback() throws Exception{
		try {
			cnx.rollback();
		} catch (Exception e) {
			throw e;
		}
	}

	private void openConnexion() throws Exception
	{
		try {

			if (cnx==null || cnx.isClosed()) {
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/thiamservicedb";
				String user="root";
				String pw="";
				cnx = DriverManager.getConnection(url, user, pw);
				stmt = cnx.createStatement();
			}
		} catch (Exception e) {
			throw e;
		}
	}


	public int myExecuteUpdate(String sql) throws Exception
	{

		nbrows=0;
		try {
			openConnexion();
			nbrows=stmt.executeUpdate(sql);
		} catch (Exception e) {
			throw e;
		}
		return nbrows;
	}

	public ResultSet myExecuteQuery(String sql) throws Exception
	{

		ResultSet rs;
		try {
			openConnexion();
			rs=stmt.executeQuery(sql);
		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

	public void myPrepareStatement(String sql) throws Exception
	{
		try {
			openConnexion();
			if (sql.trim().toLowerCase().startsWith("insert")) {
				pstmt = cnx.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			}else{
				pstmt=cnx.prepareStatement(sql);
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public void addParametres(int i,Object valeur) throws SQLException
	{
		try {
			pstmt.setObject(i, valeur);
		} catch (SQLException e) {
			throw e;
		}
	}

	public int myExecutePrepareUpdate() throws Exception
	{

		nbrows=0;
		try {
			openConnexion();
			nbrows=pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		return nbrows;
	}

	public ResultSet myExecutePrepareQuery() throws Exception
	{

		ResultSet rs;
		try {
			openConnexion();
			rs=pstmt.executeQuery();
		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

	public int[] getGeneratedKeys() throws Exception
	{
		int[] keys=new int[nbrows];
		try {
			ResultSet rs=pstmt.getGeneratedKeys();
			int i=0;
			while(rs.next())
			{
				keys[i]=rs.getInt(1);
				i++;
			}
			rs.close();
		} catch (Exception e) {
			throw e;
		}
		return keys;
	}

	public void fermerConnexion() throws Exception
	{
		try {
			if(stmt!=null && !stmt.isClosed())
			{
				stmt.close();
			}
			if(pstmt!=null && !pstmt.isClosed())
			{
				pstmt.close();
			}
			if(cnx!=null && !cnx.isClosed())
			{
				cnx.close();
			}


		} catch (Exception e) {
			throw e;
		}
	}







}
