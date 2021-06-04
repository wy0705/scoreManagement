package dao;

import entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class TeacherDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Teacher findByTeaId(int id){
        final Teacher teacher=new Teacher();
        String sql="select name password from teacher where tid=?";
        jdbcTemplate.query(sql, new Object[]{id}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                teacher.setName(resultSet.getString(1));
                teacher.setPassword(resultSet.getString(2));
            }
        });
        return teacher;
    }

    public Teacher findByTeaName(String name){
        final Teacher teacher=new Teacher();
        String sql="select tid,password from teacher where name=?";
        jdbcTemplate.query(sql, new Object[]{name}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                teacher.setTid(resultSet.getInt(1));
                teacher.setPassword(resultSet.getString(2));
            }
        });
        return teacher;
    }
    public int insertTeacher(Teacher teacher){
        String sql="insert into teacher(name,password) value(?,?)";
        return jdbcTemplate.update(sql,teacher.getName(),teacher.getPassword());
    }
}
