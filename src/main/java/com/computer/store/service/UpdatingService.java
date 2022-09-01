package com.computer.store.service;

import java.io.IOException;

import javax.servlet.ServletException;

public interface UpdatingService extends ServiceWithUserPage 
{
	void update() throws ServletException, IOException;
}