package com.restapi.FlightApi;

import java.util.*;
import java.sql.*;

public class FlightRepo {
	String url;
	String username;
	String password;
	
	public FlightRepo()
	{
		try{
			url = "jdbc:mysql://ucwjr6uj9unt4c2i:kXKKOa24te8RTOyfm0mf@bntmgq2mioer8nurvvm0-mysql.services.clever-cloud.com:3306/bntmgq2mioer8nurvvm0";
		    username = "ucwjr6uj9unt4c2i";
			password = "kXKKOa24te8RTOyfm0mf";
			String driver = "com.mysql.cj.jdbc.Driver";
			Class.forName(driver);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}	
	public void create(Flight a1) {
		String sql = "insert into flights values(?,?,?,?,?,?,?,?)";
		try
		{
			
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, a1.getId());
			st.setString(2, a1.getDeptApt());
			st.setString(3, a1.getArrApt());
			st.setString(4, a1.getDeptTime());
			st.setString(5, a1.getArrTime());
			st.setInt(6, a1.getDistance());
			st.setInt(7, a1.getPrice());
			st.setString(8, a1.getType());
			st.executeUpdate();
			st.close();
			con.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	
	public Flight getFlightById(int id){
		String sql= "select * from flights where id=" + id;
		Flight a=new Flight();
		try{		
			Connection con = DriverManager.getConnection(url,username,password);
			Statement st=con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				a.setId(rs.getInt(1));
				a.setDeptApt(rs.getString(2));
				a.setArrApt(rs.getString(3));
				a.setDeptTime(rs.getString(4));
				a.setArrTime(rs.getString(5));
				a.setDistance(rs.getInt(6));
				a.setType(rs.getString(7));
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		return a;
	}

	public List<Flight> FlightsByDestination(String departure, String arrival) {
		String sql= "select * from flights where DeptApt=" + departure + " and ArrApt=" + arrival;
		List<Flight> flights=new ArrayList<Flight>();
		try{
			Connection con = DriverManager.getConnection(url,username,password);
			Statement st=con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				Flight f = new Flight();
				f.setId(rs.getInt(1));
				f.setDeptApt(rs.getString(2));
				f.setArrApt(rs.getString(3));
				f.setDeptTime(rs.getString(4));
				f.setArrTime(rs.getString(5));
				f.setDistance(rs.getInt(6));
				f.setType(rs.getString(7));
				flights.add(f);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		return flights;
		
	}

	public List<Flight> FlightsDepartingFrom(String airport) {
		String sql= "select * from flights where DeptApt=" + airport;
		List<Flight> flights=new ArrayList<Flight>();
		try{
			Connection con = DriverManager.getConnection(url,username,password);
			Statement st=con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				Flight f = new Flight();
				f.setId(rs.getInt(1));
				f.setDeptApt(rs.getString(2));
				f.setArrApt(rs.getString(3));
				f.setDeptTime(rs.getString(4));
				f.setArrTime(rs.getString(5));
				f.setDistance(rs.getInt(6));
				f.setType(rs.getString(7));
				flights.add(f);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		return flights;
		
	}
	
	public List<Flight> getFlightByType(String type){

		List<Flight> flights= new ArrayList<>();
		String sql = "select * from flights where type=" + type;
		try{		
			Connection con = DriverManager.getConnection(url,username,password);
			Statement st=con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				Flight a=new Flight();
				a.setId(rs.getInt(1));
				a.setDeptApt(rs.getString(2));
				a.setArrApt(rs.getString(3));
				a.setDeptTime(rs.getString(4));
				a.setArrTime(rs.getString(5));
				a.setDistance(rs.getInt(6));
				a.setType(rs.getString(7));
				
				flights.add(a);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return flights;
		
	}
	
	public List<Flight> FlightsArrivingAt(String airport) {
		String sql= "select * from flights where ArrApt=" + airport;
		List<Flight> flights=new ArrayList<Flight>();
		try{
			Connection con = DriverManager.getConnection(url,username,password);
			Statement st=con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				Flight f = new Flight();
				f.setId(rs.getInt(1));
				f.setDeptApt(rs.getString(2));
				f.setArrApt(rs.getString(3));
				f.setDeptTime(rs.getString(4));
				f.setArrTime(rs.getString(5));
				f.setDistance(rs.getInt(6));
				f.setType(rs.getString(7));
				flights.add(f);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		return flights;
		
	}
	
	
	public Flight getflight(int id) 
	{
		Flight a = new Flight();
		String sql="select * from flights where id="+ id;
		try 
		{
			
			Connection con = DriverManager.getConnection(url,username,password);
			Statement st = con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			if(rs.next()) {
				a.setId(rs.getInt(1));
				a.setDeptApt(rs.getString(2));
				a.setArrApt(rs.getString(3));
				a.setDeptTime(rs.getString(4));
				a.setArrTime(rs.getString(5));
				a.setDistance(rs.getInt(6));
				a.setPrice(rs.getInt(7));
				a.setType(rs.getString(8));
			}
			st.close();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return a;
	}

	public void arrTimeupdate(int id, String t)
	{
		String sql="update flights set ArrTime = ? where id=?";
		try 
		{
			
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st= con.prepareStatement(sql);
			st.setString(1, t);
			st.setInt(2, id);
			st.executeUpdate();
			st.close();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
	}

	public void deptTimeupdate(int id, String t) 
	{
		String sql="update flights set DeptTime = ? where id=?";
		try 
		{
			
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st= con.prepareStatement(sql);
			st.setString(1, t);
			st.setInt(2, id);
			st.executeUpdate();
			st.close();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}

	public void arrAptupdate(int id, String s) 
	{
		String sql="update flights set ArrApt = ? where id=?";
		try 
		{
			
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st= con.prepareStatement(sql);
			st.setString(1, s);
			st.setInt(2, id);
			st.executeUpdate();
			st.close();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}

	public void deptAptupdate(int id, String s) 
	{
		String sql="update flights set DeptApt = ? where id=?";
		try 
		{
			
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st= con.prepareStatement(sql);
			st.setString(1, s);
			st.setInt(2, id);
			st.executeUpdate();
			st.close();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}

	public void priceupdate(int id, int p) 
	{
		String sql="update flights set Price = ? where id=?";
		try 
		{
			
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st= con.prepareStatement(sql);
			st.setInt(1, p);
			st.setInt(2, id);
			st.executeUpdate();
			st.close();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void delete(int id) {
		String sql = "delete from flights where id=?";
		try
		{
			
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
			st.close();
			con.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
