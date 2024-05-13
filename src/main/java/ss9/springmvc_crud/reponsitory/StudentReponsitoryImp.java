package ss9.springmvc_crud.reponsitory;

import org.springframework.stereotype.Repository;
import ss9.springmvc_crud.model.Student;
import ss9.springmvc_crud.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentReponsitoryImp implements StudentReponsitory{
    @Override
    public List<Student> findAll() {
        Connection conn = null;
        CallableStatement callSt= null;
        List<Student> listStudent= new ArrayList<>();
        try{
            conn = ConnectionDB.getConnection();
            callSt = conn.prepareCall("{call get_all_student}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()){
                Student student = new Student();
                student.setStudentId(rs.getInt("student_id"));
                student.setStudentName(rs.getString("student_name"));
                student.setAge(rs.getInt("age"));
                student.setStatus(rs.getBoolean("student_status"));
                listStudent.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listStudent;
    }

    @Override
    public boolean create(Student student) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.getConnection();
            callSt = conn.prepareCall("{call insert_student(?,?,?)}");
            callSt.setString(1, student.getStudentName());
            callSt.setInt(2, student.getAge());
            callSt.setBoolean(3, student.isStatus());
            callSt.executeUpdate();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }
    @Override
    public void update(Student student) {
        Connection conn = ConnectionDB.getConnection();
        try {
            CallableStatement callSt = conn.prepareCall("{call update_student(?,?,?,?)}");
            callSt.setInt(1,student.getStudentId());
            callSt.setString(2,student.getStudentName());
            callSt.setInt(3,student.getAge());
            callSt.setBoolean(4,student.isStatus());

            callSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public void deleteById(Integer id) {
        Connection conn = ConnectionDB.getConnection();
        try {
            CallableStatement callSt = conn.prepareCall("{call delete_student(?)}");
            callSt.setInt(1,id);
            callSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student findById(Integer id) {
        Connection conn = ConnectionDB.getConnection();
        try {
            CallableStatement callSt = conn.prepareCall("{call get_student_by_id(?)}");
            callSt.setInt(1,id);
            ResultSet rs = callSt.executeQuery();
            if(rs.next()){
                Student student = new Student();
                student.setStudentId(rs.getInt("student_id"));
                student.setStudentName(rs.getString("student_name"));
                student.setAge(rs.getInt("age"));
                student.setStatus(rs.getBoolean("student_status"));
                return student;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
