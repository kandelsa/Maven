package ville;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parameters {

	@SerializedName("dataset")
	@Expose
	private List<String> dataset = null;
	@SerializedName("timezone")
	@Expose
	private String timezone;
	@SerializedName("rows")
	@Expose
	private Integer rows;
	@SerializedName("format")
	@Expose
	private String format;

	public List<String> getDataset() {
		return dataset;
	}

	public void setDataset(List<String> dataset) {
		this.dataset = dataset;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

}
