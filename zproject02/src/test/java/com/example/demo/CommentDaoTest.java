package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.CommentDao;
import com.example.demo.entity.Comment;

@SpringBootTest
public class CommentDaoTest {
	@Autowired
	private CommentDao commentDao;
	
	// save 테스트
	//@Test
	public void saveTest() {
		Comment comment = Comment.builder().bno(2).content("ccc").writer("spring").build();
		assertEquals(1, commentDao.save(comment));
	}
	
	// fundByBno 테스트
	//@Test
	public void findByBnoTest() {
		assertEquals(0,commentDao.findByBno(150).size());
		assertEquals(1,commentDao.findByBno(2).size());
	}
	
	//@Test
	public void findWriterByBnoTest() {
		assertEquals(true, commentDao.findWriterById(150).isEmpty());
		assertEquals(true, commentDao.findWriterById(2).isPresent());
	}
	
	@Transactional
	//@Test
	public void deleteByCntTest() {
		assertEquals(1, commentDao.deleteByCno(6));
		assertEquals(0, commentDao.deleteByCno(150));
	}
	
	@Transactional
	@Test
	public void deleteByBno() {
		assertNotEquals(0, commentDao.deleteByBno(2));
		assertEquals(0, commentDao.deleteByBno(150));
	}
}
