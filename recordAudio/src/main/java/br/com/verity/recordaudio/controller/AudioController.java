package br.com.verity.recordaudio.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AudioController {
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@PostMapping("send-audio")
	public void requestAudio(@RequestParam MultipartFile audio,HttpServletResponse response) {
		try {
			audio.transferTo(new File("C:\\Users\\igor2\\Desktop\\" + audio.getOriginalFilename() + ".mp3"));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		ServletOutputStream stream = null;
		BufferedInputStream buf = null;
		try {
		  stream = response.getOutputStream();
		  File mp3 = new File("C:\\Users\\igor2\\Desktop\\" + audio.getOriginalFilename() + ".mp3");

		  //set response headers
		  response.setContentType("audio/ogg; codecs=opus"); 

		  response.addHeader("Content-Disposition", "attachment; filename=" + audio.getOriginalFilename());

		  response.setContentLength((int) mp3.length());

		  FileInputStream input = new FileInputStream(mp3);
		  buf = new BufferedInputStream(input);
		  int readBytes = 0;
		  //read from the file; write to the ServletOutputStream
		  while ((readBytes = buf.read()) != -1)
		    stream.write(readBytes);
		} catch (IOException ioe) {
		  try {
			throw new ServletException(ioe.getMessage());
		} catch (ServletException e) {
			e.printStackTrace();
		}
		} finally {
		  if (stream != null)
			try {
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		  if (buf != null)
			try {
				buf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
