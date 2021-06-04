package dao;

import entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CourseDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Course findByCouId(int id){
        final Course course=new Course();
        String sql="select name,tid,sid,score from course where cid=?";
        jdbcTemplate.query(sql, new Object[]{id}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                course.setName(resultSet.getString(1));
                course.setTid(resultSet.getInt(2));
                course.setSid(resultSet.getString(3));
                course.setScore(resultSet.getInt(4));
            }
        });
        return course;
    }

    public Course findByCouName(String name){
        final Course course=new Course();
        String sql="select tid,sid,score from course where name=?";
        jdbcTemplate.query(sql, new Object[]{name}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                course.setTid(resultSet.getInt(2));
                course.setSid(resultSet.getString(3));
                course.setScore(resultSet.getInt(4));
            }
        });
        return course;
    }

    public List<Integer> findByCouTea(int tid){
        String sql="select name,sid,score from course where tid=?";
        return jdbcTemplate.query(sql, new Object[]{tid}, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getInt(i);
            }
        });
    }

    public int insertCourse(Course course){
        String sql="insert into course(name,tid,sid,score) value(?,?,?,?)";
        return jdbcTemplate.update(sql,course.getName(),course.getTid(),course.getSid(),course.getScore());
    }
}
