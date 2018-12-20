/**
 * 
 */
package com.bdg.dashboard.service;

import java.util.List;

import com.bdg.dashboard.model.Tablet;

/**
 * @author Jonathan Arroyo Reina
 * @date 04/12/2018
 *
 */
public interface TabletService {
	
	List<Tablet> getAllTablet();

	Tablet registrarTablet(Tablet t) throws Exception ;
	
	boolean actualizarTablet(Tablet t) throws Exception;
}
