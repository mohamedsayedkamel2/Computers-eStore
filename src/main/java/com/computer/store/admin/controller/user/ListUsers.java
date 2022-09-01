package com.computer.store.admin.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.UserRepo;
import com.computer.store.service.InfoReterivingService;
import com.computer.store.service.impl.user.UserInfoRetriverService;


@WebServlet("/admin/list_users")
public class ListUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListUsers() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InfoReterivingService info = new UserInfoRetriverService(request, response, new UserRepo());
		info.retriveInfo(null);
	}
}
