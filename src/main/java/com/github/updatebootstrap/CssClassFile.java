/**
 * This class is free and open source. Anyone can re-use it, copy it, or add it into any 
 * project.
 */
package com.github.updatebootstrap;

/**
 * @author gr8riaz This class is a container for one CSS Class found in any
 *         file.
 */
public class CssClassFile {

	private String cssClassName;
	private String fileName;
	private String filePath;
	private int lineNumber;
	private String oldCssClass;
	private String newCssClass;
	private String comments;

	public CssClassFile(String cssClassName, String fileName, String filePath, int lineNumber, String oldCssClass,
			String newCssClass, String comments) {
		this.cssClassName = cssClassName;
		this.fileName = fileName;
		this.filePath = filePath;
		this.lineNumber = lineNumber;
		this.oldCssClass = oldCssClass;
		this.newCssClass = newCssClass;
		this.comments = comments;
	}

	/**
	 * @return the cssClassName
	 */
	public String getCssClassName() {
		return cssClassName;
	}

	/**
	 * @param cssClassName
	 *            the cssClassName to set
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
	 * @param fileName
	 *            the fileName to set
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
	 * @param filePath
	 *            the filePath to set
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
	 * @param lineNumber
	 *            the lineNumber to set
	 */
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	/**
	 * @return the oldCssClass
	 */
	public String getOldCssClass() {
		return oldCssClass;
	}

	/**
	 * @param oldCssClass
	 *            the oldCssClass to set
	 */
	public void setOldCssClass(String oldCssClass) {
		this.oldCssClass = oldCssClass;
	}

	/**
	 * @return the newCsssClass
	 */
	public String getNewCssClass() {
		return newCssClass;
	}

	/**
	 * @param newCsssClass
	 *            the newCsssClass to set
	 */
	public void setNewCssClass(String newCsssClass) {
		this.newCssClass = newCsssClass;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments
	 *            the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

}
