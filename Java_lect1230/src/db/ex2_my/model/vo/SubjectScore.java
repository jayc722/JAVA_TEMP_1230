package db.ex2_my.model.vo;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SubjectScore implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6520190043395317416L;
	/**
	 * 
	 */
	private int num;//sc_num
	@NonNull
	private Subject subject;
	@NonNull
	private int score;//sc_score
	private int key;//sc_st_key

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubjectScore other = (SubjectScore) obj;
		return Objects.equals(subject, other.subject);
	}

	@Override
	public String toString() {
		return subject + " " + score + "점";
	}


}
