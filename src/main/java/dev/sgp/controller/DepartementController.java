package dev.sgp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.sgp.entite.Departements;

@RestController
@RequestMapping("/departements")
public class DepartementController {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	RowMapper<Departements> rowMapper = { rs, num -> return new Departements(rs.getInt("ID"), rs.getString("NOM")) };

	@RequestMapping("/")
	List<Departements> lister() {
		return this.jdbcTemplate.query("select * from DEPARTEMENT", rowMapper);
	}

}
