package com.example.talb.imagesearch.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageSearchResult {

@SerializedName("totalHits")
@Expose
private Integer totalHits;
@SerializedName("hits")
@Expose
private List<Hit> hits = null;
@SerializedName("total")
@Expose
private Integer total;

public Integer getTotalHits() {
return totalHits;
}

public void setTotalHits(Integer totalHits) {
this.totalHits = totalHits;
}

public ImageSearchResult withTotalHits(Integer totalHits) {
this.totalHits = totalHits;
return this;
}

public List<Hit> getHits() {
return hits;
}

public void setHits(List<Hit> hits) {
this.hits = hits;
}

public ImageSearchResult withHits(List<Hit> hits) {
this.hits = hits;
return this;
}

public Integer getTotal() {
return total;
}

public void setTotal(Integer total) {
this.total = total;
}

public ImageSearchResult withTotal(Integer total) {
this.total = total;
return this;
}

}

