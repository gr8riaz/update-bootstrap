/**
 * This class is free and open source. Anyone can re-use it, copy it, or add it into any 
 * project.
 */
package com.github.updatebootstrap;

/**
 * @author gr8riaz
 * This class is a container for one CSS Class found in any file.
 */
public class CssClassFile {

	private String cssClassName;
	private String fileName;
	private String filePath;
	private int lineNumber;
	/**
	 * @return the cssClassName
	 */
	public String getCssClassName() {
		return cssClassName;
	}
	/**
	 * @param cssClassName the cssClassName to set
	 */
	public void setCssClassName(String cssClassName) {
		this.cssClassName = cssClassName;
	}
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}
	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	/**
	 * @return the lineNumber
	 */
	public int getLineNumber() {
		return lineNumber;
	}
	/**
	 * @param lineNumber the lineNumber to set
	 */
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	
}
