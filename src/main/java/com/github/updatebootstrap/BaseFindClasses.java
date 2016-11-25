/**
 * 
 */
package com.github.updatebootstrap;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author user
 *
 */
public abstract class BaseFindClasses {

	private String projectDirectory;
	private List<String> inputFileExtensions;
	private List<CssClassFile> listOfCssClassesFound = new ArrayList<>();
	/**
	 * 
	 * @param projectDirectory Root directory of the project
	 * @param inputFileExtensions should contain the extension of all those files which contain HTML code and the CSS classes.
	 */
	public BaseFindClasses(String projectDirectory, String... inputFileExtensions){
		initializeInput(projectDirectory, inputFileExtensions);
	}
	
	/**
	 * 
	 * @param projectDirectory2
	 * @param inputFileExtensions2
	 */
	private void initializeInput(String projectDirectory, String... inputFileExtensions) {
		this.projectDirectory = projectDirectory;
		this.inputFileExtensions = Arrays.asList(inputFileExtensions);
	}
	
	/**
	 * 
	 * @param rootPath
	 * Tranverse the rootpath recursively and find all a file with the given extension 
	 */
	public abstract void traverseRootDirectory(String rootPath);
	
	public abstract boolean isContainExtension(File file, List<String> extensions);

	/**
	 * @return the projectDirectory
	 */
	public String getProjectDirectory() {
		return projectDirectory;
	}

	/**
	 * @param projectDirectory the projectDirectory to set
	 */
	public void setProjectDirectory(String projectDirectory) {
		this.projectDirectory = projectDirectory;
	}

	/**
	 * @return the inputFileExtensions
	 */
	public List<String> getInputFileExtensions() {
		return inputFileExtensions;
	}

	/**
	 * @param inputFileExtensions the inputFileExtensions to set
	 */
	public void setInputFileExtensions(List<String> inputFileExtensions) {
		this.inputFileExtensions = inputFileExtensions;
	}

	/**
	 * @return the listOfCssClassesFound
	 */
	public List<CssClassFile> getListOfCssClassesFound() {
		return listOfCssClassesFound;
	}
	
	/**
	 * 
	 * @param cssClassFile
	 * @return {@link Boolean} This method will return {code true} if 
	 * the object {code cssClassFile} is successfully added in
	 * {code listOfCssClassesFound}
	 */
	public boolean addIntoList(CssClassFile cssClassFile){
		boolean isAdded = true;
		try {
			listOfCssClassesFound.add(cssClassFile);
		} catch (Exception e) {
			isAdded = false;
		}
		
		return isAdded;
	}
	
}
