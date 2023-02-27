package com.emms.wipro.iaf.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emms.wipro.iaf.eAssessment.forms.NavBarForms;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Controller
@RequestMapping("/navbar")
public class NavbarController {

	@GetMapping("/navlist")
	@ResponseBody
	public String getNavList() {
		StringBuilder sb = new StringBuilder();
		File file = new File("D:\\eManagement\\backend\\eManagement\\eManagement\\src\\navbar.json");
		try {
			InputStream in = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line + System.lineSeparator());
			}
			in.close();
			br.close();
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	@PostMapping("/updateNav")
	@ResponseBody
	public String updateNav(@RequestBody final NavBarForms newnav) {
		StringBuilder sb = new StringBuilder();
		String currentData = getNavList();
		sb.append(currentData + System.lineSeparator());
		try {
			FileWriter fw = new FileWriter(
					new File("D:\\eManagement\\backend\\eManagement\\eManagement\\src\\navbar.json"));
//			OutputStream out = new FileOutputStream(
//					new File("D:\\eManagement\\backend\\eManagement\\eManagement\\src\\navbar.json"));
//			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
			System.out.println(newnav.toString());
			sb.append(newnav.toString() + System.lineSeparator());
			System.out.println(sb.toString());

			fw.write(sb.toString().trim());

//			fw.append(sb.toString().trim());

//			writer.write(sb.toString());
//			out.close();
//			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getNavList();

	}

}
