package com.computer.store.admin.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.UserRepo;
import com.computer.store.service.DeletionService;
import com.computer.store.service.impl.user.UserDeletionService;

@WebServlet("/admin/delete_user")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteUser() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeletionService service = new UserDeletionService(request, response, new UserRepo());
		service.delete();
	}

}
