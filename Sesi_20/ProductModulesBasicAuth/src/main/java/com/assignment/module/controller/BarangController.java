package com.assignment.module.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.assignment.module.model.Barang;
import com.assignment.module.service.BarangService;

@RestController
@RequestMapping("/api/v1")
public class BarangController {
	
	@Autowired
	BarangService barangService;
	
	@CrossOrigin
	@GetMapping("/barangs")
	public List<Barang> list() {
		return barangService.listAllBarang();
	}

	@CrossOrigin
	@GetMapping("/barangs/{id}")
	public ResponseEntity<Barang> barangs(@PathVariable Integer id) {
		try {
			Barang barang = barangService.getBarang(id);
			return new ResponseEntity<Barang>(barang, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Barang>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin
	@PostMapping("/barangs")
	public ResponseEntity<?> barangs(@RequestBody Barang barang) {
		barangService.saveBarang(barang);
		return new ResponseEntity<>("Input data produk telah berhasil.", HttpStatus.OK);
	}

	@CrossOrigin
	@PutMapping("/barangs/{id}")
	public ResponseEntity<?> update(@RequestBody Barang barang, @PathVariable Integer id) {
		try {
			Barang existBarang = barangService.getBarang(id);
			if (existBarang.getId() != id) {
				return new ResponseEntity<>("Produk dengan ID tersebut tidak ada.",HttpStatus.OK);
			}
			barang.setId(id);
			barangService.saveBarang(barang);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin
	@DeleteMapping("/barangs/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		barangService.deleteBarang(id);
		return new ResponseEntity<>("Hapus data produk telah berhasil.", HttpStatus.OK);
	}
}
