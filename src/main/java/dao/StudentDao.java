package dao;

import entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Student findByStuId(int id){
        final Student student=new Student();
        String sql="select sid,name,age,major,password from student where id=?";
        jdbcTemplate.query(sql, new Object[]{id}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                student.setSid(resultSet.getString(1));
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getInt(3));
                student.setMajor(resultSet.getString(4));
                student.setPassword(resultSet.getString(5));
            }
        });
        return student;
    }


    public Student findByName(String name){
        final Student student=new Student();
        String sql="select sid,name,age,major,password from student where name=?";
        jdbcTemplate.query(sql, new Object[]{name}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                student.setSid(resultSet.getString(1));
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getInt(3));
                student.setMajor(resultSet.getString(4));
                student.setPassword(resultSet.getString(5));
            }
        });
        return student;
    }

    public int insertStudent(Student student){
        String sql="insert into student(sid,name,age,major,password) value(?,?,?,?,?)";
        return jdbcTemplate.update(sql,student.getSid(),student.getName(),student.getAge(),student.getMajor(),student.getPassword());
    }
}
