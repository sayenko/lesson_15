package ua.lviv.lgs;

import java.io.Serializable;

public class Book extends PaperProduct implements Serializable {
	
	public String bookName;
	public String authorName;
	private int pages;
	private String ganre;
	
	public Book() {}
		
	public Book(String bookName, String authorName) {
		super();
		this.bookName = bookName;
		this.authorName = authorName;
	}

	public Book(String bookName, int pages, String ganre, String authorName) {
		super();
		this.bookName = bookName;
		this.pages = pages;
		this.ganre = ganre;
		this.authorName = authorName;
	}
	
	public void myMethod(String a, int ... args) {
		System.out.println("myMethod(String a, int ... args)");
	}

	public void myMethod(String ... args){
		System.out.println("myMethod(String ... args)");
	}
	
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getGanre() {
		return ganre;
	}

	public void setGanre(String ganre) {
		this.ganre = ganre;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorName == null) ? 0 : authorName.hashCode());
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + ((ganre == null) ? 0 : ganre.hashCode());
		result = prime * result + pages;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (authorName == null) {
			if (other.authorName != null)
				return false;
		} else if (!authorName.equals(other.authorName))
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (ganre == null) {
			if (other.ganre != null)
				return false;
		} else if (!ganre.equals(other.ganre))
			return false;
		if (pages != other.pages)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", pages=" + pages + ", ganre=" + ganre + ", authorName=" + authorName
				+ "]";
	}
	
	
}
