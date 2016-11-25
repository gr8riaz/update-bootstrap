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
import java.util.function.Consumer;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 * @author user
 *
 */
public class FindCSSClassesInHTML extends BaseFindClasses{
	Logger LOGGER = Logger.getGlobal();
	public FindCSSClassesInHTML(String projectDirectory, String... inputFileExtensions){
		super(projectDirectory, inputFileExtensions);
	}
	
	
	@Override
	public void traverseRootDirectory(String rootPath) {
        try {
        	Stream<Path> streamOfPaths = Files.walk(Paths.get(rootPath), Integer.MAX_VALUE, FileVisitOption.values());
        	Iterator<Path> iterator = streamOfPaths.iterator();
        	while (iterator.hasNext()) {
				Path path = iterator.next();
				File file = path.toFile();
				if (file.exists() && file.isFile() && isContainExtension(file, this.getInputFileExtensions())) {
					List<String> lines = Files.readAllLines(path);
					traverseFiles(lines);
				}
			}
        } catch (IOException ex) {
        }
		
	}

	/**
	 * 
	 * @param lines
	 */
	private void traverseFiles(List<String> lines) {
		lines.forEach(new Consumer<String>() {
			@Override
			public void accept(String line) {
				if (line.contains("class")) {
					
				}
			}	
		});
		
	}


	@Override
	public boolean isContainExtension(File file, List<String> extensions) {
		// TODO Auto-generated method stub
		return false;
	}
}
