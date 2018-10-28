package com.caps.dev.dao;

import com.caps.dev.beans.Person;

public interface DAOimpl {
	public  void Create(Person person);
	public  void Search(Person person);
	public  void Update(Person person);
	public  void Delete(Person person);
}