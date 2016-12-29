/**
 * 
 */
package com.github.bootstrap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;

/**
 * @author mriaz This class is singleton
 *
 */
public class CssClassesBootstrap2To3 {
	Map<String, String> oldAndNewClasses;
	Logger LOGGER = Logger.getGlobal( );
	private static CssClassesBootstrap2To3 instance;

	private CssClassesBootstrap2To3() {
		init( );
	}

	public static CssClassesBootstrap2To3 getInstance() {
		if ( instance == null ) {
			instance = new CssClassesBootstrap2To3( );
		}
		return instance;
	}

	/*
	 * Initialize the oldAndNewClasses map
	 */
	private void init() {
		InputStream in = getClass( ).getResourceAsStream( "/old_to_new_css_classes.cl" );
		try ( BufferedReader reader = new BufferedReader( new InputStreamReader( in ) ) ) {

			String line = StringUtils.EMPTY;
			while ( (line = reader.readLine( )) != null ) {
				StringTokenizer tokens = new StringTokenizer( line, "," );
				addToMap( tokens.nextToken( ), tokens.nextToken( ) );
			}
		} catch (IOException ioException) {
			LOGGER.log( Level.WARNING, ioException.getMessage( ), ioException );
		}
	}

	/*
	 * 
	 */
	private void addToMap(String key, String value) {
		if ( oldAndNewClasses == null ) {
			oldAndNewClasses = new HashMap<>( );
		}
		oldAndNewClasses.put( key, value );
	}

	/**
	 * 
	 * @param cssClass
	 * @return {@link String} if the given css class of bootstrap version 2.x is
	 *         found then the new class of bootstrap version 3.x will be
	 *         returned. {@literal null} will be returned otherwise.
	 */
	public String getNewCssClass(String cssClass) {
		if ( oldAndNewClasses.containsKey( cssClass ) ) {
			return oldAndNewClasses.get( cssClass );
		}
		return null;
	}

}
