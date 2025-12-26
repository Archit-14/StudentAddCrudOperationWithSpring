package com.jsp.studentadd.configuration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class StuCustomId implements IdentifierGenerator
{

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		String prefix = "STU-";
        int suffix = 0;

        try {
            
            JdbcConnectionAccess jdbcConnectionAccess = session.getJdbcConnectionAccess();
            Connection connection = jdbcConnectionAccess.obtainConnection();

            Statement stmt = connection.createStatement();
         
            String sql = "SELECT nextval('stu_id_seq')";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
            	suffix = rs.getInt(1);
            }

            rs.close();
            stmt.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return prefix + suffix; 
	}

	
	
}
