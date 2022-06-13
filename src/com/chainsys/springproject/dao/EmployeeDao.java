package com.chainsys.springproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDao {
	/**
	 * oracleConnection 
	 * insertEmployee (Employee newemp)
	 * getEmployeeById(int id)
	 * getAllEmployee() 
	 * updateEmployee(Employee newemp) 
	 * deleteEmployee(int id)
	 */
	private Connection oracleConnection;
	// init-method
  private void getconnection() {
		String drivername = "oracle.jdbc.OracleDriver";
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password = "123";
		try {
			Class.forName(drivername);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			oracleConnection = DriverManager.getConnection(dbUrl, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	private java.sql.Date convertTosqlDate(java.util.Date date) {
		java.sql.Date sqldate = new java.sql.Date(date.getTime());
		return sqldate;
	}
// To insert new row to the table employees
public int insertEmployee(Employee newemp) {
		String insertquery = "insert into employees(EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY) values (?,?,?,?,?,?,?,?)";
		Connection con = null;
		int rows =0;
//		int rows ;
		PreparedStatement ps = null;
		try {
			con = oracleConnection;
			ps = con.prepareStatement(insertquery);
			ps.setInt(1, newemp.getEmp_id());
			ps.setString(2, newemp.getFirst_name());
			ps.setString(3, newemp.getLast_name());
			ps.setString(4, newemp.getEmail());
			// convert java.util.Date to java.sql.date
			ps.setString(5, newemp.getPhone_number());
			ps.setDate(6, convertTosqlDate(newemp.getHire_date()));
			ps.setString(7, newemp.getJob_id());
			ps.setFloat(8, newemp.getSalary());

			rows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(); // TODO: ExceptionManager
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace(); // TODO: ExceptionManager
			}
		}
		return rows;
	}
// for updating all the columns of the table
public int updateEmployee(Employee newemp) {
		String updatequery = "update employees set FIRST_NAME=?,LAST_NAME=?,EMAIL=?,PHONE_NUMBER =?,HIRE_DATE=?,JOB_ID=?,SALARY=? where employee_id=?";
		Connection con = null;
		int rows = 0;
		PreparedStatement ps = null;
		try {
			con = oracleConnection;
			ps = con.prepareStatement(updatequery);
			ps.setString(1, newemp.getFirst_name());
			ps.setInt(8, newemp.getEmp_id());
			ps.setString(2, newemp.getLast_name());
			ps.setString(3, newemp.getEmail());
			// convert java.util.Date to java.sql.date
			ps.setString(4, newemp.getPhone_number());
			ps.setDate(5, convertTosqlDate(newemp.getHire_date()));
			ps.setString(6, newemp.getJob_id());
			ps.setFloat(7, newemp.getSalary());

			ps.executeUpdate();
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(); // TODO: ExceptionManager
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace(); // TODO: ExceptionManager
			}
		}

		return rows;
	}
	// to update only one column of the table 
public int updateEmployeeFirstName(int id,String fname) {
		String updatequery = "update employees set FIRST_NAME=? where employee_id=?";
		Connection con = null;
		int rows = 0;
		PreparedStatement ps = null;
		try {
			con = oracleConnection;
			ps = con.prepareStatement(updatequery);
			ps.setString(1, fname);
			ps.setInt(2, id);
			ps.executeUpdate();
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(); // TODO: ExceptionManager
		}finally {
			try {
				ps.close(); 
			} catch (SQLException e) {
				e.printStackTrace(); // TODO: ExceptionManager
			}
		}

		return rows;
	}
public int updateEmployeeSalary(int id, float salary) {
		String updatequery = "update employees set SALARY=? where employee_id=?";
		Connection con = null;
		int rows = 0;
		PreparedStatement ps = null;
		try {
			con = oracleConnection;
			ps = con.prepareStatement(updatequery);
			ps.setDouble(1, salary );
			ps.setInt(2, id);
			ps.executeUpdate();
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(); // TODO: ExceptionManager
		}finally {
			try {
				ps.close(); 
			} catch (SQLException e) {
				e.printStackTrace(); // TODO: ExceptionManager
			}
		}
		return rows;
    }
	public int deleteEmployee(int id) {
		String deletequery = "delete from employees where EMPLOYEE_ID=?";
		Connection con = null;
		int rows = 0;
		PreparedStatement ps = null;
	
		try {
			con = oracleConnection;
			ps = con.prepareStatement(deletequery);
			ps.setInt(1, id);
			rows = ps.executeUpdate();	
		}catch(SQLException e) {
			e.printStackTrace(); // TODO: ExceptionManager
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace(); // TODO: ExceptionManager
			}
		}
		return rows;
	}
	//To retrive specific Employee data using employee_id
	public Employee getEmployeeById(int id){
		Employee emp =null;
		String selectquery = "select EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,HIRE_DATE,JOB_ID,SALARY  from Employees where employee_id = ? ";
		Connection con = null;
		PreparedStatement ps = null;
		 ResultSet rs  = null;
		try {
			con = oracleConnection;
			ps = con.prepareStatement(selectquery);
			ps.setInt(1, id);
			rs =ps.executeQuery();
			emp = new Employee();
			   while(rs.next()) {
		          emp.setEmp_id(rs.getInt(1));
		          emp .setFirst_name(rs.getString(2));
		          emp.setLast_name(rs.getString(3));
		          emp.setEmail(rs.getString(4));
		          java.util.Date date = new java.util.Date(rs.getDate(5).getTime());
		          emp.setHire_date(date);
		          emp.setJob_id(rs.getString(6));
		          emp.setSalary(rs.getFloat(7));
		        }
		}catch(SQLException e) {
			e.printStackTrace(); // TODO: ExceptionManager
		}finally {
			try {
				rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace(); // TODO: ExceptionManager
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace(); // TODO: ExceptionManager
			}
			
		}
		return emp;
	
	}
	//To retrieve all employee data 
	 public List<Employee> getAllEmployee(){
		 List<Employee> listOfEmployees = new ArrayList<Employee>();
		 Employee emp =null;
			String selectquery = "select EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,HIRE_DATE,JOB_ID,SALARY  from Employees ";
			Connection con = null;
			PreparedStatement ps = null;
			 ResultSet rs  = null;
			try {
				con = oracleConnection;
				ps = con.prepareStatement(selectquery);
				rs =ps.executeQuery();
				
				   while(rs.next()) {
					   emp = new Employee();
			          emp.setEmp_id(rs.getInt(1));
			          emp .setFirst_name(rs.getString(2));
			          emp.setLast_name(rs.getString(3));
			          emp.setEmail(rs.getString(4));
			          java.util.Date date = new java.util.Date(rs.getDate(5).getTime());
			          emp.setHire_date(date);
			          emp.setJob_id(rs.getString(6));
			          emp.setSalary(rs.getFloat(7));
			          listOfEmployees.add(emp);
			        }
			}catch(SQLException e) {
				e.printStackTrace(); // TODO: ExceptionManager
			}finally {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace(); // TODO: ExceptionManager
				}
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace(); // TODO: ExceptionManager
				}
			}
		 return listOfEmployees;
	 }
	 // destroy-method
	 public void close() {
		 try {
				oracleConnection.close();
			} catch (SQLException e) {
				e.printStackTrace(); // TODO: ExceptionManager
			} 
	 }
}