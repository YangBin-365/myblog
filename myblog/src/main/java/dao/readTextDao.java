package dao;

import domain.text;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

/**
 * @Author: 杨斌
 * @Date: 2020/3/22 0022 0:32
 */
public class readTextDao {
    private static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public List<text> findNewFour() {
        String sql = "select * from textinfo order by creatTime DESC limit 4";
        List<text> list = template.query(sql, new BeanPropertyRowMapper<>(text.class));
        return list;
    }

    public int count() {
        String sql = "select count(*) from textinfo";
        Integer count = template.queryForObject(sql, Integer.class);
        return count;
    }

    public List<text> findTopThree() {
        String sql = "select * from textinfo order by `count` ASC limit 3";
        List<text> list = template.query(sql, new BeanPropertyRowMapper<>(text.class));
        return list;
    }

    public List<String> findLabel() {
        String sql = "select distinct label from textinfo";
        List<String> list = template.queryForList(sql, String.class);
        return list;
    }

    public text findOneByid(int id) {
        String sql = "select * from textinfo where id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(text.class), id);
    }

    public void insertText(text t) {
        String sql = "insert into textinfo values(?,?,?,?,?,?,?);";
        template.update(sql, null, t.getTitle(), t.getTextAddress(), t.getCreatTime(), t.getLabel(), t.getCount(), t.getPicture());
    }

}
