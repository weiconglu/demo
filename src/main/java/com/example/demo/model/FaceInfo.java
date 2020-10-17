package com.example.demo.model;

import java.util.List;
import java.util.Map;

public class FaceInfo {

	private List<Map<String, Object>> faces;

	public List<Map<String, Object>> getFaces() {
		return faces;
	}

	public void setFaces(List<Map<String, Object>> faces) {
		this.faces = faces;
	}

	@Override
	public String toString() {
		return "FaceInfo [faces=" + faces + "]";
	}
	
}
