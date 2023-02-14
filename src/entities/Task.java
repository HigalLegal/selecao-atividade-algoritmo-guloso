package entities;

import java.util.Objects;

public class Task {
	
	private Integer start;
	private Integer finish;
	
	// ---------------------------------------------------------------
	
	public Task(Integer start, Integer finish) {
		this.start = start;
		this.finish = finish;
	}
	
	// ---------------------------------------------------------------

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getFinish() {
		return finish;
	}

	public void setFinish(Integer finish) {
		this.finish = finish;
	}
	
	// ---------------------------------------------------------------

	@Override
	public int hashCode() {
		return Objects.hash(finish, start);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(finish, other.finish) && Objects.equals(start, other.start);
	}
	
	@Override
	public String toString() {
		return "[" + start + " || " + finish + "]";
	}
	
}
