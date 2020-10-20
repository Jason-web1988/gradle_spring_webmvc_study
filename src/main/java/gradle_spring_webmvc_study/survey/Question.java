package gradle_spring_webmvc_study.survey;

import java.util.List;



public class Question {
	private String title;
	private List<String> options;
	
	
	/**객관식
	 * @author title
	 *
	 */
	public Question(String title, List<String> options) {
		super();
		this.title = title;
		this.options = options;
	}

	
	/**주관식
	 * @author title
	 *
	 */
	public Question(String title) {
		super();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public List<String> getOptions() {
		return options;
	}

	/* 개관식 판단 */
	public boolean isChoice() {
		return options!=null && !options.isEmpty();
	}

	
}
