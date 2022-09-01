package com.computer.store.service;

import java.io.IOException;

import javax.servlet.ServletException;

public interface InfoReterivingService
{
	void retriveInfo(String message) throws ServletException, IOException;
}