package trabalho;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import trabalho.ResultType.SearchResult;

public class SearchElement {
	
	private Integer key;
	private List<Integer> items;
	private Integer size;
	private Boolean ascending;
	private SearchType type;
	
	
	public SearchElement() {
		this.items = new ArrayList<Integer>();
	}

	public SearchElement(List<Integer> inputArray, SearchType searchType) {
		super();
		this.items = new ArrayList<Integer>();
		this.type = searchType;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public List<Integer> getItems() {
		return items;
	}

	public void setItems(List<Integer> items) {
		this.items = items;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Boolean getAscending() {
		return ascending;
	}

	public void setAscending(Boolean ascending) {
		this.ascending = ascending;
	}

	public SearchType getType() {
		return type;
	}

	public void setType(SearchType type) {
		this.type = type;
	}
	
	public Boolean isAscendingSorted (List<Integer> inputArray){
		
		if (inputArray.get(0) > inputArray.get(inputArray.size()-1)) {
	        return false;
	    } else {
	    	return true;
	    }
	}
	
//	public void checkSearchType(Integer searchType, List<Integer> inputArray, Integer key){
//		
//		ResultType resultType = new ResultType();
//		
//		if (searchType == SearchType.Equals.getSearchType()) {
//			resultType = findEquals();
//		} else if (searchType == SearchType.LessThan.getSearchType()) {
//			
//		} else if (searchType == SearchType.LessThanEquals.getSearchType()) {
//			
//		} else if (searchType == SearchType.GreaterThan.getSearchType()) {
//			
//		} else if (searchType == SearchType.GreaterThanEquals.getSearchType()) {
//			
//		}
//	}
	
	public void find (List<Integer> inputArray, Integer key, SearchType searchType) throws IOException {
		
		ResultType resultType = new ResultType();
		
		if (searchType == SearchType.Equals) {
			
			resultType = findEquals(inputArray, key);
			
		} else if (searchType == SearchType.LessThan) {
			
			resultType = findLessThan(inputArray, key);
			
		} else if (searchType == SearchType.LessThanEquals) {
			
			resultType = findLessThanEquals(inputArray, key);
			
		} else if (searchType == SearchType.GreaterThan) {
			
			resultType = findGreaterThan(inputArray, key);
			
		} else if (searchType == SearchType.GreaterThanEquals) {
			
			resultType = findGreaterThanEquals(inputArray, key);
			
		}
		
		System.out.println("\n ======================");
		System.out.println("RESULTADO: " + resultType.getSearchResult());
		System.out.println("ÍNDICE: " + resultType.getResultIndex());
		System.out.println("VALOR: " + resultType.getResultValue());
		System.out.println("====================== \n");
		
	}
	
	public ResultType findEquals (List<Integer> inputArray, Integer key) {
		
		if (key < inputArray.get(0) || key > inputArray.get(inputArray.size()-1)) {
			
			return new ResultType(SearchResult.NotFound, null, null);
			
		} else {
			
			for (int i = 0; i < inputArray.size()-1; i++) {
				
				if (inputArray.get(i) == key) {
					
					return new ResultType(SearchResult.FoundExact, i, inputArray.get(i));
					
		        }           
		    }
			
			return new ResultType(SearchResult.NotFound, null, null);
		}
		
	}
	
	public ResultType findLessThan (List<Integer> inputArray, Integer key) {
		
		if (key < inputArray.get(0) || key > inputArray.get(inputArray.size()-1)) {
			
			return new ResultType(SearchResult.NotFound, null, null);
			
		} else {
			
			if (isAscendingSorted(inputArray)) {
				
				for (int i = 0; i < inputArray.size()-1; i++) {
			        
					if (inputArray.get(i) <= key && inputArray.get(i+1) > key) {
						
						return new ResultType(SearchResult.FoundLess, i, inputArray.get(i));
						
			        }
					
			    }
				
				return new ResultType(SearchResult.NotFound, null, null);
				
			} else {
				
				for (int i = 0; i < inputArray.size()-1; i++) {
			        
					if (inputArray.get(i) <= key) {
						
						return new ResultType(SearchResult.FoundLess, i, inputArray.get(i));
						
			        }
					
			    }
				
				return new ResultType(SearchResult.NotFound, null, null);
				
			}
			
		}
	}
	
	public ResultType findLessThanEquals (List<Integer> inputArray, Integer key) {
		
		if (key < inputArray.get(0) || key > inputArray.get(inputArray.size()-1)) {
			
			return new ResultType(SearchResult.NotFound, null, null);
			
		} else {
			
			if (isAscendingSorted(inputArray)) {
				
				for (int i = 0; i < inputArray.size()-1; i++) {
			        
					if (inputArray.get(i) <= key && inputArray.get(i+1) > key) {
						
						if (inputArray.get(i) == key) {
							
							return new ResultType(SearchResult.FoundExact, i, inputArray.get(i));
							
						} else {
							
							return new ResultType(SearchResult.FoundLess, i, inputArray.get(i));
							
						}
			        }
					
			    }
				
				return new ResultType(SearchResult.NotFound, null, null);
				
			} else {
				
				for (int i = 0; i < inputArray.size()-1; i++) {
			        
					if (inputArray.get(i) <= key) {
						
						if (inputArray.get(i) == key) {
							
							return new ResultType(SearchResult.FoundExact, i, inputArray.get(i));
							
						} else {
							
							return new ResultType(SearchResult.FoundLess, i, inputArray.get(i));
							
						}
			        }
					
			    }
				
				return new ResultType(SearchResult.NotFound, null, null);
			}
			
		}
	}
	
	public ResultType findGreaterThan (List<Integer> inputArray, Integer key) {
		
		if (key < inputArray.get(0) || key > inputArray.get(inputArray.size()-1)) {
			
			return new ResultType(SearchResult.NotFound, null, null);
			
		} else {
			
			if (isAscendingSorted(inputArray)) {
				
				for (int i = 0; i < inputArray.size()-1; i++) {
			        
					if (inputArray.get(i) >= key) {
						
						return new ResultType(SearchResult.FoundGreater, i, inputArray.get(i));
						
			        }
					
			    }
				
				return new ResultType(SearchResult.NotFound, null, null);
				
			} else {
				
				for (int i = 0; i < inputArray.size()-1; i++) {
			        
					if (inputArray.get(i) >= key && inputArray.get(i+1) < key) {
						
						return new ResultType(SearchResult.FoundGreater, i, inputArray.get(i));
						
			        }
					
			    }
				
				return new ResultType(SearchResult.NotFound, null, null);
				
			}
			
		}
	}
	
	public ResultType findGreaterThanEquals (List<Integer> inputArray, Integer key) {
		
		if (key < inputArray.get(0) || key > inputArray.get(inputArray.size()-1)) {
			
			return new ResultType(SearchResult.NotFound, null, null);
			
		} else {
			
			if (isAscendingSorted(inputArray)) {
				
				for (int i = 0; i < inputArray.size()-1; i++) {
			        
					if (inputArray.get(i) >= key) {
						
						if (inputArray.get(i) == key) {
							
							return new ResultType(SearchResult.FoundExact, i, inputArray.get(i));
							
						} else {
							
							return new ResultType(SearchResult.FoundGreater, i, inputArray.get(i));
							
						}
			        }
					
			    }
				
				return new ResultType(SearchResult.NotFound, null, null);
				
			} else {
				
				for (int i = 0; i < inputArray.size()-1; i++) {
			        
					if (inputArray.get(i) >= key && inputArray.get(i+1) < key) {
						
						if (inputArray.get(i) == key) {
							
							return new ResultType(SearchResult.FoundExact, i, inputArray.get(i));
							
						} else {
							
							return new ResultType(SearchResult.FoundGreater, i, inputArray.get(i));
							
						}
			        }
					
			    }
				
				return new ResultType(SearchResult.NotFound, null, null);
				
			}
			
		}
	}
}
