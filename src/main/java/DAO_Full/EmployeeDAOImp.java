package DAO_Full;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImp implements EmployeeDAO {
    private static final Connection conn = DB.getConnection();

    // CRUD - READ, GET.
    @Override
    public Employee get(int id) {
        try {
            Employee employee = null;

            String sql = "SELECT id, employeeId, firstName, lastName, departmentName FROM employees WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet result = ps.executeQuery();

            if (result.next()) {
                int oid = result.getInt("id");
                int employeeId = result.getInt("employeeId");
                String firstName = result.getString("firstName");
                String lastName = result.getString("lastName");
                String departmentName = result.getString("departmentName");

                employee = new Employee(oid, employeeId, firstName, lastName, departmentName);
            }

            return employee;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Employee> getAll() throws SQLException {
        try {
            String sql = "SELECT id, employeeId, firstName, lastName, departmentName FROM employees";
            List<Employee> employees = new ArrayList<>();

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                int employeeId = rs.getInt("employeeId");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String departmentName = rs.getString("departmentName");

                Employee employee = new Employee(id, employeeId, firstName, lastName, departmentName);
                employees.add(employee);
            }

            return employees;
        } catch (SQLException e) {
            throw new Error("Erro ao recuperar tudo: " + e);
        }
    }

    @Override
    public int save(Employee employee) throws SQLException {
        return 0;
    }

    // CRUD - CREATE, INSERT.
    @Override
    public int insert(Employee employee) throws SQLException {
        try {
            String sql = "INSERT INTO employees (employeeId, firstName, lastName, departmentName) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, employee.getEmployeeId());
            ps.setString(2, employee.getFirstName());
            ps.setString(3, employee.getLastName());
            ps.setString(4, employee.getDepartmentName());

            int result = ps.executeUpdate();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // Tentativa de fechar conexão - EVITA SQL INJECTION.
            try {
                conn.close();
            } catch (SQLException e) {
                throw new Error("Erro ao fechar conexão: " + e);
            }
        }
    }

    // CRUD - Update
    @Override
    public int update(Employee employee) throws SQLException {
        try {
            String sql = "UPDATE employees set employeeId = ?, firstName = ?, lastName = ?, departmentName = ? where id= ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, employee.getEmployeeId());
            ps.setString(2, employee.getFirstName());
            ps.setString(3, employee.getLastName());
            ps.setString(4, employee.getDepartmentName());
            ps.setInt(5, employee.getId());

            int result = ps.executeUpdate();
            return result;
        } catch (SQLException e) {
            throw new Error("Erro ao tentar atualizar o banco de Dados: " + e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new Error("Erro ao fechar conexão: " + e);
            }
        }
    }

    @Override
    public int delete(Employee employee) {
        try {
            String sql = "DELETE FROM employees WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, employee.getId());
            int result = ps.executeUpdate();
            return result;
        } catch (SQLException e) {
            throw new Error("Erro ao deletar:" + e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new Error("Erro ao fechar conexão: " + e);
            }
        }
    }
}
