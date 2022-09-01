package com.computer.store.service;

import java.io.IOException;

import javax.servlet.ServletException;

public interface CreationService extends ServiceWithUserPage 
{
	void create() throws ServletException, IOException;
}