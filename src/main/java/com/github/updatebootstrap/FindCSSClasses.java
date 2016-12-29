/**
 * 
 */
package com.github.updatebootstrap;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.github.bootstrap.CssClassesBootstrap2To3;

/**
 * @author user
 *
 */
public class FindCSSClasses extends BaseFindClasses {
	Logger LOGGER = Logger.getGlobal( );
	CssClassesBootstrap2To3 classesToBeReplaced = CssClassesBootstrap2To3.getInstance( );

	public FindCSSClasses(String projectDirectory, String... inputFileExtensions) {
		super( projectDirectory, inputFileExtensions );
	}

	@Override
	public void traverseRootDirectory(String rootPath) {
		try ( Stream<Path> streamOfPaths = Files.walk( Paths.get( rootPath ), Integer.MAX_VALUE,
				FileVisitOption.values( ) ) ) {
			Iterator<Path> iterator = streamOfPaths.iterator( );
			while ( iterator.hasNext( ) ) {
				Path path = iterator.next( );
				File file = path.toFile( );
				if ( file.exists( ) && file.isFile( ) && isContainExtension( file, this.getInputFileExtensions( ) ) ) {
					List<String> lines = Files.readAllLines( path );
					traverseFiles( lines, file.getName( ), file.getAbsolutePath( ) );
				}
			}
		} catch (IOException ioException) {
			LOGGER.log( Level.WARNING, ioException.getMessage( ), ioException );
		}

	}

	/**
	 * 
	 * @param lines
	 */
	private void traverseFiles(final List<String> lines, final String fileName, final String filePath) {

		IntStream.range( 0, lines.size( ) ).forEach( (lineNumber) -> {
			String line = lines.get( lineNumber );
			if ( line.contains( "class" ) ) {
				addCssClassName( line, lineNumber, fileName, filePath );
			}
		} );

	}

	/*
	 * Add the css class name
	 */
	private void addCssClassName(final String line, final int lineNumber, final String fileName,
			final String filePath) {
		int classIndex = line.lastIndexOf( "class" );
		int equalToIndex = line.indexOf( '=', classIndex );
		int quotesStartIndex = line.indexOf( '"', equalToIndex );
		if ( quotesStartIndex < 0 ) {
			quotesStartIndex = line.indexOf( '\'', equalToIndex );
		}
		int quotesEndIndex = line.indexOf( '"', quotesStartIndex );
		if ( quotesEndIndex < 0 ) {
			quotesEndIndex = line.indexOf( '\'', quotesStartIndex );
		}
		String classes = line.substring( quotesStartIndex, quotesEndIndex );
		StringTokenizer tokenizer = new StringTokenizer( classes, " " );
		while ( tokenizer.hasMoreElements( ) ) {
			String cssClass = (String) tokenizer.nextElement( );
			String newClass = classesToBeReplaced.getNewCssClass( cssClass );
			if ( newClass != null ) {
				addIntoList(
						new CssClassFile( cssClass, fileName, filePath, lineNumber + 1, cssClass, newClass,
								"New Class is vailable" ) );
			}

		}

	}

	@Override
	public boolean isContainExtension(File file, List<String> extensions) {
		return false;
	}
}
