package io.pivotal.cnde.cups;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class TagRepository {
    private final JdbcTemplate jdbcTemplate;

    public TagRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Tag> findAll() {
        return jdbcTemplate.query(
                "select id, label from Tag",
                rowMapper
        );
    }

    private RowMapper<Tag> rowMapper
            = (rs, num) -> TagBuilder.tagBuilder()
            .id(rs.getInt("id"))
            .label(rs.getString("label"))
            .build();
}
