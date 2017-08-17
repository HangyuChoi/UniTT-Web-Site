package bean;

public class VideoBean {
	// videolist_idx ´Â ½ÃÄö½º
    int videolist_idx;
    int courseboard_idx;
    String title;
    String video_path;
    String content;

    public VideoBean() {
    }

	public int getVideolist_idx() {
		return videolist_idx;
	}

	public void setVideolist_idx(int videolist_idx) {
		this.videolist_idx = videolist_idx;
	}

	public int getCourseboard_idx() {
		return courseboard_idx;
	}

	public void setCourseboard_idx(int courseboard_idx) {
		this.courseboard_idx = courseboard_idx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVideo_path() {
		return video_path;
	}

	public void setVideo_path(String video_path) {
		this.video_path = video_path;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


}
