package com.aq.qmc.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aq.qmc.bean.CredentialsBean;
@Repository
public class AuthenticationUtility {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public boolean authenticate(CredentialsBean credBean) {
		System.out.println("user: "+credBean);
		Object[] paramList = {credBean.getUserid(), credBean.getPassword(), credBean.getUserType()};
		Object obj = null;
		try {
			obj = jdbcTemplate.queryForObject("select * from ec_tbl_user_credentials where userid=? and password=? and usertype=?",
					paramList,new RowMapper<CredentialsBean>() {
						
						@Override
						public CredentialsBean mapRow(ResultSet rs, int rowNum) throws SQLException {
							System.out.println("Size: "+rs.getFetchSize());
								CredentialsBean bean = new CredentialsBean();
								bean.setUserid(rs.getString("userid"));
								bean.setPassword(rs.getString("password"));
								bean.setUserType(rs.getString("usertype"));
								bean.setLoginStatus(rs.getInt("loginstatus"));
								System.out.println("bean: "+ bean);
								return bean;
						}
			});
		}catch (EmptyResultDataAccessException e) {
	        System.out.println(e.getMessage());
	    }	
		
		if(obj == null)
			return false;
		return true;
	}
	
	
	public void changeLoginStatus(CredentialsBean user, int loginStatus) {
		try {
			int updateLoginStatus = jdbcTemplate.update("update ec_tbl_user_credentials set loginstatus = "+loginStatus+" where userid='"+user.getUserid()+"' and password='"+user.getPassword()+"'");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public CredentialsBean getCredentialDataByUserid(String userid) {
		Object[] paramList = {userid};
		CredentialsBean obj = null;
		try {
			obj = (CredentialsBean)jdbcTemplate.queryForObject("select * from ec_tbl_user_credentials where userid=?",
					paramList,new RowMapper<CredentialsBean>() {
						
						@Override
						public CredentialsBean mapRow(ResultSet rs, int rowNum) throws SQLException {
							CredentialsBean bean = new CredentialsBean();
							bean.setUserid(rs.getString("userid"));
							bean.setPassword(rs.getString("password"));
							bean.setUserType(rs.getString("usertype"));
							bean.setLoginStatus(rs.getInt("loginstatus"));
							System.out.println("bean: "+ bean);
							return bean;
						}
			});
			System.out.println("strResult: "+obj);
		}catch (EmptyResultDataAccessException e) {
	        System.out.println(e.getMessage());
	    }	
		if(obj == null)
			return null;
		return obj;
	}
}
