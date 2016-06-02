package com.DAO;

public class DAOFactory {
	public static GuitarDAO getGuitarDAOInstance()
	{
		return new GuitarDAOImpl() ;
	}
}
