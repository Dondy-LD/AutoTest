package com.dao;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtilTest {
  @Test
  public void f() {
	  
  }
  @Test
  public void f1() {
	  JDBCUtil DB = new JDBCUtil("com.mysql.jdbc.Driver", "jdbc:mysql://rm-bp13er8v8trdr098eo"
	  		+ ".mysql.rds.aliyuncs.com:3306/tax_test?autoReconnectForPools=true&useUnicode=true"
	  		+ "&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull", "test_manager", "test666dingju");
	  Connection conn = DB.getConnection();
	  Statement statement = null;
		try {
			statement = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "SELECT \r\n" + 
				"  md_company_id, md_company_name\r\n" + 
				"FROM\r\n" + 
				"  biz_tax_instance bti,\r\n" + 
				"  biz_tax_instance_category btic \r\n" + 
				"WHERE bti.`id` = btic.`biz_tax_instance_id` \r\n" + 
				"  AND bti.`md_company_name` = '深圳市通达方商贸有限公司' AND btic.`biz_tax_md_category_id` = 105";
		try {
			ResultSet rs = statement.executeQuery(sql);
			System.out.println("----------------------------------------");
			System.out.println("ִ查询结果如下：");
			System.out.println("----------------------------------------");
			System.out.println("公司ID" + "\t" + "公司名称");
			System.out.println("----------------------------------------");
			int ID=0;
			String name = null;
			while(rs.next()) {
				ID = rs.getInt("md_company_id");
				name = rs.getString("md_company_name");
				
				System.out.println(ID + "\t" + name); 
			}
			assertEquals(ID, 96303);
			rs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
}
