<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.sql.*,java.util.Enumeration"
	import="java.sql.Connection"%>
<html>
<head>
<title>Test</title>

</head>
<body>

	<%
		String url = "jdbc:mysql://localhost:3306/shiva";
		Connection con = null;
		Statement stmt;
		ResultSet rs = null;
		String query, query1;
		PreparedStatement stmt1;

		try {

			try {

				Class.forName("com.mysql.jdbc.Driver");
			} catch (Exception e) {
				out.println("driver_not_found" + e.getMessage());
			}

			con = DriverManager.getConnection(url, "root", "");

			/* int id1 = 1115;
			String word1 = "आई";
			String pos1 = "noun";

			stmt1 = con
					.prepareStatement("insert into oldernewsdetails values('"
							+ id1 + "','" + word1 + "','" + pos1 + "','22/02/2015')");
			stmt1.executeUpdate(); */

			stmt = con.createStatement();
			query = "select * from oldernewsdetails ";
			ResultSet result = stmt.executeQuery(query);

			while (result.next()) {
				String id = result.getString(1);

				String word2 = result.getString(2);

				String pos2 = result.getString(3);
	%>
	<br>
	<%
		out.println(id);
	%>

	<%
		out.println(word2);
	%>
	<%
		out.println(pos2);
	%>


	<%
		}
		} catch (Exception e) {
			out.println("SQLException_caught:_" + e.getMessage());
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}

		}
	%>
	<br> Second JSP page...................
</body>
</html>