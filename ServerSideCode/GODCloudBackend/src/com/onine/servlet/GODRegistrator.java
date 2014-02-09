package com.onine.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.onine.god.RegisterDevice;
import com.onine.logger.Log;

/**
 * Servlet implementation class GODRegistrator
 */
public class GODRegistrator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = new Log().getLogger(GODRegistrator.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GODRegistrator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		logger.info("Request Received");
		
		String deviceId= request.getParameter("deviceId");
		String mode = request.getParameter("mode");
		
		logger.info("Device ID :"+ deviceId+ " Mode :"+mode);
		
		RegisterDevice registerDevice = new RegisterDevice();
		
		registerDevice.mergeDevice(deviceId, Integer.parseInt(mode));	
		
		logger.info("Registration Finished");
	}

}
