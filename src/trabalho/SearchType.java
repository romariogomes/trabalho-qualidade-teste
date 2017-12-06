package trabalho;

public enum SearchType {
	
	LessThan(0), LessThanEquals(1), Equals(2), GreaterThanEquals(3), GreaterThan(4);
	
	private Integer searchType;

	public Integer getSearchType() {
		return searchType;
	}

	SearchType(Integer searchType) {
		this.searchType = searchType;
	}
	
	
}
