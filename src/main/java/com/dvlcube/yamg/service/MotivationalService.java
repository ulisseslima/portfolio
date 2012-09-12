package com.dvlcube.yamg.service;

import java.util.List;

import com.dvlcube.yamg.bean.Motivation;

/**
 * 
 * @author wonka
 * @since 10/09/2012
 */
public interface MotivationalService {
	boolean add(Motivation motivation);

	Motivation get(long id);

	List<Motivation> list();

	Motivation remove(Motivation motivation);
}
