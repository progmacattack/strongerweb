package strongerweb.dao;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserAccountDao {
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	public List<UserAccount> getUserAccounts() {
		return jdbc.query("select * from useraccount", new RowMapper<UserAccount>() {
			public UserAccount mapRow(ResultSet rs, int rowNum) throws SQLException { 
				UserAccount userAccount = new UserAccount();
				userAccount.setId(rs.getInt("id"));
				userAccount.setUsername(rs.getString("username"));
				return userAccount;
			}
		});
	}
	
	public boolean create(UserAccount userAccount) {
		BeanPropertySqlParameterSource parameters = new BeanPropertySqlParameterSource(userAccount);
		return jdbc.update("insert into useraccount(username, password) values (:username, :password)", parameters) == 1;
	}

	public UserAccount getUserAccount(int id) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("id", id);
		
		UserAccount userAccount = jdbc.queryForObject("select * from userAccount where id = :id", parameters, new RowMapper<UserAccount>() {
			public UserAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserAccount userAccount = new UserAccount();
				userAccount.setId(rs.getInt("id"));
				userAccount.setName(rs.getString("name"));
				userAccount.setEmail(rs.getString("email"));
				userAccount.setUsername(rs.getString("username"));
				return userAccount;
			}
		});
		
		return userAccount;
	}
}
